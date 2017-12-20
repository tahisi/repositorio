/**
 * PaginaBean_Helper.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class PaginaBean_Helper {
	// Type metadata
	private static final com.ibm.ws.webservices.engine.description.TypeDesc typeDesc = new com.ibm.ws.webservices.engine.description.TypeDesc(
			PaginaBean.class);

	static {
		typeDesc.setOption("buildNum", "m1116.12");
		com.ibm.ws.webservices.engine.description.FieldDesc field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_aplicacion");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_aplicacion"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_documento");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_documento"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_expediente");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_expediente"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_folio");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_folio"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_pagina");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_pagina"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_usuario");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_usuario"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_version");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_version"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nb_archivo");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nb_archivo"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nb_extension");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nb_extension"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nu_pagina");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nu_pagina"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nu_size");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nu_size"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
	};

	/**
	 * Return type metadata object
	 */
	public static com.ibm.ws.webservices.engine.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static com.ibm.ws.webservices.engine.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class javaType, javax.xml.namespace.QName xmlType) {
		return new PaginaBean_Ser(javaType, xmlType, typeDesc);
	};

	/**
	 * Get Custom Deserializer
	 */
	public static com.ibm.ws.webservices.engine.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class javaType, javax.xml.namespace.QName xmlType) {
		return new PaginaBean_Deser(javaType, xmlType, typeDesc);
	};

}
