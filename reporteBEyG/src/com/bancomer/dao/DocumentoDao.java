package com.bancomer.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.bancomer.bean.documentoBean;

public class DocumentoDao {
	public static Logger log = Logger.getLogger(DocumentoDao.class);
	public int BuscaNumeroCliente(Connection conn, String numero_Cliente) throws SQLException {
		
		String query;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		int id_gabinete			= 0;
		try {
			
		query = "SELECT ID_GABINETE FROM IMXBEYG WHERE NUMCLIENTE= ?";
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, numero_Cliente);
		rs=pstmt.executeQuery();
		if(rs.next()){
			//crea archivo encontrados
			id_gabinete = rs.getInt(1);
		
			//busca sus documentos
			//BuscaDocumentosCliente(conn,id_gabinete, doc, cadena,salidaBeygwr);
		}else{
//			noexistenBEyG.write(cadena);
//			noexistenBEyG.write("\n");
			id_gabinete = 0;
			// crea archivo No encontrados
			
		}
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (pstmt!=null){pstmt.close();}
			if (rs!=null){rs.close();}
		}

		return id_gabinete;

	}
	
	
	public void BuscaDocumentosCliente(Connection conn, int id_gabinete,documentoBean doc,String cadena, BufferedWriter salidaBeygwr, BufferedWriter conContratobw) throws SQLException, IOException {
		String query;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		
		query = 	"SELECT CLAVE_DOCTO,NOMBRE_DOCUMENTO_VERSION,ID_VERSION, "
						+ "\n DOC.ID_CARPETA_PADRE, DOC.ID_DOCUMENTO, "
						+ "\n TO_CHAR(DOCV.FECHA_CREACION,'dd/mm/yyyy hh:mm:ss') "
						+ "\n FROM IMX_DOCUMENTO DOC "
						+ "\n INNER JOIN IMX_DOCUMENTO_VERSION DOCV ON "
						+ "\n DOC.ID_GABINETE=DOCV.ID_GABINETE "
						+ "\n AND DOC.ID_CARPETA_PADRE=DOCV.ID_CARPETA_PADRE "
						+ "\n AND DOC.ID_DOCUMENTO=DOCV.ID_DOCUMENTO "
						+ "\n AND DOC.TITULO_APLICACION = ? "
						+ "\n AND DOC.ID_GABINETE= ?"
						+ "\n AND (DOCV.NOMBRE_DOCUMENTO_VERSION LIKE  ?"
						+ "\n OR  DOCV.NUMCONTRATO LIKE  ? )";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "BEYG");
			pstmt.setInt(2, id_gabinete);
			pstmt.setString(3, "%"+doc.getNumero_cta()+"%");
			pstmt.setString(4, "%"+doc.getNumero_cta()+"%");
			rs=pstmt.executeQuery();
			

		int contador = 0;
				 
				
			while(rs.next()){
				doc.setClave_docto(rs.getString(1));
				doc.setNombre_documento(rs.getString(2));
				doc.setId_version(rs.getInt(3));
				doc.setId_carpeta_padre(rs.getInt(4));
				doc.setId_documento(rs.getInt(5));
				doc.setFecha_digital(rs.getString(6));
				CuentaPaginasDocumento(conn,id_gabinete, doc);
				//escribir en el archivo final
				salidaBeygwr.write(cadena + " " +rellenaDerecha(doc.getClave_docto(), 3, " ")+ rellenaDerecha(doc.getNombre_documento(), 180, " ") 
				+ rellenaDerecha(String.valueOf(doc.getId_version()) , 3, " ")   +rellenaDerecha(String.valueOf(doc.getNumero_paginas()) , 5, " ") 
				+ rellenaDerecha(doc.getFecha_digital(),25," ") );
				salidaBeygwr.write("\n");
				contador ++;
				
			}
			
			if (contador > 0){
				conContratobw.write(cadena);
				conContratobw.write("\n");
			}
			
		} catch (SQLException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (pstmt!=null){pstmt.close();}
			if (rs!=null){rs.close();}
		}
	
	}
	
	
	public void CuentaPaginasDocumento(Connection conn, int id_gabinete, documentoBean doc) throws SQLException  {
		String query;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		query = 	" SELECT COUNT(1) FROM IMX_PAGINA   PAG "
				+ "\n INNER JOIN IMX_PAGINA_VERSION PAGV  "
				+ "\n ON PAG.ID_GABINETE=PAGV.ID_GABINETE "
				+ "\n AND PAG.TITULO_APLICACION =PAGV.TITULO_APLICACION "
				+ "\n AND PAG.ID_GABINETE = PAGV.ID_GABINETE    "
				+ "\n AND PAG.ID_CARPETA_PADRE = PAGV.ID_CARPETA_PADRE  "
				+ "\n AND PAG.ID_DOCUMENTO = PAGV.ID_DOCUMENTO "
				+ "\n AND PAG.NUMERO_PAGINA = PAGV.NUMERO_PAGINA    "
				+ "\n AND PAG.TITULO_APLICACION = ? "
				+ "\n AND PAG.ID_GABINETE = ?   "
				+ "\n AND PAGV.ID_CARPETA_PADRE= ? "
				+ "\n AND PAGV.ID_DOCUMENTO = ?" 
				+ "\n AND PAGV.ID_VERSION=  ? ";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "BEYG");
			pstmt.setInt(2, id_gabinete);
			pstmt.setInt(3, doc.getId_carpeta_padre());
			pstmt.setInt(4, doc.getId_documento());
			pstmt.setInt(5, doc.getId_version());
			rs=pstmt.executeQuery();
			if(rs.next()){
				doc.setNumero_paginas(rs.getInt(1));
			}
		} catch (SQLException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (pstmt!=null){pstmt.close();}
			if (rs!=null){rs.close();}
		}
	}
	
	 private String rellenaDerecha(String cadena, int numeroCaracteres,String caracter){
         String salida=cadena;
         for(int i=0;i<numeroCaracteres-cadena.length();i++){
                 salida= salida + caracter;
         }
         return salida;
	 }
	
	

}
