package com.bbva.becas.dao;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.ssl.Base64;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.bbva.becas.parametros.ParametrosBecas;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.bancomer.consulta.dsmngr.*;

import com.syc.rig.client.RigClient;
import com.syc.rig.client.RigClientException;



public class DescargoArchivo extends DataSourceManager {
	private Logger log = Logger.getLogger(DescargoArchivo.class);
	

	
	

	public JSONArray DowFile(String folio) throws Exception {
		Connection conn = null;
		RigClient  h 	= null 	;				
		JSONObject respuestaASO = new JSONObject();
		JSONObject exito 		= new JSONObject();
		JSONArray resp 			= new JSONArray();
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> mapsError = new HashMap<String, Object>();
		List <String> folioID = new ArrayList<String>();
		try{
			System.out.println("CONECTANDO A ARCHIVING AMBIENTE : " + ParametrosBecas.AMBIENTE_ARCHIVING );
			if ("P".equals(ParametrosBecas.AMBIENTE_ARCHIVING)) {
				h	= new RigClient(); //PRODUCCION
			}else if("T".equals(ParametrosBecas.AMBIENTE_ARCHIVING)){
				try{
				h =  new RigClient("http://150.100.22.50:9090");
				}catch(Exception e){
					System.out.println("ERROR ----------------------- ");
					  e.printStackTrace();
				}
			}
			
			log.info("Entrando a hacer Conexion a base de datods");
			if ("T".equalsIgnoreCase(ParametrosBecas.AMBIENTE)){
			conn 				= AlmacenaDocto.Buscaconexion();
			}
			else if("P".equalsIgnoreCase(ParametrosBecas.AMBIENTE)){
			conn = DataSourceManager.getConnectionStatic();
			}
	

				OutputStream output = new ByteArrayOutputStream();
				try{
					System.out.println("Entrando a Buscar folio" + folio);
					folioID = buscaIDDow(conn, folio);
					System.out.println("folio en base de Datos " + folioID.get(0));
					try{
					System.out.println("Descargando folio " +  folioID.get(0));
					h.download("becas", folioID.get(0), output);
					ByteArrayOutputStream bos = (ByteArrayOutputStream)output;
					String stringToStore = Base64.encodeBase64String(bos.toByteArray());// el DatosBuket[2] y DatosBuket[3]  corresponde a informacion que regresa archivin( _signature y sha1N )
					exito.put("url", "");
					exito.put("archivo", stringToStore.replace("\n", "").replace("\r", ""));
//					exito.put("url", folioID.toString());
//					exito.put("archivo","");
					
//					exito.put(0, maps);
					
					}catch (RigClientException e) {
						mapsError.put("codigo", "1");
						mapsError.put("mensaje", "ERROR AL DESCARGAR DE ARCHIVING ");
						mapsError.put("causa", e.getMessage());
						e.printStackTrace();
					}
					

				}catch(Exception e){
					log.info("ERROR AL DESCARGAR DE ARCHIVING " , e);

					mapsError.put("codigo", "1");
					mapsError.put("mensaje", "ERROR AL DESCARGAR DE ARCHIVING ");
					mapsError.put("causa", e.getMessage());
					//					Arreglodedatos2.add(new JsonDescarga("", "", "", e.getMessage()));

				}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mapsError.put("codigo", "2");
			mapsError.put("mensaje", "ERROR AL HACER LA CONECTAR CON BASE DE DATOS");
			mapsError.put("causa", e.getMessage()); 
			log.info("Error: " , e );
		}finally{
//			respuestaASO.put("exito", exito);
//			respuestaASO.put("error", mapsError);
//			resp.put(respuestaASO);
			if(exito.length() !=0  ){
				respuestaASO.put("exito", exito);
			}
			if (mapsError.size()!= 0){
				respuestaASO.put("error", mapsError);
			}
				resp.put(respuestaASO);
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			conn = null;
		}

		System.out.println("ANTES DE RETURN "+resp);
		return resp; // RETORNO LA RESPUESTA DE LA DESCARGA.
	}
	
	public JSONArray Folios(String folio) throws Exception {
		Connection conn = null;			
		JSONObject respuestaASO = new JSONObject();
		JSONObject exito 		= new JSONObject();
		JsonElement maps = new JsonObject();
		Map<String, Object> mapsError = new HashMap<String, Object>();
		List<String> folioID = new ArrayList<String>();
		String ListaFolios = "";
		JSONArray resp = new JSONArray();
		try{
			if (ParametrosBecas.AMBIENTE.equals("T")){
			conn 				= AlmacenaDocto.Buscaconexion();
			}else if(ParametrosBecas.AMBIENTE.equals("P")){
				conn = DataSourceManager.getConnectionStatic();
			}
				try{
					folioID = buscaIDDow(conn, folio);
					for (int i = 0 ; i<= folioID.size()-1; i++ ){
					
					if(i<folioID.size()-1)
						ListaFolios = ListaFolios + folioID.get(i) + ParametrosBecas.separador;
					if(i==folioID.size()-1)
					ListaFolios =ListaFolios + folioID.get(i);
					}
					
					try{
					String urlvisor = urlVisorArch(conn);
					exito.put("url", urlvisor + ListaFolios);
					exito.put("archivo","");

//					exito.put(0, maps);
					
					}catch (RigClientException e) {
						e.printStackTrace();
					}
					

				}catch(Exception e){
					log.info("ERROR AL DESCARGAR DE ARCHIVING " , e);

					mapsError.put("codigo", "1");
					mapsError.put("mensaje", "ERROR AL DESCARGAR DE ARCHIVING ");
					mapsError.put("causa", e.getMessage());
					//					Arreglodedatos2.add(new JsonDescarga("", "", "", e.getMessage()));

				}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mapsError.put("codigo", "2");
			mapsError.put("mensaje", "ERROR AL HACER LA CONECTAR CON BASE DE DATOS");
			mapsError.put("causa", e.getMessage()); 
			log.info("Error: " , e );
		}finally{
			if(exito.length() !=0  ){
			respuestaASO.put("exito", exito);
			}
			if (mapsError.size()!= 0){
			respuestaASO.put("error", mapsError);
			}
			resp.put(respuestaASO);
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			conn = null;
		}


		return resp; // RETORNO LA RESPUESTA DE LA DESCARGA.
	}
	
	public List<String>  buscaID(Connection conn, String folio) throws SQLException{
		Fortimax fm = new Fortimax(folio);
		PreparedStatement ps = null;
		ResultSet rs = null;
		 List <String> foliopag = new ArrayList<String>();
		try{
		int cd_aplicacion = buscaAplicacion(conn, fm.getTituloAplicacion());
		String query = "Select cd_folio,nb_extension  from tlms035_pagina where cd_aplicacion= ? and cd_expediente =? and cd_documento = ? and cd_version = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, cd_aplicacion);
		ps.setInt(2, fm.getIdGabinete());
		ps.setInt(3, fm.getIdDocumento());
		ps.setInt(4, fm.getVersion());
		rs = ps.executeQuery();
		while(rs.next()){
			foliopag.add(rs.getString("cd_folio")+"."+ rs.getString("nb_extension"));
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
		}
		return foliopag;
		
	}
	
	
	public List<String>  buscaIDDow(Connection conn, String folio) throws SQLException{
		Fortimax fm = new Fortimax(folio);
		PreparedStatement ps = null;
		ResultSet rs = null;
		 List <String> foliopag = new ArrayList<String>();
		try{
		int cd_aplicacion = buscaAplicacion(conn, fm.getTituloAplicacion());
		String query = "Select cd_folio  from tlms035_pagina where cd_aplicacion= ? and cd_expediente =? and cd_documento = ? and cd_version = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, cd_aplicacion);
		ps.setInt(2, fm.getIdGabinete());
		ps.setInt(3, fm.getIdDocumento());
		ps.setInt(4, fm.getVersion());
		rs = ps.executeQuery();
		while(rs.next()){
			foliopag.add(rs.getString("cd_folio"));
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
		}
		return foliopag;
		
	}
	
	
	public String  urlVisorArch(Connection conn) throws SQLException{

		PreparedStatement ps = null;
		ResultSet rs = null;
		String urlArchiving = null;
		try{
		String query = "Select tx_valorparam  from tlms006_paramconf where tp_parametro= ? ";
		ps = conn.prepareStatement(query);
		ps.setString (1, "VISOR_ARCHIVING");
		
		rs = ps.executeQuery();
		while(rs.next()){
			urlArchiving = rs.getString("tx_valorparam");
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
		}
		return urlArchiving;
		
	}

	
	public int  buscaAplicacion(Connection conn, String aplicacion) throws SQLException{
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cd_aplicacion = -1;
		String query = "Select cd_aplicacion from tlms031_aplicacion where nb_aplicacion = ?";
		try{
		ps = conn.prepareStatement(query);
		ps.setString(1, aplicacion);
		rs = ps.executeQuery();
		if(rs.next()){
			cd_aplicacion = rs.getInt(1);
			
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(rs!= null) rs.close();
			if(ps!=null)ps.close();
		}
		return cd_aplicacion;
		
	}
}
