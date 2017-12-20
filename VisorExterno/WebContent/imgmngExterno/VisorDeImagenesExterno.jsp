<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Visor De Imagenes</title>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="expires" content="-1"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="com.syc.utils.*, com.bbva.visor.extranet.*"%>
<%	
	session.removeAttribute(ParametersInterface.TREE_KEY);
	
	String treeNodeId     = request.getParameter("select");
/* 	String treeNodeLigaId = request.getParameter("selectliga");	 */
	String idxVal         = request.getParameter(ParametersInterface.INDEX_KEY);
	boolean isDel         = "true".equals(request.getParameter(ParametersInterface.DELETE_KEY));
	String aplicacion 	  = request.getParameter("aplicacion");
	System.out.println("Información, Visor de imagenes [aplicacion]:" + aplicacion);
	System.out.println("Información, Visor de imagenes [idxVal]:" + idxVal);
	System.out.println("Información, Visor de imagenes [isDel]:" + isDel);
	System.out.println("Información, Visor de imagenes [treeNodeId]:" + treeNodeId);

	Documento d = (Documento) session.getAttribute("docs");
	//session.setAttribute("doc", d);
	StringBuffer queryString = new StringBuffer();
	queryString.append("?select=" + treeNodeId);
	queryString.append("&aplicacion=" + aplicacion);
	/* queryString.append("&aplicacion=" + d.getCd_aplicacion());
	queryString.append("&idGabinetePadre=" + d.getCd_expediente()); */
	
	if ((idxVal != null) && !isDel)
		queryString.append(
			"&"
				+ ParametersInterface.LOAD_KEY
				+ "=last&"
				+ ParametersInterface.INDEX_KEY
				+ "="
				+ Integer.parseInt(idxVal));
	else if ((idxVal != null) && isDel)
		queryString.append("&" + ParametersInterface.LOAD_KEY + "=current&image.index=" + Integer.parseInt(idxVal));
	else{
	System.out.println("FILE NAMES" +   d.getFilesNames()  );
	queryString.append("&" + ParametersInterface.INDEX_KEY + "=" + ((d.getFilesNames().length > 0) ? "0" : "-1")); 
	}
		
	session.setAttribute(ParametersInterface.TREE_KEY, d);
	
%>
	<script language="javascript">
			openThumbail=1;
			function redimensiona() {
				var fraSet = document.getElementById("viewerFrameSet");
				if (openThumbail==1){
					fraSet.cols = "0%,0%,100%,0%";
					openThumbail=0;
				} else {
			 		fraSet.cols = "0%,12%,78%,10%";
					openThumbail=1;
				}
			}
	
			function setViewFrame(link) {
				document.getElementById('viewerFrame').src = link;
			}
	</script>
</head>
	<frameset id="viewerFrameSet" rows="*" cols="0%,80%,10%" framespacing="0" frameborder="no" border="1">
	 <frame name="inputViewerFrame" src="inputVisualizadorDeImagenExterno.jsp<%=queryString.toString()%>" scrolling="no" noresize>
		<frame name="viewerFrame"      src="VisualizadorDeImagenExterno.jsp<%=queryString.toString()%>" scrolling="no" noresize>
		<frame name="listFrame"        src="ListaDeImagenesExterno.jsp?aplicacion=<%=aplicacion%>&select=<%=treeNodeId%>&image.maxidx=<%=((d.getFilesNames().length > 0) ? Integer.toString(d.getFilesNames().length) : "-1")%>" scrolling="no" noresize>
	</frameset>
<!-- </frameset> -->
<noframes>
<body>
Su Browser no soprta &lt;frames&gt;
</body>
</noframes>
</html>