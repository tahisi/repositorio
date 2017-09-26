package com.test.ws;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import mx.bbva.bancomer.hsm.bean.ResponseBean;
import mx.bbva.bancomer.hsm.bean.UserBean;
import mx.bbva.bancomer.hsm.wsdl.WSSeguridadHSM;
import mx.bbva.bancomer.hsm.wsdl.WSSeguridadHSMService;
import syc.bbva.firmadig.utils.Constantes;
import syc.bbva.firmadig.ws.cliente.ArrayOfXsdBase64Binary;
import syc.bbva.firmadig.ws.cliente.WSExpunicoSEI;
import syc.bbva.firmadig.ws.cliente.WSExpunicoService;
import syc.bbva.gestorremoto.ws.DigitalizacionService;
import syc.bbva.gestorremoto.ws.DigitalizacionServiceDelegate;
import syc.bbva.jaxb.Context;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.syc.bbva.ws.RecibeContratoDelegate;
import com.syc.bbva.ws.RecibeContratoService;

public class WebServiceClient {
    
    public static JAXBContext jc; 
    public static Context context;
    public static Unmarshaller u;
    public static FileInputStream in;
    public static RecibeContratoService contratoService = new RecibeContratoService();
    public static String wsdlExpUnicPrev;// =  "http://150.50.102.88:16016/fimxexpunic/services/WSExpunico/wsdl/WSExpunico.wsdl"; /** Ambiente previo */
    //public static final String wsdlExpUnicProd =  "http://imaxdigita.intranet.com.mx:8021/fimxexpunic/services/WSExpunico/wsdl/WSExpunico.wsdl" ; /** Produccion */	

	
    public static void main(String... args) {

    	//subeContratos();
		//recibeInformacion();
		//subeReportes(null);
		//subeReportes("019,019,CPBAS036,26");
		consumeGenericFile(); //subir archivo
		//consumeWS_SeguridadMX();
		//consumeWS_Expunico();
		//pruebaEnviaCorreo();
		//getFileFTP();
		//getFilesFTP();
		//getFileShared();
		//readFile_sendWsdl();

		System.exit(0);
    }
    
    public static void 	recibeInformacion(){

		RecibeContratoDelegate delegate = contratoService.getRecibeContratoPort();
		//File fileXML;

	    try {

			/*System.out.println(
				delegate.recibeInformacion("tipoOperacion|numCte|numContrato|cveProducto|numFolio",
							   "sancionCredito|D0072721|00740960579845626011|98|D0072721960010000001", null));*/

			/*fileXML = new File("C:/FirmaDigital/XMLReing/Ipav/00740010139698229514.xml");

			/*System.out.println(
				delegate.recibeInformacion("tipoOperacion|numCte|numContrato|folioTemp|cveProducto|subProd|user|statusProp|cveDocumento|sucOperativa",
							   "DocumentoDigital|D0019213|00740010112092451026| |20| |cpbas096| |208|3616",
							   CreateBase64.loadFile(fileXML)));

			System.out.println( delegate.recibeInformacion("tipoOperacion|numCte|numContrato|cveProducto|subProducto|user|statusProp|cveDocumento",
				"DocumentoDigital|J0819537|00740010139698229514|96|96|cpbas096|25|034,033", CreateBase64.loadFile(fileXML)) );

			/*int i = 0;
			String splitName[];

			//for( File file : new File("C:/FirmaDigital/Laboratorio/REPORTE_BS/").listFiles() ){

			File file = new File ("/home/aflores/Descargas/074318278333960743000005.xml");
				//String name = file.getName().replace(".pdf", "");
				System.out.println( delegate.recibeInformacion("tipoOperacion|numCte|numContrato|folioTemp|cveProducto|subProd|user|statusProp|cveDocumento|sucOperativa",
																"DocumentoDigital|18278333| |18278333960743000005|96| |msdtest| |038|6772", CreateBase64.loadFile(file)) );
				i++;
			//}


			/*File fileXML = new File("/fichtemcomp/aplicativo/firmadigital/PILOTO/255/161003/B6834182mban.xml");
			for( File fileXML : new File("/home/aflores/Proyectos/FirmaDigital/test_xml/bmovil/").listFiles() ) {

				String numCte = fileXML.getName().replace("mban.xml","");

				System.out.println(
						delegate.recibeInformacion("tipoOperacion|numCte|cveDocumento|sucOperativa|canal|md5",
								"firmaAutografa|" + numCte+ "|255|3307|mban|5897146d702fd752565b6eadb8a8c8d7",
								CreateBase64.loadFile(fileXML)));
			}*/

			/*
				System.out.println( delegate.recibeInformacion(
									"tipoOperacion|numCte|numCuenta|cveDocto",
									"consultaDocumento|35800568|9817599261|033",
									null) );
			*/
	    } catch (Exception e) {
			e.printStackTrace();
	    }
    }
    
    public static void consumeWS_Expunico() {
	
		WSExpunicoService wsExpUnic = WSExpunicoService.getInstancia(getWsdlLocation());
		WSExpunicoSEI wsExpUnicSEI = wsExpUnic.getWSExpunico();

		//envioArchivosBytes(String gaveta, String lista_campos, String lista_valores);
		ArrayOfXsdBase64Binary img = wsExpUnicSEI.envioArchivosBytes("EXPUNICO", "NUMCLIENTE|NOMCLIENTE|NUMCONTRATO|CLVEDOCTO|USUARIO|TIPO_DOCTO|FOLIO", "0|0|0|0|FD_CONSULTA|0|EU_EU_G13907C1D1V1");
		System.out.println(img.getBase64Binary());

		List<byte[]> listImgB64 = img.getBase64Binary(); //create empty array
		FileOutputStream fout = null;
		int i = 1;
		for (byte[] bs : listImgB64) {
			try {
				fout = new FileOutputStream("C:/FirmaDigital/fileZilla/snoop(" + i + ").jpg");
				fout.write(bs);
				i++;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fout != null)
						fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
    
    public static URL getWsdlLocation(){
		URL url = null;

		try {
			URL baseUrl;
			baseUrl = syc.bbva.firmadig.ws.cliente.WSExpunicoService.class.getResource(".");

			url = new URL( baseUrl, wsdlExpUnicPrev);

		} catch (MalformedURLException e) {
			System.out.println("Failed to create URL for the wsdl Location: '" + Constantes.wsdlExpUnic +"', retrying as a local file");
			System.out.println(e.getMessage());
		}
		return url;
    }

	public static void readFile_sendWsdl() {

		File file;
		long start, fin;
		BufferedReader br = null;
		RecibeContratoDelegate delegate = contratoService.getRecibeContratoPort();

		try {

			File fileXml = null;
			file = new File("/home/aflores/Proyectos/FirmaDigital/review/reporteBS/ValNumCte/reproceso.txt");
			br = new BufferedReader( new FileReader( file ) );

			String linea;
			String datos[];

			while( ( linea = br.readLine() ) != null ){

				try {
					start = System.currentTimeMillis();

					datos = linea.split("\\|");
					String prod = datos[1].substring(10, 12);
					String pathXML = file.getParentFile().getAbsolutePath() + "/" + datos[1] + ".xml";

					fileXml = new File(pathXML);
					System.out.println(String.format("Datos al WS: %s, ruta del xml: %s", Arrays.toString(datos), pathXML));

					System.out.println( "Respuesta WS: " + delegate.recibeInformacion(
										"tipoOperacion|numCte|numContrato|folioTemp|cveProducto|subProd|user|statusProp|cveDocumento|sucOperativa|Batch",
										"DocumentoDigital|" + datos[0] + "|" + datos[1] + "| |" + prod + "|" + prod +"|" + datos[2] + "| |033,034|" + datos[3] + "|0",
										CreateBase64.loadFile(fileXml)) );

					fin = System.currentTimeMillis() - start;
					System.out.println("End: Seconds " + fin / 1000.0);

				}finally{

					fileXml.delete();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Error al leer el archivo");

		}finally{
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
			}
		}
	}

    public static void getFileFTP() {

		File file;
		BufferedReader br = null;
		FTPDownloadFile ftpFile = new FTPDownloadFile();

		try {

			file = new File("/home/aflores/Proyectos/FirmaDigital/review/reporteBS/reportesBS.txt");
			br = new BufferedReader( new FileReader( file ) );

			String linea;

			while( ( linea = br.readLine() ) != null ){

				ftpFile.sftp(linea, linea.replace("/fichtemcomp/aplicativo/firmadigital/SCORING/",
												  "/home/aflores/Proyectos/FirmaDigital/review/reporteBS/ValNumCte/"));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Error al leer el archivo");

		}finally{
			try {
				br.close();
				ftpFile.disconnect();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
			}
		}
    }

	public static void getFilesFTP() {

		File file;
		BufferedReader br = null;
		FTPDownloadFile ftpFile = new FTPDownloadFile();

		try {

			file = new File("/home/aflores/Descargas/result.txt");
			br = new BufferedReader( new FileReader( file ) );

			File fileTmp;
			String [] datos;
			String linea, rutaArchivo;

			while( ( linea = br.readLine() ) != null ){

				datos = linea.split("\t");
				rutaArchivo = (datos[1].replace("Ruta: ","")).split(",")[0].replace(".pdf",".xml");// + ".xml";

				if(rutaArchivo.startsWith("/fichtemcomp/aplicativo/") && rutaArchivo.endsWith(".xml")) {

					String ruta = rutaArchivo.replace("/fichtemcomp/aplicativo/firmadigital/PILOTO/",
													  "/home/aflores/Proyectos/FirmaDigital/reproceso/");

					fileTmp = new File(ruta);

					if(!fileTmp.getParentFile().exists()) fileTmp.getParentFile().mkdirs();

					ftpFile.sftp( rutaArchivo, ruta );

				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Error al leer el archivo");

		}finally{
			try {
				br.close();
				//ftpFile.disconnect();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
			}
		}
	}

	public static void getFileShared(){

		File file, source, dest;
		BufferedReader br = null;

		try {

			file = new File("/home/aflores/Descargas/result.txt");
			br = new BufferedReader( new FileReader( file ) );

			String [] datos, json;
			String linea, rutaArchivo;

			while( ( linea = br.readLine() ) != null ) {
				datos = linea.split("\t");
				rutaArchivo = (datos[1].replace("Ruta: ","")).split(",")[0];

				if(rutaArchivo.startsWith("to_timestamp")){
					json = datos[0].split(",");
					String name = "FD" + json[8].split(":")[1].replace("}","") +
										 json[1].split(":")[1].replace("00","") +
										 json[7].split(":")[1] + ".xml";
					System.out.println(name);
					source = new File ( "\\\\150.225.103.26\\fichtemcom\\CapaGestora\\20161018\\" + name);
					dest = new File( "/home/aflores/Proyectos/FirmaDigital/reproceso/BUROSCORE/" + name);

					try {
						FileUtils.copyFile(source, dest);
					}catch (FileNotFoundException e) {
						System.out.println("Archivo no encontrado " + e.getMessage());
					}
				}
			}

			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
	}
    
    public static void subeContratos(){
    	
    	int i=1;//, x = 0;
    	long start, fin;

    	RecibeContratoDelegate delegate = contratoService.getRecibeContratoPort();

		//for( File file : new File("/home/aflores/Proyectos/FirmaDigital/test_xml/contratos/").listFiles() ){
			File file = new File("/home/aflores/FileZilla/00745882731512492253.xml");
    	    
    	    if(file.getAbsolutePath().endsWith(".xml")){
    		start = System.currentTimeMillis();	
    		String numCto = file.getName().replace(".xml", "");/*.replace("chequesahorropersonafisica", "")
    								  .replace("fondodeinversion", "")
    								  .replace("inversionespersonafisica", "");//numsCtos.get(x);*/

    		try{
    		    
    		    /*CONTRATOS*/
    		    System.out.println(i + ".- Respuesta WS: " + delegate.recibeInformacion(
    			    		   		   "tipoOperacion|numCte|numContrato|folioTemp|cveProducto|subProd|user|statusProp|cveDocumento|sucOperativa",
    			    		   		   "DocumentoDigital|" + getCteXML(file) + "|" + numCto + "| |" + numCto.substring(10, 12) + "| |cpbas096| |019|" +
										numCto.substring(4, 8), CreateBase64.loadFile(file)));


				/*REPORTE DE BURO Y SCORE
				String prod = numCto.substring(10, 12);
				System.out.println(i + ".- Respuesta WS: " + delegate.recibeInformacion(
						"tipoOperacion|numCte|numContrato|folioTemp|cveProducto|subProd|user|statusProp|cveDocumento|sucOperativa|Batch",
						"DocumentoDigital|" + getCampo(file, "NUMCLIE") + "|" + numCto + "| |" + prod + "|" + prod +"|CPBAS096| |033,034|0010|0",
						CreateBase64.loadFile(file)));*/

    		    fin = System.currentTimeMillis() - start;
    		    System.out.println("End: Seconds " + fin/1000.0);
    		
    		}catch(IOException e){
    		    e.printStackTrace();
    		    //continue;
    		}catch(Throwable e){
    		    e.printStackTrace();
    		    //continue;
    		}
    		i++;
    		//if(i==9) i=0; else 
    	    //}
    	    //x++;
    	}
    }
    
    public static void subeReportes(String params){
	int i=1;//, x = 0;
    	long start;

    	RecibeContratoDelegate delegate = contratoService.getRecibeContratoPort();
  	
    	for( File file : 
    	    new File("C:/FirmaDig/XMLReing/xml/upload/").listFiles() ){
    	    
    	    if(file.getAbsolutePath().endsWith(".xml")){
    		start = System.currentTimeMillis();	
    		String numCto = file.getName().replace(".xml", "");

    		try{
    		    if(params != null)
    		    System.out.println(i + ".- " + (System.currentTimeMillis() - start)/ 1000.0 + 
    			    		" seg, - Respuesta WS: " + delegate.recibeXML(CreateBase64.loadFile(file), "B3173119", numCto, params));
    		        		    
    		}catch(IOException e){
    		    e.printStackTrace();
    		}catch(Throwable e){
    		    e.printStackTrace();
    		}
    			i++;
    	    }
    	}
    }
    
	public static void pruebaEnviaCorreo(){
		long start, fin;

		RecibeContratoDelegate delegate = contratoService.getRecibeContratoPort();
		start = System.currentTimeMillis();
		System.out.println("Start: " + new Date(start));

		/*System.out.println(
				delegate.sendInfoMail("57637154", "00744762019808731880", "019", "alejandroismael.flores.contractor@bbva.com", "abc234")
		);
		/*
		System.out.println(
			delegate.sendInfoMail("D0051549", "00740010100178871299", "019", "alejandroismael.flores.contractor@bbva.com", "abc234")
		);
		System.out.println(
			delegate.sendInfoMail("D0019213", "00740010111106164331", "019", "alejandroismael.flores.contractor@bbva.com", "abc234")
		);
		System.out.println(
			delegate.sendInfoMail("D0060941", "00740010112092452952", "019", "alejandroismael.flores.contractor@bbva.com", "abc234")
		);
		System.out.println(
			delegate.sendInfoMail("D0057457", "00740010129696772644", "019", "alejandroismael.flores.contractor@bbva.com", "abc234")
		);*/

		/*System.out.println(
			delegate.sendInfoMail("D0055599", "00740010192092446197", "208", "alejandroismael.flores.contractor@bbva.com", "abc234")
		);
		System.out.println(
			delegate.sendInfoMail("D0033778", "00740010151368034826", "210", "alejandroismael.flores.contractor@bbva.com", "abc234")
		);

		System.out.println(
			delegate.resendInfoMail("D0066945", "FDEU@9600810741019p", "00740010159600810741", "019",
						"alejandroismael.flores.contractor@bbva.com", "abc234")
			);

		*/

		/*
		************************** GESTOR REMOTO *************************
		DigitalizacionService digitalService = new DigitalizacionService();
		DigitalizacionServiceDelegate delegateService = digitalService.getDigitalizacionServicePort();

		try{

			delegateService.servicioGlobal(
					CreateBase64.loadFile(new File ("/home/aflores/Proyectos/FirmaDigital/test_xml/contratos/00740960569820032304.xml")),
					"tipoOperacion|numeroCliente|numeroContrato|claveDocumento|correoE",
					"enviarContrato|92573270|00740010119603489371|019|guillermo.querea.contractor@bbva.com");//alejandroismael.flores.contractor@bbva.com


		} catch (IOException e) {
			e.printStackTrace();
		}*/

		/**/
		System.out.println(
			//delegate.getGenericFile(CreateBase64.loadFile(fileXML), ".xsl", fileXML.getName().replace(".xsl", ""))
			delegate.sendDocumentsByMail("A4555MSD", "00743458897381434449", "MA", "InfoP", "InfoE",
							//Arrays.asList(new String[]{"EU_EU_G13936C1D1V1|IDENT. OFICIAL|CREDENCIAL ELECTOR"}),
							Arrays.asList(new String[]{
											"EU_EU_G15089C1D4V1|IDENT. OFICIAL|CREDENCIAL ELECTOR",
											"EU_EU_G15258C1D2V3|DOMICILIO PARTICU|RECIBO DE TELEFONO",
											"EU_EU_G15258C5D1V1|DOMICILIO PARTICU|PREDIAL BIMESTRAL",
										    "FDEU@067909046138033p|BURO CREDITO|REPORTEB",
											"FDEU@067909046138034p|SCORE|REPORTES"}),
							" - Prueba de no afectación Aplicativo...", "0011", "5516606006", "JOSE DAVID AGUIRRE", "alejandroismael.flores.contractor@bbva.com")
		);



		fin = System.currentTimeMillis() - start;
		System.out.println("End: " + fin/1000.0);

	}
    
    public static void consumeGenericFile(){

	RecibeContratoDelegate delegate = contratoService.getRecibeContratoPort();
	
	/*;
	//numeroCliente, numeroContrato, claveDocumento, correoE, contrasenia
	delegate.sendInfoMail("81250925","00740446870100319341","019","isaacjones9@hotmail.com","741852");
	delegate.sendInfoMail("94072207","00743708050100315281","019","astutoricardo@yahoo.com.mx","415231");*/
	
	//for( File fileXML : new File("/home/aflores/wars/"/*"F:/home/ediweb/aplicativo/xsl_025/"*/).listFiles() ){

	    try {

			for( File fileXML : new File("E://SubeFirma").listFiles() ) {
//			File fileXML = new File("C:/Users/SyC/Desktop/war/docs/DocFolioInvalido.pdf");
									//C:/Users/SyC/Desktop/war/docs/DocFolioInvalido.pdf
			/*System.out.println(
				delegate.getGenericFile(CreateBase64.loadFile(new File("C:\\Temp\\PBLVKAHO0101V01150518E_PAR.txt")),
							".xml", "PBLVKAHO0101V01150518E_PAR.txt" ));*/
				System.out.println(
						delegate.getGenericFile(CreateBase64.loadFile(fileXML), "", fileXML.getName()));

			}
	    } catch (IOException e) {
			e.printStackTrace();
	    }
	//}
	
    }
    
    private static String getCteXML(File file) {
	
	try{
        	jc = JAXBContext.newInstance(Context.class);
        	u = jc.createUnmarshaller();
        	in = new FileInputStream( file );
        	context = (Context) u.unmarshal(in);
        	
        	return context.getDATOSPRODUCTO().getANEXOCOMPLEMENTO().getNUMCLIENTE();
        	
	} catch (JAXBException e) {
	    e.printStackTrace();
	    return "";
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    return "";
	} catch (NullPointerException npe){
	    System.out.println("Error al obtner el nodo: " + npe.getLocalizedMessage());
	    npe.printStackTrace();
	    return "";
	}
    }

    public static void deleteFiles(){
	for( File file : new File("C:/FirmaDigital/XMLReing/xml/").listFiles() ){
	    try{
	    System.out.println(file.getName() + "\t" + file.getName().replace(".xml", "").substring(10,20));
	    
	    for(String a : new String[3]){
		System.out.println(a);
	    }
	    //file.renameTo(new File(file.getParent() + "/" +file.getName().replace(".xml", "").substring(10,20) + ".xml"));
	    }catch(IndexOutOfBoundsException e){
		System.out.println("No se pudo cortar el nombre de: " + file.getName());
		continue;
	    }
	}
    }
    
    static {
	HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
	    {
	        public boolean verify(String hostname, SSLSession session)
	        {
	            if (hostname.equals("150.250.235.63"))
	                return true;
	            return false;
	        }
	});
    }
    
    public static void consumeWS_SeguridadMX(){
	    
        final String username = "produccion";
        final String password = "S36uR1dAD";

        UserBean user = new UserBean();
        user.setUsuario(username);
		user.setPassword(password);
	
         try{

            URL url = new URL("https://150.250.235.63/BBVAMexico/services/WSSeguridadHSM?wsdl");
            
            QName qname = new QName("http://wsdl.hsm.bancomer.bbva.mx", "WSSeguridadHSMService");
            Service service = WSSeguridadHSMService.create(url, qname);
            
            WSSeguridadHSM proxy = service.getPort(WSSeguridadHSM.class);
            Map<String, Object> requestContext = ((BindingProvider) proxy).getRequestContext();
            
            requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString());
            /*requestContext.put(BindingProvider.USERNAME_PROPERTY, username);
            requestContext.put(BindingProvider.PASSWORD_PROPERTY, password);*/
            
            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            
            headers.put("Timeout", Collections.singletonList("10000"));
            
            requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
            
            ResponseBean resp =  proxy.cifrarArchivoXML("BBVAProdFD", 
        	    		 CreateBase64.loadFile(new File("C:/FirmaDigital/XMLReing/xml/reportes/00743401727378847153.xml")), user);
            
            

            
            System.out.println("Result is: " + resp.getRespuesta());
	    
        } catch(IOException io){
	    	io.printStackTrace();
		} catch(Throwable t){
			t.printStackTrace();
		}
    }

	@SuppressWarnings("unchecked")
	public static String getCampo(File fileXML, String contentCte){

		Document doc;
		SAXBuilder builder = new SAXBuilder();

		try {

			doc = builder.build(fileXML);
			Element node = doc.getRootElement();
			List<Element> childrens =node.getChildren();

			return valueOfNode(childrens, contentCte, null);

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}

	@SuppressWarnings("unchecked")
	public static String valueOfNode(List<Element> childrens, String strNameNodo, String aux){

		for (Element children : childrens){
			//System.out.println(String.format("%s - [%s = %s] ? %s", children.toString(), children.getName(), strNameNodo, aux));

			if(strNameNodo.equals( children.getName() ))
				return aux = children.getValue();

			else{
				aux = valueOfNode(children.getChildren(), strNameNodo, aux);

				if( aux == null )
					continue;
				else
					break;
			}
		}
		return aux;
	}

}
