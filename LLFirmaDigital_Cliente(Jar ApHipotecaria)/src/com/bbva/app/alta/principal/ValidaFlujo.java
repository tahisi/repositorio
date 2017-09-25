package com.bbva.app.alta.principal;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


public class ValidaFlujo {
	
	private static Logger log = Logger.getLogger(ValidaFlujo.class);
	
	public static  JSONObject AppLabHipotecaria(JSONObject entrada)
	{

		JSONArray arr 				= entrada.getJSONArray("atributos");
		JSONObject respuesta 		= new JSONObject();
		Map<String, Object> maps 	= new HashMap<String, Object>();
		JSONObject exito 			= new JSONObject();
		JSONObject error 			= new JSONObject();
		int flujo 					= 1;			
				;
		for(int i=0; i<arr.length(); i++){   
			JSONObject o = arr.getJSONObject(i);  
			if(o.getString("campo").equals("propuesta")){
				flujo = 2;
			}else if(o.getString("campo").equals("flujo")){
				flujo =3;
			}
			maps.put(o.getString("campo"), o.get("valor"));

		}
		RecibeDoctoOI docto = new RecibeDoctoOI();
		if (flujo ==  1){
			log.info("--------- Flujo  addFile -------- " );
		
		
//		if (maps.get("Flujo").toString().equals("doctoTemp")){
//			respuesta= 	docto.RecibeDoctoOI(entrada);
			respuesta =  docto.addFile(entrada);
			
		
//			respuesta = avaluos.deleteFile(entrada);
			
		
		}else if(flujo ==2){
			respuesta = docto.sendFileOI(entrada);
			
		}else if(flujo ==3 ){
			respuesta = docto.findDocs(entrada);
		}
		
		else{
			error.put("codigo", "002");
			error.put("mensaje", "El atributo -| Flujo |- no viene informado");
			error.put("causa", "Informacion nula");
			respuesta.put("exito", exito);
			respuesta.put("error", error);
			
		}
		
		return respuesta;

	}
	
	

}
