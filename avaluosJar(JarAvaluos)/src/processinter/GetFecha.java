package processinter;

import java.text.SimpleDateFormat;

import java.util.Date;


public class GetFecha {
	
	
	public static String fechaActual (){
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String date = sdf.format(new Date()); 
		
		return date;
	}
	

}
