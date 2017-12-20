package com.bbva.visor.extranet;



public class Documento {
	int  cd_documento;
	int   cd_expediente;
	int   cd_aplicacion ;
	int cd_version;
	int cd_carpeta;
	int cd_pagina;
	int size;
	String   nb_documento;
	String  tp_doc;
	String   nb_beca;
	String   nb_generacion;
	String   tx_descripcion;
	String folioDig;
	String extension;
	String usuario;
	String nombre_archivo;
	String numeroCliente;
	String numeroCuenta;
	String cicloEscolar;
	String sha1;
	String cr;
	int numeroPaginas;
	private String nombre_documento  = new String();
	PaginaBean[] paginas = new PaginaBean[0];
	
	public int getCd_documento() {
		return cd_documento;
	}
	public void setCd_documento(int cd_documento) {
		this.cd_documento = cd_documento;
	}
	public int getCd_expediente() {
		return cd_expediente;
	}
	public void setCd_expediente(int cd_expediente) {
		this.cd_expediente = cd_expediente;
	}
	public int getCd_aplicacion() {
		return cd_aplicacion;
	}
	public void setCd_aplicacion(int cd_aplicacion) {
		this.cd_aplicacion = cd_aplicacion;
	}
	public String getNb_documento() {
		return nb_documento;
	}
	public void setNb_documento(String nb_documento) {
		this.nb_documento = nb_documento;
	}
	public String getTp_doc() {
		return tp_doc;
	}
	public void setTp_doc(String tp_doc) {
		this.tp_doc = tp_doc;
	}
	public String getNb_beca() {
		return nb_beca;
	}
	public void setNb_beca(String nb_beca) {
		this.nb_beca = nb_beca;
	}
	public String getNb_generacion() {
		return nb_generacion;
	}
	public void setNb_generacion(String nb_generacion) {
		this.nb_generacion = nb_generacion;
	}
	public String getTx_descripcion() {
		return tx_descripcion;
	}
	public void setTx_descripcion(String tx_descripcion) {
		this.tx_descripcion = tx_descripcion;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public PaginaBean[] getPaginasDocumento() {
		return paginas;
	}

	public void setPaginasDocumento(PaginaBean[] paginas) {
		this.paginas = paginas;
	}

	public String[] getFilesNames() {
		String filesNames[] = new String[paginas.length];
		for (int i = 0; i < paginas.length; i++) {	
				filesNames[i] = nombre_documento + "_" + (i + 1) + paginas[i].getNb_extension();
		}

		return filesNames;
	}
	public PaginaBean getPaginaDocumento(int index) {
		return paginas[index];
	}
	public int getCd_version() {
		return cd_version;
	}
	public void setCd_version(int cd_version) {
		this.cd_version = cd_version;
	}
	public int getCd_carpeta() {
		return cd_carpeta;
	}
	public void setCd_carpeta(int cd_carpeta) {
		this.cd_carpeta = cd_carpeta;
	}
	public int getCd_pagina() {
		return cd_pagina;
	}
	public void setCd_pagina(int cd_pagina) {
		this.cd_pagina = cd_pagina;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFolioDig() {
		return folioDig;
	}
	public void setFolioDig(String folioDig) {
		this.folioDig = folioDig;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre_archivo() {
		return nombre_archivo;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getCicloEscolar() {
		return cicloEscolar;
	}
	public void setCicloEscolar(String cicloEscolar) {
		this.cicloEscolar = cicloEscolar;
	}
	public String getSha1() {
		return sha1;
	}
	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}
	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	


	
}
