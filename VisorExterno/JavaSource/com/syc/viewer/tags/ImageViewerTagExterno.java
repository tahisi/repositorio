package com.syc.viewer.tags;

import static java.lang.String.format;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.media.jai.RenderedOp;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.bbva.visor.extranet.Documento;
import com.bbva.visor.extranet.PaginaBean;
import com.bbva.visor.extranet.WSVisorDelegate;
import com.bbva.visor.extranet.WSVisorServiceLocator;
import com.sun.media.jai.codec.FileCacheSeekableStream;
import com.sun.xml.messaging.saaj.util.ByteInputStream;

import com.syc.utils.ParametersInterface;
import com.syc.viewer.ImageManagerJAI;


public class ImageViewerTagExterno extends TagSupport implements ParametersInterface {

	public static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ImageViewerTagExterno.class);

	private String id = null;
	private String param = null;
	private float quality = 0.75F;
	private String aplicacion = null;
	

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getParam() {
		return param;
	}

	public void setQuality(String quality) {
		this.quality = Float.parseFloat(quality);
		if ((this.quality < 0.0F) || (this.quality > 1.0F))
			throw new IllegalArgumentException("Calidad \"" + quality + "\" fuera de rango (0.0 - 1.0)");
	}

	public String getQuality() {
		return Float.toString(quality);
	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		
		HttpSession session = request.getSession();
		if (session == null) {
			return SKIP_BODY;
		}
		
		String selectId = request.getParameter(getParam());
		System.out.println("IMAGE VIEWER TAG EXTERNO FOLIO" + selectId );
		if (selectId == null) {
			return SKIP_BODY;
		}
		
		String aplicacion = request.getParameter("aplicacion");
		
		Documento d = (Documento) session.getAttribute("docs");
		if (d == null) {
			return EVAL_PAGE;
		}
		
		int fileIndex = -1;
		String fileIndexVal = request.getParameter(INDEX_KEY);
		if (fileIndexVal == null) {
			return EVAL_PAGE;
		} else
			fileIndex = Integer.parseInt(fileIndexVal);

		try {
//			if (fileIndex>= 0 && !fileIndexVal.equals("-1")){
			PaginaBean p = d.getPaginaDocumento(fileIndex);
			WSVisorServiceLocator client = new WSVisorServiceLocator();
			WSVisorDelegate service =  client.getWSVisorPort();
			byte[] bFile = null;	
			bFile = service.getFiles(p.getCd_folio(), aplicacion);
//			bFile = ArchivingUtils.getBytesFromArchiving(aplicacion, p.getCd_folio());

			
			if (bFile==null || bFile.length<=0) {
				log.error(format("No existe imagen a mostrar en volumen para VisualizadorDeImagenExterno.jsp: %s", bFile));
				return SKIP_BODY;
			}
			
			String fileName         = "vacio";
			String fullPathFileName = "vacio";

			
				ByteInputStream bis          = null;
				FileCacheSeekableStream fcss = null;
				RenderedOp outputImage       = null;
				try {
//					fileName         = p.getNomArchivoOrg();
//					fullPathFileName = p.getNomArchivoVol();
					
					boolean reset 	 	= "true".equals(request.getParameter("reset"));
					int heightSize   	= 0;
					String heightVal 	= reset ? "0" : request.getParameter(HEIGHT_KEY);
					int widthSize    	= 0;
					int outputRotate 	= 0;
					String newFileName 	= "";
					boolean imagen = isImage(p.getNb_extension());
					if(imagen){
						if (heightVal != null) {
							session.setAttribute(HEIGHT_KEY, heightVal);
							heightVal = (String) session.getAttribute(HEIGHT_KEY);
							if (heightVal != null)
								heightSize = Integer.parseInt(heightVal);
						}
						String sizeVal = reset ? "0" : request.getParameter(WIDTH_KEY);
						if (sizeVal != null) {
							session.setAttribute(WIDTH_KEY, sizeVal);
							sizeVal = (String) session.getAttribute(WIDTH_KEY);
							if (sizeVal != null)
								widthSize = Integer.parseInt(sizeVal);
						}
						String rotateVal = reset ? "0" : request.getParameter(ROTATE_KEY);
						if (rotateVal != null) {
							session.setAttribute(ROTATE_KEY, rotateVal);
							rotateVal = (String) session.getAttribute(ROTATE_KEY);
							if (rotateVal != null)
								outputRotate = Integer.parseInt(rotateVal);
						}
						if ("vacio".equals(fullPathFileName)) {
							bis         = new ByteInputStream(bFile, bFile.length);
							fcss        = new FileCacheSeekableStream(bis);
							outputImage = ImageManagerJAI.load(bFile);
							if ((widthSize == 0) && (heightSize == 0)) {
								if ((outputRotate == 90) || (outputRotate == 270)) {
									widthSize = outputImage.getHeight();
									heightSize = outputImage.getWidth();
								} else {
									widthSize = outputImage.getWidth();
									heightSize = outputImage.getHeight();
								}
							} else {
								int tmpSize = widthSize;
								widthSize = heightSize;
								heightSize = tmpSize;
							}
						}
						newFileName = fileName;
						int lastDot = newFileName.lastIndexOf('.');
						if (lastDot > -1)
							newFileName = newFileName.substring(0, lastDot + 1);
						newFileName = newFileName + ((outputRotate == 0) ? "jpg" : outputRotate + ".jpg");
						newFileName = URLEncoder.encode(newFileName, "UTF-8");
						
						out.print("<img id=\"" + getId() + "\" src=\"" + request.getContextPath() + "/imageStoreExterno"
								+ "?aplicacion="+aplicacion + "&" +getParam() + "=" + selectId + "&" + INDEX_KEY + "=" + fileIndex + "\" width=\"" + widthSize
								+ "\" height=\"" + heightSize + "\" alt=\"Tamaño " + widthSize + " x " + heightSize + "\">");
						
						out.print("<input type=\"hidden\" name=\"" + getParam() + "\" value=\"" + selectId + "\">");
						out.print("<input type=\"hidden\" name=\"" + NAME_KEY + "\" value=\"" + fileName + "\">");
						out.print("<input type=\"hidden\" name=\"" + INDEX_KEY + "\" value=\"" + fileIndex + "\">");
						out.print("<input type=\"hidden\" name=\"" + WIDTH_KEY + "\" value=\"" + widthSize + "\">");
						out.print("<input type=\"hidden\" name=\"" + HEIGHT_KEY + "\" value=\"" + heightSize + "\">");
						out.print("<input type=\"hidden\" name=\"" + ROTATE_KEY + "\" value=\"" + outputRotate + "\">");
					}else{
						newFileName = fileName;
						int lastDot = newFileName.lastIndexOf('.');
						if (lastDot > -1)
							newFileName = newFileName.substring(0, lastDot + 1);
						newFileName = newFileName + ((outputRotate == 0) ? "jpg" : outputRotate + ".jpg");
						newFileName = URLEncoder.encode(newFileName, "UTF-8");
						
						out.print("<img id=\"" + getId() + "\" src=\"" + request.getContextPath() + "/imageStoreExterno" 
								+ "?aplicacion="+aplicacion + "&" + getParam() + "=" + selectId + "&" + INDEX_KEY + "=" + fileIndex + "\" width=\"" + widthSize
								+ "\" height=\"" + heightSize + "\" alt=\"Tamaño " + widthSize + " x " + heightSize + "\">");
						
						out.print("<input type=\"hidden\" name=\"" + getParam() + "\" value=\"" + selectId + "\">");
						out.print("<input type=\"hidden\" name=\"" + NAME_KEY + "\" value=\"" + fileName + "\">");
						out.print("<input type=\"hidden\" name=\"" + INDEX_KEY + "\" value=\"" + fileIndex + "\">");
						out.print("<input type=\"hidden\" name=\"" + WIDTH_KEY + "\" value=\"" + widthSize + "\">");
						out.print("<input type=\"hidden\" name=\"" + HEIGHT_KEY + "\" value=\"" + heightSize + "\">");
						out.print("<input type=\"hidden\" name=\"" + ROTATE_KEY + "\" value=\"" + outputRotate + "\">");
					}
					
				} catch (IOException e) {
					log.error("Error general en visor externo", e);
				} finally {
					try {
						if (outputImage!=null)
							outputImage.dispose();
						
						if (fcss!=null)
							fcss.close();
						
						if (bis!=null)
							bis.close();
					} catch (IOException e) {
						log.warn("Problemas al liberar los objetos", e);
					} finally {							
						outputImage = null;
						fcss        = null;
						bis         = null;
					}
				}
			
		} catch (IOException e) {
			log.error(e);
			//e.printStackTrace();
		}catch (Exception e) {
			log.error(e);
			//e.printStackTrace();
		}finally {
			try {
				if (out!=null) 
					out.flush();
			} catch (IOException e) {
				log.warn("Problemas al liberar el JspWriter", e);
			} finally {					
				out = null;
			}
		}
		return EVAL_PAGE;
	}

	/**
	 * Regresa el path de contexto del JSP o Servlet incluyendo la ultima diagonal.
	 */
	public String getContextPath(PageContext pageContext) {
		return getContextPath((HttpServletRequest) pageContext.getRequest());
	}

	/**
	 * Regresa el path de contexto del JSP o Servlet incluyendo la ultima diagonal.
	 */
	public String getContextPath(HttpServletRequest req) {
		String servletPath = req.getServletPath();
		ServletContext servletContext = pageContext.getServletContext();
		String realPath = servletContext.getRealPath(servletPath);
		int lastSlash = realPath.lastIndexOf(System.getProperty("file.separator"));
		if (lastSlash > -1) {
			String contextPath = realPath.substring(0, lastSlash + 1);
			return contextPath;
		}
		return "";
	}
	
	
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
