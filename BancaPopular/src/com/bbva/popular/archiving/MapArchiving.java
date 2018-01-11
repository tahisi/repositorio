package com.bbva.popular.archiving;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bbva.popular.bean.BeanPopular;


public class MapArchiving {
	
	public Map<String, Object>  generaMetadata (BeanPopular bean){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String date = sdf.format(new Date()); 
		
	
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("t", bean.getAplicacion());                  //Titulo aplicacion
		metadata.put("g", bean.getCd_expediente());     //id GAbinete
		metadata.put("c", bean.getCd_carpeta());      //id Carpeta
		metadata.put("d", bean.getCd_documento());    //idDocumento
		metadata.put("v", bean.getCd_version());      //id version
		metadata.put("p", bean.getCd_pagina());      //id pagina
		metadata.put("f", bean.getFolioDig());      //folio Digitalizacion  
		metadata.put("cd", bean.getCveDoc());		//clave del Documento
		metadata.put("nd", quitaSignos(bean.getNombreDoc()));		//clave del Documento
		metadata.put("u", bean.getUsuario());                  //usuario
		metadata.put("fd", date);            //fecha
		metadata.put("e", bean.getExtesion());                  //extension
		metadata.put("s", bean.getSize()); //tamaño archivo
		metadata.put("sha1N", bean.getSha1());   //Digestion SHA1 del Archivo
		metadata.put("n", quitaSignos(bean.getNombreArchivo()));
		metadata.put("tp", bean.getTipoProceso());
		metadata.put("ne", bean.getNombreEtapa());
		metadata.put("nc", bean.getContrato());
	
	
		

		return metadata;
		
	}
	
	 public static String quitaSignos(String cadena) {
		 String response = null;
		 if (cadena != null)
		 response = cadena.replaceAll("[^\\dA-Za-z. ]", "");
		 return response;
		 }

}
