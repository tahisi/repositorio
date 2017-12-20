/**
 * Documento_Ser.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class Documento_Ser extends com.ibm.ws.webservices.engine.encoding.ser.BeanSerializer {
	/**
	 * Constructor
	 */
	public Documento_Ser(java.lang.Class _javaType, javax.xml.namespace.QName _xmlType,
			com.ibm.ws.webservices.engine.description.TypeDesc _typeDesc) {
		super(_javaType, _xmlType, _typeDesc);
	}

	public void serialize(javax.xml.namespace.QName name, org.xml.sax.Attributes attributes, java.lang.Object value,
			com.ibm.ws.webservices.engine.encoding.SerializationContext context) throws java.io.IOException {
		context.startElement(name, addAttributes(attributes, value, context));
		addElements(value, context);
		context.endElement();
	}

	protected org.xml.sax.Attributes addAttributes(org.xml.sax.Attributes attributes, java.lang.Object value,
			com.ibm.ws.webservices.engine.encoding.SerializationContext context) throws java.io.IOException {
		return attributes;
	}

	protected void addElements(java.lang.Object value,
			com.ibm.ws.webservices.engine.encoding.SerializationContext context) throws java.io.IOException {
		Documento bean = (Documento) value;
		java.lang.Object propValue;
		javax.xml.namespace.QName propQName;
		{
			propQName = QName_0_0;
			propValue = new java.lang.Integer(bean.getCd_aplicacion());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_1;
			propValue = new java.lang.Integer(bean.getCd_carpeta());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_2;
			propValue = new java.lang.Integer(bean.getCd_documento());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_3;
			propValue = new java.lang.Integer(bean.getCd_expediente());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_4;
			propValue = new java.lang.Integer(bean.getCd_pagina());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_5;
			propValue = new java.lang.Integer(bean.getCd_version());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_6;
			propValue = bean.getCicloEscolar();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_7;
			propValue = bean.getCr();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_8;
			propValue = bean.getExtension();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_9;
			propValue = bean.getFolioDig();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_10;
			propValue = bean.getNb_beca();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_11;
			propValue = bean.getNb_documento();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_12;
			propValue = bean.getNb_generacion();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_13;
			propValue = bean.getNombre_archivo();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_14;
			propValue = bean.getNumeroCliente();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_15;
			propValue = bean.getNumeroCuenta();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_16;
			propValue = new java.lang.Integer(bean.getNumeroPaginas());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_17;
			{
				propValue = bean.getPaginasDocumento();
				if (propValue != null) {
					for (int i = 0; i < java.lang.reflect.Array.getLength(propValue); i++) {
						serializeChild(propQName, null, java.lang.reflect.Array.get(propValue, i), QName_2_25, true,
								null, context);
					}
				}
			}
			propQName = QName_0_18;
			propValue = bean.getSha1();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_19;
			propValue = new java.lang.Integer(bean.getSize());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_20;
			propValue = bean.getTp_doc();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_21;
			propValue = bean.getTx_descripcion();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_22;
			propValue = bean.getUsuario();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
		}
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
	private final static javax.xml.namespace.QName QName_1_23 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("http://www.w3.org/2001/XMLSchema", "int");
	private final static javax.xml.namespace.QName QName_0_20 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "tp_doc");
	private final static javax.xml.namespace.QName QName_0_12 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "nb_generacion");
	private final static javax.xml.namespace.QName QName_1_24 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("http://www.w3.org/2001/XMLSchema", "string");
	private final static javax.xml.namespace.QName QName_0_0 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_aplicacion");
	private final static javax.xml.namespace.QName QName_0_21 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "tx_descripcion");
	private final static javax.xml.namespace.QName QName_0_19 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "size");
	private final static javax.xml.namespace.QName QName_0_18 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "sha1");
	private final static javax.xml.namespace.QName QName_2_25 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("http://extranet.visor.bbva.com/", "paginaBean");
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
