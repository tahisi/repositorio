package com.bbva.extranet.servlet;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.media.jai.RenderedOp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.bbva.visor.extranet.Documento;
import com.bbva.visor.extranet.PaginaBean;
import com.bbva.visor.extranet.WSVisorDelegate;
import com.bbva.visor.extranet.WSVisorServiceLocator;
import com.sun.media.jai.codec.FileCacheSeekableStream;
import com.sun.xml.messaging.saaj.util.ByteInputStream;

import com.syc.utils.ParametersInterface;
import com.syc.viewer.GifEncoder;
import com.syc.viewer.ImageManagerJAI;

@WebServlet("/imageStoreExterno")
public class GetImageServletExterno extends HttpServlet implements ParametersInterface {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.sendRedirect("index.jsp");
			return;
		}

		String selectId = req.getParameter("select");
		if (selectId == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Sin nodo seleccionado");
			return;
		}
		String aplicacion = req.getParameter("aplicacion");
		Documento d = (Documento) session.getAttribute("docs");

		int fileIndex = -1;
		String fileIndexVal = req.getParameter(INDEX_KEY);
		if (fileIndexVal == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Sin indice de archivo");
			return;
		}
		fileIndex = Integer.parseInt(fileIndexVal);

		boolean isThumbnail = false;
		String thumbnailVal = req.getParameter(THUMBNAIL_KEY);
		if (thumbnailVal != null)
			isThumbnail = "true".equals(thumbnailVal);

		int outputRotate = 0;
		String rotateVal = (String) session.getAttribute(ROTATE_KEY);
		if (!isThumbnail && (rotateVal != null))
			outputRotate = Integer.parseInt(rotateVal);
		session.removeAttribute(ROTATE_KEY);
		
		PaginaBean p = d.getPaginaDocumento(fileIndex);
		
	
		WSVisorServiceLocator client = new WSVisorServiceLocator();
		WSVisorDelegate service = null;
		try {
			service = client.getWSVisorPort();
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] bFile = null;	
		bFile = service.getFiles(p.getCd_folio(), aplicacion);
	
	
	if (bFile==null || bFile.length<=0) {
		resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Pagina sin archivo");
		return;
	}
		
//				
	boolean	imagen  = isImage(d.getPaginaDocumento(fileIndex).getNb_extension());
//	if ("A".equalsIgnoreCase(d.getPaginaDocumento(imgIndex).getNb_extension())) {
if (imagen) {
			
			String ext = p.getNb_extension();
			
			ByteInputStream bis          = null;
			FileCacheSeekableStream fcss = null;
			RenderedOp outputImage       = null;
			
			OutputStream os = resp.getOutputStream();
			try {
				bis         = new ByteInputStream(bFile, bFile.length);
				fcss        = new FileCacheSeekableStream(bis);
//				outputImage = ImageManagerJAI.load(fcss);
				outputImage =	ImageManagerJAI.load(bFile);
				System.out.println(outputImage);
				if ((isThumbnail) && ((outputImage.getWidth() > 60) || (outputImage.getHeight() > 60))) {
					outputImage = ImageManagerJAI.thumbnail(outputImage, 60);
				} else if (outputRotate != 0) {
					outputImage = ImageManagerJAI.rotate(outputImage, outputRotate);
				}
		
					
					if ("gif".equals(ext)) {
						resp.setContentType("image/gif");
	
						try {
							ImageManagerJAI.writeResult(os, outputImage, "GIF");
						} catch (IOException ioe) {
							Frame frame = null;
							Graphics g = null;
	
							try {
								frame = new Frame();
								frame.addNotify();
	
								Image image = frame.createImage(60, 60);
								g = image.getGraphics();
	
								g.setFont(new Font("Arial", Font.PLAIN, 10));
								g.drawString("GIF con", 10, 20);
								g.drawString("mas de 256", 3, 30);
								g.drawString("colores", 12, 40);
	
								GifEncoder encoder = new GifEncoder(image, os);
								encoder.encode();
							} finally {
								if (g != null)
									g.dispose();
	
								if (frame != null)
									frame.removeNotify();
							}
						}
					} else {
						resp.setContentType("image/jpeg");
						ImageManagerJAI.writeResult(os, outputImage, "JPEG");
					}
				
		
			}
			catch (RuntimeException e){
				e.printStackTrace();
			} finally {
				if (outputImage!=null)
					outputImage.dispose();
				
				if (fcss!=null)
					fcss.close();
				
				if (bis!=null)
					bis.close();
				
				if (os!=null) {
					os.flush();
					os.close();
				}
				outputImage = null;
				fcss        = null;
				bis         = null;
				os          = null;
			}
		}}	
	
	  public static boolean isImage(String extension){
			
			boolean imagen = false;
			
			ArrayList<String> list = new ArrayList<String>();
				list.add("tif");
				list.add("tiff");
				list.add("jpg");
				list.add("jpeg");
				list.add("bmp");
				list.add("gif");
				list.add("png");
				
			if(list.contains(extension.toLowerCase())){
				imagen = true;
			}
			
			return imagen;
		}
}
