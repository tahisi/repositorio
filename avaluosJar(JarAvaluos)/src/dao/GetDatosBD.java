package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class GetDatosBD {
	
	 static Logger log = Logger.getLogger(GetDatosBD.class);
	
	public int Existe(Connection conn,String folio) throws SQLException{
		log.info("ENTRA A BUSCAR EXPEDIENTE " +  folio);
		int res					= -1;
		PreparedStatement stmt 	= null;
		ResultSet rs			= null;
		
		try {
			
			String	query = "SELECT COUNT(*) FROM GORAPR.TLMS025_EXPEDIENTE WHERE CD_FOLIOLL = ? ";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, folio);
			rs = stmt.executeQuery();
			while(rs.next()){
				res=rs.getInt(1);
			}

		} catch (SQLException e) {
			
			log.info("ERROR AL CONSULTAR SI EL ARCHIVO EXISTE " , e);
		
		} finally{
			
			if (stmt!= null) stmt.close();
			if(rs != null) rs.close();
			stmt = null;
			rs = null;
		}
		return res;
	}
	
	public int ArchivoElimnado(Connection conn,String IdArchivo) throws SQLException{
		int res= -1;

		PreparedStatement stmt = null;
		ResultSet rs 		= null;
		try {
//			String query = "SELECT COUNT(*) FROM GORAPR.TGIA001_EXPEDIENTE WHERE CD_FOLIOLL = ? AND CD_ESTATUS = 'E'";
			String query  = "SELECT COUNT(*) FROM GORAPR.TLMS025_EXPEDIENTE WHERE CD_FOLIOLL = ?" ;
			stmt = conn.prepareStatement(query);
			stmt.setString(1, IdArchivo);
			log.info("BUSCANDO SI EXISTE DOCUMENTO CON FOLIO : "+IdArchivo);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				res= rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info("Error en la ejecucion del Query de ArchivoEliminado" + e.getMessage());
		
		} finally{
			if (rs!=null)rs.close();
			if (stmt != null) stmt.close();
			rs= null;
			stmt = null;
		}
		return res;
	}
	
	public static String GetExpediente(Connection con,String Expediente) {
//		ArrayList<String> regreso 	= new ArrayList<String>();
		PreparedStatement stmt 		= null;
		ResultSet rs				= null;
		String regreso 				= "";
		try {

			String query = "SELECT CD_FOLIOLL FROM GORAPR.TLMS025_EXPEDIENTE WHERE CD_EXPEDIENTE = ? AND CD_ESTATUS = 'A'";
			stmt = con.prepareStatement(query);
			stmt.setString(1, Expediente);
			log.info("BUSCANDO FOLIOS DE EXPEDIENTE : "+ Expediente);
			rs = stmt.executeQuery();
			while(rs.next()){
				regreso =regreso + rs.getString("CD_FOLIOLL") + "," ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			log.info("Error en la ejecucion del Query de GetExpediente" + e.getMessage());
		} finally{
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			stmt = null;
		}
//		log.info("FOLIOS ENCONTRADOS  " + regreso.size());
		return regreso;
	}

	public static String GetBuketArchivo(Connection con,String IDArchivo){

		String  regreso="1"; 
		PreparedStatement stmt = null;

		try {
			String query = "SELECT TX_NOMBREDOCUMENTO||'@'||CD_FOLIOLL||'@'||CD_TIPODOCUMENTO FROM GORAPR.TLMS025_EXPEDIENTE WHERE CD_FOLIOLL = ?  AND CD_ESTATUS = 'A'";
			stmt = con.prepareStatement(query);
			log.info("BUSCANDO BUKET PARA FOLIO : "+IDArchivo);
			stmt.setString(1, IDArchivo);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				regreso=resultado.getString(1);
			}
			stmt.close();
			
			if(regreso.length()!=1){
				return regreso;
			}else{
				regreso="Error@";
			}


		} catch (SQLException e) {
			log.info("Error en la ejecucion del Query de GetExpediente" + e.getMessage());
		} 
		return regreso;
	}
	

}
