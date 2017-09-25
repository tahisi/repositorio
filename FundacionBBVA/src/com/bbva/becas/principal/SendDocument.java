package com.bbva.becas.principal;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.ssl.Base64;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bbva.becas.bean.BecasBean;
import com.bbva.becas.dao.AlmacenaDocto;

public class SendDocument {


	private static Logger log = Logger.getLogger(SendDocument.class); 
	
	private enum atributosFB   {numeroCliente, numeroCuenta, cr, nombreBeca, ciclo, nombreDoc, cveDoc, extension,  primera, ultima, usuario,  nombreArchivo};
		
		public static JSONObject almacenaInformacion (JSONObject informacion){
			
			JSONObject respuesta 	= new JSONObject();
			JSONObject atributo 	= new JSONObject();
			String documentBase64, titulo_aplicacion;
			JSONArray atributos = new JSONArray();
			JSONObject codigoError = new JSONObject();
			JSONObject codigoExito = new JSONObject();
			
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				titulo_aplicacion = (String) informacion.get("tituloAplicacion");
				documentBase64 = informacion.get("byteFile").toString();
				atributos = (JSONArray) informacion.get("atributos");

				if("BECAS".equalsIgnoreCase(titulo_aplicacion)){
					//Recorremos los atributos para mapearlos.
					for(int i=0; i<atributos.length(); i++){
						atributo = atributos.getJSONObject(i);
						log.info("Insertando al map (CAMPO): " + atributo.getString("campo").toString()
								+ ", (VALOR): " + atributo.getString("valor").toString());
						
						map.put(atributo.getString("campo").toString(), atributo.getString("valor").toString());
					}
	
					
					BecasBean becas = new  BecasBean();
						log.info("Llenando BeanBecas");
						becas.setIdAplicacion(1);
						becas.setNumeroCliente((String)map.get(atributosFB.numeroCliente.toString()));
						becas.setNumeroCuenta((String)map.get(atributosFB.numeroCuenta.toString()));
						becas.setCr((String)map.get(atributosFB.cr.toString()));
						becas.setCveDoc((String)map.get(atributosFB.cveDoc.toString()));
						becas.setNombreBeca((String)map.get(atributosFB.nombreBeca.toString()));
						becas.setUsuario((String)map.get(atributosFB.usuario.toString()));
						becas.setExtension((String)map.get(atributosFB.extension.toString()));
						becas.setCicloEscolar((String)map.get(atributosFB.ciclo.toString()));
						becas.setNombreDocto((String)map.get(atributosFB.nombreDoc.toString()));
						becas.setNombreArch((String)map.get(atributosFB.nombreArchivo.toString()));
						becas.setPrimera((String)map.get(atributosFB.primera.toString()));
						becas.setUltima((String)map.get(atributosFB.ultima.toString()));
						becas.setBase64(documentBase64);
						byte [] archivo = Base64.decodeBase64(becas.getBase64());
						becas.setSha1(DigestUtils.sha1Hex(archivo));
						becas.setSize(archivo.length);
						respuesta = new AlmacenaDocto().addFile(becas, archivo);
											
					
				} else {
					log.info("El titulo de la aplicacion no corresponde a nuestro flujo: " + titulo_aplicacion);
					codigoError.put("codigo","0");
					codigoError.put("mensaje","Aplicacion no valida");
					codigoError.put("causa","Aplicacion diferente a FABRICA");

					respuesta.put("exito", codigoExito);
					respuesta.put("error", codigoError);
				}	
			} catch(NullPointerException  e){
				log.error("Error al procesar la informacion: " + e.getCause());
				codigoError.put("codigo","0");
				codigoError.put("mensaje","Parametros nulos");
				codigoError.put("causa","Parametros nulos");
				
				respuesta.put("exito", codigoExito);
				respuesta.put("error", codigoError);
			} catch(JSONException  e){
				log.error("Error al procesar la informacion: " + e.getMessage());
				codigoError.put("codigo","0");
				codigoError.put("mensaje",e.getMessage());
				codigoError.put("causa","Error en la estructura del JSON");
				
				respuesta.put("exito", codigoExito);
				respuesta.put("error", codigoError);
			} catch(Exception e){
				log.error("Error al procesar la informacion: " + e.getCause());
				codigoError.put("codigo","0");
				codigoError.put("mensaje","Error desconocido");
				codigoError.put("causa","Error desconocido");
				
				respuesta.put("exito", codigoExito);
				respuesta.put("error", codigoError);
			}
			
			return respuesta;
			
		}
		
}
