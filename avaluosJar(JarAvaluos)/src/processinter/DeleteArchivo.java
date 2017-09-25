package processinter;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.syc.bancomer.dsmngr.DataSourceManager;

import dao.GetDatosBD;

public class DeleteArchivo extends DataSourceManager{

	private Logger log = Logger.getLogger(DeleteArchivo.class);

	public JSONObject BorroArchivo(String NombreArchivo) {
		
		log.info("ENTRA A ELIMINAR ARCHIVO " + NombreArchivo);
	
		Connection conn 		= null;		
		int borrareg 			= -1;
		JSONObject respuestaASO = new JSONObject();
		JSONObject exito 		= new JSONObject();
		JSONObject error 		= new JSONObject();
		
		try {
			try {
				conn = getConnectionStatic();
//				BuscaBD db = new BuscaBD();
//				conn= 	db.Buscaconexion();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao.BorroArchivo borra= new dao.BorroArchivo();
			GetDatosBD datos = new GetDatosBD();
			int datos_borrar  = datos.ArchivoElimnado(conn, NombreArchivo);
			if (datos_borrar >0 ) {
				borrareg = borra.DeleteFiles(conn, NombreArchivo);
				if (borrareg > 0) {
					exito.put("folioDigitalizacion", "0");
					log.info("borre el archivo...");
				} else {
					error.put("codigo", "1");
					error.put("mensaje", "No se fue posible eliminar el archivo");
					error.put("causa", "Error al eliminar de base de datos");
//					regresoArchivo = "1|No se fue posible eliminar el archivo";
				}

			} else { // Se valido la existencia del archivo y ya esta en estatus E
				error.put("codigo", "1");
				error.put("mensaje", "No existe el archivo");
				error.put("causa", "El archivo no existe");
//				regresoArchivo = "1|No existe el archivo"; // el archivo ya esta en estatus E (Eliminado)
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			respuestaASO.put("exito", exito);
			respuestaASO.put("error", error);
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return respuestaASO;
	}


}
