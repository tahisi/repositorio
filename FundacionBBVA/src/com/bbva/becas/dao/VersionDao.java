package com.bbva.becas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbva.becas.bean.BecasBean;

public class VersionDao {
	
	
	public int createVersion (Connection conn, BecasBean becas, Statement st) throws SQLException{	

		String query = "INSERT INTO TLMS034_VERSION (CD_VERSION, CD_DOCUMENTO, CD_EXPEDIENTE,CD_APLICACION) VALUES "
				+ " ( "+becas.getIdVersion()+" , "+becas.getIdDocumento()+" , "+becas.getIdGabinete()+" , "+becas.getIdAplicacion()+" )";
		
		st.addBatch(query);
	
	
		return 1;
		
		
		
	}
	
	public int maxVersion(Connection conn, int idExpediente, int cd_documento, int cd_aplicacion ) throws SQLException{

		PreparedStatement ps = null;
		ResultSet rs = null;
		int version = -1;
		String query ="select max(cd_version) as version from tlms034_version  where cd_expediente = ?  and cd_documento = ? and cd_aplicacion = ?";
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, idExpediente);
			ps.setInt(2, cd_documento);
			ps.setInt(3, cd_aplicacion);
			rs = ps.executeQuery();
			if(rs.next()){
				version = rs.getInt("version");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(ps!=null) ps.close();
			if(rs!=null) rs.close();
			ps = null;
			rs = null;
		}
		return version;
	}



}
