package com.bbva.becas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbva.becas.bean.BecasBean;

public class PaginaDao {
	
public void idPagina(Connection conn, BecasBean becas , Statement st) throws SQLException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query ="select max(cd_pagina) as pagina from tlms035_pagina where cd_version = ? and cd_documento = ? and cd_expediente = ? and cd_aplicacion = ?";
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, becas.getIdVersion());
			ps.setInt(2, becas.getIdDocumento());
			ps.setInt(3, becas.getIdGabinete());
			ps.setInt(4, becas.getIdAplicacion());

			rs = ps.executeQuery();
			if(rs.next()){
				becas.setIdPagina(rs.getInt("pagina") +1);
				createPagina(conn, becas, st);

				// TODO: handle exception
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			rs=null;
			ps = null;
		}
			 
	
		}


public void createPagina (Connection conn, BecasBean bean, Statement st) throws SQLException{
	
	
	bean.setIdCarpeta(1);
	bean.setFolioDig("BECAS@G"+bean.getIdGabinete()+"C"+bean.getIdCarpeta()+"D"+bean.getIdDocumento()+"V"+bean.getIdVersion()+"P"+bean.getIdPagina());
	String query = "INSERT INTO TLMS035_PAGINA (CD_PAGINA, CD_VERSION,CD_DOCUMENTO, CD_EXPEDIENTE, CD_APLICACION , "
			+ "CD_FOLIO, NB_ARCHIVO, NU_SIZE, NB_EXTENSION, NB_SHA1, TM_DIGITALIZACION , CD_USUARIO)  VALUES "
			+ " ( "+ bean.getIdPagina()+" , "+bean.getIdVersion()+" , "+bean.getIdDocumento()+" , "+bean.getIdGabinete()+" , "
			+ " "+ bean.getIdAplicacion()+" , '"+ bean.getFolioDig()+"' ,"
			+ " '"+bean.getNombreArch()+"' , "+bean.getSize()+", '"+bean.getExtension()+"' , '"+bean.getSha1()+"',  sysdate , '"+bean.getUsuario()+"' )";
	System.out.println(query);
	st.addBatch(query);
	
	
	
}
}
