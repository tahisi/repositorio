package com.bancomer.bean;

public class documentoBean {
	String clave_docto 		= null;
	String nombre_documento = null;
	String numero_cta 		= null;
	String cd_cliente		= null;
	String fecha_digital	= null;
	int id_version 			= 0;
	int id_carpeta_padre 	= 0;
	int id_documento 		= 0;
	int numero_paginas 		= 0;
	
	public String getFecha_digital() {
		return fecha_digital;
	}
	public void setFecha_digital(String fecha_digital) {
		this.fecha_digital = fecha_digital;
	}
	
	public String getCd_cliente() {
		return cd_cliente;
	}
	public void setCd_cliente(String cd_cliente) {
		this.cd_cliente = cd_cliente;
	}
	public String getNumero_cta() {
		return numero_cta;
	}
	public void setNumero_cta(String numero_cta) {
		this.numero_cta = numero_cta;
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
	public int getId_version() {
		return id_version;
	}
	public void setId_version(int id_version) {
		this.id_version = id_version;
	}
	public int getId_carpeta_padre() {
		return id_carpeta_padre;
	}
	public void setId_carpeta_padre(int id_carpeta_padre) {
		this.id_carpeta_padre = id_carpeta_padre;
	}
	public int getId_documento() {
		return id_documento;
	}
	public void setId_documento(int id_documento) {
		this.id_documento = id_documento;
	}
	public int getNumero_paginas() {
		return numero_paginas;
	}
	public void setNumero_paginas(int numero_paginas) {
		this.numero_paginas = numero_paginas;
	}
}
