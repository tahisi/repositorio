/**
 * WSVisorServiceInformation.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class WSVisorServiceInformation implements com.ibm.ws.webservices.multiprotocol.ServiceInformation {

	private static java.util.Map operationDescriptions;
	private static java.util.Map typeMappings;

	static {
		initOperationDescriptions();
		initTypeMappings();
	}

	private static void initOperationDescriptions() {
		operationDescriptions = new java.util.HashMap();

		java.util.Map inner0 = new java.util.HashMap();

		java.util.List list0 = new java.util.ArrayList();
		inner0.put("getDocuments", list0);

		com.ibm.ws.webservices.engine.description.OperationDesc getDocuments0Op = _getDocuments0Op();
		list0.add(getDocuments0Op);

		java.util.List list1 = new java.util.ArrayList();
		inner0.put("getFiles", list1);

		com.ibm.ws.webservices.engine.description.OperationDesc getFiles1Op = _getFiles1Op();
		list1.add(getFiles1Op);

		operationDescriptions.put("WSVisorPort", inner0);
		operationDescriptions = java.util.Collections.unmodifiableMap(operationDescriptions);
	}

	private static com.ibm.ws.webservices.engine.description.OperationDesc _getDocuments0Op() {
		com.ibm.ws.webservices.engine.description.OperationDesc getDocuments0Op = null;
		com.ibm.ws.webservices.engine.description.ParameterDesc[] _params0 = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
				new com.ibm.ws.webservices.engine.description.ParameterDesc(
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "folio"),
						com.ibm.ws.webservices.engine.description.ParameterDesc.IN,
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
								"string"),
						java.lang.String.class, false, false, false, true, true,
						false),
				new com.ibm.ws.webservices.engine.description.ParameterDesc(
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "aplicacion"),
						com.ibm.ws.webservices.engine.description.ParameterDesc.IN,
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
								"string"),
						java.lang.String.class, false, false, false, true, true, false), };
		_params0[0].setOption("inputPosition", "0");
		_params0[0].setOption("partQNameString", "{http://www.w3.org/2001/XMLSchema}string");
		_params0[0].setOption("partName", "string");
		_params0[1].setOption("inputPosition", "1");
		_params0[1].setOption("partQNameString", "{http://www.w3.org/2001/XMLSchema}string");
		_params0[1].setOption("partName", "string");
		com.ibm.ws.webservices.engine.description.ParameterDesc _returnDesc0 = new com.ibm.ws.webservices.engine.description.ParameterDesc(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "return"),
				com.ibm.ws.webservices.engine.description.ParameterDesc.OUT,
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
						"documento"),
				com.bbva.visor.extranet.Documento.class, true, false, false, true, true, false);
		_returnDesc0.setOption("outputPosition", "0");
		_returnDesc0.setOption("partQNameString", "{http://extranet.visor.bbva.com/}documento");
		_returnDesc0.setOption("partName", "documento");
		com.ibm.ws.webservices.engine.description.FaultDesc[] _faults0 = new com.ibm.ws.webservices.engine.description.FaultDesc[] {};
		getDocuments0Op = new com.ibm.ws.webservices.engine.description.OperationDesc("getDocuments",
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
						"getDocuments"),
				_params0, _returnDesc0, _faults0, null);
		getDocuments0Op.setOption("portTypeQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorDelegate"));
		getDocuments0Op.setOption("outputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getDocumentsResponse"));
		getDocuments0Op.setOption("ServiceQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorService"));
		getDocuments0Op.setOption("buildNum", "m1116.12");
		getDocuments0Op.setOption("ResponseNamespace", "http://extranet.visor.bbva.com/");
		getDocuments0Op.setOption("targetNamespace", "http://extranet.visor.bbva.com/");
		getDocuments0Op.setOption("ResponseLocalPart", "getDocumentsResponse");
		getDocuments0Op.setOption("inputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getDocuments"));
		getDocuments0Op.setStyle(com.ibm.ws.webservices.engine.enumtype.Style.WRAPPED);
		return getDocuments0Op;

	}

	private static com.ibm.ws.webservices.engine.description.OperationDesc _getFiles1Op() {
		com.ibm.ws.webservices.engine.description.OperationDesc getFiles1Op = null;
		com.ibm.ws.webservices.engine.description.ParameterDesc[] _params0 = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
				new com.ibm.ws.webservices.engine.description.ParameterDesc(
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "folio"),
						com.ibm.ws.webservices.engine.description.ParameterDesc.IN,
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
								"string"),
						java.lang.String.class, false, false, false, true, true,
						false),
				new com.ibm.ws.webservices.engine.description.ParameterDesc(
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "aplicacion"),
						com.ibm.ws.webservices.engine.description.ParameterDesc.IN,
						com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
								"string"),
						java.lang.String.class, false, false, false, true, true, false), };
		_params0[0].setOption("inputPosition", "0");
		_params0[0].setOption("partQNameString", "{http://www.w3.org/2001/XMLSchema}string");
		_params0[0].setOption("partName", "string");
		_params0[1].setOption("inputPosition", "1");
		_params0[1].setOption("partQNameString", "{http://www.w3.org/2001/XMLSchema}string");
		_params0[1].setOption("partName", "string");
		com.ibm.ws.webservices.engine.description.ParameterDesc _returnDesc0 = new com.ibm.ws.webservices.engine.description.ParameterDesc(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "return"),
				com.ibm.ws.webservices.engine.description.ParameterDesc.OUT,
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema",
						"base64Binary"),
				byte[].class, true, false, false, true, true, false);
		_returnDesc0.setOption("outputPosition", "0");
		_returnDesc0.setOption("partQNameString", "{http://www.w3.org/2001/XMLSchema}base64Binary");
		_returnDesc0.setOption("partName", "base64Binary");
		com.ibm.ws.webservices.engine.description.FaultDesc[] _faults0 = new com.ibm.ws.webservices.engine.description.FaultDesc[] {};
		getFiles1Op = new com.ibm.ws.webservices.engine.description.OperationDesc("getFiles",
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
						"getFiles"),
				_params0, _returnDesc0, _faults0, null);
		getFiles1Op.setOption("portTypeQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorDelegate"));
		getFiles1Op.setOption("outputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getFilesResponse"));
		getFiles1Op.setOption("ServiceQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorService"));
		getFiles1Op.setOption("buildNum", "m1116.12");
		getFiles1Op.setOption("ResponseNamespace", "http://extranet.visor.bbva.com/");
		getFiles1Op.setOption("targetNamespace", "http://extranet.visor.bbva.com/");
		getFiles1Op.setOption("ResponseLocalPart", "getFilesResponse");
		getFiles1Op.setOption("inputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getFiles"));
		getFiles1Op.setStyle(com.ibm.ws.webservices.engine.enumtype.Style.WRAPPED);
		return getFiles1Op;

	}

	private static void initTypeMappings() {
		typeMappings = new java.util.HashMap();
		typeMappings.put(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
				"documento"), com.bbva.visor.extranet.Documento.class);

		typeMappings.put(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
				"paginaBean"), com.bbva.visor.extranet.PaginaBean.class);

		typeMappings = java.util.Collections.unmodifiableMap(typeMappings);
	}

	public java.util.Map getTypeMappings() {
		return typeMappings;
	}

	public Class getJavaType(javax.xml.namespace.QName xmlName) {
		return (Class) typeMappings.get(xmlName);
	}

	public java.util.Map getOperationDescriptions(String portName) {
		return (java.util.Map) operationDescriptions.get(portName);
	}

	public java.util.List getOperationDescriptions(String portName, String operationName) {
		java.util.Map map = (java.util.Map) operationDescriptions.get(portName);
		if (map != null) {
			return (java.util.List) map.get(operationName);
		}
		return null;
	}

}
