package com.bancomer.pia.jndi;

/**
 * 
 * @author irvincito
 *
 */
public final class TraeJndi {
	
	private static String strJndi="jdbc/pia";

	public static String getStrJndi() {
		System.out.println("Conectado a jdbc/pia");
		return strJndi;
	}
	
}
