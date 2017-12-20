/**
 * WSVisorPortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class WSVisorPortBindingStub extends com.ibm.ws.webservices.engine.client.Stub
		implements com.bbva.visor.extranet.WSVisorDelegate {
	public WSVisorPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service)
			throws com.ibm.ws.webservices.engine.WebServicesFault {
		if (service == null) {
			super.service = new com.ibm.ws.webservices.engine.client.Service();
		} else {
			super.service = service;
		}
		super.engine = ((com.ibm.ws.webservices.engine.client.Service) super.service).getEngine();
		super.messageContexts = new com.ibm.ws.webservices.engine.MessageContext[2];
		java.lang.String theOption = (java.lang.String) super._getProperty("lastStubMapping");
		if (theOption == null || !theOption.equals("com.bbva.visor.extranet.WSVisorPortBinding")) {
			initTypeMapping();
			super._setProperty("lastStubMapping", "com.bbva.visor.extranet.WSVisorPortBinding");
		}
		super.cachedEndpoint = endpointURL;
		super.connection = ((com.ibm.ws.webservices.engine.client.Service) super.service).getConnection(endpointURL);
	}

	private void initTypeMapping() {
		javax.xml.rpc.encoding.TypeMapping tm = super.getTypeMapping(
				com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
		java.lang.Class javaType = null;
		javax.xml.namespace.QName xmlType = null;
		javax.xml.namespace.QName compQName = null;
		javax.xml.namespace.QName compTypeQName = null;
		com.ibm.ws.webservices.engine.encoding.SerializerFactory sf = null;
		com.ibm.ws.webservices.engine.encoding.DeserializerFactory df = null;
		javaType = com.bbva.visor.extranet.Documento.class;
		xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
				"documento");
		sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(
				com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
		df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(
				com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
		if (sf != null || df != null) {
			tm.register(javaType, xmlType, sf, df);
		}

		javaType = com.bbva.visor.extranet.PaginaBean.class;
		xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
				"paginaBean");
		sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(
				com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
		df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(
				com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
		if (sf != null || df != null) {
			tm.register(javaType, xmlType, sf, df);
		}

	}

	private static com.ibm.ws.webservices.engine.description.OperationDesc _getFilesOperation0 = null;

	private static com.ibm.ws.webservices.engine.description.OperationDesc _getgetFilesOperation0() {
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
		_getFilesOperation0 = new com.ibm.ws.webservices.engine.description.OperationDesc("getFiles",
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
						"getFiles"),
				_params0, _returnDesc0, _faults0, "");
		_getFilesOperation0.setOption("portTypeQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorDelegate"));
		_getFilesOperation0.setOption("outputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getFilesResponse"));
		_getFilesOperation0.setOption("ServiceQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorService"));
		_getFilesOperation0.setOption("buildNum", "m1116.12");
		_getFilesOperation0.setOption("ResponseNamespace", "http://extranet.visor.bbva.com/");
		_getFilesOperation0.setOption("targetNamespace", "http://extranet.visor.bbva.com/");
		_getFilesOperation0.setOption("ResponseLocalPart", "getFilesResponse");
		_getFilesOperation0.setOption("inputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getFiles"));
		_getFilesOperation0.setUse(com.ibm.ws.webservices.engine.enumtype.Use.LITERAL);
		_getFilesOperation0.setStyle(com.ibm.ws.webservices.engine.enumtype.Style.WRAPPED);
		return _getFilesOperation0;

	}

	private int _getFilesIndex0 = 0;

	private synchronized com.ibm.ws.webservices.engine.client.Stub.Invoke _getgetFilesInvoke0(Object[] parameters)
			throws com.ibm.ws.webservices.engine.WebServicesFault {
		com.ibm.ws.webservices.engine.MessageContext mc = super.messageContexts[_getFilesIndex0];
		if (mc == null) {
			mc = new com.ibm.ws.webservices.engine.MessageContext(super.engine);
			mc.setOperation(WSVisorPortBindingStub._getFilesOperation0);
			mc.setUseSOAPAction(true);
			mc.setSOAPActionURI("");
			mc.setEncodingStyle(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
			mc.setProperty(com.ibm.wsspi.webservices.Constants.SEND_TYPE_ATTR_PROPERTY, Boolean.FALSE);
			mc.setProperty(com.ibm.wsspi.webservices.Constants.ENGINE_DO_MULTI_REFS_PROPERTY, Boolean.FALSE);
			super.primeMessageContext(mc);
			super.messageContexts[_getFilesIndex0] = mc;
		}
		try {
			mc = (com.ibm.ws.webservices.engine.MessageContext) mc.clone();
		} catch (CloneNotSupportedException cnse) {
			throw com.ibm.ws.webservices.engine.WebServicesFault.makeFault(cnse);
		}
		return new com.ibm.ws.webservices.engine.client.Stub.Invoke(connection, mc, parameters);
	}

	public byte[] getFiles(java.lang.String folio, java.lang.String aplicacion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new com.ibm.ws.webservices.engine.NoEndPointException();
		}
		java.util.Vector _resp = null;
		try {
			_resp = _getgetFilesInvoke0(new java.lang.Object[] { folio, aplicacion }).invoke();

		} catch (com.ibm.ws.webservices.engine.WebServicesFault wsf) {
			Exception e = wsf.getUserException();
			throw wsf;
		}
		try {
			return (byte[]) ((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue();
		} catch (java.lang.Exception _exception) {
			return (byte[]) super.convert(
					((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue(), byte[].class);
		}
	}

	private static com.ibm.ws.webservices.engine.description.OperationDesc _getDocumentsOperation1 = null;

	private static com.ibm.ws.webservices.engine.description.OperationDesc _getgetDocumentsOperation1() {
		com.ibm.ws.webservices.engine.description.ParameterDesc[] _params1 = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
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
		_params1[0].setOption("inputPosition", "0");
		_params1[0].setOption("partQNameString", "{http://www.w3.org/2001/XMLSchema}string");
		_params1[0].setOption("partName", "string");
		_params1[1].setOption("inputPosition", "1");
		_params1[1].setOption("partQNameString", "{http://www.w3.org/2001/XMLSchema}string");
		_params1[1].setOption("partName", "string");
		com.ibm.ws.webservices.engine.description.ParameterDesc _returnDesc1 = new com.ibm.ws.webservices.engine.description.ParameterDesc(
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "return"),
				com.ibm.ws.webservices.engine.description.ParameterDesc.OUT,
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
						"documento"),
				com.bbva.visor.extranet.Documento.class, true, false, false, true, true, false);
		_returnDesc1.setOption("outputPosition", "0");
		_returnDesc1.setOption("partQNameString", "{http://extranet.visor.bbva.com/}documento");
		_returnDesc1.setOption("partName", "documento");
		com.ibm.ws.webservices.engine.description.FaultDesc[] _faults1 = new com.ibm.ws.webservices.engine.description.FaultDesc[] {};
		_getDocumentsOperation1 = new com.ibm.ws.webservices.engine.description.OperationDesc("getDocuments",
				com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
						"getDocuments"),
				_params1, _returnDesc1, _faults1, "");
		_getDocumentsOperation1.setOption("portTypeQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorDelegate"));
		_getDocumentsOperation1.setOption("outputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getDocumentsResponse"));
		_getDocumentsOperation1.setOption("ServiceQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "WSVisorService"));
		_getDocumentsOperation1.setOption("buildNum", "m1116.12");
		_getDocumentsOperation1.setOption("ResponseNamespace", "http://extranet.visor.bbva.com/");
		_getDocumentsOperation1.setOption("targetNamespace", "http://extranet.visor.bbva.com/");
		_getDocumentsOperation1.setOption("ResponseLocalPart", "getDocumentsResponse");
		_getDocumentsOperation1.setOption("inputMessageQName", com.ibm.ws.webservices.engine.utils.QNameTable
				.createQName("http://extranet.visor.bbva.com/", "getDocuments"));
		_getDocumentsOperation1.setUse(com.ibm.ws.webservices.engine.enumtype.Use.LITERAL);
		_getDocumentsOperation1.setStyle(com.ibm.ws.webservices.engine.enumtype.Style.WRAPPED);
		return _getDocumentsOperation1;

	}

	private int _getDocumentsIndex1 = 1;

	private synchronized com.ibm.ws.webservices.engine.client.Stub.Invoke _getgetDocumentsInvoke1(Object[] parameters)
			throws com.ibm.ws.webservices.engine.WebServicesFault {
		com.ibm.ws.webservices.engine.MessageContext mc = super.messageContexts[_getDocumentsIndex1];
		if (mc == null) {
			mc = new com.ibm.ws.webservices.engine.MessageContext(super.engine);
			mc.setOperation(WSVisorPortBindingStub._getDocumentsOperation1);
			mc.setUseSOAPAction(true);
			mc.setSOAPActionURI("");
			mc.setEncodingStyle(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
			mc.setProperty(com.ibm.wsspi.webservices.Constants.SEND_TYPE_ATTR_PROPERTY, Boolean.FALSE);
			mc.setProperty(com.ibm.wsspi.webservices.Constants.ENGINE_DO_MULTI_REFS_PROPERTY, Boolean.FALSE);
			super.primeMessageContext(mc);
			super.messageContexts[_getDocumentsIndex1] = mc;
		}
		try {
			mc = (com.ibm.ws.webservices.engine.MessageContext) mc.clone();
		} catch (CloneNotSupportedException cnse) {
			throw com.ibm.ws.webservices.engine.WebServicesFault.makeFault(cnse);
		}
		return new com.ibm.ws.webservices.engine.client.Stub.Invoke(connection, mc, parameters);
	}

	public com.bbva.visor.extranet.Documento getDocuments(java.lang.String folio, java.lang.String aplicacion)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new com.ibm.ws.webservices.engine.NoEndPointException();
		}
		java.util.Vector _resp = null;
		try {
			_resp = _getgetDocumentsInvoke1(new java.lang.Object[] { folio, aplicacion }).invoke();

		} catch (com.ibm.ws.webservices.engine.WebServicesFault wsf) {
			Exception e = wsf.getUserException();
			throw wsf;
		}
		try {
			return (com.bbva.visor.extranet.Documento) ((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp
					.get(0)).getValue();
		} catch (java.lang.Exception _exception) {
			return (com.bbva.visor.extranet.Documento) super.convert(
					((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue(),
					com.bbva.visor.extranet.Documento.class);
		}
	}

	private static void _staticInit() {
		_getFilesOperation0 = _getgetFilesOperation0();
		_getDocumentsOperation1 = _getgetDocumentsOperation1();
	}

	static {
		_staticInit();
	}
}
