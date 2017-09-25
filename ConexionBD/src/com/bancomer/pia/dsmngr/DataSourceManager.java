package com.bancomer.pia.dsmngr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bancomer.pia.jndi.TraeJndi;
import com.bancomer.pia.utils.Configuracion;
import com.bancomer.pia.utils.ConstantesBD;

public abstract class DataSourceManager extends Thread {
	
	private static DataSource ds         = null;
	private static DataSourceManager dsm = null;
	
	protected void init() {
		if (ds == null) {
			Context initContext = null;
			Hashtable<String, String> env = new Hashtable<String, String>();
			Context envContext = null;
			try {

				if ("T".equals(Configuracion.TIPO_SESION)) {
					initContext = new InitialContext();
				} else {
					env.put(Context.INITIAL_CONTEXT_FACTORY,"com.ibm.Websphere.naming.WsnInitialContextFactory");
					initContext = new InitialContext(env);
				}
				envContext = (Context) initContext.lookup("java:comp/env");
				ds = (DataSource) envContext.lookup(TraeJndi.getStrJndi());

			} catch (NamingException ne) {
				try {
					initContext = new InitialContext();
					ds = (DataSource) initContext.lookup(TraeJndi.getStrJndi());
				} catch (NamingException exc) {
					ne.printStackTrace();
					exc.printStackTrace();
					throw new RuntimeException("No se encontro la fuente '" + TraeJndi.getStrJndi() + "'");
				}
			}
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if(ds == null)
			throw new SQLException("No se ha llamado al metodo init del DataSourceManager");
		
		int cont = 0;
		while ((conn == null) && (cont < 100)) {
			conn = ds.getConnection();
			cont++;
		}
		if (Integer.toString(Configuracion.BASE_DATOS).equals(Integer.toString(ConstantesBD.SQL_SERVER))) {
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		}
		conn.setAutoCommit(false);
		return conn;
	}

	public static Connection getConnectionStatic() throws SQLException {
		System.out.println("ENTRANDO A HACER CONEXION");
		if (dsm == null)
			dsm = new DataSourceManager() {
			};
		if (ds == null)
			dsm.init();
		return dsm.getConnection();
	}
	
}
