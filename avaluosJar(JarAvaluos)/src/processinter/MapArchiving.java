package processinter;

import java.util.HashMap;
import java.util.Map;

public class MapArchiving {
	
	public Map<String, Object>  generaMetadata (String aplicacion, String folio, String id, String extension, byte [] buf){
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("t", aplicacion);                  //Titulo aplicacion
		metadata.put("e", folio);                       //Identificador Unico de Expediente
		metadata.put("d", id);                          //Identificador Unico de Documento
		metadata.put("x", extension);                   //Extension  del Archivo   
		metadata.put("s", "A");                         //Estatus del Documento
		metadata.put("f", GetFecha.fechaActual());      //Fecha de Control DDMMAAAA
		metadata.put("v", "1");							//Version del Documento
		metadata.put("z", buf.length);                  //Tamaño del Archivo
		metadata.put("n", id+"."+extension);            //Nombre del Archivo
		metadata.put("sha1N",Digestion.GetSha1(buf));   //Digestion SHA1 del Archivo

		return metadata;
		
	}

}
