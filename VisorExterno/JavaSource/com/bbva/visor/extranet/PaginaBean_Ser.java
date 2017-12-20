/**
 * PaginaBean_Ser.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class PaginaBean_Ser extends com.ibm.ws.webservices.engine.encoding.ser.BeanSerializer {
	/**
	 * Constructor
	 */
	public PaginaBean_Ser(java.lang.Class _javaType, javax.xml.namespace.QName _xmlType,
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
		PaginaBean bean = (PaginaBean) value;
		java.lang.Object propValue;
		javax.xml.namespace.QName propQName;
		{
			propQName = QName_0_0;
			propValue = new java.lang.Integer(bean.getCd_aplicacion());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_2;
			propValue = new java.lang.Integer(bean.getCd_documento());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_3;
			propValue = new java.lang.Integer(bean.getCd_expediente());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_26;
			propValue = bean.getCd_folio();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_4;
			propValue = new java.lang.Integer(bean.getCd_pagina());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_27;
			propValue = new java.lang.Integer(bean.getCd_usuario());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_5;
			propValue = new java.lang.Integer(bean.getCd_version());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_28;
			propValue = bean.getNb_archivo();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_29;
			propValue = bean.getNb_extension();
			if (propValue != null && !context.shouldSendXSIType()) {
				context.simpleElement(propQName, null, propValue.toString());
			} else {
				serializeChild(propQName, null, propValue, QName_1_24, false, null, context);
			}
			propQName = QName_0_30;
			propValue = new java.lang.Integer(bean.getNu_pagina());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
			propQName = QName_0_31;
			propValue = new java.lang.Integer(bean.getNu_size());
			serializeChild(propQName, null, propValue, QName_1_23, true, null, context);
		}
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
	private final static javax.xml.namespace.QName QName_1_23 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("http://www.w3.org/2001/XMLSchema", "int");
	private final static javax.xml.namespace.QName QName_1_24 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("http://www.w3.org/2001/XMLSchema", "string");
	private final static javax.xml.namespace.QName QName_0_26 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_folio");
	private final static javax.xml.namespace.QName QName_0_4 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_pagina");
	private final static javax.xml.namespace.QName QName_0_3 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_expediente");
	private final static javax.xml.namespace.QName QName_0_0 = com.ibm.ws.webservices.engine.utils.QNameTable
			.createQName("", "cd_aplicacion");
}
