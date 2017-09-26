package com.bancomer.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bancomer.bean.documentoBean;
import com.bancomer.principal.reporteBEyG;

public class comparaAplicacion {
	public static Logger log = Logger.getLogger(comparaAplicacion.class);
	public String comaraCd_aplicacion(Connection conn, String cd_aplicacion, String cadena,documentoBean doc,    BufferedWriter captacionbw,
			BufferedWriter carterabw,  BufferedWriter existenBEyGw, BufferedWriter noexistenBEyGw  , BufferedWriter salidaBeygbw, BufferedWriter conContratobw) throws IOException{
		int id_gabinete = 0;
		DocumentoDao dao = new DocumentoDao();
		if (cd_aplicacion.equals("VI00") || cd_aplicacion.equals("FI00") || cd_aplicacion.equals("PZ00") || cd_aplicacion.equals("MESA")){
			//GENERA ARCHIVO CAPTACION
			captacionbw.write(cadena);
			captacionbw.write("\n");
		

			try {
				id_gabinete= dao.BuscaNumeroCliente(conn, doc.getCd_cliente() );
			if(id_gabinete !=0){
				existenBEyGw.write(cadena);
				existenBEyGw.write("\n");
				//busca sus documentos
				dao.BuscaDocumentosCliente(conn,id_gabinete, doc, cadena,salidaBeygbw,conContratobw); 
			
			}
			else{
				noexistenBEyGw.write(cadena);
				noexistenBEyGw.write("\n");
			}
			} catch (SQLException e) {
				log.info(e.getMessage());
				e.printStackTrace();
			}
		}else if(cd_aplicacion.equals("UG  ") || cd_aplicacion.equals("LE  ") ){
			//GENERA ARCHIVO CARTERA
			carterabw.write(cadena);
			carterabw.write("\n");
		}
		return null	;
	}

}

