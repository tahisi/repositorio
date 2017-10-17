package com.bbva.becas.dao;


import static java.lang.String.format;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbva.becas.bean.BecasBean;
import com.bbva.becas.manager.SequenceManager;


public class ExpedienteDao {
	

	public BecasBean idExpedinte (Connection conn, BecasBean becas , Statement st) throws SQLException{

		PreparedStatement ps = null;
		ResultSet rs = null;
		DocumentoDao doc = new DocumentoDao();
		
		
		String query = "SELECT CD_EXPEDIENTE FROM tlms032_expediente WHERE CD_CLIENTE = ? AND CD_CUENTA = ? AND CD_APLICACION = ? ";
		try {
		
		ps = conn.prepareStatement(query);
		ps.setString(1, becas.getNumeroCliente());
		ps.setString(2, becas.getNumeroCuenta());
		ps.setInt(3, becas.getIdAplicacion());
		
		rs = ps.executeQuery();
		if(rs.next()){
			becas.setIdGabinete( rs.getInt("CD_EXPEDIENTE"));
		}else{
			secuenceExpediente(conn, becas,st); 
		}
		
		System.out.println("Expediente " + becas.getIdGabinete());
		becas =  doc.idDocumento(conn, becas, st) ;
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			conn.rollback();
		}finally {
			if(rs !=null)rs.close();
			if(ps != null) ps.close();
			rs = null;
			ps = null;
		}
		
		
		return becas;
		
	}
	
	
	public int secuenceExpediente (Connection conn, BecasBean becas, Statement st) throws SQLException{
		int idExpediente = -1;

		idExpediente = 	nextValExpediente(conn, becas.getIdAplicacion());
		becas.setIdGabinete(idExpediente);
	 	createExpediente(conn, becas,st);
		
		return idExpediente;
		
	}
	
	
	private static synchronized int nextValExpediente (Connection conn, int cd_aplicacion) throws SQLException{			
			String  titulo_aplicacion = "TLMS032_EXPEDIENTE";
			return SequenceManager.getInstance().nextValue(conn, format(titulo_aplicacion), "cd_expediente",cd_aplicacion);
		
	}
	
	
	public int createExpediente (Connection conn, BecasBean becas, Statement st) throws SQLException{

		int insert = 0;
		String query =  "INSERT INTO TLMS032_EXPEDIENTE (CD_EXPEDIENTE,CD_APLICACION,CD_CLIENTE,CD_CUENTA,CD_CR) VALUES "
							+ " ( "+becas.getIdGabinete()+ " , "+becas.getIdAplicacion()+" ,'"+becas.getNumeroCliente()+"' , "
							+ "'"+becas.getNumeroCuenta()+"', '"+becas.getCr()+"')";

		st.addBatch(query);
		
		return insert;

	}
	


}
