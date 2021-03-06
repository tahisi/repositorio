//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//

package com.syc.bbva.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "RecibeContratoDelegate", targetNamespace = "http://ws.bbva.syc.com/")
public interface RecibeContratoDelegate {

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "recibePDF", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibePDF")
	@ResponseWrapper(localName = "recibePDFResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibePDFResponse")
	public String recibePDF(
			@WebParam(name = "arg0", targetNamespace = "") byte[] arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3);

	/**
	 * 
	 * @param genericFile
	 * @param listaCampos
	 * @param listaValores
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "recibeFO", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibeFO")
	@ResponseWrapper(localName = "recibeFOResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibeFOResponse")
	public String recibeFO(
			@WebParam(name = "genericFile", targetNamespace = "") byte[] genericFile,
			@WebParam(name = "listaCampos", targetNamespace = "") String listaCampos,
			@WebParam(name = "listaValores", targetNamespace = "") String listaValores);

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "recibeXML", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibeXML")
	@ResponseWrapper(localName = "recibeXMLResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibeXMLResponse")
	public String recibeXML(
			@WebParam(name = "arg0", targetNamespace = "") byte[] arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3);

	/**
	 * 
	 * @param auxiliar
	 * @param xslFoB64
	 * @param extension
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getGenericFile", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.GetGenericFile")
	@ResponseWrapper(localName = "getGenericFileResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.GetGenericFileResponse")
	public String getGenericFile(
			@WebParam(name = "xslFoB64", targetNamespace = "") byte[] xslFoB64,
			@WebParam(name = "extension", targetNamespace = "") String extension,
			@WebParam(name = "auxiliar", targetNamespace = "") String auxiliar);

	/**
	 * 
	 * @param contrasenia
	 * @param numeroContrato
	 * @param claveDocumento
	 * @param numeroCliente
	 * @param correoE
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "sendInfoMail", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.SendInfoMail")
	@ResponseWrapper(localName = "sendInfoMailResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.SendInfoMailResponse")
	public String sendInfoMail(
			@WebParam(name = "numeroCliente", targetNamespace = "") String numeroCliente,
			@WebParam(name = "numeroContrato", targetNamespace = "") String numeroContrato,
			@WebParam(name = "claveDocumento", targetNamespace = "") String claveDocumento,
			@WebParam(name = "correoE", targetNamespace = "") String correoE,
			@WebParam(name = "contrasenia", targetNamespace = "") String contrasenia);

	/**
	 * 
	 * @param contrasenia
	 * @param numeroContrato
	 * @param folioDig
	 * @param claveDocumento
	 * @param numeroCliente
	 * @param correoE
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "resendInfoMail", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.ResendInfoMail")
	@ResponseWrapper(localName = "resendInfoMailResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.ResendInfoMailResponse")
	public String resendInfoMail(
			@WebParam(name = "numeroCliente", targetNamespace = "") String numeroCliente,
			@WebParam(name = "folioDig", targetNamespace = "") String folioDig,
			@WebParam(name = "numeroContrato", targetNamespace = "") String numeroContrato,
			@WebParam(name = "claveDocumento", targetNamespace = "") String claveDocumento,
			@WebParam(name = "correoE", targetNamespace = "") String correoE,
			@WebParam(name = "contrasenia", targetNamespace = "") String contrasenia);

	/**
	 * 
	 * @param cvesDoctos
	 * @param numContrato
	 * @param idUsuario
	 * @param numCliente
	 * @param idTerminal
	 * @param statusPropuesta
	 * @param cr
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "saveInfoBuroScoring", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.SaveInfoBuroScoring")
	@ResponseWrapper(localName = "saveInfoBuroScoringResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.SaveInfoBuroScoringResponse")
	public String saveInfoBuroScoring(
			@WebParam(name = "numCliente", targetNamespace = "") String numCliente,
			@WebParam(name = "numContrato", targetNamespace = "") String numContrato,
			@WebParam(name = "statusPropuesta", targetNamespace = "") String statusPropuesta,
			@WebParam(name = "cvesDoctos", targetNamespace = "") List<String> cvesDoctos,
			@WebParam(name = "cr", targetNamespace = "") String cr,
			@WebParam(name = "idTerminal", targetNamespace = "") String idTerminal,
			@WebParam(name = "idUsuario", targetNamespace = "") String idUsuario);

	/**
	 * 
	 * @param crSuc
	 * @param comentarios
	 * @param nomEjecutivo
	 * @param infoEnvio
	 * @param infoProd
	 * @param telSuc
	 * @param foliosDig
	 * @param numeroContrato
	 * @param marca
	 * @param numeroCliente
	 * @param correoE
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "sendDocumentsByMail", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.SendDocumentsByMail")
	@ResponseWrapper(localName = "sendDocumentsByMailResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.SendDocumentsByMailResponse")
	public String sendDocumentsByMail(
			@WebParam(name = "numeroCliente", targetNamespace = "") String numeroCliente,
			@WebParam(name = "numeroContrato", targetNamespace = "") String numeroContrato,
			@WebParam(name = "marca", targetNamespace = "") String marca,
			@WebParam(name = "infoProd", targetNamespace = "") String infoProd,
			@WebParam(name = "infoEnvio", targetNamespace = "") String infoEnvio,
			@WebParam(name = "foliosDig", targetNamespace = "") List<String> foliosDig,
			@WebParam(name = "comentarios", targetNamespace = "") String comentarios,
			@WebParam(name = "crSuc", targetNamespace = "") String crSuc,
			@WebParam(name = "telSuc", targetNamespace = "") String telSuc,
			@WebParam(name = "nomEjecutivo", targetNamespace = "") String nomEjecutivo,
			@WebParam(name = "correoE", targetNamespace = "") String correoE);

	/**
	 * 
	 * @param genericFile
	 * @param listaCampos
	 * @param listaValores
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "recibeInformacion", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibeInformacion")
	@ResponseWrapper(localName = "recibeInformacionResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.RecibeInformacionResponse")
	public String recibeInformacion(
			@WebParam(name = "lista_campos", targetNamespace = "") String listaCampos,
			@WebParam(name = "lista_valores", targetNamespace = "") String listaValores,
			@WebParam(name = "generic_file", targetNamespace = "") byte[] genericFile);

	/**
	 * 
	 * @return returns boolean
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "validaMSD", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.ValidaMSD")
	@ResponseWrapper(localName = "validaMSDResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.ValidaMSDResponse")
	public boolean validaMSD();

	/**
	 * 
	 * @param cveDocto
	 * @param folioDig
	 * @return returns byte[]
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getDocumento", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.GetDocumento")
	@ResponseWrapper(localName = "getDocumentoResponse", targetNamespace = "http://ws.bbva.syc.com/", className = "com.syc.bbva.ws.GetDocumentoResponse")
	public byte[] getDocumento(
			@WebParam(name = "folioDig", targetNamespace = "") String folioDig,
			@WebParam(name = "cveDocto", targetNamespace = "") String cveDocto);

}
