package com.bancomer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.bancomer.bean.datosBean;

public class principal extends HttpServlet {
	public static Logger log = Logger.getLogger(principal.class);
	/**
		 * Constructor of the object.
		 */
	public principal() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		BasicConfigurator.configure();
		response.setContentType("text/html");
		Connection conn = null;
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD> ");
		out.println("<script type=\"text/javascript\" src=\"./js/jquery-1.2.6.min.js\"></script>");
		out.println("</HEAD>");
		out.println("  <BODY>");
		log.info("Iniciando Proceso");
		out.println("   Iniciando Proceso...");
		try {
			conn = Buscaconexion();
			Date fechaInicio = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			log.info("Hora Inicio: "+hourdateFormat.format(fechaInicio));
			buscaGabinete(conn,out);
			log.info(" Proceso Terminado  ... ");
			Date fechafin= new Date();
			System.out.println("Hora Fin: "+hourdateFormat.format(fechafin));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	public int buscaGabinete(Connection conn,  PrintWriter out) throws SQLException {


		PreparedStatement pstmt	= null;
		String query			= null;
		ResultSet rs			= null;
		int id_gabinete			= 0;
		int borra_doc			= 0;
		int borra_org_carp		= 0;
		int borra_carp			= 0;
		int cg_caso				= 0;
		int borra_caso_dato		= 0;
		int borra_cg_operacion	= 0;
		int borra_cg_caso		= 0;
		int borra_gabinete 		= 0;
		try {
			query = "\n SELECT DISTINCT(ID_GABINETE) FROM IMX_DOCUMENTO DOC "
					+ "\n WHERE DOC.TITULO_APLICACION = ?"
					+ "\n AND  DOC.NOMBRE_USUARIO = ?  "
					+ "\n AND DOC.FH_CREACION > TO_DATE(?, ?) AND DOC.FH_CREACION < TO_DATE(?, ?)  ";

			pstmt=conn.prepareStatement(query);

			pstmt.setString(1,"PYMES");
			pstmt.setString(2, "M55787"); 
			pstmt.setString(3, "01/10/2016");
			pstmt.setString(4, "DD/MM/YYYY");
			pstmt.setString(5, "31/10/2016");
			pstmt.setString(6, "DD/MM/YYYY");
			rs=pstmt.executeQuery();

			while (rs.next()){
				datosBean datos = new  datosBean();
				id_gabinete= rs.getInt("id_gabinete");
				//Sacar datos del las paginas,  borrar archivo y registro en pagina
				datos= 	buscaDatos(conn, datos, id_gabinete,out);
				if (datos.getId_gabinete()!= 0){
				borra_doc= borrar_documento(conn, datos);
				if (borra_doc>=1){
					borra_org_carp = borrar_org_carpeta(conn, datos);
					if (borra_org_carp >= 1){
						borra_carp = borra_carpeta(conn, datos);
						if(borra_carp >=1){
							cg_caso =busca_cg_caso(conn, datos);
							if (cg_caso != 0){
								borra_caso_dato = borra_cg_caso_dato(conn, cg_caso);
								if (borra_caso_dato >= 1){
									borra_cg_operacion = borra_caso_dato_oper(conn, cg_caso);
									if(borra_cg_operacion >=1){
										borra_cg_caso =	borra_cg_caso(conn, cg_caso);
										if(borra_cg_caso >= 1){
											borra_gabinete = borra_id_gabinete(conn, datos);
											if(borra_gabinete >= 0){
												conn.commit();
												log.info("Borrado Existoso para cd_gabinete " + datos.getId_gabinete());
											}
										}
									}
								}
							}else{
								borra_gabinete = borra_id_gabinete(conn, datos);
								if(borra_gabinete >0){
									conn.commit();
									log.info("Borrado Existoso para cd_gabinete " + datos.getId_gabinete());
								}
							}
						}
					}
				
				}
			}
				else{
					datos.setId_gabinete(id_gabinete);
					borra_doc= borrar_documento(conn, datos);
					if (borra_doc>=1){
						borra_org_carp = borrar_org_carpeta(conn, datos);
						if (borra_org_carp >= 1){
							borra_carp = borra_carpeta(conn, datos);
							if(borra_carp >=1){
								cg_caso =busca_cg_caso(conn, datos);
								if (cg_caso != 0){
									borra_caso_dato = borra_cg_caso_dato(conn, cg_caso);
									if (borra_caso_dato >= 1){
										borra_cg_operacion = borra_caso_dato_oper(conn, cg_caso);
										if(borra_cg_operacion >=1){
											borra_cg_caso =	borra_cg_caso(conn, cg_caso);
											if(borra_cg_caso >= 1){
												borra_gabinete = borra_id_gabinete(conn, datos);
												if(borra_gabinete >= 0){
													conn.commit();
													log.info("Borrado Existoso para cd_gabinete " + datos.getId_gabinete());
												}
											}
										}
									}
								}else{
									borra_gabinete = borra_id_gabinete(conn, datos);
									if(borra_gabinete >= 0){
										conn.commit();
										log.info("Borrado Existoso para cd_gabinete " + datos.getId_gabinete());
									}
								}
							}
						}
					
					}
				
					
				}
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally{
			if (pstmt!=null){pstmt.close();}
			if (rs!=null){rs.close();}
			if (conn!= null)conn.close();
		}

		return id_gabinete;



	}
	

	public datosBean buscaDatos(Connection conn, datosBean datos, int id_gabinete,PrintWriter out) throws SQLException {


		PreparedStatement pstmt	= null;
		String query			= null;
		ResultSet rs			= null;
		try {

			query = "\n SELECT DOC.ID_GABINETE, DOC.ID_CARPETA_PADRE, "
					+ "\n DOC.ID_DOCUMENTO, PAG.VOLUMEN, PAG.NOM_ARCHIVO_VOL, PAG.NUMERO_PAGINA"
					+ "\n FROM IMX_DOCUMENTO DOC "
					+ "\n INNER JOIN IMX_PAGINA PAG ON "
					+ "\n DOC.TITULO_APLICACION=PAG.TITULO_APLICACION "
					+ "\n AND  DOC.ID_GABINETE= PAG.ID_GABINETE "
					+ "\n AND DOC.ID_CARPETA_PADRE= PAG.ID_CARPETA_PADRE "
					+ "\n AND DOC.ID_DOCUMENTO=PAG.ID_DOCUMENTO "
					+ "\n AND DOC.TITULO_APLICACION = ?"
				//	+ "\n AND  DOC.NOMBRE_USUARIO = ?  "
				//	+ "\n AND DOC.FH_CREACION > TO_DATE(?, ?)  "
				//	+ "\n AND DOC.FH_CREACION < TO_DATE(?, ?) "
					+ "\n AND DOC.ID_GABINETE= ? ";

			pstmt=conn.prepareStatement(query);

			pstmt.setString(1,"PYMES");
			//pstmt.setString(2, "M55787");
//			pstmt.setString(2, "31/03/2016");
//			pstmt.setString(3, "DD/MM/YYYY");
//			pstmt.setString(4, "10/04/2016");
//			pstmt.setString(5, "DD/MM/YYYY");
			pstmt.setInt(2, id_gabinete);
			rs=pstmt.executeQuery();
			log.info("Sacando Datos para gabinete " + id_gabinete);
			while (rs.next()){
				datos.setId_gabinete(rs.getInt(1));
				datos.setId_carpeta_padre(rs.getInt(2));
				datos.setId_documento(rs.getInt(3));
				datos.setVolumen(rs.getString(4));
				datos.setNom_archivo_vol(rs.getString(5));
				datos.setNumero_pagina(rs.getInt(6));
				eliminaArchivo(conn, datos, out);

			}
		} catch (Exception e) {
			//		log.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (pstmt!=null){pstmt.close();}
			if (rs!=null){rs.close();}
		}

		return datos;



	}
	
	public int eliminaArchivo(Connection conn, datosBean datos, PrintWriter out) throws SQLException{

		PreparedStatement pstmt	= null;
		String query			= null;
		ResultSet rs			= null;
		String ruta 			= null;
		int borraBase			= 0;
		int borrapagina			= 0;
		try {

			query = "\n  SELECT  UNIDAD_DISCO, RUTA_BASE, RUTA_DIRECTORIO FROM  IMX_VOLUMEN WHERE VOLUMEN = ?";

			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, datos.getVolumen());
			rs=pstmt.executeQuery();

			while (rs.next()){
				datos.setUnidad_disco(rs.getString(1));
				datos.setRuta_base(rs.getString(2));
				datos.setRuta_directorio(rs.getString(3));
				ruta	= 	armaRutas(datos);
				borraBase = borra_ruta(ruta, out);
				if ( borraBase== 1) {
					borrapagina= borrar_pagina(conn, datos);//borrar paginas
				}
			}
		} catch (Exception e) {
			//		log.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (pstmt!=null){pstmt.close();}
			if (rs!=null){rs.close();}
		}
		return borrapagina;
	}
		
	public String armaRutas ( datosBean datos) throws SQLException{
		String ruta = null;
		ruta = datos.getUnidad_disco() + datos.getRuta_base() + datos.getRuta_directorio() + datos.getNom_archivo_vol();
	//System.out.println(ruta + "\n");
		return ruta;

	}
	
//	public int borra_ruta ( String ruta ) throws IOException {
//		int bandera = 0;
//		try {
//			
//			URL myURL = new URL("http://150.50.102.88:16021/fimxpyme_mx_web/depura/eliminaArchivos?ruta=" + ruta);
//			log.info(myURL);
//			URLConnection myURLConnection = myURL.openConnection();
//			
//			myURLConnection.connect();
//		
//			log.info("Ruta borrada " + ruta);
//			bandera=1;
//
//		} 
//		catch (MalformedURLException e) { 
//			bandera=0;
//		} 
//
//		return bandera;
//	}
	
	public int borra_ruta(String ruta, PrintWriter out) throws IOException{
		int bandera=0;
			out.println("<script type=\"text/javascript\" >");
			out.println("var ruta = '"+ruta+"';");
			out.println("url = \"http://150.100.246.196:7041/pymes/depura/eliminaArchivos?ruta=\" + ruta ");
			out.println("createXmlHttpRequest();");
			out.println("ajax.open(\"GET\", url, true);");
			out.println("ajax.onreadystatechange = BorraRuta;");
			out.println("ajax.send(null);");

			out.println("function BorraRuta (){");
			System.out.println("Borrando Ruta " + ruta);
			out.println("if(ajax.readyState == 4){");  
			bandera=1;
			out.println("   if(ajax.status == 200){");	 
			bandera=1;
			out.println("}");   
			out.println("}");
			out.println("}");

			
			
			out.println("function createXmlHttpRequest(){									");
			out.println("	try                                                             ");
			out.println("	{                                                               ");
			out.println("		// Firefox, Opera 8.0+, Safari                              ");
			out.println("		xmlHttp=new XMLHttpRequest();                               ");
			out.println("		ajax=new XMLHttpRequest();                                  ");
			out.println("	}catch (e){                                                     ");
			out.println("		// Internet Explorer                                        ");
			out.println("		try                                                         ");
			out.println("			{                                                       ");
			out.println("			xmlHttp=new ActiveXObject(\"Msxml2.XMLHTTP\");          ");
			out.println("			ajax=new ActiveXObject(\"Msxml2.XMLHTTP\");             ");
			out.println("			}                                                       ");
			out.println("		catch (e)                                                   ");
			out.println("		{                                                           ");
			out.println("			try                                                     ");
			out.println("			{                                                       ");
			out.println("				xmlHttp=new ActiveXObject(\"Microsoft.XMLHTTP\");   ");
			out.println("				ajax=new ActiveXObject(\"Microsoft.XMLHTTP\");      ");
			out.println("			}                                                       ");
			out.println("			catch (e)                                               ");
			out.println("			{                                                       ");
			out.println("				alert(\"Su browser no suporta AJAX!\");             ");
			out.println("				return false;                                       ");
			out.println("			}                                                       ");
			out.println("		}                                                           ");
			out.println("	}                                                               ");
			out.println("}                                                                  ");

			out.print("</script>");
			return bandera;
		
		
	}
	public int borrar_pagina ( Connection conn, datosBean datos ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			log.info("borrando pagina para gabinete " + datos.getId_gabinete() + "Carpeta " +datos.getId_carpeta_padre() + "Documento " + datos.getId_documento()  + "Pagina " + datos.getNumero_pagina());
			pstmnt = conn.prepareStatement("delete from imx_pagina where titulo_aplicacion = ? and id_gabinete = ? and id_carpeta_padre= ? and id_documento = ? and numero_pagina=?");
			pstmnt.setString(1, "PYMES");
			pstmnt.setInt(2, datos.getId_gabinete());
			pstmnt.setInt(3, datos.getId_carpeta_padre());
			pstmnt.setInt(4, datos.getId_documento());
			pstmnt.setInt(5, datos.getNumero_pagina());
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if (pstmnt!=null){pstmnt.close();}
			
		}
		return bandera;
	}
	
	public int borrar_documento( Connection conn, datosBean datos ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			log.info("Borrando documento para id_gabinete " + datos.getId_gabinete());
			pstmnt = conn.prepareStatement("delete from imx_documento where titulo_aplicacion = ? and  id_gabinete = ?");
			pstmnt.setString(1, "PYMES");
			pstmnt.setInt(2, datos.getId_gabinete());
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if (pstmnt!=null){pstmnt.close();}
		}
		return bandera;
	}
	
	public int borrar_org_carpeta( Connection conn, datosBean datos ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			log.info("Borrando org_carpeta para gabinete" + datos.getId_gabinete() );
			pstmnt = conn.prepareStatement("delete from IMX_ORG_CARPETA  where   titulo_aplicacion =  ? and  id_gabinete = ? ");
			pstmnt.setString(1, "PYMES");
			pstmnt.setInt(2, datos.getId_gabinete());
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if (pstmnt!=null){pstmnt.close();}
		}
		return bandera;
	}
	
	public int borra_carpeta( Connection conn, datosBean datos ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			log.info("Borrando carpeta para id_Gabinete " + datos.getId_gabinete());
			pstmnt = conn.prepareStatement("delete from imx_carpeta  where   titulo_aplicacion =  ? and  id_gabinete = ? ");
			pstmnt.setString(1, "PYMES");
			pstmnt.setInt(2, datos.getId_gabinete());
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if (pstmnt!=null){pstmnt.close();}
		}
		return bandera;
	}
	
	public int busca_cg_caso(Connection conn, datosBean datos) throws SQLException {


		PreparedStatement pstmt	= null;
		String query			= null;
		ResultSet rs			= null;
		int id_caso			= 0;
		try {
			log.info("Buscando cg_caso para " + datos.getId_gabinete());
			query = "select id_caso from CG_CASO where c_id_gabinete = ? ";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, datos.getId_gabinete());
			rs=pstmt.executeQuery();

			while (rs.next()){
				id_caso= rs.getInt("id_Caso");
				
			}
		} catch (Exception e) {
			//		log.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (pstmt!=null){pstmt.close();}
			if (rs!=null){rs.close();}
		}

		return id_caso;



	}
	
	public int borra_cg_caso_dato( Connection conn, int id_caso ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			pstmnt = conn.prepareStatement(" delete from CG_CASO_DATO where id_caso =  ? ");
			pstmnt.setInt(1, id_caso);
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if (pstmnt!=null){pstmnt.close();}
		}
		return bandera;
	}
	public int borra_caso_dato_oper( Connection conn, int id_caso ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			log.info("Borrando cg_caso_operacion " + id_caso);
			pstmnt = conn.prepareStatement("delete from CG_CASO_OPERACION  where id_caso= ? ");
			pstmnt.setInt(1, id_caso);
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if(pstmnt != null) pstmnt.close();
			pstmnt = null;

		}
		return bandera;
	}
	
	public int borra_cg_caso( Connection conn, int id_caso ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			log.info("Borrando cg_caso  " + id_caso );
			pstmnt = conn.prepareStatement(" delete from cg_caso  where id_caso= ? ");
			pstmnt.setInt(1, id_caso);
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if (pstmnt!=null){pstmnt.close();}

		}
		return bandera;
	}
	
	
	public int borra_id_gabinete( Connection conn, datosBean datos ) throws IOException, SQLException {

		int bandera 				= 0;
		PreparedStatement pstmnt 	= null;


		try{
			log.info("Borrando id_Gabinete " + datos.getId_gabinete());
			pstmnt = conn.prepareStatement("   delete from imxpymes  where id_gabinete= ? ");
			pstmnt.setInt(1, datos.getId_gabinete());
			bandera = pstmnt.executeUpdate();
			
		}catch(Exception e){



		}finally{
			if (pstmnt!=null){pstmnt.close();}
		}
		return bandera;
	}

	public static Connection Buscaconexion() throws Exception{		

		Connection conn = null; 
		Class.forName("oracle.jdbc.OracleDriver") ;

// 		PRODUCCION
		String cadena="jdbc:oracle:thin:@150.100.151.213:1530:BIXBP0013";
		String user= "dbsbpy";
		String pass= "xdbsbpy12";
		

// 		TEST
//		String cadena="jdbc:oracle:thin:@150.100.152.22:1530:BQGBP001";
//		String user= "dbsbpy";
//		String pass= "dbsbpy12";
//
		System.out.println("Conectado a    :"+cadena+"");
		conn = DriverManager.getConnection(cadena,user, pass);

		conn.setAutoCommit(false);
		return conn;
	}

}
