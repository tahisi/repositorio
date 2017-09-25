package com.bbva.didactic.principal;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import java.util.Map;

import org.apache.commons.ssl.Base64;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


import com.bbva.dicactic.parametros.ParametrosDidactic;
import com.syc.rig.client.RigClient;




public class GetDocumentDidactic {
	private static Logger log = Logger.getLogger(GetDocumentDidactic.class);
	public  static JSONObject buscaDoc(JSONObject entrada) 
	{

		JSONObject respuesta 	= new JSONObject();
		log.info("GetDocument ");
		respuesta= downloadfile(entrada);	
		
		return respuesta;

	}
	
	
	
	public  static  JSONObject downloadfile(JSONObject consulta) {
		
		String aplicacion 		= consulta.get("tituloAplicacion").toString();
		JSONArray arr 			= consulta.getJSONArray("atributos");
		JSONArray foliosArray	= consulta.getJSONArray("folio");
		JSONObject respuesta   	=  new JSONObject();

		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> folios = new HashMap<String, Object>();
		
		for(int i=0; i<foliosArray.length(); i++){   
			JSONObject a = foliosArray.getJSONObject(i);  
			folios.put("folio", a.getString("folioDigitalizacion"));
		}
		
		for(int i=0; i<arr.length(); i++){   
			JSONObject o = arr.getJSONObject(i);  
			maps.put(o.getString("campo"), o.get("valor"));
		}
		String opcion  = maps.get("opcion").toString();
		String folio = folios.get("folio").toString();
		log.info("RECIBO INFORMACION DOWNLOADFILE" );
		log.info("FOLIO " + folio);		

		log.info("APLICACION " + aplicacion );
		
		
		if(aplicacion.toUpperCase().trim().equals("DIDACTIC"))
		{

			if("base64".equalsIgnoreCase(opcion)){
		
					try {
						respuesta = DowFile(folio.trim());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				


			}
		}
		return respuesta;


	}
	
	public static JSONObject DowFile(String folio) throws Exception {

		RigClient  h 	= null 	;				
		JSONObject respuestaASO = new JSONObject();
		JSONArray exito 		= new JSONArray();
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> mapsError = new HashMap<String, Object>();

		try{
			if ("T".equals(ParametrosDidactic.AMBIENTE_ARCHIVING)) {
				h = new RigClient("http://150.225.99.157");	//AMBIENTES PREVIOS

			}else if("P".equals(ParametrosDidactic.AMBIENTE_ARCHIVING)){
				h = new RigClient();	 //PRODUCCION

			}
	

				OutputStream output = new ByteArrayOutputStream();
				try{

					
		
					h.download("didactic", folio, output);
					ByteArrayOutputStream bos = (ByteArrayOutputStream)output;
					String stringToStore = Base64.encodeBase64String(bos.toByteArray());// el DatosBuket[2] y DatosBuket[3]  corresponde a informacion que regresa archivin( _signature y sha1N )
					maps.put("url", "");
					maps.put("archivo", stringToStore.replace("\n", "").replace("\r", ""));
					exito.put(0, maps);

				}catch(Exception e){
					log.info("ERROR AL DESCARGAR DE ARCHIVING " , e);

					mapsError.put("codigo", "1");
					mapsError.put("mensaje", "ERROR AL DESCARGAR DE ARCHIVING ");
					mapsError.put("causa", e.getMessage());
				

				}
			


		
		}finally{
			respuestaASO.put("exito", exito);
			respuestaASO.put("error", mapsError);
			
		}


		return respuestaASO; // RETORNO LA RESPUESTA DE LA DESCARGA.
	}
	public static void main (String args[]){

String cadena = "{ "
		+ "\"tituloAplicacion\": \"DIDACTIC\","
		+ "\"folio\": [{ "
		+ "                   \"folioDigitalizacion\" : \"ENOTARIO@P001D1\", "
		+ "}], "
		+ "\"atributos\": [{ "
		+ "\"campo\": \"opcion\", "
		+ "\"valor\": \"base64\" "
		+ "} "
		+ "] }";
		System.out.println(cadena);
		JSONObject respuesta = null;
		JSONObject jsonObj = new JSONObject(cadena);
		respuesta=  buscaDoc(jsonObj);
//		respuesta = sendFileOI(jsonObj);
		System.out.println(respuesta);
		
//		return respuesta;
	//}

	
	}
}
