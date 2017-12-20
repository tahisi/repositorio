/**
 * PaginaBean_Deser.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class PaginaBean_Deser extends com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializer {
	/**
	 * Constructor
	 */
	public PaginaBean_Deser(java.lang.Class _javaType, javax.xml.namespace.QName _xmlType,
			com.ibm.ws.webservices.engine.description.TypeDesc _typeDesc) {
		super(_javaType, _xmlType, _typeDesc);
	}

	/**
	 * Create instance of java bean
	 */
	public void createValue() {
		value = new PaginaBean();
	}

	protected boolean tryElementSetFromString(javax.xml.namespace.QName qName, java.lang.String strValue) {
		if (qName == QName_0_0) {
			((PaginaBean) value)
					.setCd_aplicacion(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_2) {
			((PaginaBean) value)
					.setCd_documento(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_3) {
			((PaginaBean) value)
					.setCd_expediente(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_26) {
			((PaginaBean) value).setCd_folio(strValue);
			return true;
		} else if (qName == QName_0_4) {
			((PaginaBean) value)
					.setCd_pagina(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_27) {
			((PaginaBean) value)
					.setCd_usuario(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_5) {
			((PaginaBean) value)
					.setCd_version(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_28) {
			((PaginaBean) value).setNb_archivo(strValue);
			return true;
		} else if (qName == QName_0_29) {
			((PaginaBean) value).setNb_extension(strValue);
			return true;
		} else if (qName == QName_0_30) {
			((PaginaBean) value)
					.setNu_pagina(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
			return true;
		} else if (qName == QName_0_31) {
			((PaginaBean) value)
					.setNu_size(com.ibm.ws.webservices.engine.encoding.ser.SimpleDeserializer.parseint(strValue));
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
		return false;
	}

	private final static javax.xml.namespace.QName QName_0_31 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nu_size");
	private final static javax.xml.namespace.QName QName_0_28 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nb_archivo");
	private final static javax.xml.namespace.QName QName_0_2 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_documento");
	private final static javax.xml.namespace.QName QName_0_27 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_usuario");
	private final static javax.xml.namespace.QName QName_0_5 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_version");
	private final static javax.xml.namespace.QName QName_0_30 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nu_pagina");
	private final static javax.xml.namespace.QName QName_0_29 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nb_extension");
	private final static javax.xml.namespace.QName QName_0_26 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_folio");
	private final static javax.xml.namespace.QName QName_0_4 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_pagina");
	private final static javax.xml.namespace.QName QName_0_3 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_expediente");
	private final static javax.xml.namespace.QName QName_0_0 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_aplicacion");
}
