package com.faavoo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.bbva.tdcempresarial.alta.controller.FlujoTdcEmpresarialController;

@Path("/saludo")
public class Holamundo {
    
    @GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_HTML)
    public String getSaludoHTML(@PathParam("param") String nombre) {
        return "<html> " + "<title>" + "Hola Mundo" + "</title>"  
             + "<body><h1>" + "Hola Mundo en HTML : " + nombre 
             + "</body></h1>" + "</html> ";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSaludoPlain() {
        return "Hola mundo!"  ;
    }
    
    @GET
	@Path("ejemplo_salida")
	public String getEjemploSalida() {
		return "Ejemplo Salida";
	}

}