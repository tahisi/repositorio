
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.ssl.Base64;
import org.json.JSONObject;

import fd.org.apache.http.HttpResponse;
import fd.org.apache.http.client.ClientProtocolException;
import fd.org.apache.http.client.HttpClient;
import fd.org.apache.http.client.methods.HttpPost;
import fd.org.apache.http.entity.StringEntity;
 
/**
*
 * @author Felipon
*
*/
public class Principal {
 
                public static void main(String[] args) throws IOException {
                              
//                               String uri = "http://150.250.235.63:31201/fimxlive_mx_web/jaxrs/alta";
                              String uri = "http://150.100.210.236:36015/fimxlive/jaxrs/alta/";
                               InputStreamReader isr = null;
                               BufferedReader br     = null;
                               String nombre_archivo ="becasIntegracion2.txt";
                       			String ruta_base = "E:\\BBVA\\Fundacion BBVA\\Migracion HigSales Produccion\\BI\\";
                       			BufferedReader linea = null;
                       			String cadena;
                       			Date fechaInicio = new Date();
                       			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
                       			File salida 			= new File (ruta_base+nombre_archivo +"Salida"+ dateFormat.format(fechaInicio)+".txt");
                       			FileWriter salidaw			= new FileWriter(salida);
                       			BufferedWriter salidabw 	= new BufferedWriter(salidaw);
                       			PrintWriter salidawr 		= new PrintWriter(salidabw);
                       			linea = new BufferedReader(new InputStreamReader(new FileInputStream(ruta_base+nombre_archivo),"ISO-8859-1"));
                       			while((cadena=linea.readLine()) != null){
                       			String datos [] = cadena.split("\\|");
                       			//Cliente |cuenta |cr|beca|version|tipodocumento|numero_pagina|generacion|fecha digitalizacion|usuario|extension|calificacion|nivelescolar|grado|periodo|cicloescolar|nombrearchivo|totalpaginas1
                       			String cliente = datos [0];
                       			String cuenta = datos[1];
                       			String cr = datos[2];
                       			if(cr.equals("")){
                       				cr= "NA";
                       			}
                       			String beca = datos [3];
                       			String tp_docto = datos[5];
                       			String numero_pagina = datos[6];
                       			String  generacion =datos[7];
                       			String fecha = datos[8];
                       			String usuario = datos[9];
                       			String extension =datos[10];
                       			String nombreArchivo = datos[16].replace("/", "\\");
                       			String totalpaginas = datos[17];
                       			String primera = "";
                       			String ultima = "";
                       			String ruta = ruta_base + nombreArchivo;
                       		   byte[] bFile = readBytesFromFile(ruta);
//                       		String base64 =   Base64.encodeBase64String(bFile);
                             //read file into bytes[]
                           
//                       		String base64 = Base64.encodeBase64String(contenido).replaceAll("\n", "");
                       			String   base64 = new String(Base64.encodeBase64(bFile));
                       	
//                       		String base64Encoded = Base64.getEncoder().encodeToString(bFile);
                       			if(numero_pagina.equals("1")){
                       				primera = "true";
                       			}else {
                       				primera = "false";
                       			}
                       			if(numero_pagina.equals(totalpaginas)){
                       				ultima ="true";
                       			}else{
                       				ultima = "false";
                       			}
                       				
                       			String alta = "{ "
                       					+ "  	  \"tituloAplicacion\": \"BECAS\","
                       					+ "  	  \"atributos\": [ "
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"numeroCliente\", "
                       					+ "  	      \"valor\": \""+cliente+"\" "
                       					+ "},   "
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"numeroCuenta\", " 
                       					+ "  	      \"valor\": \""+cuenta+"\" "
                       					+ "  	    },"
                       					+ "	    { "
                       					+ "  	      \"campo\": \"cr\","
                       					+ "  	      \"valor\": \""+cr+"\" "
                       					+ "  	    }, "
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"nombreBeca\", " 
                       					+ "  	      \"valor\": \""+beca+"\" "
                       					+ "  	    },"
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"nombreDoc\", " 
                       					+ "  	      \"valor\": \""+tp_docto+"\" "
                       					+ "  	    },"
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"cveDoc\", " 
                       					+ "  	      \"valor\": \""+tp_docto+"\" "
                       					+ "  	    },"

                       					+ "  	    { "
                       					+ "  	      \"campo\": \"ciclo\", "
                       					+ "  	      \"valor\":  \""+generacion+"\" "
                       					+ "  	    }, "
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"extension\", "
                       					+ "  	      \"valor\":  \""+extension+"\" "
                       					+ "  	    },"
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"nombreArchivo\", "
                       					+ "  	      \"valor\":  \""+nombreArchivo.substring(9)+"\" "
                       					+ "  	    },"
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"usuario\", "
                       					+ "  	      \"valor\":  \""+usuario+" \" "
                       					+ "  	    },"
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"primera\", "
                       					+ "  	      \"valor\":  \""+primera+"\" "
                       					+ "  	    },"
                       					+ "  	    { "
                       					+ "  	      \"campo\": \"ultima\", "
                       					+ "  	      \"valor\":  \""+ultima+"\" "
                       					+ "  	    }"
                       			      	+ "  	  ], "
                       			  	+ "  	  \"byteFile\": \""+base64+"\" "
                       				

                       			      	+ "  	}";
                       			

                       				try {
//                       					System.out.println(alta);
                       					HttpClient client = new fd.org.apache.http.impl.client.DefaultHttpClient();
                       					HttpPost post = new HttpPost(uri);

                       					StringEntity input = new StringEntity(alta);
                       					input.setContentType("application/json");
                       					post.setEntity(input);

                       					HttpResponse response = client.execute(post);

                       					System.out.println("contentTypeResponse: " + response.getEntity().getContentType());

                       					isr = new InputStreamReader(response.getEntity().getContent());
                       					br = new BufferedReader(isr);
                       					String line = "";
                       					while ((line=br.readLine()) != null) {
                       						JSONObject jsonObj = new JSONObject(line);
//                       						System.out.println(jsonObj);
                       						String folio ="";
                       						String exito = (String) jsonObj.get("exito").toString();
//                       						String error = (String) jsonObj.get("error").toString();
                       						if(!exito.equals(""))
                       						 folio= new JSONObject(exito).getString("folioDigitalizacion");
                       						System.out.println(folio);
                       						if(ultima.equals("true")){
//                       						cadena = cadena + "|"+ folio +"|" + error;
                       							cadena = cadena + "|"+ folio ;
                       						salidawr.write( cadena);
                       						salidawr.write("\n");
                       						}
                       					}

                       				} catch (UnsupportedEncodingException e) {
                       					e.printStackTrace();
                       				} catch (ClientProtocolException e) {
                       					e.printStackTrace();
                       				} catch (IOException e) {
                       					e.printStackTrace();
                       				} finally {
                       					try {
                       						if (br != null)
                       							br.close();
                       						if (isr != null)
                       							isr.close();
                       					} catch (IOException e) {
                       						e.printStackTrace();
                       					}
                       				}
                       			}
                       			salidawr.close();
                    			salidabw.close();
                }
                
                
                private static byte[] readBytesFromFile(String filePath) {

                    FileInputStream fileInputStream = null;
                    byte[] bytesArray = null;

                    try {

                        File file = new File(filePath);
                        bytesArray = new byte[(int) file.length()];

                        //read file into bytes[]
                        fileInputStream = new FileInputStream(file);
                        fileInputStream.read(bytesArray);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                    return bytesArray;

                }

}