package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.ssl.Base64;

import processmsd.GetMsdAvaluos;
import processmsd.GetMsdAvaluosService;

public class testAvaluos {
	
//	public static void main (String args[]){
//		Date fechaInicio = new Date();
//		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
//		System.out.println("Hora Inicio: "+hourdateFormat.format(fechaInicio));
//		GetMsdAvaluosService service = new GetMsdAvaluosService();
//		GetMsdAvaluos avaluos = service.getGetMsdAvaluos();
//		String CADENABASE64="";
//		
//		String imagen="docto2.pdf";
//		
//		String Folio       ="10037";
//	String TipoArchivo ="10037D0036";
//	String Extesion    ="jpg";
//	String Aplicacion  ="avaluos";
//	String rutaArchivo="E:\\" + imagen;
//	File file = new File(rutaArchivo);
//	byte[] fileArray = new byte[(int) file.length()];
//	InputStream inputStream;
//	try {
//		inputStream = new FileInputStream(file);
//		inputStream.read(fileArray);
//		CADENABASE64 = Base64.encodeBase64String(fileArray);
////		avaluos.addFile(CADENABASE64, TipoArchivo, Extesion, );
//		System.out.print(avaluos.addFile(CADENABASE64, Folio, TipoArchivo, Extesion, Aplicacion));
//		Date fechaFin= new Date();
//		System.out.print("Hora Fin: "+hourdateFormat.format(fechaFin));
//		
//	}catch (Exception e){
//		e.printStackTrace();
//	}
//
//}
	public static void main(String args[]){
		GetMsdAvaluosService service = new GetMsdAvaluosService();
		GetMsdAvaluos avaluos = service.getGetMsdAvaluos();
	String respuesta=	avaluos.deleteFile("102", "102001", "avaluos");
	System.out.println(respuesta);
	}
}