package com.bbva.becas.manager;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bbva.becas.bean.Sequence;
import com.bbva.becas.dao.AlmacenaDocto;
import com.bbva.becas.parametros.ParametrosBecas;
import com.syc.bancomer.dsmngr.DataSourceManager;
import com.syc.bancomer.jndi.TraeJndi;




/* Tabla requerida para esta clase
 *
	CREATE TABLE imx_sequence (
		seq_name VARCHAR(20) NOT NULL,
		seq_value NUMBER DEFAULT ,
	);
 *
 */

public class SequenceManager extends DataSourceManager {

	private static final Logger log = Logger.getLogger(SequenceManager.class);

	private static SequenceManager seqMangr = null;

//	private SequenceManager() {
//		super.init(TraeJndi.getStrJndi());
//	}

	public static SequenceManager getInstance() {
		if (seqMangr == null) {
			seqMangr = new SequenceManager();
		}

		return seqMangr;
	}

	public static int delete(Connection conn, String name) throws SQLException {

		int retVal = 0;
		PreparedStatement psDelete = null;

		try {
			psDelete = conn.prepareStatement("DELETE FROM imx_sequence WHERE seq_name = ?");

			psDelete.setString(1, name);

			retVal = psDelete.executeUpdate();
		} finally {
			if (psDelete != null)
				try {
					psDelete.close();
				} catch (SQLException e) {
					log.warn("Cerrando PreparedStatement", e);
				}
		}

		return retVal;
	}

	public static Sequence insert(Connection conn, int cd_aplicacion, int value) throws SQLException {

		Sequence retVal = null;
		PreparedStatement psInsert = null;

		try {
			psInsert = conn.prepareStatement("INSERT INTO TLMS036_SEQUENCE (cd_aplicacion, cd_value) VALUES (?, ?)");

			psInsert.setInt(1, cd_aplicacion);
			psInsert.setInt(2, value);

			if (psInsert.executeUpdate() == 1)
				retVal = new Sequence(cd_aplicacion, value);
		} finally {
			if (psInsert != null)
				try {
					psInsert.close();
				} catch (SQLException e) {
					log.warn("Cerrando PreparedStatement", e);
				}
		}

		return retVal;
	}

	public static Sequence update(Connection conn, int cd_aplicacion, int cd_value) throws SQLException {

		Sequence retVal = null;
		PreparedStatement psUpdate = null;

		try {
			psUpdate = conn.prepareStatement("UPDATE TLMS036_SEQUENCE SET cd_value = ? WHERE cd_aplicacion = ?");

			psUpdate.setInt(1, cd_value);
			psUpdate.setInt(2, cd_aplicacion);

			if (psUpdate.executeUpdate() == 1)
				retVal = new Sequence(cd_aplicacion, cd_value);
		} finally {
			if (psUpdate != null)
				try {
					psUpdate.close();
				} catch (SQLException e) {
					log.warn("Cerrando PreparedStatement", e);
				}
		}

		return retVal;
	}

//	public static Sequence select(Connection conn, int cd_aplicacion) throws SQLException {
//
//		Sequence retVal = null;
//		PreparedStatement psSelect = null;
//		ResultSet rs = null;
//
//		try {
//			psSelect = conn.prepareStatement("SELECT * FROM imx_sequence WHERE seq_name = ?");
//
//			psSelect.setInt(1, cd_aplicacion);
//
//			rs = psSelect.executeQuery();
//			if (rs.next())
//				retVal = new Sequence(rs.getInt("cd_aplicacion"), rs.getInt("cd_value"));
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//			} catch (Exception e) {
//				log.warn("Cerrando ResultSet", e);
//			}
//
//			try {
//				if (psSelect != null)
//					psSelect.close();
//			} catch (Exception e) {
//				log.warn("Cerrando PreparedStatement", e);
//			}
//
//			rs = null;
//			psSelect = null;
//		}
//
//		return retVal;
//	}

	public static int maxValue(Connection conn, String tableName, String columnName, int cd_aplicacion) throws SQLException {

		int retVal = 1;
		ResultSet rs = null;
		
		try {
			String query = format("SELECT MAX(%s) FROM %s WHERE CD_APLICACION  = "+cd_aplicacion+"", columnName, tableName);
			System.out.println("Tahis temp: " + query);
			rs = conn.createStatement().executeQuery(query);
			if (rs.next())
				retVal = rs.getInt(1);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.warn("Cerrando ResultSet", e);
			}

			rs = null;
		}

		return retVal;
	}

	public int currentValue(String name) throws SQLException {

		int retVal = 1;
		Connection conn = null;
		PreparedStatement psSelect = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			synchronized (seqMangr) {
				psSelect = conn.prepareStatement("SELECT seq_value FROM imx_sequence WHERE seq_name = ?");

				psSelect.setString(1, name);

				rs = psSelect.executeQuery();
				if (rs.next())
					retVal = rs.getInt(1);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.warn("Cerrando ResultSet", e);
			}

			try {
				if (psSelect != null)
					psSelect.close();
			} catch (Exception e) {
				log.warn("Cerrando PreparedStatement", e);
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				log.warn("Cerrando conexion a base de datos", e);
			}

			rs = null;
			psSelect = null;
			conn = null;
		}

		return retVal;
	}

	public int nextValue(int cd_aplicacion) throws SQLException {

		int retVal = -1;
		Connection conn = null;
		PreparedStatement psUpdate = null, psSelect = null;
		ResultSet rs = null;

		try {
//			conn = getConnection();
			
//			conn = AlmacenaDocto.Buscaconexion();
			if ("P".equals(ParametrosBecas.AMBIENTE)) {
				conn = getConnectionStatic();
			}else if("T".equals(ParametrosBecas.AMBIENTE)){
				conn 				= AlmacenaDocto.Buscaconexion();
			}
			// Bloqueamos el registro incrementando al nuevo valor
			psUpdate = conn.prepareStatement("UPDATE TLMS036_SEQUENCE SET cd_value = cd_value + 1 WHERE cd_aplicacion = ?");
			psUpdate.setInt(1, cd_aplicacion);

			psUpdate.executeUpdate();
			// Recuperamos el nuevo valor
			psSelect = conn.prepareStatement("SELECT cd_value FROM TLMS036_SEQUENCE WHERE cd_aplicacion = ?");
			psSelect.setInt(1, cd_aplicacion);

			rs = psSelect.executeQuery();
			if (rs.next())
				retVal = rs.getInt("cd_value");

			conn.commit();
		} catch (Exception exc) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				log.warn("En rollback", e);
			}
			throw new SQLException(exc);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				log.warn("Cerrando ResultSet", e);
			}

			try {
				if (psSelect != null)
					psSelect.close();
			} catch (Exception e) {
				log.warn("Cerrando PreparedStatement", e);
			}

			try {
				if (psUpdate != null)
					psUpdate.close();
			} catch (Exception e) {
				log.warn("Cerrando PreparedStatement", e);
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				log.warn("Cerrando conexion a base de datos", e);
			}

			rs = null;
			psSelect = null;
			psUpdate = null;
			conn = null;
		}

		return retVal;
	}

	public int nextValue(String tableName, String columnName, int cd_aplicacion) throws SQLException {

		int maxValue = -1;
		Connection conn = null;
		try {
			synchronized (seqMangr) {
				maxValue = nextValue(cd_aplicacion);
				// Si no existe la secuencia, se crea
				if (maxValue == -1) {
//					conn = getConnection();
					if ("P".equals(ParametrosBecas.AMBIENTE)) {
						conn = getConnectionStatic();
					}else if("T".equals(ParametrosBecas.AMBIENTE)){
						conn = AlmacenaDocto.Buscaconexion();
					}
					
					// Busca el maximo de tableName en columnName
					maxValue = maxValue(conn, tableName, columnName, cd_aplicacion);
					// Se crea la nueva secuencia
					insert(conn, cd_aplicacion, maxValue);
					// Se hacen permanentes los cambios
					conn.commit();
					// Se recupera el siguiente valor de la secuencia
					maxValue = nextValue(cd_aplicacion);
				}
			}
		} catch (Exception exc) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				log.warn("En Rollback", e);
			}
			throw new SQLException(exc);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					log.warn("Cerrando conexion a base de datos", e);
				}

			conn = null;
		}

		return maxValue;
	}
}
