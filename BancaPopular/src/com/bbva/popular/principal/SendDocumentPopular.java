package com.bbva.popular.principal;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.ssl.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bbva.popular.bean.BeanPopular;
import com.bbva.popular.dao.AlmacenaPopular;

public class SendDocumentPopular {

	private enum atributosPopular  {tipoProceso, nombreEtapa, cveDoc, nombreDoc, contrato, nombreArchivo, extension, usuario};
	private enum atributosCR  {cr,  cveDoc, nombreArchivo, extension, usuario};
	
	
	public static JSONObject almacenaInformacion (JSONObject informacion){
		
		JSONObject respuesta 	= new JSONObject();
		JSONObject atributo 	= new JSONObject();
		String documentBase64, titulo_aplicacion;
		JSONArray atributos = new JSONArray();
		JSONObject codigoError = new JSONObject();
		JSONObject codigoExito = new JSONObject();
		System.out.println("RECIBIENDO ARCHIVO " + informacion.toString() );
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			titulo_aplicacion = (String) informacion.get("tituloAplicacion");
			documentBase64 = informacion.get("byteFile").toString();
			atributos = (JSONArray) informacion.get("atributos");

			if("POPULAR".equalsIgnoreCase(titulo_aplicacion)){
				//Recorremos los atributos para mapearlos.
				for(int i=0; i<atributos.length(); i++){
					atributo = atributos.getJSONObject(i);
					System.out.println("Insertando al map (CAMPO): " + atributo.getString("campo").toString()
							+ ", (VALOR): " + atributo.getString("valor").toString());
					
					map.put(atributo.getString("campo").toString(), atributo.getString("valor").toString());
				}

				
					BeanPopular popular = new  BeanPopular();
					byte []  archivo = null;
					if (map.get("flujo").equals("1")){
					System.out.println("Llenando BeanPopular");
					popular.setAplicacion(titulo_aplicacion);
					popular.setTipoProceso((String)map.get(atributosPopular.tipoProceso.toString()));
					popular.setNombreEtapa((String)map.get(atributosPopular.nombreEtapa.toString()));
					popular.setCveDoc((String)map.get(atributosPopular.cveDoc.toString()));
					popular.setNombreDoc((String)map.get(atributosPopular.nombreDoc.toString()));
					popular.setContrato((String)map.get(atributosPopular.contrato.toString()));
					popular.setNombreArchivo((String)map.get(atributosPopular.nombreArchivo.toString()));
					popular.setExtesion((String)map.get(atributosPopular.extension.toString()));
					popular.setUsuario((String)map.get(atributosPopular.usuario.toString()));
					popular.setBase64(documentBase64);
					archivo = Base64.decodeBase64(popular.getBase64());
					popular.setSha1(DigestUtils.sha1Hex(archivo));
					popular.setSize(archivo.length);
			} else {
				System.out.println("Llenando BeanPopular para CR");
				popular.setAplicacion(titulo_aplicacion);
				popular.setTipoProceso("POPULAR");
				popular.setContrato((String)map.get(atributosCR.cr.toString()));
				popular.setNombreEtapa("NA");
				popular.setCveDoc((String)map.get(atributosCR.cveDoc.toString()));
				popular.setNombreDoc("NA");
			
				popular.setNombreArchivo((String)map.get(atributosCR.nombreArchivo.toString()));
				popular.setExtesion((String)map.get(atributosCR.extension.toString()));
				popular.setUsuario((String)map.get(atributosCR.usuario.toString()));
				popular.setBase64(documentBase64);
				 archivo = Base64.decodeBase64(popular.getBase64());
				popular.setSha1(DigestUtils.sha1Hex(archivo));
				popular.setSize(archivo.length);
			}
					respuesta = new AlmacenaPopular().addFile(popular, archivo);
										
				
			} else {
				System.out.println("El titulo de la aplicacion no corresponde a nuestro flujo: " + titulo_aplicacion);
				codigoError.put("codigo","0");
				codigoError.put("mensaje","Aplicacion no valida");
				codigoError.put("causa","Aplicacion diferente a FABRICA");

				respuesta.put("exito", codigoExito);
				respuesta.put("error", codigoError);
			}	
		} catch(NullPointerException  e){
			System.out.println("Error al procesar la informacion: " + e.getCause());
			codigoError.put("codigo","0");
			codigoError.put("mensaje","Parametros nulos");
			codigoError.put("causa","Parametros nulos");
			
			respuesta.put("exito", codigoExito);
			respuesta.put("error", codigoError);
		} catch(JSONException  e){
			System.out.println("Error al procesar la informacion: " + e.getMessage());
			codigoError.put("codigo","0");
			codigoError.put("mensaje",e.getMessage());
			codigoError.put("causa","Error en la estructura del JSON");
			
			respuesta.put("exito", codigoExito);
			respuesta.put("error", codigoError);
		} catch(Exception e){
			e.printStackTrace();
			codigoError.put("codigo","0");
			codigoError.put("mensaje","Error desconocido POPULAR");
			codigoError.put("causa",e.getCause());
			
			respuesta.put("exito", codigoExito);
			respuesta.put("error", codigoError);
		}
		
		return respuesta;
		
	}
	
}
