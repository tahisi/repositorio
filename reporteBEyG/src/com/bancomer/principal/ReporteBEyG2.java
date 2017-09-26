package com.bancomer.principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.bancomer.bean.ReporteBeyG2bean;
import java.io.*;

public class ReporteBEyG2 {
	public static Logger log = Logger.getLogger(ReporteBEyG2.class);
	public static void main(String[] args) throws SQLException {
		GeneraRep();

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


public static List ReporteNvo(String rutaExcel) throws SQLException{
	
	Connection conn 	= null;
	List listaDatos = new ArrayList();
	String query;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		conn = Buscaconexion();
	
		
		query = 	"SELECT SUCURSAL, DV.NOMBRE_USUARIO, NUMCLIENTE,NOMCLIENTE, CLAVE_DOCTO, NOMBRE_DOCUMENTO_VERSION, FECHA_CREACION "
				+ " FROM IMXBEYG G INNER  JOIN IMX_DOCUMENTO DOC  ON G.ID_GABINETE= DOC.ID_GABINETE  "
				+ "INNER JOIN IMX_DOCUMENTO_VERSION DV  ON DOC.ID_GABINETE = DV.ID_GABINETE  "
				+ " AND DOC.ID_CARPETA_PADRE = DV.ID_CARPETA_PADRE "
				+ "AND DOC.ID_DOCUMENTO  = DV.ID_DOCUMENTO AND DOC.TITULO_APLICACION = ?  "
				+ " AND FECHA_CREACION > TO_DATE(?,?)  and FECHA_CREACION < TO_DATE(?,?) order by fh_Creacion asc";
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, "BEYG");
		pstmt.setString(2, "01/11/2016");
		pstmt.setString(3, "'DD/MM/YYYY");
//		pstmt.setString(4, "01/01/2017");
		pstmt.setString(4, "02/11/2016");
		pstmt.setString(5, "'DD/MM/YYYY");
		rs=pstmt.executeQuery();
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		while(rs.next()){
			ReporteBeyG2bean  rep = new ReporteBeyG2bean();
			rep.setSucursal(rs.getString(1));
			rep.setNombre_usuario(rs.getString(2));
			rep.setNumcliente(rs.getString(3));
			rep.setNomcliente(rs.getString(4));
			rep.setClave_docto(rs.getString(5));
			rep.setNombre_documento(rs.getString(6));
			rep.setFecha_creacion(rs.getString(7));
			listaDatos.add(rep);
		}
		creaExcelReporteExp(listaDatos, rutaExcel);
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(pstmt!= null)pstmt.close();
		if(rs!=null)rs.close();
		if (conn!=null)conn.close();
		pstmt =null;
		rs=null;
		conn=null;
		}
	
	return null;
	
}

public static String GeneraRep() throws SQLException {

	System.out.println("REPORTE EXPEDIENTE");
	List listaDatosConteo = new ArrayList(); 
	String tempDir = "E:\\BBVA\\BEyG\\ReporteNuevoBEYG\\";
	String  rutaExcel = tempDir + "reporte.xlsx";
	StringBuffer respuesta 	= new StringBuffer();
	ReporteNvo(rutaExcel);
	File archivo = new File(rutaExcel); 
	if(archivo.exists()){
	System.out.println("Reporte terminado con exito");
	}else{
	
		System.out.println("No se genero el reporte");
	}


	
	return null;
	
	
}

public static void creaExcelReporteExp(List listaDatos, String rutaExcel) throws IOException {
	
	
	HSSFCell cell = null;
	HSSFRow row = null;

	int numColumns = listaDatos.size() + 1;
	Iterator itRepIndx = listaDatos.iterator();
	String[][] arregloExcelDato = new String[numColumns][7];

	String[][] arregloExcelTitulo = new String[numColumns][7];

	arregloExcelTitulo [0][0] = "CR";
	arregloExcelTitulo [0][1] = "Usuario";
	arregloExcelTitulo [0][2] = "N° Cliente";
	arregloExcelTitulo [0][3] = "Nombre del Cliente";
	arregloExcelTitulo [0][4] = "Clave de Documento";
	arregloExcelTitulo [0][5] = "Nombre del documento";
	arregloExcelTitulo [0][6] = "Fecha de Creación";

	int j = 1;
	while (itRepIndx.hasNext()) {
		ReporteBeyG2bean bean = new ReporteBeyG2bean();
		bean = (ReporteBeyG2bean) itRepIndx.next();
		arregloExcelDato[j][0] =  bean.getSucursal();
		arregloExcelDato[j][1] = bean.getNombre_usuario();
		arregloExcelDato[j][2] = bean.getNumcliente();
		arregloExcelDato[j][3] = bean.getNomcliente();
		arregloExcelDato[j][4] = bean.getClave_docto();
		arregloExcelDato[j][5] = bean.getNombre_documento();
		arregloExcelDato[j][6] = bean.getFecha_creacion();

		j++;

	}
	HSSFWorkbook workbook = new HSSFWorkbook();

	HSSFSheet sheet = workbook.createSheet("Reporte");


	for (int r = 0; r < numColumns; r++) {

		row = sheet.createRow((int) r);
		for (int i = 0; i < 7; i++) {

			if ( r == 0) {
				cell = row.createCell(i);
				cell.setCellValue(arregloExcelTitulo[r][i]);
			}else{


				cell = row.createCell(i);

				cell.setCellValue(arregloExcelDato[r][i]);


			}
		}
	}

	
	try {

		
		FileOutputStream archivo = new FileOutputStream(rutaExcel);
		workbook.write(archivo);
		archivo.flush();
		archivo.close();
		System.out.println("Archivo Creado con Exito");
	} catch (Exception exce) {
		System.out.println("Error al general el Reporte Modificacion de  Expediente: "
				+ exce.getMessage() + " Causa:" + exce.getCause());
	}
}





}
