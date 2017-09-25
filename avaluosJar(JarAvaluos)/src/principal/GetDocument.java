package principal;

import org.apache.log4j.Logger;

import org.json.JSONObject;

import processmsd.GetMsdAvaluos;

public class GetDocument {
	
	private static Logger log = Logger.getLogger(GetDocument.class);
	
	public  static JSONObject buscaDoc(JSONObject entrada) throws Exception
	{

		JSONObject respuesta 		= new JSONObject();		
		log.info("GetDocument ");
		respuesta = new GetMsdAvaluos().downloadfile(entrada);
		
		return respuesta;

	}
	
	   
    
    


	
  
/////////////////////////    DOWNLOADFILE   /////////////////////////
//  public static void main(String args[]) throws Exception{
//  	JSONObject respuesta = null;
//  	String cadena ="{\"tituloAplicacion\":\"avaluos\","
//  			+ "\"folio\":["
//  			+ "{\"folioDigitalizacion\":\"00015\"}],"
//  			+ "\"atributos\":["
//  			+ "{\"campo\":\"folioExpediente\" ,\"valor\":\"10037D0037\"},"
//  			+ "{\"campo\":\"extension\",\"valor\":\"pdf\"}]}";
//  			
//  	JSONObject jsonObj = new JSONObject(cadena );
//  	respuesta= buscaDoc(jsonObj);
//  	System.out.println(respuesta);
//  }

  
  

}
