package com.bbva.didactic.principal;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.ssl.Base64;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bbva.dicactic.parametros.ParametrosDidactic;
import com.syc.rig.client.RigClient;
import com.syc.rig.client.RigClientException;



public class SendDocumentDidactic {



	private static Logger log = Logger.getLogger(SendDocumentDidactic.class); 
	
	private enum atributosFB   {flujo,id_proceso, id_doc, nombreDoc,usuario, extension, nombreArch};
		
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

				if("DIDACTIC".equalsIgnoreCase(titulo_aplicacion)){
					//Recorremos los atributos para mapearlos.
					for(int i=0; i<atributos.length(); i++){
						atributo = atributos.getJSONObject(i);
						log.info("Insertando al map (CAMPO): " + atributo.getString("campo").toString()
								+ ", (VALOR): " + atributo.getString("valor").toString());
						
						map.put(atributo.getString("campo").toString(), atributo.getString("valor").toString());
					}
	
					
					String flujo = (String)map.get(atributosFB.flujo.toString());
					String id_proceso = (String)map.get(atributosFB.id_proceso.toString());
					String id_documento =  (String)map.get(atributosFB.id_doc.toString());
					String nombreDocumento =  (String)map.get(atributosFB.nombreDoc.toString());
					String usuario = (String)map.get(atributosFB.usuario.toString());
					String extension  =  (String)map.get(atributosFB.extension.toString());
					String nombreArch = (String)map.get(atributosFB.nombreArch.toString()); 
					String base64 = documentBase64;
					byte [] archivo = Base64.decodeBase64(base64);
					String sha1  = DigestUtils.sha1Hex(archivo);
					int size =  archivo.length;
					try{
//						respuesta = addFile(flujo,id_proceso, id_documento, nombreDocumento, sha1,usuario, extension, nombreArch, size, archivo);
						respuesta = addFile(flujo, id_proceso, id_documento, nombreDocumento, sha1, size, usuario, extension, nombreArch, archivo)	;
					}catch(RigClientException r){
						r.printStackTrace();
					}
						
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
		
		public static JSONObject addFile (String flujo, String id_proceso, String id_documento,String  nombreDocumento, String  sha1, int size, String usuario, String extension, String nombreArch, byte[] archivo) throws Exception{
			
			
			RigClient  h 		= null; 	
			String folio  		= null;
			
			JSONObject exito 	= new JSONObject();
			JSONObject error 	= new JSONObject();
			JSONObject respuestaASO = new JSONObject();
			

				Map<String, Object> metadata 	= new HashMap<String, Object>();
				
				metadata 						=  generaMetadata(flujo,id_proceso, id_documento, nombreDocumento, sha1, usuario, extension, nombreArch, size);
				String folioArc =null;
				if ("P".equals(ParametrosDidactic.AMBIENTE_ARCHIVING)) {
					h	= new RigClient(); //PRODUCCION
				}else if("T".equals(ParametrosDidactic.AMBIENTE_ARCHIVING)){
					h =  new RigClient("http://150.100.22.50:9090");
				}
				
				String result  =  h.upload("didactic", metadata , archivo);
				JSONObject json = new JSONObject(result);
				
				try{	
				} catch (Exception e){
					e.printStackTrace();
				}
				if(!json.get("success").toString().equals("[]")){
					try{
						JSONArray success = json.getJSONArray("success");
						json = success.getJSONObject(0);
						folioArc = json.getString("_s3_key");
						System.out.println("FOLIO ARCHIVING" + folioArc);
					}catch (Exception e){
						e.printStackTrace();
					}
						
							
							folio = folioArc;  
							exito.put("folioDigitalizacion", folio);
							respuestaASO.put("exito", exito);
							respuestaASO.put("error", error);
						
						}
					
					
					
				
				return respuestaASO;
			}

		
		public static Map<String, Object>  generaMetadata (String flujo, String id_proceso, String id_documento,String  nombreDocumento, String  sha1,String usuario, String extension, String nombreArch,  int size){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			String date = sdf.format(new Date()); 
			
		
			Map<String, Object> metadata = new HashMap<String, Object>();
			metadata.put("t", flujo);   //Titulo aplicacion
			metadata.put("g", -1);    //id GAbinete
			metadata.put("c", -1);    //id Carpeta
			metadata.put("d", -1);    	//idDocumento
			metadata.put("v", -1);    //id version
			metadata.put("p", -1);     //id pagina
			metadata.put("f", flujo+"@P"+id_proceso+"D"+id_documento);      //folio Digitalizacion  
			metadata.put("cd", id_documento);		//clave del Documento
			metadata.put("nd", nombreDocumento);		//clave del Documento
			metadata.put("u", usuario);                  //usuario
			metadata.put("fd", date);            //fecha
			metadata.put("e", extension);                  //extension
			metadata.put("s", size); //tamaño archivo
			metadata.put("sha1N", sha1);   //Digestion SHA1 del Archivo
			metadata.put("n", nombreArch);
			metadata.put("ip", id_proceso);
		


			

			return metadata;
			
		}


		}


