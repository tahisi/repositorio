package processinter;

import java.sql.Connection;
import java.sql.SQLException;


import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.syc.bancomer.dsmngr.DataSourceManager;

import dao.GetDatosBD;


public class GetExpediente  extends DataSourceManager{
	private Logger log = Logger.getLogger(GetExpediente.class);
	
	public JSONObject traigoExpediente(String FOLIOEXPEDIENTE) {
		
		log.info("Entro a traer el expediente");
		String regreso = null;

		Connection conn = null;
		JSONObject exito = new JSONObject();
		JSONObject error = new JSONObject();
		JSONObject respuestaASO = new JSONObject();
		try {
			conn = getConnectionStatic();
//			BuscaBD bd= new BuscaBD();
//			conn = bd.Buscaconexion();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		regreso=GetDatosBD.GetExpediente(conn, FOLIOEXPEDIENTE);
		
		if(!regreso.equals("")){
//			datos =  regreso.toArray(new String[regreso.size()]);
			exito.put("folioDigitalizacion", regreso);
		}else {
			error.put("codigo", "1");
			error.put("mensaje", "No se encontro ningun archivo en este expediente");
			error.put("causa", "El folio no exite en base de datos");
//			datos =  regreso.toArray(new String[regreso.size()]);
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info("Error: "+ e.getMessage());
		}
		respuestaASO.put("exito" , exito);
		respuestaASO.put("error" , error);
	    return respuestaASO;
		
	}
	

}
