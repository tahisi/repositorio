package com.bbva.becas.parametros;



public class ParametrosBecas {

		public static final int entorno  = 0 ; // 0 TEST , 1 Produccion
		
		public static String[] urlVisorArchiving= { "http://150.100.22.50:4200/#/outerview/get?becas=",
		"URL PRODUCCION" };
		
		public static final String separador ="%2C";

/********************************************************************************************************
 ********************************************** VARIABLES *********************************************** 
 ********************************************************************************************************/
	public static final String AMBIENTE        = "T";						// Ambiente a utilizar
//	public static final String AMBIENTE        = "P";						// Ambiente a utilizar
	
//	public static final int BASE_DATOS         = ConstantesBD.SQL_SERVER;	// Base de datos a utilizar
//	public static final int BASE_DATOS         = ConstantesBD.ORACLE;		// Base de datos a utilizar
	
//	public static final String TIPO_SESION     = "T";						// Tipo de servidor a utilizar (T-W) (Tomcat-Websphere)
	public static final String TIPO_SESION     = "W";						// Tipo de servidor a utilizar (T-W) (Tomcat-Websphere)
	
	public static final String AMBIENTE_ARCHIVING   = "T";	
//	public static final String AMBIENTE_ARCHIVING   = "P";	
}
