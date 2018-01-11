package visor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import processmsd.GetMsdAvaluos;
import processmsd.GetMsdAvaluosService;
import processmsd.GetMsdAvaluosServiceLocator;
//import utils.DatosProperties;

/**
 * Servlet implementation class VisorAvaluos
 */
public class VisorAvaluos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map <String,String> mapaInfoGuardarDoc = null;
		String tempDir 				= getServletContext().getRealPath("/") + File.separator 	+ "tmp" + File.separator;
		String idFolio 				= request.getParameter("idFolio");
		String tipoArchivoRetorno	= "";
		File file 					= null;
		File file2 					= null; 
		String folioCompleto		= idFolio.trim();
		String folio 				= null;		
		int valorAleatorio 			= 0;
		AuxVisorAvaluos auxVisor 	= new AuxVisorAvaluos();
		Date fecha1 = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.println("Abriendo Visor: "+hourdateFormat.format(fecha1));
		try{
			GetMsdAvaluosService service 	= new GetMsdAvaluosServiceLocator();
			GetMsdAvaluos avaluos 			= service.getGetMsdAvaluos();
			String estatusArchivo 			= "";
			tipoArchivoRetorno				= "application/pdf";
			
			if(folioCompleto != null && folioCompleto !="" && !folioCompleto.equals("")){

				valorAleatorio 		= (int) Math.floor(Math.random()*1500+1);
				Date fecha2 = new Date();
				
				System.out.println("Iniciando Descarga: "+hourdateFormat.format(fecha2));
				String cadenaJson 	= avaluos.downloadfile("",folioCompleto, "AVALUOS");
	Date fecha3 = new Date();
				
				System.out.println("Terminando Descarga: "+hourdateFormat.format(fecha3));
				mapaInfoGuardarDoc 	= auxVisor.convertirCadenaJsonToMap(cadenaJson);

				if(!mapaInfoGuardarDoc.get("error").toString().equals("No existe este documento.")){
					
					file2 = auxVisor.crearArchivoTemporal(mapaInfoGuardarDoc.get("cadena64").toString(),mapaInfoGuardarDoc.get("nombre").toString(),mapaInfoGuardarDoc.get("extension").toString(),valorAleatorio,tempDir);																	
				
					if(auxVisor.verificarExtensionArchivoImagenes(mapaInfoGuardarDoc.get("extension").toString())){
						
						if(mapaInfoGuardarDoc.get("extension").toString().equals("pdf")){
							
							System.out.println("RutaPDF: "+file2.getPath());
							file = file2;											
							tipoArchivoRetorno="application/pdf";
							
						}else if(mapaInfoGuardarDoc.get("extension").toString().equals("jpg")){			
							
							System.out.println("RutaImagen: "+file2.getPath());
							file = file2;
							tipoArchivoRetorno="image/jpg";
							
						}
						
					}else if(file2==null){

						file = new File(getServletContext().getRealPath("/") + File.separator + "tmp" + "/NoHayVersionAMostrar.pdf"); 
						
					}else{

						file = new File(getServletContext().getRealPath("/") + File.separator + "tmp" + "/NoHayVersionAMostrar.pdf"); 
					}

					if(file != null){
						
					}else{
						
						System.out.println("Error al bajar Archivo: "+estatusArchivo);
						file = new File(getServletContext().getRealPath("/") + File.separator + "tmp" + "/parametrosInvalidos.pdf"); 
					}
				
				}else{
					
					System.out.println(mapaInfoGuardarDoc.get("error").toString());
					file = new File(getServletContext().getRealPath("/") + File.separator + "tmp" + "/documentoNoEncontrado.pdf"); 
				}

			}else{
				
				System.out.println("Folio Vacio o nulo"+folio);
				file = new File(getServletContext().getRealPath("/") + File.separator + "tmp" + "/folioVacioNulo.pdf"); 
				
			}
		}catch(Exception e){
			System.err.println( e.getMessage() );
			file = new File(getServletContext().getRealPath("/") + File.separator + "tmp" + "/errorVisualizarDocumento.pdf"); 
			e.printStackTrace( System.err );
		}

		ServletOutputStream stream 	= null;
		BufferedInputStream buf 	= null;    
		
		try {
			stream 		= response.getOutputStream();
			response.setContentType(tipoArchivoRetorno);
			response.setHeader("Cache-Control","no-cache"); 
			response.setHeader("Pragma","no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentLength((int) file.length());            
			buf = new BufferedInputStream(new FileInputStream(file));
			int readBytes = 0;
			while ((readBytes = buf.read()) != -1)
				stream.write(readBytes);
		}
		catch(Exception e){
			System.err.println( e.getMessage() );
			e.printStackTrace();
		}
		finally{
			if (stream != null)
				stream.flush();
			stream.close();
			if (buf != null)
				buf.close();
			if(file2 != null){
				if(file2.delete()){
					System.out.println("Borrado de archivo: "+file2.getPath());
				}else{
					System.out.println("No se Borrado de archivo: "+file2.getPath());
				}
			}            
		}
		Date fecha2 = new Date();
		
		System.out.println("Terminando Proceso: "+hourdateFormat.format(fecha2));

	}

}
