package processinter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.HashMap;

import java.util.Map;

import org.apache.commons.ssl.Base64;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


import com.syc.bancomer.dsmngr.DataSourceManager;
import com.syc.bancomer.utils.ConfiguracionAval;
import com.syc.rig.client.RigClient;

import dao.GetDatosBD;


public class DescargoArchivo extends DataSourceManager {
	private Logger log = Logger.getLogger(DescargoArchivo.class);

	public JSONObject DowFile(String ID) throws Exception {
		Connection conn = null;
		RigClient  h 	= null 	;				
		JSONObject respuestaASO = new JSONObject();
		JSONArray exito 		= new JSONArray();
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> mapsError = new HashMap<String, Object>();
		
		try{
			if ("P".equals(ConfiguracionAval.AMBIENTE_ARCHIVING)) {
				h = new RigClient("http://150.225.99.157");	//AMBIENTES PREVIOS

			}else if("T".equals(ConfiguracionAval.AMBIENTE_ARCHIVING)){
				h = new RigClient();	 //PRODUCCION

			}
			conn = getConnectionStatic();
//			BuscaBD db	= new BuscaBD();
//			conn 		= db.Buscaconexion();
			String InfBuket 		= GetDatosBD.GetBuketArchivo(conn, ID);
			String [] DatosBuket 	= InfBuket.split("@");
			if(!DatosBuket[0].contains("Error")){

				OutputStream output = new ByteArrayOutputStream();
				try{

					h.download(DatosBuket[0], DatosBuket[1], output);
					ByteArrayOutputStream bos = (ByteArrayOutputStream)output;
					String stringToStore = Base64.encodeBase64String(bos.toByteArray());// el DatosBuket[2] y DatosBuket[3]  corresponde a informacion que regresa archivin( _signature y sha1N )
					//					Arreglodedatos2.add(new JsonDescarga(stringToStore.replace("\n", "").replace("\r", ""), DatosBuket[4], DatosBuket[5], ""));
					maps.put("url", "");
					maps.put("archivo", stringToStore.replace("\n", "").replace("\r", ""));

					exito.put(0, maps);


				}catch(Exception e){
					log.info("ERROR AL DESCARGAR DE ARCHIVING " , e);

					mapsError.put("codigo", "1");
					mapsError.put("mensaje", "ERROR AL DESCARGAR DE ARCHIVING ");
					mapsError.put("causa", e.getMessage());
					//					Arreglodedatos2.add(new JsonDescarga("", "", "", e.getMessage()));

				}
			}else{
				mapsError.put("codigo", "2");
				mapsError.put("mensaje", "EL DOCUMENTO NO EXISTE");
				mapsError.put("causa", "NO EXISTE ESTE DOCUMENTO EN BD");
				//				Arreglodedatos2.add(new JsonDescarga("", "", "", "No existe este documento."));

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mapsError.put("codigo", "2");
			mapsError.put("mensaje", "ERROR AL HACER LA CONECTAR CON BASE DE DATOS");
			mapsError.put("causa", e.getMessage()); 
			log.info("Error: " , e );
		}finally{
			respuestaASO.put("exito", maps);
			respuestaASO.put("error", mapsError);
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			conn = null;
		}


		return respuestaASO; // RETORNO LA RESPUESTA DE LA DESCARGA.
	}
	

}
