/**
 * Documento_Deser.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class Documento_Deser extends com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializer {
	/**
	 * Constructor
	 */
	public Documento_Deser(java.lang.Class _javaType, javax.xml.namespace.QName _xmlType,
			com.ibm.ws.webservices.engine.description.TypeDesc _typeDesc) {
		super(_javaType, _xmlType, _typeDesc);
	}

	/**
	 * Create instance of java bean
	 */
	public void createValue() {
		value = new Documento();
	}

	protected boolean tryElementSetFromString(javax.xml.namespace.QName qName, java.lang.String strValue) {
		if (qName == QName_0_0) {
			((Documento) value)
					.setCd_aplicacion(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_1) {
			((Documento) value)
					.setCd_carpeta(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_2) {
			((Documento) value)
					.setCd_documento(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_3) {
			((Documento) value)
					.setCd_expediente(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_4) {
			((Documento) value)
					.setCd_pagina(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_5) {
			((Documento) value)
					.setCd_version(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_6) {
			((Documento) value).setCicloEscolar(strValue);
			return true;
		} else if (qName == QName_0_7) {
			((Documento) value).setCr(strValue);
			return true;
		} else if (qName == QName_0_8) {
			((Documento) value).setExtension(strValue);
			return true;
		} else if (qName == QName_0_9) {
			((Documento) value).setFolioDig(strValue);
			return true;
		} else if (qName == QName_0_10) {
			((Documento) value).setNb_beca(strValue);
			return true;
		} else if (qName == QName_0_11) {
			((Documento) value).setNb_documento(strValue);
			return true;
		} else if (qName == QName_0_12) {
			((Documento) value).setNb_generacion(strValue);
			return true;
		} else if (qName == QName_0_13) {
			((Documento) value).setNombre_archivo(strValue);
			return true;
		} else if (qName == QName_0_14) {
			((Documento) value).setNumeroCliente(strValue);
			return true;
		} else if (qName == QName_0_15) {
			((Documento) value).setNumeroCuenta(strValue);
			return true;
		} else if (qName == QName_0_16) {
			((Documento) value)
					.setNumeroPaginas(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_18) {
			((Documento) value).setSha1(strValue);
			return true;
		} else if (qName == QName_0_19) {
			((Documento) value)
					.setSize(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_20) {
			((Documento) value).setTp_doc(strValue);
			return true;
		} else if (qName == QName_0_21) {
			((Documento) value).setTx_descripcion(strValue);
			return true;
		} else if (qName == QName_0_22) {
			((Documento) value).setUsuario(strValue);
			return true;
		}
		return false;
	}

	protected boolean tryAttributeSetFromString(javax.xml.namespace.QName qName, java.lang.String strValue) {
		return false;
	}

	protected boolean tryElementSetFromObject(javax.xml.namespace.QName qName, java.lang.Object objValue) {
		return false;
	}

	protected boolean tryElementSetFromList(javax.xml.namespace.QName qName, java.util.List listValue) {
		if (qName == QName_0_17) {
			com.bbva.visor.extranet.PaginaBean[] array = new com.bbva.visor.extranet.PaginaBean[listValue.size()];
			listValue.toArray(array);
			((Documento) value).setPaginasDocumento(array);
			return true;
		}
		return false;
	}

	private final static javax.xml.namespace.QName QName_0_14 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "numeroCliente");
	private final static javax.xml.namespace.QName QName_0_10 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nb_beca");
	private final static javax.xml.namespace.QName QName_0_15 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "numeroCuenta");
	private final static javax.xml.namespace.QName QName_0_7 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cr");
	private final static javax.xml.namespace.QName QName_0_3 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_expediente");
	private final static javax.xml.namespace.QName QName_0_16 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "numeroPaginas");
	private final static javax.xml.namespace.QName QName_0_8 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "extension");
	private final static javax.xml.namespace.QName QName_0_13 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nombre_archivo");
	private final static javax.xml.namespace.QName QName_0_2 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_documento");
	private final static javax.xml.namespace.QName QName_0_20 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "tp_doc");
	private final static javax.xml.namespace.QName QName_0_12 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nb_generacion");
	private final static javax.xml.namespace.QName QName_0_0 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_aplicacion");
	private final static javax.xml.namespace.QName QName_0_21 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "tx_descripcion");
	private final static javax.xml.namespace.QName QName_0_19 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "size");
	private final static javax.xml.namespace.QName QName_0_18 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "sha1");
	private final static javax.xml.namespace.QName QName_0_22 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "usuario");
	private final static javax.xml.namespace.QName QName_0_6 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cicloEscolar");
	private final static javax.xml.namespace.QName QName_0_5 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_version");
	private final static javax.xml.namespace.QName QName_0_1 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_carpeta");
	private final static javax.xml.namespace.QName QName_0_17 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "paginasDocumento");
	private final static javax.xml.namespace.QName QName_0_4 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_pagina");
	private final static javax.xml.namespace.QName QName_0_11 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nb_documento");
	private final static javax.xml.namespace.QName QName_0_9 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "folioDig");
}
