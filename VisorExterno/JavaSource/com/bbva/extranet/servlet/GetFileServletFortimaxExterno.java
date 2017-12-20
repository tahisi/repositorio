package com.bbva.extranet.servlet;

import static java.lang.String.format;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.bbva.visor.extranet.Documento;
import com.bbva.visor.extranet.PaginaBean;
import com.bbva.visor.extranet.WSVisorDelegate;
import com.bbva.visor.extranet.WSVisorServiceLocator;
import com.sun.xml.messaging.saaj.util.ByteInputStream;

import com.syc.utils.ParametersInterface;


@WebServlet("/getFileServletFortimaxExterno")
public class GetFileServletFortimaxExterno extends HttpServlet implements ParametersInterface {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(GetFileServletFortimaxExterno.class);
	
	/**
	 * Metodo init. <br>
	 *
	 * Este metodo inicializa el servlet
	 * 
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {

	}
	
	/**
	 * Metodo doGet. <br>
	 *
	 * Este metodo es llamado cuando la forma tiene el valor igual a get
	 * 
	 * @param request; request enviado por el cliente al servidor
	 * @param response; response enviado por el server al cliente
	 * @throws ServletException; en caso de ocurrir algun error
	 * @throws IOException; en caso de ocurrir algun error
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Entro por metodo GET GetFileServletFortimaxExterno");
		doPost(request, response);
	}

	
	/**
	 * Metodo doPost. <br>
	 *
	 * Este metodo es llamado cuando la forma tiene el valor igual a post
	 * 
	 * @param request; request enviado por el cliente al servidor
	 * @param response; response enviado por el server al cliente
	 * @throws ServletException; en caso de ocurrir algun error
	 * @throws IOException; en caso de ocurrir algun error
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String[] msg         = null;
		boolean embebido     = (request.getParameter("embebido")     == null ? true  : "true".equalsIgnoreCase(request.getParameter("embebido")));
		boolean elimina_file = (request.getParameter("elimina_file") == null ? true : "true".equalsIgnoreCase(request.getParameter("elimina_file")));
		boolean isClose      = (request.getParameter("close")        == null ? false : "true".equalsIgnoreCase(request.getParameter("close")));
		boolean isBack       = (request.getParameter("back")         == null ? false : "true".equalsIgnoreCase(request.getParameter("back")));
		int index            = (request.getParameter(INDEX_KEY)      == null ? -1    : Integer.parseInt(request.getParameter(INDEX_KEY)));		
		String aplicacion	= request.getParameter("aplicacion");
		log.info("Entro por metodo POST GetFileServletFortimaxExterno");
		log.info(format("embebido: %s", embebido));
		log.info(format("elimina_file: %s", elimina_file));
		log.info(format("isClose: %s", isClose));
		log.info(format("isBack: %s", isBack));
		log.info(format("index: %s", index));
		
		HttpSession session = request.getSession();
		if(session==null) {
			session = request.getSession(true);
			msg = new String[1];
			log.warn(msg[0] = "Session recibida nula o vac&iacute;a");
			session.setAttribute("msg", msg);
			response.sendRedirect("imgmngExterno/Messages.jsp?ok=false&close=" + isClose + "&back=" + isBack);
			return;
		}
		
		Documento d = (Documento) session.getAttribute("docs");		
		log.info(format("documento: %s", d));
		if(d==null) {
			msg = new String[1];
			log.warn(msg[0] = "Documento recibido nulo o vac&iacute;o");
			session.setAttribute("msg", msg);
			response.sendRedirect("imgmngExterno/Messages.jsp?ok=false&close=" + isClose + "&back=" + isBack);
			return;
		}
		if(index==-1) {
			msg = new String[1];
			log.warn(msg[0] = "N&uacute;mero de p&aacute;gina recibida nula o vac&iacute;a");
			session.setAttribute("msg", msg);
			response.sendRedirect("imgmngExterno/Messages.jsp?ok=false&close=" + isClose + "&back=" + isBack);
			return;
		}
		
		PaginaBean p = null;
		if (d.getPaginasDocumento().length>0) {
			p = d.getPaginaDocumento(index);
		} else {
			msg = new String[1];
			log.warn(msg[0] = "Objeto de p&aacute;gina nula o vac&iacute;a");
			session.setAttribute("msg", msg);
			response.sendRedirect("imgmngExterno/Messages.jsp?ok=false&close=" + isClose + "&back=" + isBack);
			return;
		}
		
		byte[] bFile = null;
		WSVisorServiceLocator client = new WSVisorServiceLocator();
		WSVisorDelegate service = null;
		try {
			service = client.getWSVisorPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bFile =service.getFiles(p.getCd_folio(), aplicacion);

		
		String filename = d.getNb_documento().trim()+"." + d.getPaginaDocumento(index).getNb_extension( );
		log.info(format("Documento a visualizar '%s'", filename));
		if (bFile==null || bFile.length<=0) {
			msg = new String[2];
//			log.warn(msg[0] = format("No existe la p&aacute;gina en volumen: %s", p.getVolumen()));
//			log.warn(msg[1] = format("Nombre p&aacute;gina: %s", p.getNomArchivoVol()));
			session.setAttribute("msg", msg);
			response.sendRedirect("imgmngExterno/Messages.jsp?ok=false&close=" + isClose + "&back=" + isBack);
			return;
		}
		
		
		doDownload(response, bFile, filename, embebido);
		
//		if (elimina_file) {
//			File file = d.getFullPathFiles(index);
//			if (file.exists()) {				
//				if (!file.delete()) {
//					log.info(format("No se pudo eliminar la imagen, se elimina al salir: %s", file.getAbsolutePath()));
//					file.deleteOnExit();
//				} else {
//					log.info(format("Eliminamos el archivo: %s", file.getAbsolutePath()));					
//				}
//			}
//		}
	}
	
	/**
	 * Metodo doDownload. <br>
	 * 
	 * Este metodo descarga mediante el response el archivo solicitado
	 * 
	 * @param response; response enviado por el server al cliente
	 * @param bFile; archivo en bytes a descargar
	 * @param filename; nombre del archivo a descargar
	 * @param embebido; true en caso de querer el archivo embebido o false para descargarlo
	 * @throws IOException; en caso de ocurrir algun error
	 */
	private void doDownload(HttpServletResponse response, byte[] bFile, String filename, boolean embebido) throws IOException {
		
		ByteInputStream bis     = null;
		ServletOutputStream sos = null;
		try {
			ServletContext context = getServletConfig().getServletContext();
			String mimetype        = context.getMimeType(filename);
			
			bis = new ByteInputStream(bFile, bFile.length);
			int longitud = bis.available();
			byte[] datos = new byte[longitud];
			bis.read(datos);
			
			response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
			response.setContentLength((int) longitud);
			response.addHeader("Content-Disposition", "inline; filename=\"" + filename + "\";");
			
			sos = response.getOutputStream();
			sos.write(datos);
			
		} finally {
			if (bis!=null)
				bis.close();
			
			if (sos!=null) {				
				sos.flush();
				sos.close();
			}
			sos  = null;
			bis  = null;
		}
	}

}