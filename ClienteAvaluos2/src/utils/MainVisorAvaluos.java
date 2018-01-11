package utils;

import processmsd.GetMsdAvaluos;
import processmsd.GetMsdAvaluosService;
import processmsd.GetMsdAvaluosServiceLocator;

public class MainVisorAvaluos {

	public static void main(String[] args) {
		try{
			GetMsdAvaluosService service = new GetMsdAvaluosServiceLocator();
			GetMsdAvaluos avaluos = service.getGetMsdAvaluos();
			String folio="10030";
		    String tipoArchivo="D0030";
		    String aplicacion="avaluos";
//		    String usuarioVisor="visor";
//		   	String passwordVisor="avaluos";
			System.out.println("REsul: "+ avaluos.downloadfile(folio, tipoArchivo, aplicacion));
//		   	String [] datos = avaluos.getListFol(folio, aplicacion);
//		    //System.out.println("REsul: "+ avaluos.getListFol(folio, aplicacion));
//		    for (String string : datos) {
//				System.out.println(string);
//			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
