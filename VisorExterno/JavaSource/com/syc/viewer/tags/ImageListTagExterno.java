package com.syc.viewer.tags;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.bbva.visor.extranet.Documento;
import com.syc.utils.ParametersInterface;
import com.syc.utils.ViewerParametersInterface;



public class ImageListTagExterno extends TagSupport implements ViewerParametersInterface {

	public static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ImageListTagExterno.class);

	private String param = null;
	private String paginate = null;
	private int paginateCount = 10;
	private String prefix = null;
	private String aplicacion = null;

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void setParam(String node) {
		this.param = node;
	}

	public String getParam() {
		return param;
	}

	public void setPaginate(String paginate) {
		this.paginate = paginate;
	}

	public String getPaginate() {
		return paginate;
	}

	public void setPaginateCount(int paginateCount) {
		this.paginateCount = paginateCount;
	}

	public int getPaginateCount() {
		return this.paginateCount;
	}

	public String getThumbnailPrefix() {
		return prefix;
	}

	public void setThumbnailPrefix(String prefix) {
		this.prefix = prefix;
	}


	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();

		if (session == null)
			return SKIP_PAGE;

		String selectId = request.getParameter("select");
		String aplicacion= request.getParameter("aplicacion");
		
		System.out.print("IMAGELISTTAGEXTRENO " + selectId +" APLICACION " + aplicacion);
		if (selectId == null) {
			throw new JspException("No se recibio ningun atributo \"param\"");
		}

		int iniPaginate = -1;
		int finPaginate = -1;
		String paginateVal = request.getParameter(getPaginate());
		if (paginateVal != null) {
			iniPaginate = Integer.parseInt(paginateVal.substring(0, paginateVal.indexOf('-')));
			finPaginate = Integer.parseInt(paginateVal.substring(paginateVal.indexOf('-') + 1));
		}

		Documento d = (Documento) session.getAttribute("docs");
		
		if (d == null) {
			throw new JspException("No se encontro el documento con nodo: " + selectId);
		}

		iniPaginate = (iniPaginate == -1)  ? 0 : iniPaginate;
		finPaginate = ((finPaginate == -1) ? ((d.getPaginasDocumento().length > paginateCount) ? paginateCount : d.getPaginasDocumento().length) : finPaginate);
		try {
			if (d.getPaginasDocumento().length > 0) {
				out.println("<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
				
//					FEP Inicio.- Seccion que agrega el boton para obtener las imagenes de forma continua
//					out.println("\t\t\t<tr>");
//					out.println("\t\t\t\t<td align=\"center\">");
//					out.println("\t\t\t\t\t<a name=\"imgList\" href=\"VisualizadorDeImagenExterno.jsp?" + getParam() + "=" + selectId
//							+ "&" + INDEX_KEY + "=" + 0 + "&oculto=si&lista=si\" target=\"viewerFrame\">");
//					out.println("\t\t\t\t\t\t<img src=\"../imagenes/visornew/icono_lista.png?select=" + selectId + "&" + INDEX_KEY + "=" + 0
//							+ "\" alt=\"Ver Imagenes en Lista\" border=\"0\">");
//					out.println("\t\t\t\t\t</a>");
//					out.println("\t\t\t\t</td>");
//					out.println("\t\t\t</tr>");
//					FEP Fin
				System.out.println("INICIO   " + iniPaginate);
				System.out.println("FIN   " + finPaginate);
				for (int i = iniPaginate; i < finPaginate; i++) {
					
					int imgIndex     = i;
					String pagename  = d.getPaginaDocumento(imgIndex).getNb_archivo();
					
					out.println("\t\t\t<tr>");
					out.println("\t\t\t\t<td align=\"center\">");
					String style = (i == 0)? "style=\"border: 2px #333399 solid;\"" : "";
					out.println("\t\t\t\t\t<div id=\"imagen"+i+"\" "+style+">");

					if (imgIndex == iniPaginate)
						out.println("\t\t\t\t\t\t<input type=\"hidden\" name=\"select\" value=\"" + selectId + "\">");
					
				boolean	imagen  = isImage(d.getPaginaDocumento(imgIndex).getNb_extension());
//					if ("A".equalsIgnoreCase(d.getPaginaDocumento(imgIndex).getNb_extension())) {
				if (imagen) {
					
					
					out.println("\t\t\t\t\t\t<a name=\"imgList\" href=\"../imgmngExterno/VisualizadorDeImagenExterno.jsp?aplicacion="+aplicacion +"&"+ getParam() + "=" + selectId + "&" +
							INDEX_KEY + "=" + imgIndex + "\" " + "target=\"viewerFrame\" onClick=imageBorder('imagen"+i+"',"+iniPaginate+","+(finPaginate-1)+");mostrarBotonesDocExterno('" +aplicacion + "','" + imagen+ "','" + imgIndex + "')>");
				out.println("\t\t\t\t\t\t\t<img src=\"" + request.getContextPath() + "/imageStoreExterno?aplicacion="+aplicacion+"&select=" + selectId + "&" + THUMBNAIL_KEY + "=true" + "&" + INDEX_KEY + "=" + imgIndex +
							"\" alt=\"" + pagename + "\" border=\"1\">");
				out.println("\t\t\t\t\t\t</a>");
				out.println("\t\t\t\t\t</div>");
				out.println("\t\t\t\t</td>");
				out.println("\t\t\t</tr>");
					
					} else {
						out.println("\t\t\t\t\t\t<a name=\"imgList\" href=\"" + request.getContextPath() + "/getFileServletFortimaxExterno?aplicacion="+aplicacion+"&" + getParam() + "=" + selectId + "&" + 
								INDEX_KEY + "=" + imgIndex + "\" " + "target=\"viewerFrame\" onClick=imageBorder('imagen"+i+"',"+iniPaginate+","+(finPaginate-1)+");mostrarBotonesDocExterno('" + aplicacion + "','" +imagen + "','" + imgIndex + "')>");
					if (pagename.lastIndexOf(".pdf")!=-1)
						out.println("\t\t\t\t\t\t\t<img src=\"../imagenes/imagetags/Pdf.png\"        alt=\"" + pagename + "\" border=\"1\" width=\"50\" heigth=\"50\">");
					else if (pagename.lastIndexOf(".xls")!=-1 || pagename.lastIndexOf(".xlsx")!=-1)
						out.println("\t\t\t\t\t\t\t<img src=\"../imagenes/imagetags/Excel.png\"      alt=\"" + pagename + "\" border=\"1\" width=\"50\" heigth=\"50\">");
					else if (pagename.lastIndexOf(".ppt")!=-1 || pagename.lastIndexOf(".pptx")!=-1)
						out.println("\t\t\t\t\t\t\t<img src=\"../imagenes/imagetags/PowerPoint.png\" alt=\"" + pagename + "\" border=\"1\" width=\"50\" heigth=\"50\">");
					else if (pagename.lastIndexOf(".doc")!=-1 || pagename.lastIndexOf(".docx")!=-1)
						out.println("\t\t\t\t\t\t\t<img src=\"../imagenes/imagetags/Word.png\"       alt=\"" + pagename + "\" border=\"1\" width=\"50\" heigth=\"50\">");
					else
						out.println("\t\t\t\t\t\t\t<img src=\"../imagenes/imagetags/FileX.png\"      alt=\"" + pagename + "\" border=\"1\" width=\"50\" heigth=\"50\">");
					
					out.println("\t\t\t\t\t\t</a>");
					out.println("\t\t\t\t\t</div>");
					out.println("\t\t\t\t</td>");
					out.println("\t\t\t</tr>");					
					
					
					}
					
				}
			} else {
				out.println("<table align=\"center\" style=\"text-align:center;margin: 0px auto;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
				out.println("\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"60\" height=\"60\">&nbsp;</td>\n\t\t\t\t\t</tr>");
			}
			out.println("\t\t</table>");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return EVAL_PAGE;
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
