package com.bbva.live.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.bbva.live.ws.DocumentoBean;
import com.bbva.live.ws.WSLiveServicePortImpDelegate;
import com.bbva.live.ws.WSLiveServicePortImpService;
import com.bbva.live.ws.WsExpediente;

//import com.bbva.live.ws.DocumentoBean;
//import com.bbva.live.ws.WSLiveServicePortImpDelegate;
//import com.bbva.live.ws.WSLiveServicePortImpService;

public class test {
	public static void main (String args[]){
		WSLiveServicePortImpService service = new WSLiveServicePortImpService();
		WSLiveServicePortImpDelegate del = service.getWSLiveServicePortImpPort();
		DocumentoBean documento= new DocumentoBean();
		documento.setTituloAplicacion("ACLARACIONES");
		documento.setNuCliente("10129111");
		documento.setFolioAclaracion("556779");
//		documento.setCve_docto("001");
		documento.setNbDocumento("NO_POST");
		documento.setNbArchivo("Archivo1");
		documento.setExtension("jpg");
		documento.setDescripcion("IDENTIFICACION");
		documento.setUsuario("XMCJ102");
		
		String pathImagen= "E:\\layout.png";
		 File file = new File(pathImagen);

		    byte[] fileInBytes = null;
			try {
				fileInBytes = FileUtils.readFileToByteArray(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		ficheroStream.read(contenido);
		    documento.setArchivo(fileInBytes);
		    String respuesta = null;

	WsExpediente bean =  del.enviaExpediente(documento);
		System.out.println("FOLIO = " + bean.getFolio());
		System.out.println("ERROR = " + bean.getError());
		
		
		
//		System.out.println(del.getDocumento("101291556778041.jp"));
}

}
