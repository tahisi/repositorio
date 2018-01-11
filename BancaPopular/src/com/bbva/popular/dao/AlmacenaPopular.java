package com.bbva.popular.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bancomer.pia.dsmngr.*;
import com.bbva.popular.archiving.MapArchiving;
import com.bbva.popular.bean.BeanPopular;
import com.bbva.popular.configuracion.ParametrosPopular;
import com.syc.rig.client.RigClient;


public class AlmacenaPopular extends DataSourceManager {
	
	public JSONObject addFile (BeanPopular popular, byte[] archivo) throws Exception{
		System.out.println("ADDFILE ");
		Connection conn 	= null;
		RigClient  h 		= null; 	
		String folio  		= null;
		
		JSONObject exito 	= new JSONObject();
		JSONObject error 	= new JSONObject();
		JSONObject respuestaASO = new JSONObject();
		
		ExpedienteDao exp   = new ExpedienteDao();
		if ("P".equals(ParametrosPopular.AMBIENTE)) {
			conn = getConnectionStatic();
		}else if("T".equals(ParametrosPopular.AMBIENTE)){
			conn 				= Buscaconexion();
		}
		System.out.println("CREANDO EXPEDIENTE");
		Statement st 		= conn.createStatement();
		
		popular 				= exp.idExpedinte(conn, popular, st);
		
		if (popular.getCd_expediente()  != 0 && popular.getCd_documento()!= 0 && popular.getCd_pagina() != 0  && popular.getCd_version() != 0){

			Map<String, Object> metadata 	= new HashMap<String, Object>();
			MapArchiving m 					= new MapArchiving();
			metadata 						=  m.generaMetadata(popular);
			String folioArc =null;
			if ("P".equals(ParametrosPopular.AMBIENTE_ARCHIVING)) {
				h	= new RigClient(); //PRODUCCION
			}else if("T".equals(ParametrosPopular.AMBIENTE_ARCHIVING)){
				h =  new RigClient("http://150.100.22.50:9090");
			}
			
			String result  =  h.upload("popular", metadata , archivo);
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
					if (folioArc.equals(popular.getFolioDig())){
						
						folio = "POPULAR@G"+popular.getCd_expediente()+"C1D"+popular.getCd_documento()+"V"+popular.getCd_version();  
						exito.put("folioDigitalizacion", folio);
						respuestaASO.put("exito", exito);

					try{
					st.executeBatch();
					conn.commit();
					}catch(SQLException e){
						e.printStackTrace();
					}
				
				
			}
					else{
						System.out.println("ERROR  FOLIOS DIFERENTES");
						error.put("codigo", "005");
						error.put("causa", "Error Transaccional");
						error.put("mensaje", "Error al guardar en Archiving folios diferentes");
//						respuestaASO.put("exito", exito);
						respuestaASO.put("error", error);
					}
			}

					else{
	
						JSONArray errorar = json.getJSONArray("error");
						json = errorar.getJSONObject(0);
						conn.rollback();
						error.put("codigo", "005");
						error.put("causa", "Error Transaccional");
//						error.put("mensaje", json.get("error").toString().replace("[","").replace("]",""));
						error.put("mensaje",json.get("_error_message").toString().replace("[","").replace("]",""));
//						respuestaASO.put("exito", exito);
						respuestaASO.put("error", error);
						
					}
		}else {
			conn.rollback();
			error.put("codigo", "005");
			error.put("causa", "Error Transaccional");
			error.put("mensaje", "Error al almacenar en base de datos");
//			respuestaASO.put("exito", exito);
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
