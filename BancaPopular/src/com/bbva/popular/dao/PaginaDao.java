package com.bbva.popular.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbva.popular.bean.BeanPopular;

public class PaginaDao {
	
public void idPagina(Connection conn, BeanPopular popular , Statement st) throws SQLException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query ="select max(cd_pagina) as pagina from tlms035_pagina where cd_version = ? and cd_documento = ? and cd_expediente = ? and cd_aplicacion = ?";
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, popular.getCd_version());
			ps.setInt(2, popular.getCd_documento());
			ps.setInt(3, popular.getCd_expediente());
			ps.setInt(4, popular.getId_aplicacion());

			rs = ps.executeQuery();
			if(rs.next()){
				popular.setCd_pagina(rs.getInt("pagina") +1);
				createPagina(conn, popular, st);

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


public void createPagina (Connection conn, BeanPopular bean, Statement st) throws SQLException{
	
	
	bean.setCd_carpeta(1);
	bean.setFolioDig("POPULAR@G"+bean.getCd_expediente()+"C"+bean.getCd_carpeta()+"D"+bean.getCd_documento()+"V"+bean.getCd_version()+"P"+bean.getCd_pagina());
	String query = "INSERT INTO TLMS035_PAGINA (CD_PAGINA, CD_VERSION,CD_DOCUMENTO, CD_EXPEDIENTE, CD_APLICACION , "
			+ "CD_FOLIO, NB_ARCHIVO, NU_SIZE, NB_EXTENSION, NB_SHA1, TM_DIGITALIZACION , CD_USUARIO)  VALUES "
			+ " ( "+ bean.getCd_pagina()+" , "+bean.getCd_version()+" , "+bean.getCd_documento()+" , "+bean.getCd_expediente()+" , "
			+ " "+ bean.getId_aplicacion()+" , '"+ bean.getFolioDig()+"' ,"
			+ " '"+bean.getNombreArchivo()+"' , "+bean.getSize()+", '"+bean.getExtesion()+"' , '"+bean.getSha1()+"',  sysdate , '"+bean.getUsuario()+"' )";
	System.out.println(query);
	st.addBatch(query);
	
	
	
}
}
