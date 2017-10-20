package com.bbva.becas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbva.becas.bean.BecasBean;

public class DocumentoDao {

	
	public BecasBean idDocumento(Connection conn, BecasBean becas, Statement st) throws SQLException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		VersionDao version = new VersionDao();
		
		String query ="select cd_documento from tlms033_documento  where cd_expediente =  ? and tp_doc = ?  and nb_beca =  ? and nb_generacion = ? ";
		try{
		ps = conn.prepareStatement(query);
		ps.setInt(1, becas.getIdGabinete());
		ps.setString(2, becas.getCveDoc());
		ps.setString(3, becas.getNombreBeca());
		ps.setString(4, becas.getCicloEscolar());
		PaginaDao  pag = new PaginaDao();
		rs = ps.executeQuery();
		if(rs.next()){
			becas.setIdDocumento(rs.getInt("cd_documento"));
			if (becas.getPrimera().equals("true")){
				becas.setIdVersion(version.maxVersion(conn, becas.getIdGabinete(), becas.getIdDocumento(), becas.getIdAplicacion())+1);   
				version.createVersion(conn,becas, st);
				becas.setIdPagina(1);	
				pag.createPagina(conn, becas,st);	
			}else{
				becas.setIdVersion(version.maxVersion(conn, becas.getIdGabinete(), becas.getIdDocumento(), becas.getIdAplicacion()));
				pag.idPagina(conn, becas, st);
			}
			
			
		}else{
			becas.setIdDocumento(maxDoc(conn, becas.getIdGabinete(), becas.getIdAplicacion())); 
			int insert = createDocumento(conn, becas,st);
				becas.setIdVersion( 1);  ;
				version.createVersion(conn, becas, st);
				becas.setIdPagina(1);	
				pag.createPagina(conn, becas,st);	
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
			 
	
		return becas;
		}
	
	
public int maxDoc(Connection conn, int idExpediente, int idAplicacion) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idDocumento = -1;
		String query ="select max(cd_documento) as documento from tlms033_documento  where cd_expediente = ?  and cd_aplicacion = ?";
		try{
		ps = conn.prepareStatement(query);
		ps.setInt(1, idExpediente);
		ps.setInt(2, idAplicacion);
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



public int createDocumento (Connection conn, BecasBean bean , Statement st) throws SQLException{
	
//	PreparedStatement ps = null;
//	int insert = 0;
//	String query = "INSERT INTO TLMS033_DOCUMENTO (CD_DOCUMENTO, CD_EXPEDIENTE,CD_APLICACION,NB_DOCUMENTO,TP_DOC, NB_BECA, NB_GENERACION, TX_DESCRIPCION) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ?)";
	String query = "INSERT INTO TLMS033_DOCUMENTO (CD_DOCUMENTO, CD_EXPEDIENTE,CD_APLICACION,NB_DOCUMENTO,TP_DOC, NB_BECA, NB_GENERACION, TX_DESCRIPCION)"
			+ " VALUES  ( "+bean.getIdDocumento()+" , "+bean.getIdGabinete()+" , "+bean.getIdAplicacion()+" , '"+bean.getNombreDocto()+"' , '"+ bean.getCveDoc()+"' , '"+bean.getNombreBeca()+"' , '"+bean.getCicloEscolar()+"' , 'ALTA ASO')";
	
	st.addBatch(query);
	System.out.println(query);
	//	try {
//	ps = conn.prepareStatement(query);
//	ps.setInt(1, bean.getIdDocumento());
//	ps.setInt(2, bean.getIdGabinete());
//	ps.setInt(3, bean.getIdAplicacion());
//	ps.setString(4, bean.getNombreDocto());
//	ps.setString(5, bean.getCveDoc());
//	ps.setString(6, bean.getNombreBeca());
//	ps.setString(7, bean.getCicloEscolar());
//	ps.setString(8, "ALTA ASO");
//	insert = ps.executeUpdate();
//	}catch(SQLException e){
//		e.printStackTrace();
//	}finally {
//		if (ps!=null)ps.close();
//			ps = null;
//		
//	}
	
	return 1;
	
}

}



