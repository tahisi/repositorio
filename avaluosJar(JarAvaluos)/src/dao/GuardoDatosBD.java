package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;


import com.syc.bancomer.bean.beanRespuesta;

public class GuardoDatosBD {
	
	 static Logger log = Logger.getLogger(GuardoDatosBD.class);
	
	public  int AlmacenoInformacionLocal(Connection conn, String Aplicacion, String Fecha, String Expediente, String LlaveArchiving, String CControl,  String Extension, String StatusDocumento, String IdDocumento) throws SQLException {
	
		PreparedStatement stmt 	= null;
		int insert		 		= -1;
		
		try {
			log.info("INSERTANTO REGISTRO BASE DE DATOS CON FOLIO " + IdDocumento);
			String query = "INSERT INTO GORAPR.TLMS025_EXPEDIENTE "
					+ "	(CD_ACCION,TM_ACCION,CD_EXPEDIENTE,TX_NOMBREDOCUMENTO, "
					+ "	CD_DOCUMENTO,CD_TIPODOCUMENTO,CD_ESTATUS,CD_FOLIOLL) "
					+ "	VALUES (?,sysdate,?,?,?,?,?,?)";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, Aplicacion);
			stmt.setString(2, Expediente);
			stmt.setString(3, LlaveArchiving);
			stmt.setString(4, CControl);
			stmt.setString(5, Extension);
			stmt.setString(6, StatusDocumento);
			stmt.setString(7, IdDocumento);
			insert = stmt.executeUpdate();

		} catch (SQLException e) {
			
			log.info("Error al querer almacenar el archivo en la BD.. "+e.getMessage());
			e.printStackTrace();
		} finally{
			if (stmt!= null) stmt.close();
		}

		return insert;	
	}
	
	
	public  beanRespuesta ActualizoInformacionLocal(Connection conn, String Aplicacion, String Fecha, String Expediente, String LlaveArchiving, String CControl, String Extension, String StatusDocumento, String IdDocumento, beanRespuesta bean) throws SQLException{
		PreparedStatement stmt 	= null;
		int update 				=  -1;
	
		try {

			String  query =" UPDATE GORAPR.TLMS025_EXPEDIENTE T SET T.TX_NOMBREDOCUMENTO = ?,T.CD_DOCUMENTO=? WHERE T.CD_FOLIOLL = ? AND T.CD_ESTATUS = 'A' ";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, LlaveArchiving);
			stmt.setString(2, CControl);
			stmt.setString(3, IdDocumento);
			update = stmt.executeUpdate();
			log.info("ACTUALIZANDO FOLIO DE ARCHIVNG LLAVERARCHIVING " + LlaveArchiving );
			
			if (update>0 ){
				
//			 retorno = "0";
//				bean.put("folioDigitalizacion", LlaveArchiving);
				bean.setFolioDigitalizacion(IdDocumento);
			}else{
				
//				retorno = "1|Error no fue posible actualizar el Archivo en BD";
//				resp.put("codigo", "1");
//				resp.put("mensaje", "Error al actualizar folio");
//				resp.put("causa", "No fue posible actualizar el Archivo en BD");
				bean.setCodigo("1");
				bean.setMensaje("Error al actualizar folio");
				bean.setCausa("No fue posible actualizar el folio en BD");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());

		} finally {
			if(stmt != null) stmt.close();
			stmt =null;
		}

		return bean ;	
}	
	
	public static String AchivoExistente(Connection conn, String Aplicacion, String Fecha, String Expediente, String LlaveArchiving, String CControl, String Extension, String StatusDocumento, String IdDocuemnto) throws SQLException {

		PreparedStatement stmt 	= null;
		int update 				= -1;
		String retorno			= null;
		try {

			String query = "UPDATE GORAPR.TLMS025_EXPEDIENTE T SET T.CD_DOCUMENTO = ? WHERE T.CD_FOLIOLL = ? AND T.CD_ESTATUS = 'A'";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, CControl);
			stmt.setString(2, IdDocuemnto);
			log.info("ACTUALIZANDO CCONTROL " + CControl + "\n IDDOCUMENTO" + IdDocuemnto);
			update = stmt.executeUpdate();

			if(update>0){

				retorno = "0";
			}else{

				retorno = 	"1|Error no fue posible actualizar el Archivo en BD";
			}

		} catch (SQLException e) {
	
			log.info(e.getMessage());
			
		} finally{
			if(stmt != null) stmt.close();
			stmt.close();
		}

		return retorno;	
}	

}
