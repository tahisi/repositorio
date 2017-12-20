/**
 * Documento_Helper.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class Documento_Helper {
	// Type metadata
	private static final com.ibm.ws.webservices.engine.description.TypeDesc typeDesc = new com.ibm.ws.webservices.engine.description.TypeDesc(
			Documento.class);

	static {
		typeDesc.setOption("buildNum", "m1116.12");
		com.ibm.ws.webservices.engine.description.FieldDesc field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_aplicacion");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_aplicacion"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cd_carpeta");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_carpeta"));
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
		field.setFieldName("cd_pagina");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cd_pagina"));
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
		field.setFieldName("cicloEscolar");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cicloEscolar"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("cr");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "cr"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("extension");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "extension"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("folioDig");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "folioDig"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nb_beca");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nb_beca"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nb_documento");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nb_documento"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nb_generacion");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nb_generacion"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("nombre_archivo");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "nombre_archivo"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("numeroCliente");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "numeroCliente"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("numeroCuenta");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "numeroCuenta"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("numeroPaginas");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "numeroPaginas"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("paginasDocumento");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "paginasDocumento"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
				"paginaBean"));
		field.setMinOccursIs0(true);
		field.setMaxOccurs(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("sha1");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "sha1"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("size");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "size"));
		field.setXmlType(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("tp_doc");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "tp_doc"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("tx_descripcion");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "tx_descripcion"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
		typeDesc.addFieldDesc(field);
		field = new com.ibm.ws.webservices.engine.description.ElementDesc();
		field.setFieldName("usuario");
		field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "usuario"));
		field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
				"string"));
		field.setMinOccursIs0(true);
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
		return new Documento_Ser(javaType, xmlType, typeDesc);
	};

	/**
	 * Get Custom Deserializer
	 */
	public static com.ibm.ws.webservices.engine.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class javaType, javax.xml.namespace.QName xmlType) {
		return new Documento_Deser(javaType, xmlType, typeDesc);
	};

}
