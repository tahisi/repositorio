package com.syc.bancomer.utils;

import com.syc.bancomer.utils.ConstantesBD;


public class ConfiguracionAval {


/********************************************************************************************************
 ********************************************** VARIABLES *********************************************** 
 ********************************************************************************************************/
//	public static final String AMBIENTE        = "T";						// Ambiente a utilizar
	public static final String AMBIENTE        = "P";						// Ambiente a utilizar
	
//	public static final int BASE_DATOS         = ConstantesBD.SQL_SERVER;	// Base de datos a utilizar
	public static final int BASE_DATOS         = ConstantesBD.ORACLE;		// Base de datos a utilizar
	
//	public static final String TIPO_SESION     = "T";						// Tipo de servidor a utilizar (T-W) (Tomcat-Websphere)
	public static final String TIPO_SESION     = "W";						// Tipo de servidor a utilizar (T-W) (Tomcat-Websphere)
	
//	public static final String AMBIENTE_ARCHIVING   = "T";	
	public static final String AMBIENTE_ARCHIVING   = "P";	
}
