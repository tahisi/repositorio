package com.bancomer.bean;

public class datosBean {

	int id_gabinete;
	int id_carpeta_padre;
	int id_documento;
	int numero_pagina;
	String volumen;
	String nom_archivo_vol;
	String unidad_disco;
	String ruta_base;
	String ruta_directorio;
	
	public int getNumero_pagina() {
		return numero_pagina;
	}
	public void setNumero_pagina(int numero_pagina) {
		this.numero_pagina = numero_pagina;
	}
	public String getUnidad_disco() {
		return unidad_disco;
	}
	public void setUnidad_disco(String unidad_disco) {
		this.unidad_disco = unidad_disco;
	}
	public String getRuta_base() {
		return ruta_base;
	}
	public void setRuta_base(String ruta_base) {
		this.ruta_base = ruta_base;
	}
	public String getRuta_directorio() {
		return ruta_directorio;
	}
	public void setRuta_directorio(String ruta_directorio) {
		this.ruta_directorio = ruta_directorio;
	}
	public int getId_gabinete() {
		return id_gabinete;
	}
	public void setId_gabinete(int id_gabinete) {
		this.id_gabinete = id_gabinete;
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
	public String getVolumen() {
		return volumen;
	}
	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}
	public String getNom_archivo_vol() {
		return nom_archivo_vol;
	}
	public void setNom_archivo_vol(String nom_archivo_vol) {
		this.nom_archivo_vol = nom_archivo_vol;
	}
	
}
