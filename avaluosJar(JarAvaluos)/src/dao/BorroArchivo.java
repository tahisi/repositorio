package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class BorroArchivo {
	
	 static Logger log = Logger.getLogger(BorroArchivo.class);
	
	public  int DeleteFiles(Connection con,String IdArchivo) throws SQLException{
		PreparedStatement stmt 	= null;
		int actualiza		 	= -1;
		try {			
//			String query = "UPDATE GORAPR.TGIA001_EXPEDIENTE T SET T.CD_ESTATUS = 'E' WHERE T.CD_FOLIOLL = ? AND T.CD_ESTATUS = 'A'";
			String query  ="DELETE GORAPR.TLMS025_EXPEDIENTE T WHERE T.CD_FOLIOLL = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, IdArchivo);
			log.info("BORRANDO EXPEDIENTE " +IdArchivo);
			actualiza = stmt.executeUpdate();

		} catch (SQLException e) {
			log.info("Error en la ejecucion del Query de Eliminar archivo... "+e.getMessage());
		} finally{
			if(stmt != null)stmt.close();
			stmt = null;
		}

		return actualiza;
	}

}
