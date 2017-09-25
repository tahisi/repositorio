package com.bbva.becas.principal;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.bbva.becas.dao.BuscaDocumento;



public class GetDocument {
	private static Logger log = Logger.getLogger(GetDocument.class);
	public  static JSONObject buscaDoc(JSONObject entrada) 
	{

		JSONObject respuesta 		= new JSONObject();		
		log.info("GetDocument ");
		respuesta = new BuscaDocumento().downloadfile(entrada);
		
		return respuesta;

	}
	
	
	

}
