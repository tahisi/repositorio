package com.bancomer.bean;

import java.sql.Date;

public class ReporteBeyG2bean {
	
String sucursal; 
String nombre_usuario;
String numcliente;
String nomcliente; 
String clave_docto; 
String nombre_documento;

public String getSucursal() {
	return sucursal;
}
public void setSucursal(String sucursal) {
	this.sucursal = sucursal;
}
public String getNombre_usuario() {
	return nombre_usuario;
}
public void setNombre_usuario(String nombre_usuario) {
	this.nombre_usuario = nombre_usuario;
}
public String getNumcliente() {
	return numcliente;
}
public void setNumcliente(String numcliente) {
	this.numcliente = numcliente;
}
public String getNomcliente() {
	return nomcliente;
}
public void setNomcliente(String nomcliente) {
	this.nomcliente = nomcliente;
}
public String getClave_docto() {
	return clave_docto;
}
public void setClave_docto(String clave_docto) {
	this.clave_docto = clave_docto;
}
public String getNombre_documento() {
	return nombre_documento;
}
public void setNombre_documento(String nombre_documento) {
	this.nombre_documento = nombre_documento;
}
public String getFecha_creacion() {
	return fecha_creacion;
}
public void setFecha_creacion(String fecha_creacion) {
	this.fecha_creacion = fecha_creacion;
}
String fecha_creacion;

}
