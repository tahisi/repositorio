package com.bbva.firdig.alta.principal;

//import java.util.HashMap;
//import java.util.Map;

//import org.apache.commons.ssl.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

//import com.google.gson.JsonElement;

import syc.bbva.firdig.ws.DigitalizacionService;
import syc.bbva.firdig.ws.DigitalizacionServiceDelegate;

public class DigitalizacionServiceConsulta {
public static   JSONArray getFile(JSONObject Documento){
		
		String aplicacion 		= Documento.get("tituloAplicacion").toString();
//		String folio 			= Documento.getJSONArray("atributos");
		JSONArray arr 			= Documento.getJSONArray("atributos");
		JSONObject atributo		= new JSONObject();
		String listaCampos		= "";
		String listaValores		= "";
		String respuesta		= null;
		JSONObject respuestaASO = new JSONObject();
		JSONArray  resp 		= new JSONArray();
		JSONObject exito 		= new JSONObject();
		JSONObject error 		= new JSONObject();
//		Map<String, Object> maps = new HashMap<String, Object>();
		String nb_atributo  = null;
	if (aplicacion.equalsIgnoreCase("FIRDIG")){

		for(int i=0; i<arr.length(); i++){
			atributo = arr.getJSONObject(i);
			nb_atributo = atributo.getString("campo");
			if(nb_atributo.equals("claveDocumento")){
				 nb_atributo = nb_atributo.replaceAll("claveDocumento", "cveDocumento");
			}
            listaCampos = listaCampos + nb_atributo;
            listaValores = listaValores + atributo.getString("valor");
            if(i!=arr.length()-1){
            	listaCampos = listaCampos + "|";
            	listaValores = listaValores + "|";
            }
            
            }
		System.out.println("lista Campos"+ listaCampos);
		System.out.println("lista Valores" + listaValores );
		
		DigitalizacionService service = new DigitalizacionService ();
		DigitalizacionServiceDelegate del = service.getDigitalizacionServicePort();
//		byte[] genericFile = Base64.decodeBase64(archivo);
		respuesta= 	del.servicioGlobal(null , listaCampos, listaValores);
		
	 if(respuesta.contains("<resp status='false'>")){
		error.put("codigo", "003");
		error.put("causa", respuesta);
		error.put("mensaje", "Error");
//		respuestaASO.put("exito", exito);
		respuestaASO.put("error", error);
	}else if(respuesta.contains("parámetro")){
		error.put("codigo", "002");
		error.put("causa", respuesta);
		error.put("mensaje", "Error");
//		respuestaASO.put("exito", exito);
		respuestaASO.put("error", error);
	}else if(respuesta.contains("<resp status='error'>")){
		error.put("codigo", "005");
		error.put("causa", "Error");
		error.put("mensaje", respuesta);
//		respuestaASO.put("exito", exito);
		respuestaASO.put("error", error);
		resp.put(respuestaASO);
		
	}else{

		exito.put("url", "");
		exito.put("archivo",respuesta);

//		exito.put(0, maps);
		if(exito.length() !=0  ){
			respuestaASO.put("exito", exito);
		}
		if (error.length()!= 0){
			respuestaASO.put("error", error);
		}
		resp.put(respuestaASO);
	}
		
	}else{
		error.put("codigo", "005");
		error.put("causa", "TituloAplicacion no definido" );
		error.put("mensaje", "Error");
//		respuestaASO.put("exito", exito);
		respuestaASO.put("error", error);
		resp.put(respuestaASO);
	}
	return  resp;
	}
public static void main (String args[]){

String cadena = "{ "
		+ "\"tituloAplicacion\": \"FIRDIG\","
		+ "\"folio\": [{ "
		+ "                   \"folioDigitalizacion\" : \"0\", "
		+ "}], "
		+ "\"atributos\": [{ "
		+ "\"campo\": \"tipoOperacion\", "
		+ "\"valor\": \"getFirmaCliente\" "
		+ "}, "
		+"{ "
		+ "\"campo\": \"numeroCliente\", "
		+ "\"valor\": \"00516279\" "
		+ "}, "
		+"{ "
		+ "\"campo\": \"claveDocumento\", "
		+ "\"valor\": \"255\" "
		+ "} "
		+ "] }";
		System.out.println(cadena);
		JSONArray respuesta = new JSONArray();
		JSONObject jsonObj = new JSONObject(cadena);
		respuesta=  getFile(jsonObj);
//		respuesta = sendFileOI(jsonObj);
		System.out.println(respuesta);
		
//		return respuesta;
	}
}
