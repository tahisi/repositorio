package com.bbva.didactic.test;
//
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.ssl.Base64;
import org.json.JSONObject;

import com.bbva.didactic.principal.SendDocumentDidactic;

public class test {
	

	public static void main (String args[]){
		
		String ruta  = "E:\\BBVA\\E-notario\\";
		String nombreArchivo = "Tutorial para solicitar guias en DHL.mp4";
		String rutaC = ruta+nombreArchivo;
		 byte[] bFile = readBytesFromFile(rutaC);
			String   base64 = new String(Base64.encodeBase64(bFile));
		String cadena = "{ "
				+ "  	  \"tituloAplicacion\": \"DIDACTIC\","
				+ "  	  \"atributos\": [ "
				+ "  	    { "
				+ "  	      \"campo\": \"flujo\", "
				+ "  	      \"valor\": \"ENOTARIO\" "
				+ "},   "
				+ "  	    { "
				+ "  	      \"campo\": \"id_proceso\", " 
				+ "  	      \"valor\": \"001\" "
				+ "  	    },"
				+ "	    { "
				+ "  	      \"campo\": \"id_doc\","
				+ "  	      \"valor\": \"1\" "
				+ "  	    }, "
				+ "  	    { "
				+ "  	      \"campo\": \"nombreDoc\", " 
				+ "  	      \"valor\": \"guias dhl\" "
				+ "  	    },"
				+ "  	    { "
				+ "  	      \"campo\": \"usuario\", "
				+ "  	      \"valor\":  \"enotario\" "
				+ "  	    },"
				+ "  	    { "
				+ "  	      \"campo\": \"extension\", " 
				+ "  	      \"valor\": \"mp4\" "
				+ "  	    },"
				+ "  	    { "
				+ "  	      \"campo\": \"nombreArch\", " 
				+ "  	      \"valor\": \"Tutorial para solicitar guias en DHL.mp4\" "
				+ "  	    }"
		      	+ "  	  ], "

	+ "  	  \"byteFile\": \""+base64+"\" "
		      	+ "  	}";
		
		//System.out.println(cadena);
		JSONObject respuesta = null;
		JSONObject jsonObj = new JSONObject(cadena);
		SendDocumentDidactic oi = new SendDocumentDidactic();
		respuesta= oi.almacenaInformacion(jsonObj);
		System.out.println(respuesta);
	}
	
	private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }
	

	
	

}
