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
import com.syc.bancomer.dsmngr.DataSourceManager;

import com.syc.rig.client.RigClient;
import com.syc.rig.client.RigClientException;



public class DescargoArchivo extends DataSourceManager {
	private Logger log = Logger.getLogger(DescargoArchivo.class);
	

	
	

	public JSONObject DowFile(String folio) throws Exception {
		Connection conn = null;
		RigClient  h 	= null 	;				
		JSONObject respuestaASO = new JSONObject();
		JSONArray exito 		= new JSONArray();
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> mapsError = new HashMap<String, Object>();
		List <String> folioID = new ArrayList<String>();
		try{
			System.out.println("CONECTANDO A ARCHIVING AMBIENTE : " + ParametrosBecas.AMBIENTE_ARCHIVING );
			if ("P".equals(ParametrosBecas.AMBIENTE_ARCHIVING)) {
				h	= new RigClient(); //PRODUCCION
			}else if("T".equals(ParametrosBecas.AMBIENTE_ARCHIVING)){
				try{
				h =  new RigClient("http://150.225.99.157");
				}catch(Exception e){
					System.out.println("ERROR ----------------------- ");
					  e.printStackTrace();
				}
			}
			System.out.println("Entrando a hacer Conexion a base de datods");
			conn 				= AlmacenaDocto.Buscaconexion();
			
			//conn = getConnectionStatic();
			
	

				OutputStream output = new ByteArrayOutputStream();
				try{
					System.out.println("Entrando a Buscar folio" + folio);
					folioID = buscaID(conn, folio);
					System.out.println("folio en base de Datos " + folioID.get(0));
					try{
					System.out.println("Descargando folio " +  folioID.get(0));
					h.download("becas", folioID.get(0), output);
					ByteArrayOutputStream bos = (ByteArrayOutputStream)output;
					String stringToStore = Base64.encodeBase64String(bos.toByteArray());// el DatosBuket[2] y DatosBuket[3]  corresponde a informacion que regresa archivin( _signature y sha1N )
					maps.put("url", "");
					maps.put("archivo", stringToStore.replace("\n", "").replace("\r", ""));

					exito.put(0, maps);

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
			respuestaASO.put("exito", exito);
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
	
	
	public JSONObject Folios(String folio) throws Exception {
		Connection conn = null;			
		JSONObject respuestaASO = new JSONObject();
		JSONArray exito 		= new JSONArray();
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> mapsError = new HashMap<String, Object>();
		List<String> folioID = new ArrayList<String>();
		String ListaFolios = "";
		try{
			conn 				= AlmacenaDocto.Buscaconexion();
				try{
					folioID = buscaID(conn, folio);
					for (int i = 0 ; i<= folioID.size()-1; i++ ){
					ListaFolios = 	folioID.get(i) ;
					if(i==folioID.size())
						ListaFolios = ListaFolios + ",";
					}
					try{
					
					maps.put("url", folioID);
					maps.put("archivo","");

					exito.put(0, maps);

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
	
	public List<String>  buscaID(Connection conn, String folio) throws SQLException{
		Fortimax fm = new Fortimax(folio);
		PreparedStatement ps = null;
		ResultSet rs = null;
		 List <String> foliopag = new ArrayList<String>();
		try{
		int cd_aplicacion = buscaAplicacion(conn, fm.getTituloAplicacion());
		String query = "Select cd_folio from tlms035_pagina where cd_aplicacion= ? and cd_expediente =? and cd_documento = ? and cd_version = ?";
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
