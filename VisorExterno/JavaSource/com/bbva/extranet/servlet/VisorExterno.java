package com.bbva.extranet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.bbva.visor.extranet.Documento;

import com.bbva.visor.extranet.WSVisorDelegate;
import com.bbva.visor.extranet.WSVisorService;
import com.bbva.visor.extranet.WSVisorServiceLocator;




@WebServlet("/VisorExterno")
public class VisorExterno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			WSVisorServiceLocator client = new WSVisorServiceLocator();
			WSVisorDelegate service =  client.getWSVisorPort();
			HttpSession session      = request.getSession(true);
			String folio = request.getParameter("folio");
			String aplicacion = request.getParameter("aplicacion");
			String[] msg             = null;
			
			Documento docs = service.getDocuments(folio, aplicacion);
			if (docs == null){
				msg = new String[2];
				msg[0] = "<b>ERROR </b>";
				msg[1] = "'ERROR AL CONSULTAR EL DOCUMENTO'";
				session.setAttribute("msg", msg);
				response.sendRedirect("imgmngExterno/Messages.jsp?ok=false&close=true");
				return;
			}

			session.setAttribute("docs", docs);

			response.sendRedirect("imgmngExterno/VisorDeImagenesExterno.jsp?select="+folio+"&aplicacion="+aplicacion);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
