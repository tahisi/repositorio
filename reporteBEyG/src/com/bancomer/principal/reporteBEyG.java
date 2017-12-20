package com.bancomer.principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bancomer.bean.documentoBean;
import com.bancomer.dao.comparaAplicacion;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class reporteBEyG {
	public static Logger log = Logger.getLogger(reporteBEyG.class);
	
	public static void main (String args []) throws IOException{
		BasicConfigurator.configure();
		String nombre_archivo = "";
//		nombre_archivo=args[0]
//		nombre_archivo = "DM_BEYG_TEXSAS_20170224.txt";
		nombre_archivo ="DM_BEYG_TEXSAS-20122017.txt";
		String ruta_base = "E:/BBVA/BEyG/ReporteBEyG/";
		log.info("Lee Archivo " + nombre_archivo);
		
		try {
			creaArchivos(nombre_archivo, ruta_base);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static String creaArchivos(String nombre_archivo, String ruta_base) throws Exception {
		Date fechaInicio = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.println("Hora Inicio: "+hourdateFormat.format(fechaInicio));
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		
		String ruta = ruta_base + nombre_archivo;
		String cadena;
		BufferedReader linea = null;
	
		linea = new BufferedReader(new InputStreamReader(new FileInputStream(ruta),"ISO-8859-1"));
		File captacion, cartera, existenBEyG, noexistenBEyG,salidaBeyg, conContrato;
		String rutafecha= ruta_base +"Reporte_" + dateFormat.format(fechaInicio)+"/";
		File ruta_base1 = new File(rutafecha);
		ruta_base1.mkdirs();
		captacion 			= new File (rutafecha +"Captacion_"+ dateFormat.format(fechaInicio)+".txt");
		cartera 			= new File (rutafecha +"Cartera_"+ dateFormat.format(fechaInicio)+".txt");
		existenBEyG 		= new File (rutafecha +"ExistenBEyG_"+ dateFormat.format(fechaInicio)+".txt");
		noexistenBEyG 		= new File (rutafecha +"NoExistenBEyG_"+ dateFormat.format(fechaInicio)+".txt");
		salidaBeyg			= new File (rutafecha +"Documentos_"+ dateFormat.format(fechaInicio)+".txt");
		conContrato			= new File (rutafecha +"Existen_"+ dateFormat.format(fechaInicio)+".txt");//clientes con contrato
		FileWriter captacionw			= new FileWriter(captacion);
		BufferedWriter captacionbw 	= new BufferedWriter(captacionw);
		PrintWriter captacionwr 		= new PrintWriter(captacionbw);

		FileWriter carteraw 			= new FileWriter(cartera);
		BufferedWriter carterabw 		= new BufferedWriter(carteraw);
		PrintWriter carterawr 			= new PrintWriter(carterabw);

		FileWriter existenBEyGw		= new FileWriter(existenBEyG);
		BufferedWriter existenBEyGbw 	= new BufferedWriter(existenBEyGw);
		PrintWriter existeBeyGwr 		= new PrintWriter(existenBEyGbw);

		FileWriter noexistenBEyGw		= new FileWriter(noexistenBEyG);
		BufferedWriter noexistenBEyGbw = new BufferedWriter(noexistenBEyGw);
		PrintWriter noexisteBeyGwr 	= new PrintWriter(noexistenBEyGbw);



		FileWriter salidaBeygw		= new FileWriter(salidaBeyg);
		BufferedWriter salidaBeygbw = new BufferedWriter(salidaBeygw);
		PrintWriter salidaBeygwr 	= new PrintWriter(salidaBeygbw);
		
		FileWriter conContratow		= new FileWriter(conContrato);
		BufferedWriter conContratobw = new BufferedWriter(conContratow);
		PrintWriter conContratowr 	= new PrintWriter(conContratobw);

		Connection conn 	= null;
		int contador=0;
		try {
			conn = Buscaconexion();

			while((cadena=linea.readLine()) != null){
				 contador ++;
				String cd_aplicacion 	= cadena.substring(10,14);
				String nu_cta			= cadena.substring(40,62).trim();
				String cd_cliente		= cadena.substring(62, 70);

				comparaAplicacion comp = new comparaAplicacion();
				documentoBean doc = new documentoBean();
				doc.setCd_cliente(cd_cliente);
				doc.setNumero_cta(nu_cta);
				comp.comaraCd_aplicacion(conn, cd_aplicacion, cadena, doc, captacionbw, carterabw, existenBEyGbw, noexistenBEyGbw, salidaBeygbw, conContratobw);
				if(contador ==1000){
					System.out.println(cadena);
					contador = 0;
				}
			}
			
			captacionwr.close();
			captacionbw.close();
			carterawr.close();
			carterabw.close();
			existeBeyGwr.close();
			existenBEyGbw.close();
			noexisteBeyGwr.close();
			noexistenBEyGbw.close();

			salidaBeygwr.close();
			salidaBeygbw.close();
			conContratowr.close();
			conContratobw.close();
			
			

			linea.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			e.printStackTrace();
		}finally
		{
			if (conn != null) conn.close();
			Date fechaFin= new Date();
		log.info("Hora Fin: "+hourdateFormat.format(fechaFin));
		}
		return null;

	}
	
	public static Connection Buscaconexion() throws Exception{		
		
		Connection conn = null; 
		Class.forName("oracle.jdbc.OracleDriver") ;

		
		String cadena="jdbc:oracle:thin:@150.100.151.213:1530:BIXBP0013";
		String user= "dbsbxc";
		String pass= "xdbsbxc12";
		
		log.info("Conectado a    :"+cadena+"");
		conn = DriverManager.getConnection(cadena,user, pass);

		conn.setAutoCommit(false);
		return conn;
	}
	
	 
}
