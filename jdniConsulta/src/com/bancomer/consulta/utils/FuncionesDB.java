package com.bancomer.consulta.utils;

import com.bancomer.consulta.utils.Configuracion;
import com.bancomer.consulta.utils.ConstantesBD;

/**
 * 
 * @author felipon
 *
 */
public class FuncionesDB {
	
	/**
	 * Function funcDatediff
	 * 
	 * Funcion para obtener la diferencia entre dos fechas
	 * 
	 * @param campo1, Campo de la primer fecha
	 * @param campo2, Campo de la seguna fecha
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String dateDiff(String campo1, String campo2) {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS) {
		
			case ConstantesBD.SQL_SERVER:
				retValue = "DATEDIFF(day, " + campo1 + ", " + campo2 + ")";
				break;
			case ConstantesBD.ORACLE:
				retValue = "round(to_date(to_char("+campo2+", 'dd/mm/yy')) - to_date(to_char("+campo1+", 'dd/mm/yy')))";;
				break;
			default:
				System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Function funcSystemDate
	 * 
	 * Funcion para obtener la fecha actual del sistema
	 * 
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String systemDate() {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS) {
		
			case ConstantesBD.SQL_SERVER:
				retValue = "getdate()";
				break;
			case ConstantesBD.ORACLE:
				retValue = "sysdate";
				break;
			default:
				System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Function funcConvertFechaChar
	 * 
	 * Funcion para la conversion de campo tipo fecha a string en el formato seleccionado
	 * 
	 * @param campo, Campo a convertir de formato
	 * @param formato, Formato a convertir el campo
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String convertFechaVarchar(String campo, String formato) {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS){
			case ConstantesBD.SQL_SERVER:
//				retValue = "convert(varchar, " + campo + ", 103)"; // FORMATO dd/MM/yyyy
				retValue = "convert(varchar, " + campo + ", " + formato + ")";
				break;
			case ConstantesBD.ORACLE:
//				retValue = "To_char(" + campo + ", 'dd/MM/yyyy')";
				retValue = "To_char(" + campo + ", " + formato + ")";
				break;
			default:
				System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	
	/**
	 * Function convertFechaDate
	 * 
	 * Funcion para la conversion de campo tipo string a fecha en el formato seleccionado
	 * 
	 * @param campo, Campo a convertir en formato fecha
	 * @param horaMinSeg, Hora:Minutos:Segundos para convertir la fecha
	 * @param formato, Formato a convertir el campo fecha
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String convertFechaDate(String campo, String horaMinSeg, String formato) {
		String retValue = new String();
		
		if (horaMinSeg!=null && !"".equals(horaMinSeg)) {
			horaMinSeg  = (horaMinSeg.indexOf(":")!=-1) ? horaMinSeg : "00:00:00";
			if (!"?".equals(campo))
				campo   = campo.substring(0,campo.lastIndexOf("'")) + " " + horaMinSeg + "'";
			if (Integer.toString(Configuracion.BASE_DATOS).equals(Integer.toString(ConstantesBD.ORACLE))) {				
				formato = formato.substring((formato.indexOf("'")+1), formato.lastIndexOf("'"));
				formato = "'" + formato + " HH24:MI:SS" + "'";
			}
		}
		
		switch (Configuracion.BASE_DATOS){
			case ConstantesBD.SQL_SERVER:
				retValue = "convert(datetime, " + campo + ", " + formato + ")";
				break;
			case ConstantesBD.ORACLE:
				retValue = "To_date(" + campo + ", " + formato + ")";
				break;
			default:
				System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Function formatoFecha_ddmmyyyy
	 * 
	 * Funcion para la conversion de campo tipo string a fecha en el formato seleccionado
	 * 
	 * @param campo, Campo a convertir de formato
	 * @param formato, Formato a convertir el campo
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String formatoFecha_ddmmyyyy() {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS){
			case ConstantesBD.SQL_SERVER:
				retValue = "103";
				break;
			case ConstantesBD.ORACLE:
				retValue = "'dd/MM/yyyy'";
				break;
			default:
				System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Function funcUpper
	 * 
	 * Funcion para la conversion a mayusculas del campo
	 * 
	 * @param campo, Campo a convertir a mayusculas
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String upper(String campo){
		String retValue = new String();
		switch (Configuracion.BASE_DATOS){
		case ConstantesBD.SQL_SERVER:
			retValue = campo;
			break;
		case ConstantesBD.ORACLE:
			retValue = "UPPER(" + campo + ")";
			break;
		default:
			System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Function funcLower
	 * 
	 * Funcion para la conversion a minusculas del campo
	 * 
	 * @param campo, Campo a convertir a minusculas
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String lower(String campo){
		String retValue = new String();
		switch (Configuracion.BASE_DATOS){
		case ConstantesBD.SQL_SERVER:
			retValue = campo;
			break;
		case ConstantesBD.ORACLE:
			retValue = "LOWER(" + campo + ")";
			break;
		default:
			System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Function substring
	 * @param campo, Campo a cortar
	 * @param inicio, Inicio para empezar a cortar el campo
	 * @param longitud, Fin para cortar el campo
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String substring(String campo, String inicio, String longitud) {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS){
		case ConstantesBD.SQL_SERVER:
			retValue = "SUBSTRING(" + campo + ", " + inicio + ", " + longitud + ")";
			break;
		case ConstantesBD.ORACLE:
			retValue = "SUBSTR(" + campo + ", " + inicio + ", " + longitud + ")";
			break;
		default:
			System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Function charindex
	 * @param campo, Campo a buscar la posicion del valor
	 * @param valor, Valor con la condicion a buscar
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String charindex(String campo, String valor) {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS){
		case ConstantesBD.SQL_SERVER:
			retValue = "CHARINDEX(" + valor + ", " + campo + ")";
			break;
		case ConstantesBD.ORACLE:
			retValue = "INSTR(" + campo + ", " + valor + ")";
			break;
		default:
			System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/**
	 * Fucntion len
	 * @param campo, Campo a obtener el total de caracteres
	 * @return retValue, Cadena con el valor para la consulta
	 */
	public static String len(String campo) {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS){
		case ConstantesBD.SQL_SERVER:
			retValue = "LEN(" + campo + ")";
			break;
		case ConstantesBD.ORACLE:
			retValue = "LENGTH(" + campo + ")";
			break;
		default:
			System.out.println("DB no implemetada");
		}
		return retValue;
	}
	
	/** 
	 * Function functIsNull
	 * @return retValue, Cadena para manejo de valores nulos de la base de datos en uso
	 */
	public static String isNull() {
		String retValue = new String();
		switch (Configuracion.BASE_DATOS) {
			case ConstantesBD.SQL_SERVER:
				retValue = "isNull";
				break;
			case ConstantesBD.ORACLE:
				retValue = "nvl";
				break;
			default:
				System.out.println("DB no implemetada: ");
		}
		return retValue;
	}
	
	/**
	 * Function functConcatena
	 * @return retValue, Cadena para concatenar valores de la base de datos en uso
	 */
	public static String concatena(){
		String retValue = new String();
		switch (Configuracion.BASE_DATOS) {
			case ConstantesBD.SQL_SERVER:
				retValue = "+";
				break;
			case ConstantesBD.ORACLE:
				retValue = "||";
				break;
			default:
				System.out.println("DB no implemetada: ");
		}
		return retValue;
	}
	
}
