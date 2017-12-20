<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="com.syc.utils.ParametersInterface, com.bbva.visor.extranet.*"%>
<%@ taglib uri="/WEB-INF/tags/imagetagExterno.tld" prefix="image"%>
<html>
<head>
	<title>Listado de Imagenes</title>
	<meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">
	<meta http-equiv="pragma"        content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires"       content="0">
	<meta http-equiv="keywords"      content="keyword1,keyword2,keyword3">
	<meta http-equiv="description"   content="Expediente">
	<link rel="stylesheet" href="../css/imageview.css" type="text/css"/>
	<link rel="stylesheet" href="../css/gestion.css"   type="text/css"/>
	<script type="text/javascript" src="../js/jquery-1.2.6.min.js"></script>
	<%
	int paginateCount = 10;
		String select = request.getParameter("select");
	String aplicacion	= request.getParameter("aplicacion");
	System.out.println("LISTA DE IMAGENES " + select );
	System.out.println("LISTA DE IMAGENES APLICACION " + aplicacion );
	String paginate   = request.getParameter("paginate");
	String totPaginas = request.getParameter("image.maxidx");

	int start         = (paginate == null) ? 0 : Integer.parseInt(paginate.substring(0, paginate.indexOf("-")));
	int end           = (paginate == null) ? 0 : Integer.parseInt(paginate.substring(paginate.indexOf("-")+1))-1;
	Documento d       = (Documento) session.getAttribute(ParametersInterface.TREE_KEY);

	System.out.println("Informacion, Lista de imagenes externo [select]: "     + select);
	System.out.println("Informacion, Lista de imagenes externo [paginate]: "   + paginate);
	System.out.println("Informacion, Lista de imagenes externo [totPaginas]: " + totPaginas);
	System.out.println("Informacion, Lista de imagenes externo [start]: "      + start);
	System.out.println("Informacion, Lista de imagenes externo [end]: "        + end);
	System.out.println("Informacion, Lista de imagenes externo [d]: "          + d);
	%>
	<style>
		div#DivSupList        {margin:0px;padding:0px;border:0px;position:absolute;vertical-align:middle;text-align:center;height:40px;}
		div#imgDivList        {margin:0px;padding:0px;border:0px;position:absolute;vertical-align:middle;text-align:center;top:40px;overflow:auto;}
	</style>
	<script language="javascript">
// 		FEP
		document.oncontextmenu=function() { return false; }; //deshabilita boton derecho del mouse

	function getIsInterno(){
		return "<%=false%>";
	}

	function getNodeSelect() {
		return "<%=select%>";
	}
	
	function getPageSelect(indexPag) {
		return document.getElementById("indexPaginate").value;
	}
	
	function mostrarBotonesDocExterno(titulo_aplicacion ,tipo_archivo, indexPag){
		if(titulo_aplicacion === "BASTANTEO"){ //Quitar esta validacion cuando se habiliten mas gavetas
			if(tipo_archivo === "A"){
				document.getElementById("indexPaginate").value = indexPag;
				parent.frames[0].document.getElementById("botones").style.display 			= "block";
				parent.frames[0].document.getElementById("brespaldararchivo").style.display = "block";
				parent.frames[0].document.getElementById("beliminar").style.display 	    = "block";
			}else{
				parent.frames[0].document.getElementById("botones").style.display 			= "none";
				parent.frames[0].document.getElementById("brespaldararchivo").style.display = "none";
				parent.frames[0].document.getElementById("beliminar").style.display 		= "none";
			}	
		}
	}

		function chargeFirstPage() {
			var imgIndex = parent.inputViewerFrame.document.getElementById("imgIndex").value;
		<%
			if(d!=null && paginate==null) {
				if(Integer.parseInt(totPaginas)>0 && "pdf".equalsIgnoreCase(d.getPaginaDocumento(0).getNb_extension())) {
			%>
					window.parent.viewerFrame.location.href = '../getFileServletFortimaxExterno?aplicacion=<%=aplicacion%>&select=<%=select%>&image.index='+imgIndex;
			<%  } else { %>
					window.parent.viewerFrame.location.href = '../imgmngExterno/VisualizadorDeImagenExterno.jsp?aplicacion=<%=aplicacion%>&select=<%=select%>&image.index='+imgIndex;
			<%
				}
			}
			%>
			imageBorder(imgIndex, <%=start%>, <%=end%>);
		}

		function imageBorder(imgIndex, iniPaginate, finPaginate) {
// 			alert("index= "+imgIndex+"\niniPaginate= "+iniPaginate+"\nfinPaginate = "+finPaginate);
			if(iniPaginate<finPaginate) {
				for(var i=iniPaginate; i<=finPaginate; i++) {
				    if(i == imgIndex.substring(6)) {
				    	document.getElementById("imagen"+i).style.border = '2px #333399 solid';
				    } else {
						document.getElementById("imagen"+i).style.border = 'none';
					}
				}
			}
			parent.inputViewerFrame.document.getElementById("imgIndex").value = imgIndex;
		}
// 		FEP

		function newPage(type) {
			var objSelect = document.getElementById("paginate");
			var max = objSelect.options.length - 1;
			for (var i = 0; i < objSelect.options.length; i++) {
				if (objSelect.options[i].selected) {
					switch (type) {
						case 0:	// Izq.
							objSelect.value = objSelect.options[(i>0) ? (i-1): 0].value;
							break;
						case 1: // Der.
							objSelect.value = objSelect.options[(i<max) ? (i+1): i].value;
							break;
					}
					document.forms[0].submit();
					break;
				}
			}
		}

		$(document).ready(function(){
			$(window).load(function () {
				$(window).resize();
			});
			$(window).resize(function () {
				var hWindow = $(window).height();
				var wWindow = $(window).width();
				var hInferior = hWindow-40;
				$("div#DivSupList").css({width:wWindow,top:"5px"});
				$("div#imgDivList").css({height:hInferior,width:wWindow,overflow:"auto"});
			});
	  	});
	</script>
	</head>
	<body onload="chargeFirstPage();">
		<form action="ListaDeImagenesExterno.jsp?&aplicacion=<%=aplicacion%>&select=<%=select%>&image.maxidx=<%=totPaginas%>" method="post">
			<div id="DivSupList">
				<table align="center" border="0" cellpadding="0" cellspacing="4" style="text-align:center;margin:0px auto;">
					<tr>
						<td align="center">
							<!-- <a class="button" href="javascript:newPage(0)">
								<img src="../imagenes/visornew/atras.png" alt="Anterior" width="22" height="22" border="0">
							</a> -->
						</td>
						<td valign="top">
						<%
						String strTotPage = request.getParameter("image.maxidx");

						if (strTotPage == null)
							strTotPage = "0";

						int totPages = Integer.parseInt(strTotPage);
						if (totPages > 0) {
							int ini = 0;
							int fin = 0;
							out.println("\t\t\t\t<select id=\"paginate\" name=\"paginate\" onchange=\"submit();\">");
							while ((fin += paginateCount) < totPages) {
								out.println(
									"\t\t\t\t  <option value=\""
									+ ini
									+ "-"
									+ fin
									+ "\""
									+ ((ini == start) ? " selected>" : ">")
									+ (ini + 1)
									+ "-"
									+ fin
									+ "</option>");
								ini = fin;
							}
							if (totPages > 0) {
								out.println(
									"\t\t\t\t  <option value=\""
									+ ini
									+ "-"
									+ totPages
									+ "\""
									+ ((ini == start) ? " selected>" : ">")
									+ (ini + 1)
									+ "-"
									+ totPages
									+ "</option>");
							}
							out.println("\t\t\t\t</select>");
						} else {
							out.println("\t\t\t\t<select>");
							out.println("\t\t\t\t  <option selected>Vacio</option>");
							out.println("\t\t\t\t</select>");
						}
						%>
						</td>
						<td>
							<!-- <a class="button" href="javascript:newPage(1)">
								<img src="../imagenes/visornew/adelante.png" alt="Siguiente" width="22" height="22" border="0">
							</a> -->
						</td>
		 			</tr>
				</table>
			</div>
			<div id="imgDivList">
			<%-- 	<image:imagelist param="select" paginateCount="<%=paginateCount%>" aplicacion="<%=aplicacion %>" paginate="paginate" thumbnailPrefix="_thumbnail"/> --%>
			
		<image:imagelistExterno param="select" paginateCount="<%=paginateCount%>" paginate="paginate" thumbnailPrefix="_thumbnail" aplicacion="<%=aplicacion %>"  /> 
			<%-- <image:imagelistExterno thumbnailPrefix="_thumbnail" aplicacion="<%=aplicacion %>" param="select"/> --%>
			</div>
			<input id="indexPaginate" value="" type="hidden">
		</form>
	</body>
</html>