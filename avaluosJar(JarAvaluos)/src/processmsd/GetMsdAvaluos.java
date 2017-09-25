package processmsd;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


import com.syc.bancomer.bean.beanRespuesta;

import processinter.CargoArchivo;
import processinter.DeleteArchivo;
import processinter.DescargoArchivo;
import processinter.GetExpediente;
public class GetMsdAvaluos {


	private static Logger log = Logger.getLogger(GetMsdAvaluos.class);
	
	
	public    JSONObject addFile(JSONObject Avaluos)
	{
	
		String aplicacion 		= Avaluos.get("tituloAplicacion").toString();
		String archivo 			= Avaluos.get("byteFile").toString();
		
		JSONArray arr 			= Avaluos.getJSONArray("atributos");
		
		boolean folio			= false;
		boolean tipoA			= false;
		boolean ext				= false;
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		beanRespuesta bean 		= new beanRespuesta();
		
		JSONObject respuestaASO = new JSONObject();
		JSONObject exito 		= new JSONObject();
		JSONObject error 		= new JSONObject();
		
		for(int i=0; i<arr.length(); i++){   

			JSONObject o = arr.getJSONObject(i);  
			
			if(o.getString("campo").equals("folioExpediente")){
				folio	= true;
			}else if(o.getString("campo").equals("tipoArchivo")){
				tipoA 	= true;
			}else if(o.getString("campo").equals("extension")){
				ext 	= true ;
			}

			maps.put(o.getString("campo"), o.get("valor"));


		}
		if (folio   && tipoA  && ext) {

			System.out.println(aplicacion);

			String folioExpediente	= maps.get("folioExpediente").toString();
			String tipoArchivo 		= maps.get("tipoArchivo").toString();
			String extension 		= maps.get("extension").toString();
	

			System.out.println(aplicacion);
			if(aplicacion.toUpperCase().trim().equals("AVALUOS"))
			{
				CargoArchivo progress = new CargoArchivo();
				log.info("RECIBO INFORMACION CARGA ARCHIVO " );
				log.info("FOLIO			" + folioExpediente);		
				log.info("TIPO			" + tipoArchivo);
				log.info("EXTENSION		" + extension);

				try {
					bean =	progress.AgregoArchivo( archivo,
							folioExpediente.trim() ,
							tipoArchivo.trim(), 
							extension.trim(), 
							"AVALUOS", bean);

					if (bean.getFolioDigitalizacion()!= null){

						exito.put("folioDigitalizacion", bean.getFolioDigitalizacion());

					}else if(bean.getCodigo()!=null	){

						error.put("codigo", bean.getCodigo());
						error.put("mensaje", bean.getMensaje());
						error.put("causa", bean.getCausa());
					}

					respuestaASO.put("exito", exito);
					respuestaASO.put("error", error);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else{
			String mensaje  = null;
			if (!folio) {
				mensaje   = "folioExpediente";
			}
			else if(!tipoA){
				mensaje = "tipoArchivo";
			}else if (!ext){
				mensaje = "extension";
			}
		    error.put("codigo","002");
            error.put("mensaje","El atributo -| " + mensaje + " |- no viene informado");
            error.put("causa","Informacion nula");
            respuestaASO.put("exito", exito) ;
            respuestaASO.put("error", error);
		}
		return respuestaASO;

	}
	
	public    JSONObject downloadfile(JSONObject consulta) throws Exception
	{
		String aplicacion 		= consulta.get("tituloAplicacion").toString();
		JSONArray arr 			= consulta.getJSONArray("atributos");
		JSONArray foliosArray	= consulta.getJSONArray("folio");
		JSONObject respuesta   	= null;

		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> folios = new HashMap<String, Object>();
		
		for(int i=0; i<foliosArray.length(); i++){   
			JSONObject a = foliosArray.getJSONObject(i);  
			folios.put("folio", a.getString("folioDigitalizacion"));
		}
		
		for(int i=0; i<arr.length(); i++){   
			JSONObject o = arr.getJSONObject(i);  
			maps.put(o.getString("campo"), o.get("valor"));
		}
		
		String folioExpediente	= maps.get("folioExpediente").toString();
		String folio = folios.get("folio").toString();
		log.info("RECIBO INFORMACION DOWNLOADFILE" );
		log.info("FOLIO " + folio);		
		log.info("FOLIO EXPEDIENTE " + folioExpediente);
		log.info("APLICACION " + aplicacion );
		
		
		if(aplicacion.toUpperCase().trim().equals("AVALUOS"))
		{
			DescargoArchivo down = new DescargoArchivo();

			respuesta= down.DowFile(folioExpediente.trim());

		}
		return respuesta;
	}
	
    public  JSONObject deleteFile(JSONObject borra)
    	{
    	
    	String aplicacion 		= borra.get("tituloAplicacion").toString();
		JSONArray arr 			= borra.getJSONArray("atributos");
		JSONObject respuesta   	= new JSONObject();
		JSONObject exito 		= new JSONObject();
		JSONObject error 		= new JSONObject();
		boolean fE = false ;
		boolean f = false ;
		Map<String, Object> maps = new HashMap<String, Object>();
		
		
		for(int i=0; i<arr.length(); i++){   
			JSONObject o = arr.getJSONObject(i);  
			if(o.getString("campo").equals("folioExpediente")){
				fE	= true;
			}else if(o.getString("campo").equals("tipoArchivo")){
				f 	= true;
			}

			maps.put(o.getString("campo"), o.get("valor"));
		}
		if (fE & f){
		String folioExpediente	= maps.get("folioExpediente").toString();
		String folio = maps.get("folio").toString();
    	log.info("RECIBO INFORMACION DELETEFILE" );
		log.info("FOLIO			" + folio);		
		log.info("TIPO			" + folioExpediente);
		log.info("APLICACION	" + aplicacion );
    	
  
    		if(aplicacion.toUpperCase().trim().equals("AVALUOS"))
    		{
    			DeleteArchivo eje = new DeleteArchivo();
    		
    			respuesta=eje.BorroArchivo(folioExpediente.trim());
				
    		}
		}
		 else{
				String mensaje  = null;
				if (!fE) {
					mensaje   = "folioExpediente";
				}
				else if(!f){
					mensaje = "tipoArchivo";
				}
			    error.put("codigo","002");
	            error.put("mensaje","El atributo -| " + mensaje + " |- no viene informado");
	            error.put("causa","Informacion nula");
	            respuesta.put("exito", exito);
	            respuesta.put("error", error);
			}
    		return respuesta;
    	}
	
    public  JSONObject getListFol(JSONObject buscafolio)
  	{
    	String aplicacion 	= buscafolio.get("tituloAplicacion").toString();
    	JSONArray arr 		= buscafolio.getJSONArray("atributos");
    	JSONObject regreso = new JSONObject (); 
    	JSONObject exito = new JSONObject (); 
    	JSONObject error = new JSONObject (); 
    	boolean f = false;
    	
    	Map<String, Object> maps = new HashMap<String, Object>();
    	
    	for(int i=0; i<arr.length(); i++){   
			JSONObject o = arr.getJSONObject(i);  
			maps.put(o.getString("campo"), o.get("valor"));
		}
    	
    	
    	String folio = maps.get("folio").toString();
    	
      	log.info("RECIBO INFORMACION GETLISTFOL" );
  		log.info("FOLIO			" + folio);		
  		log.info("APLICACION	" + aplicacion );
  		
  		if (f){
  			if(aplicacion.toUpperCase().trim().equals("AVALUOS"))
  			{
  				GetExpediente info = new GetExpediente();

  				regreso= info.traigoExpediente(folio);

  			}
  		}else {
  			String mensaje  = null;
		
			if(!f){
				mensaje = "folio";
			}
		    error.put("codigo","002");
            error.put("mensaje","El atributo -| " + mensaje + " |- no viene informado");
            error.put("causa","Informacion nula");
            regreso.put("exito", exito);
            regreso.put("error", error);
  			
  		}
  			return regreso;
  	}
    

    
}
