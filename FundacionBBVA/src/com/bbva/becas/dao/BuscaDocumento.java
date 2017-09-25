package com.bbva.becas.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;





public class BuscaDocumento {
	private static Logger log = Logger.getLogger(BuscaDocumento.class);
	public    JSONObject downloadfile(JSONObject consulta) {
		
	String aplicacion 		= consulta.get("tituloAplicacion").toString();
	JSONArray arr 			= consulta.getJSONArray("atributos");
	JSONArray foliosArray	= consulta.getJSONArray("folio");
	JSONObject respuesta   	= null;

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
	
	
	if(aplicacion.toUpperCase().trim().equals("BECAS"))
	{
		DescargoArchivo down = new DescargoArchivo();
		if("base64".equalsIgnoreCase(opcion)){
		try {
			respuesta= down.DowFile(folio.trim());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				respuesta = down.Folios(folio.trim());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	return respuesta;


}
}
