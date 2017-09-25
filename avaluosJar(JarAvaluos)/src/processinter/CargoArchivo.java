package processinter;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.ssl.Base64;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.syc.bancomer.bean.beanRespuesta;
import com.syc.bancomer.dsmngr.DataSourceManager;
import com.syc.bancomer.utils.ConfiguracionAval;
import com.syc.rig.client.RigClient;

import dao.GetDatosBD;
import dao.GuardoDatosBD;



public class CargoArchivo extends DataSourceManager{
	
private static Logger log = Logger.getLogger(CargoArchivo.class);

public beanRespuesta AgregoArchivo(String CADENABASE64,String Folio,String ID,String extension,String aplicacion, beanRespuesta  bean) throws SQLException {


	JSONObject obj 	= null;
	Connection conn = null;
	int insertareg 	= -1;
	int existeExp 	= -1;
	RigClient  h = null 	;	
	

	try { 

		log.info("-------------- INICIO CONECTAR RIGCLIENT -------------- ");
		if ("P".equals(ConfiguracionAval.AMBIENTE_ARCHIVING)) {
		h	= new RigClient(); //PRODUCCION
		}else if("T".equals(ConfiguracionAval.AMBIENTE_ARCHIVING)){
		h =  new RigClient("http://150.225.99.157");
		}
		
		log.info("-------------- DESPUES DE  CONECTAR RIGCLIENT -------------- " + h);
		
		
		conn 				 = getConnectionStatic();
//		BuscaBD bd= new BuscaBD();
//		conn = bd.Buscaconexion();
		
		log.info("-------------- CONEXION ESTABLECIDA" + conn );
		GetDatosBD datos 	 = new GetDatosBD();
		GuardoDatosBD guarda = new GuardoDatosBD();

		existeExp = datos.Existe(conn, ID);
		extension = extension.toLowerCase();
		if(existeExp != 0){

			byte [] buf = Base64.decodeBase64(CADENABASE64);

			insertareg = guarda.AlmacenoInformacionLocal(conn,aplicacion,"",Folio,"@Llave","1",extension,"A",ID);

			if(insertareg ==1){
				Map<String, Object> metadata = new HashMap<String, Object>();
				MapArchiving m= new MapArchiving();
				metadata =  m.generaMetadata(aplicacion, Folio, ID, extension, buf);
				try {
					log.info("-------------- RIGCLIENT UPLOAD --------------" + h);
					obj = GetJson(h.upload("avaluo", metadata , buf));
					log.info("-------------- REGRESO FOLIO DE ARCHIVING  " + ID +" -------------- " + obj);					    
				} catch (Exception e) {

					log.info("ERROR AL CARGAR A ARCHIVING  ", e);
					//regreso ="1|Error al cargar a archiving";
					bean.setCodigo("0");
					bean.setMensaje("Error al cargar en archiving");
					bean.setCausa("Archiving");
					
				}

				if(!obj.get("success").toString().equals("[]")){

					obj = GetJson(obj.get("success").toString().replace("[","").replace("]",""));
					log.info("VALIDANDO SHA");
					if(obj.get("sha1N").equals(Digestion.GetSha1(buf)))
					{	
						log.info("ACTUALIZANDO FOLIO ARCHIVNG, SHA OK");
						bean=guarda.ActualizoInformacionLocal(conn,aplicacion,"",Folio,format("%s@%s@%s@%s",obj.getString("_s3_bucket"),obj.getString("_s3_key"),obj.getString("_signature"),obj.getString("sha1N")),"2",extension,"A",ID, bean);
						conn.commit();
					}else{
						log.info("SHA DIFERENTE REALIZA ROLLBACK ");
						bean.setCodigo("1");
						bean.setMensaje("Error al almacenar Archiving");
						bean.setCausa("Sha1 diferente");
//						regreso = "1|Error al almacenar Archiving SHA1 DIFERENTE";
						conn.rollback();
					}

				}else{

					log.info("OCURRIO ERROR DE ARCHIVING");
				
					obj = GetJson(obj.get("error").toString().replace("[","").replace("]",""));
					log.info("ERROR " + obj.getString("_error_message"));
//					regreso = "1|Error " ;
					bean.setCodigo("1");
					bean.setMensaje("Error al almacenar en Archiving");
					bean.setCausa("Error");
					conn.rollback();
					if(obj.getString("_error_message").contains("El archivo ya existe")){

						obj = GetJson(obj.get("error").toString().replace("[","").replace("]",""));
						log.info("ERROR " + obj.getString("_error_message"));
						log.info("1|Error el Archivo ya Existe.. en Archiving");
//						regreso="1|Error el Archivo ya Existe..";
						bean.setCodigo("1");
						bean.setMensaje("Error el Archivo ya Existe");
						bean.setCausa("Archivo ya existe en Archiving");

					}else{
//						regreso="1|Error al querer almacenar en Archiving.";
						bean.setCodigo("1");
						bean.setMensaje("Error al querer almacenar en Archiving");
						bean.setCausa("Error al querer almacenar en Archiving");
					}


				}

			}
			else{
				bean.setCodigo("1");
				bean.setMensaje("Error no fue posible registrar el archivo");
				bean.setCausa("Problema al insertar en BD");
				log.info("1|Error no fue posible registrar el archivo");
//				regreso ="1|Error no fue posible registrar el archivo";
			}
		}else{
			bean.setCodigo("1");
			bean.setMensaje("Error el Archivo ya Existe en BD");
			bean.setCausa("Folio ya esta dado de alta");

			log.info("1|Error el Archivo ya Existe en BD..");
//			regreso="1|Error el Archivo ya Existe..";

		}

	} catch (Exception e) {
		
		log.info("ERROR ", e);
//		regreso="1|Error "+ e.getMessage();
		bean.setCodigo("1");
		bean.setMensaje("Error inesperado");
		bean.setCausa("");
//		conn.rollback();
		
	}finally{

		if (conn!= null) conn.close();
		conn= null;
	}

	log.info("TERMINO CARGA DE DOCUMENTO " + bean);
	return bean;
}
	
	
	
	private JSONObject GetJson(String  obj){
		
		JSONObject	regreso = new JSONObject(obj);
	
		return regreso;
	}
	
	

	
}
