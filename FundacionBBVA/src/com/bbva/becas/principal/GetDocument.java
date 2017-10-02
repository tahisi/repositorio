package com.bbva.becas.principal;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.bbva.becas.dao.BuscaDocumento;





public class GetDocument {
	private static Logger log = Logger.getLogger(GetDocument.class);
	public  static JSONArray buscaDoc(JSONObject entrada) 
	{
	
		JSONArray respuesta 		= new JSONArray();	
	
		log.info("GetDocument ");
		respuesta = new BuscaDocumento().downloadfile(entrada);
	
		return respuesta;

	}
	
	
	

}
