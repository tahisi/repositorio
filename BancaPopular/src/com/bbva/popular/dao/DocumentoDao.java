package com.bbva.popular.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbva.popular.bean.BeanPopular;

public class DocumentoDao {

	
	public BeanPopular idDocumento(Connection conn,  BeanPopular popular, Statement st) throws SQLException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		VersionDao version = new VersionDao();
		
		String query ="select cd_documento from tlms033_documento  where cd_expediente =  ? and tp_doc = ?  and nb_documento =  ? and tx_descripcion = ? ";
		try{
		ps = conn.prepareStatement(query);
		ps.setInt(1, popular.getCd_expediente());
		ps.setString(2, popular.getCveDoc());
		ps.setString(3, popular.getNombreDoc());
		ps.setString(4, popular.getNombreEtapa());
		PaginaDao  pag = new PaginaDao();
		rs = ps.executeQuery();
		if(rs.next()){
			popular.setCd_documento(rs.getInt("cd_documento"));
//			if (popular.getPrimera().equals("true")){
				popular.setCd_version(version.maxVersion(conn, popular.getCd_expediente(), popular.getCd_documento(), popular.getId_aplicacion())+1);   
				version.createVersion(conn,popular, st);
				popular.setCd_pagina(1);	
				pag.createPagina(conn, popular,st);	
			
		}else{
			popular.setCd_documento(maxDoc(conn, popular.getCd_expediente(), popular.getId_aplicacion())); 
			int insert = createDocumento(conn, popular,st);
				popular.setCd_version( 1);  ;
				version.createVersion(conn, popular, st);
				popular.setCd_pagina(1);	
				pag.createPagina(conn, popular,st);	
			}
			
			//
//			si es primera pagina inserta pagina1, sino saca maximo de pagina  e inserta la siguente
			
		
	
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(ps!=null) ps.close();
			if(rs!=null)rs.close();
			ps = null;
			rs  = null;
		}
			 
	
		return popular;
		}
	
	
public int maxDoc(Connection conn, int idExpediente, int id_aplicacion) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idDocumento = -1;
		String query ="select max(cd_documento) as documento from tlms033_documento  where cd_expediente = ?  and cd_aplicacion = ?";
		try{
		ps = conn.prepareStatement(query);
		ps.setInt(1, idExpediente);
		ps.setInt(2, id_aplicacion);
		rs = ps.executeQuery();
		if(rs.next()){
			idDocumento = rs.getInt("documento") + 1;
		}
			 
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(ps!=null) ps.close();
			if(rs!=null)rs.close();
			ps = null;
			rs  = null;
		}
		return idDocumento;
		}



public int createDocumento (Connection conn, BeanPopular bean , Statement st) throws SQLException{
	
	String query = "INSERT INTO TLMS033_DOCUMENTO (CD_DOCUMENTO, CD_EXPEDIENTE,CD_APLICACION,NB_DOCUMENTO,TP_DOC,  TX_DESCRIPCION ,NB_BECA,NB_GENERACION)"
			+ " VALUES  ( "+bean.getCd_documento()+" , "+bean.getCd_expediente()+" , "+bean.getId_aplicacion()+" , '"+bean.getNombreDoc()+"' , '"+ bean.getCveDoc()+"' ,   '"+bean.getNombreEtapa()+"' , 'NA', 'NA')";
	
	st.addBatch(query);
	System.out.println(query);
	
	
	return 1;
	
}

}



