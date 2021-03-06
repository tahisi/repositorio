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
	public  static JSONArray buscaDoc(JSONObject entrada) 
	{

		JSONArray respuesta 	= new JSONArray();
		log.info("GetDocument ");
		respuesta= downloadfile(entrada);	
		
		return respuesta;

	}
	
	
	
	public  static  JSONArray downloadfile(JSONObject consulta) {
		
		String aplicacion 		= consulta.get("tituloAplicacion").toString();
		JSONArray arr 			= consulta.getJSONArray("atributos");
		JSONArray foliosArray	= consulta.getJSONArray("folio");
		JSONArray respuesta   	=  new JSONArray();
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
	
	public static JSONArray DowFile(String folio) throws Exception {

		RigClient  h 	= null 	;				
		JSONObject respuestaASO = new JSONObject();
		JSONObject exito 		= new JSONObject();
		JSONArray resp 		= new JSONArray();
//		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> mapsError = new HashMap<String, Object>();

		try{
			if ("T".equals(ParametrosDidactic.AMBIENTE_ARCHIVING)) {
				h = new RigClient("http://150.100.22.50:9090");	//AMBIENTES PREVIOS

			}else if("P".equals(ParametrosDidactic.AMBIENTE_ARCHIVING)){
				h = new RigClient();	 //PRODUCCION

			}
	

				OutputStream output = new ByteArrayOutputStream();
				try{

					
		
					h.download("didactic", folio, output);
					ByteArrayOutputStream bos = (ByteArrayOutputStream)output;
					String stringToStore = Base64.encodeBase64String(bos.toByteArray());// el DatosBuket[2] y DatosBuket[3]  corresponde a informacion que regresa archivin( _signature y sha1N )
					exito.put("url", "");
					exito.put("archivo", stringToStore.replace("\n", "").replace("\r", ""));
					//exito.put(0, maps);

				}catch(Exception e){
					log.info("ERROR AL DESCARGAR DE ARCHIVING " , e);

					mapsError.put("codigo", "1");
					mapsError.put("mensaje", "ERROR AL DESCARGAR DE ARCHIVING ");
					mapsError.put("causa", e.getMessage());
				

				}
			


		
		}finally{
			if (exito.length() != 0){
			respuestaASO.put("exito", exito);
			}
			if(mapsError.size() != 0){
			respuestaASO.put("error", mapsError);
			}
			resp.put(respuestaASO);
		}


		return resp; // RETORNO LA RESPUESTA DE LA DESCARGA.
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
		JSONArray respuesta = null;
		JSONObject jsonObj = new JSONObject(cadena);
		respuesta=  buscaDoc(jsonObj);
//		respuesta = sendFileOI(jsonObj);
		System.out.println(respuesta);
		
//		return respuesta;
	//}

	
	}
}
