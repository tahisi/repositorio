package com.bbva.becas.archiving;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bbva.becas.bean.BecasBean;

public class MapArchiving {
	
	public Map<String, Object>  generaMetadata (BecasBean bean){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String date = sdf.format(new Date()); 
		
	
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("t", "BECAS");                  //Titulo aplicacion
		metadata.put("g", bean.getIdGabinete());     //id GAbinete
		metadata.put("c", bean.getIdCarpeta());      //id Carpeta
		metadata.put("d", bean.getIdDocumento());    //idDocumento
		metadata.put("v", bean.getIdVersion());      //id version
		metadata.put("p", bean.getIdPagina());      //id pagina
		metadata.put("f", bean.getFolioDig());      //folio Digitalizacion  
		metadata.put("cd", bean.getCveDoc());		//clave del Documento
		metadata.put("nd", bean.getNombreDocto());		//clave del Documento
		metadata.put("u", bean.getUsuario());                  //usuario
		metadata.put("fd", date);            //fecha
		metadata.put("e", bean.getExtension());                  //extension
		metadata.put("s", bean.getSize()); //tamaño archivo
		metadata.put("sha1N", bean.getSha1());   //Digestion SHA1 del Archivo
		metadata.put("n", bean.getNombreArch());
		metadata.put("nc", bean.getNumeroCliente());
		metadata.put("cu", bean.getNumeroCuenta());
		metadata.put("cr", bean.getCr());
		metadata.put("b", bean.getNombreBeca());
		metadata.put("ce", bean.getCicloEscolar());
	
		

		return metadata;
		
	}

}
