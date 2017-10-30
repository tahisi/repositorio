package com.bbva.firdig.configuracion;

public class ConfWsFirma {
	
	public static final int entorno = 3; //0=DESARROLO, 1=CALIDAD VIA1, 2 = CALIDAD VIA2 , 3= BALANCEADOR PRODUCCION , 4 = LOCAL RAFA
	
	public static String[] wsLLFirma= { "http://150.250.235.63:1446/LLFirmaDigital/DigitalizacionService/WEB-INF/wsdl/DigitalizacionService.wsdl",
			"http://150.250.234.123:36081/LLFirmaDigital/DigitalizacionService/WEB-INF/wsdl/DigitalizacionService.wsdl",
			"http://150.250.234.124:36081/LLFirmaDigital/DigitalizacionService/WEB-INF/wsdl/DigitalizacionService.wsdl",
	"http://150.100.210.22:7051/LLFirmaDigital/DigitalizacionService/WEB-INF/wsdl/DigitalizacionService.wsdl"};

}
