package utils;

public class Datos {
	
	private String Cadena="";
	private String Nombre="";
	private String Extension="";
	private String Error="";

	public Datos(String cadena, String nombre,String extension,String error){
		
		this.Cadena     = cadena;
		this.Nombre     = nombre;
		this.Extension  = extension;
		this.Error      = error;
		
	}

	public String getCadena() {
		return Cadena;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getExtension() {
		return Extension;
	}

	public String getError() {
		return Error;
	}
	
	

}
