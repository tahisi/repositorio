package com.bancomer.consulta.jndi;

/**
 * 
 * @author irvincito
 *
 */
public final class TraeJndi {
	
	private static String strJndi="jdbc/consulta";

	public static String getStrJndi() {
		System.out.println(strJndi);
		return strJndi;
	}
	
}
