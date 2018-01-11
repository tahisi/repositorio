package visor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.ssl.Base64;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//import utils.CallProperties;
import utils.Datos;
//import utils.DatosProperties;

public class AuxVisorAvaluos {
//	DatosProperties getinfo = new DatosProperties();
//	CallProperties  datosproperties= getinfo.loadProperties();
	
	public File crearArchivoTemporal(String cadena64, String nombreDoc, String extDoc, int numAleatorio, String tempDir){		
		File fileRetorno = null;
		byte[] cadenEnBytes = Base64.decodeBase64(cadena64);
	    ByteArrayInputStream bais = new ByteArrayInputStream(cadenEnBytes);
//	    String ruta = datosproperties.getPathCarpetaDescarga();
	    boolean estatus =verificarExtensionArchivoImagenes(extDoc);
	    if(estatus==true){
	    	//String rutaArchivo=ruta+"\\"+nombreDoc+"_"+numAleatorio+extDoc;
	    	String rutaArchivo=tempDir+nombreDoc+"_"+numAleatorio+"."+extDoc;
		    File file = new File(rutaArchivo);    
		    try {
				file.createNewFile();			
				FileOutputStream fos = new FileOutputStream(rutaArchivo);
				fos.write(cadenEnBytes);
				fos.close();
				bais.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}		    
		    if(file.exists()){
		    	fileRetorno = new File(rutaArchivo);	    	
		    }
	    }	    
	    return fileRetorno;
	}//fin metodo
	
//	public Map<String,String> validarFolio(String folio){
//		Map<String,String> mapInfoFolioFinal = new HashMap<String,String>();
//		String patron;
//		patron ="^[0-9]{1,}[D][0-9]{1,}";
//		Pattern pat = Pattern.compile(patron);
//	    Matcher mat = pat.matcher(folio);	    
//	    if (mat.matches()) {
//	        mapInfoFolioFinal = obtenerDatosFolio(folio);
//	        mapInfoFolioFinal.put("estatus", "OK");
//	    } else {
//	        mapInfoFolioFinal.put("estatus", "NOOK");
//	    }
//	    return mapInfoFolioFinal;
//	}
	
//	public Map<String,String> obtenerDatosFolio(String folio){
//		String carpeta;
//	    String preFolio;
//	    String folioFinal;
//	    Map<String,String> mapInfoFolio = new HashMap<String,String>();
//        int numInicioFolio = folio.lastIndexOf("D");
//		int tam = folio.length();        
//		preFolio = folio.substring(numInicioFolio, tam);
//        carpeta = folio.substring(0, numInicioFolio);
//        folioFinal=folio;
////		System.out.println("TipoDocumento: "+preFolio);
////		System.out.println("Folio: "+carpeta);
////		System.out.println("NombreDocumento: "+folioFinal);
//		mapInfoFolio.put("preFolio", preFolio);
//		mapInfoFolio.put("carpeta", carpeta);
//		mapInfoFolio.put("folioFinal", folioFinal);
//		mapInfoFolio.put("estatus", "OK");
//		return mapInfoFolio;
//	}
	
	public boolean verificarExtensionArchivoImagenes(String nombreArchivo){
		boolean verificacion = false;
		String ext = nombreArchivo.substring(nombreArchivo.lastIndexOf(".")+1);
		String patron ="^jpeg|jpg|pdf|PDF|JPG";		
		//String patron ="^[a-zA-Z]{1}";
		Pattern pat = Pattern.compile(patron);
	    Matcher mat = pat.matcher(ext.toLowerCase());
	    if (mat.matches()) {
	        verificacion = true;
	    } else {	        
	        verificacion = false;
	    }
		return verificacion;
	}
	
	public Map<String,String> convertirCadenaJsonToMap(String cadenaJson){
		Map<String,String> retornaMapa = new HashMap<String,String>();
		if(!cadenaJson.startsWith("1|Error")){
			Gson gson = new Gson();
			Type tipoListaDatos = new TypeToken<List<Datos>>(){}.getType();
			List<Datos> listaDatos = gson.fromJson(cadenaJson, tipoListaDatos);
			Datos datos = listaDatos.get(0);
			System.out.println("Nombre Doc: "+datos.getNombre());
			System.out.println("Ext Doc: "+datos.getExtension());
			System.out.println("Error: "+datos.getError());
			retornaMapa.put("cadena64", datos.getCadena());
			retornaMapa.put("nombre", datos.getNombre());
			retornaMapa.put("extension", datos.getExtension());
			retornaMapa.put("error", datos.getError());
		}else{
			int posicion = cadenaJson.indexOf('|');
			String msnError = cadenaJson.substring(posicion+1);
			System.out.println("Error: "+msnError);
			retornaMapa.put("cadena64", msnError);
			retornaMapa.put("nombre", msnError);
			retornaMapa.put("extension", msnError);
			retornaMapa.put("error", "error");
		}
		return retornaMapa;

	}

}
