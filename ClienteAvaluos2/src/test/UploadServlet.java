package test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.ssl.Base64;


import processmsd.GetMsdAvaluos;
import processmsd.GetMsdAvaluosService;
import processmsd.GetMsdAvaluosServiceLocator;



/**
 * Servlet implementation class UploadServlet
 */

@MultipartConfig
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected String tempDir = null;
	
	public void init(ServletConfig config) throws ServletException {

		if (tempDir == null) {
			tempDir = "E://tmp//";
		}	
		File fDir = new File(tempDir + File.separator);
		if (!fDir.exists())
			if (!fDir.mkdirs())
				throw new ServletException("No se pudo crear el directorio " + tempDir);
		System.out.println("[" + this.getClass().getName() + ".init(ServletConfig config)] tempDir: " + tempDir);
	}


	   
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			List<?> fileItems = parseRequest(request);
			GetMsdAvaluosService service 	= new GetMsdAvaluosServiceLocator();
			GetMsdAvaluos avaluos = null;
			PrintWriter out = null;
			try {
				avaluos = service.getGetMsdAvaluos();
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			try{
			
			int count = 0;
			boolean inWhile = false;
			int totFiles = fileItems.size();
			String tmpFile = null;
			boolean insertPageDoc = false;
			Iterator<?> i = fileItems.iterator();
			String base64 = null;
			while (i.hasNext()) {
				FileItem item = (FileItem) i.next();
			
				
				if ( !item.isFormField()) { // Recibe pagina documento
					inWhile = true;
					count++;
					try {
						
						

						
						tmpFile = (new File(item.getName())).getName();
						
				
//						File file = File.createTempFile(tmpFile,"pdf");
						File file = new File(tempDir  + tmpFile);
						item.write(file);
						byte [] archivoBytes = Utils.getBytesFromFile(file);
						byte[] fileArray = new byte[(int) file.length()];
						InputStream inputStream;
						try {
							inputStream = new FileInputStream(file);
							inputStream.read(fileArray);
							base64 = Base64.encodeBase64String(fileArray);
						} catch (Exception e) {	
							e.printStackTrace();
						}
//						102001
						String cadena = "";
						String folioexpediente="102";
						String tipoArchivo = "102001";
						String extesion ="pdf";
						String aplicacion = "avaluos";
						try{
							Date fecha1 = new Date();
							DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
							System.out.println("Guardando en Archiving: "+hourdateFormat.format(fecha1));
							
						String res =avaluos.addFile(base64, folioexpediente, tipoArchivo, extesion, aplicacion);
						System.out.println("CARGA ARCHIVO" + res);
						Date fecha2 = new Date();
						System.out.println("Termino de Guardar: "+hourdateFormat.format(fecha2));

						item.delete();
						file.delete();
						if(res.equals("0")){
							Date fecha3 = new Date();
							System.out.println("Abriendo Visor: "+hourdateFormat.format(fecha3));
							
							 response.sendRedirect("http://localhost:8080/VisorAvaluos/VisorAvaluos?idFolio="+tipoArchivo);
							
						}
//						else{
//								out.write(res);
//						}
					} catch (Exception e) {
						System.err.println("[" + this.getClass().getName() + ".doPost] " + e.getMessage());
						throw new ServletException(e);
					} 
				
			

	    }catch (Exception e){
	    	e.printStackTrace();
	    	
	    }
				}}}
		protected List<?> parseRequest(HttpServletRequest req) throws ServletException {
			DiskFileUpload upload = new DiskFileUpload();
			
			upload.setRepositoryPath(tempDir); // Directorio temporal de carga de
			// archivos

			// Si el archivo excede este tamaño, ocurre un excepcion
			// FileUploadException
			upload.setSizeMax(-1); // -1 sin limite

			try {
				return upload.parseRequest(req);
			} catch (FileUploadException fe) {
				fe.printStackTrace();
				throw new ServletException("Error de recepcion " + fe.getMessage());
			}
		}

		

		
		
		
		public class AddPageDocumentUploadFilenameFilter implements FilenameFilter {
			
			protected String usrCode;
			
			public AddPageDocumentUploadFilenameFilter(String usrCode) {
				this.usrCode = usrCode;
			}
		
			public boolean accept(File f, String s) {
				return s.startsWith(usrCode);
			}
		}
		

		private void closeWindow(HttpServletResponse resp) {
			PrintWriter out = null;

			try {
				out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<link rel=\"stylesheet\" href=\"css/fortimax_sistema.css\" type=\"text/css\">");
				out.println("	<script type=\"text/javascript\">");
				out.println("		self.close();");
				out.println("	</script>");
				out.println("</head>");
				out.println("</html>");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				out.flush();
				out.close();
			}
		}
		
		protected boolean extPermitida(boolean isImaxFile, String ext) {
			
//			String extPerm[] = { "tif", "bmp", "gif", "jpg", "png", "pnm", "wbmp", "fpx" };
			String extPerm[] = { "tif", "bmp", "gif", "jpg", "png"};

//			if (isImaxFile == false)
//				return true;

			for (int i = 0; i < extPerm.length; i++)
				if (ext.equalsIgnoreCase(extPerm[i]))
					return true;

			return false;
		}
		
		protected boolean extPermitida(String ext) {
			
			String extPerm[] = { "tif", "bmp", "gif", "jpg", "png"};

			for (int i = 0; i < extPerm.length; i++)
				if (ext.equalsIgnoreCase(extPerm[i]))
					return true;

			return false;
		}
	}


