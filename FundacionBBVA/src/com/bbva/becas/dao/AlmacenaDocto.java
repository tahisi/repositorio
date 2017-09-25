package com.bbva.becas.dao;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bbva.becas.archiving.MapArchiving;
import com.bbva.becas.bean.BecasBean;
import com.bbva.becas.parametros.ParametrosBecas;
import com.syc.bancomer.dsmngr.DataSourceManager;
import com.syc.rig.client.RigClient;
import com.syc.rig.client.RigClientException;

public class AlmacenaDocto extends DataSourceManager {
	
	public JSONObject addFile (BecasBean becas, byte[] archivo) throws Exception{
		
		Connection conn 	= null;
		RigClient  h 		= null; 	
		String folio  		= null;
		
		JSONObject exito 	= new JSONObject();
		JSONObject error 	= new JSONObject();
		JSONObject respuestaASO = new JSONObject();
		
		ExpedienteDao exp   = new ExpedienteDao();
		if ("P".equals(ParametrosBecas.AMBIENTE)) {
			conn = getConnectionStatic();
		}else if("T".equals(ParametrosBecas.AMBIENTE)){
			conn 				= Buscaconexion();
		}
		
		Statement st 		= conn.createStatement();
		
		becas 				= exp.idExpedinte(conn, becas, st);
		
		if (becas.getIdGabinete() != 0 && becas.getIdDocumento()!= 0 && becas.getIdPagina() != 0  && becas.getIdVersion() != 0){

			Map<String, Object> metadata 	= new HashMap<String, Object>();
			MapArchiving m 					= new MapArchiving();
			metadata 						=  m.generaMetadata(becas);
			String folioArc =null;
			if ("P".equals(ParametrosBecas.AMBIENTE_ARCHIVING)) {
				h	= new RigClient(); //PRODUCCION
			}else if("T".equals(ParametrosBecas.AMBIENTE_ARCHIVING)){
				h =  new RigClient("http://150.225.99.157");
			}
			
			String result  =  h.upload("becas", metadata , archivo);
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
					if (folioArc.equals(becas.getFolioDig())){
					if(becas.getUltima().equals("true")) {
						
						folio = "BECAS@G"+becas.getIdGabinete()+"C1D"+becas.getIdDocumento()+"V"+becas.getIdVersion();  
						exito.put("folioDigitalizacion", folio);
						respuestaASO.put("exito", exito);
						respuestaASO.put("error", error);
					}else {
						
						folio = "Pagina " + becas.getIdPagina(); 
						exito.put("folioDigitalizacion", folio);
						respuestaASO.put("exito", exito);
						respuestaASO.put("error", error);
					}
					try{
					st.executeBatch();
					conn.commit();
					}catch(SQLException e){
						e.printStackTrace();
					}
				
				
			}
					else{
						System.out.println("ERROR  FOLIOS DIFERENTES");
					}
			}

					else{
						JSONArray errorar = json.getJSONArray("error");
						json = errorar.getJSONObject(0);
						json = GetJson(json.get("error").toString().replace("[","").replace("]",""));
						conn.rollback();
						error.put("codigo", "005");
						error.put("causa", "Error Transaccional");
						error.put("mensaje", json.get("error").toString().replace("[","").replace("]",""));
						respuestaASO.put("exito", exito);
						respuestaASO.put("error", error);
						
					}
		}else {
			conn.rollback();
			error.put("codigo", "005");
			error.put("causa", "Error Transaccional");
			error.put("mensaje", "Error al almacenar en base de datos");
			respuestaASO.put("exito", exito);
			respuestaASO.put("error", error);
			
		}
		return respuestaASO;


	}

public static Connection Buscaconexion() throws Exception{		
		
		Connection conn = null; 
		Class.forName("oracle.jdbc.OracleDriver") ;

		
		String cadena="jdbc:oracle:thin:@150.50.102.249:1521:lmsbdmx1";
		String user= "zdbslms";
		String pass= "xfirma123";
		
		
		conn = DriverManager.getConnection(cadena,user, pass);

		conn.setAutoCommit(false);
		return conn;
	}

private JSONObject GetJson(String  obj){
	
	JSONObject	regreso = new JSONObject(obj);

	return regreso;
}
	
	
}
