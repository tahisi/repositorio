package com.bbva.popular.dao;


import static java.lang.String.format;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbva.popular.bean.BeanPopular;
import com.bbva.popular.manager.SequenceManager;


public class ExpedienteDao {
	

	public BeanPopular idExpedinte (Connection conn, BeanPopular popular , Statement st) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		popular = buscaAplicacion(conn, popular);
		DocumentoDao doc = new DocumentoDao();
		
		
		String query = "SELECT CD_EXPEDIENTE FROM tlms032_expediente WHERE CD_CLIENTE = ? AND CD_CUENTA = ? AND CD_APLICACION = ? ";
		try {
		
		ps = conn.prepareStatement(query);
		ps.setString(1, popular.getTipoProceso());
		ps.setString(2, popular.getContrato());
		ps.setInt(3, popular.getId_aplicacion());
		
		rs = ps.executeQuery();
		if(rs.next()){
			popular.setCd_expediente(( rs.getInt("CD_EXPEDIENTE")));
		}else{
			secuenceExpediente(conn, popular,st); 
		}
		
		System.out.println("Expediente " + popular.getCd_expediente());
		popular =  doc.idDocumento(conn, popular, st) ;
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			if(rs !=null)
				try {
					rs.close();
					if(ps != null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			rs = null;
			ps = null;
		}
		
		
		return popular;
		
	}
	
	
	public int secuenceExpediente (Connection conn, BeanPopular popular, Statement st) throws SQLException{
		int idExpediente = -1;
		idExpediente = 	nextValExpediente(conn, popular.getId_aplicacion());
		popular.setCd_expediente(idExpediente);
		try{
	 	createExpediente(conn, popular,st);
		}catch (SQLException s){
			s.printStackTrace();
		}
		return idExpediente;
		
	}
	
	
	private static synchronized int nextValExpediente (Connection conn, int cd_aplicacion) throws SQLException{			
			String  titulo_aplicacion = "TLMS032_EXPEDIENTE";
			return SequenceManager.getInstance().nextValue(conn, format(titulo_aplicacion), "cd_expediente",cd_aplicacion);
		
	}
	
	
	public int createExpediente (Connection conn, BeanPopular popular, Statement st) throws SQLException{

		int insert = 0;
		String query =  "INSERT INTO TLMS032_EXPEDIENTE (CD_EXPEDIENTE,CD_APLICACION,CD_CLIENTE,CD_CUENTA,CD_CR) VALUES "
							+ " ( "+popular.getCd_expediente()+ " , "+popular.getId_aplicacion()+" ,'"+popular.getTipoProceso()+"' , "
							+ "'"+popular.getContrato()+"' , '0')";
	
		st.addBatch(query);
	
		
		return insert;

	}
	
	public BeanPopular buscaAplicacion (Connection conn, BeanPopular popular) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "SELECT CD_APLICACION FROM TLMS031_APLICACION WHERE NB_APLICACION =  ? ";
		try {
			pst= conn.prepareStatement(query);
			pst.setString(1, popular.getAplicacion());
			rs = pst.executeQuery();
			if(rs.next())
				popular.setId_aplicacion(rs.getInt("CD_APLICACION"));	
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return popular;
		
		
	}

}
