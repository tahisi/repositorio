<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="com.syc.utils.*, com.bbva.visor.extranet.*"%>

<html>
	<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

	<%@ taglib uri="/WEB-INF/tags/imagetagExterno.tld" prefix="image"%>
	<%-- <%@ taglib uri="/WEB-INF/tags/treetagFortimax.tld" prefix="tree"%> --%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
	<link rel="stylesheet" href="../css/imageview.css" type="text/css" />
	<link href="../css/gestion.css" rel="stylesheet">
	<link href="../css/scrolltable.css" rel="stylesheet">
	<link href="../css/fortimax_sistema.css" rel="stylesheet">
	<style>
		html,body,form {
			padding: 0px;
			margin: 0px;
			border: 0px;
		}
		
		html,body {
			overflow: hidden;
		}
		
		div#DivSup {
			margin: 0px;
			border: 0px;
			padding: 0px;
			height: 40px;
			width: 100%;
			position: absolute;
			vertical-align: middle;
			overflow: hidden;
		}
		
		div#imgDiv {
			margin: 0px;
			border: 0px;
			padding: 0px;
			top: 40px;
			position: absolute;
			vertical-align: middle;
			overflow: auto;
			text-align: center;
		}
	</style>
	<title>Documento de imagenes</title>
	<script language="javascript" src="../js/imageview.js"></script>
	<script type="text/javascript" src="../js/jquery-1.2.6.min.js"></script>
	<%
		String operacion      = (String) ((session.getAttribute("operacion") == null) ? "" : session.getAttribute("operacion"));
	
//		FEP Inicio.- Seccion que agrega el boton para obtener las imagenes de forma continua
		String oculto = request.getParameter("oculto");
		session.removeAttribute("oculto");
		if(oculto == null)
			oculto = "no";
		
		String lista = request.getParameter("lista");
		session.removeAttribute("lista");
		if(lista == null)
			lista = "no";
		session.setAttribute("listado",lista);
//		FEP Fin
	
		String strIdx = (String) session.getAttribute(ViewerParametersInterface.SEL_INDEX);
		int selIdx = -1;
		if (strIdx != null)
			selIdx = Integer.parseInt(strIdx);
		

	String select     = request.getParameter("select"); 
			
		String idNodeLiga = request.getParameter("selectliga");
		String aplicacion = request.getParameter("aplicacion");
		
		int outputIndex = -1;
		int outputMaxIndex = 0;
		
		System.out.println("VISUALIZADOR DE IMAGEN  SELECT " + select);
		
		String indexVal = request.getParameter("image.index");
		if (indexVal != null)
			outputIndex = Integer.parseInt(indexVal);
		
		String strMaxIndex = request.getParameter("image.maxidx");
		System.out.println("mage.maxidx" +strMaxIndex ); 
		if (strMaxIndex == null) {
			Documento d = (Documento) session.getAttribute("docs");
			strMaxIndex = Integer.toString(d.getFilesNames().length);
				System.out.println("mage.maxidx" +strMaxIndex ); 
		}
		
		if (strMaxIndex != null)
			outputMaxIndex = Integer.parseInt(strMaxIndex);
		
		String correcionValue = (String) session.getAttribute("correccion");
		boolean correcion = "true".equalsIgnoreCase(correcionValue);
	%>
	<script language="JavaScript">
		document.oncontextmenu=function() { return false; }; //deshabilita boton derecho del mouse
		
		function selectOption() {
			<%if (selIdx != -1) {%>
				var sel = document.getElementById("docSel");
				sel.selectedIndex = <%=selIdx%>
			<%}%>
		}
		
		function getIsInterno(){
			return "<%=false%>";
		}
		
		function getNodeSelect() {
			return "<%=select%>";
		}
		
		function getNodeSelectLigaPadre() {
			return "<%=idNodeLiga%>";
		}
		
		function getNodeSelectStatus() {
			return <%=true%>;
		}
		
		function getPageActual() {
			return "<%=outputIndex%>";
		}
		
		function getPageFinal() {
			return "<%=strMaxIndex%>";
		}
		
		function dimensionaImagen() {
			var objDivImg = document.getElementById("div1");
			var objZoom   = document.getElementById("zoom");
		 	var imgMaxVal = parseInt(document.getElementsByName("totPage")[0].value) - 1;
		 	
		 	<%if (oculto.equals("si")) { %>		
			for(var i = 0; i <= imgMaxVal; i++) {
				if(i == 0)
					var cadena = "imgView";
				else
					var cadena = "imgView" + i;
				var objImagen        = document.getElementById(cadena);			
			 	var relaZoom         = objZoom.value;
				var wImgOriginal     = document.getElementsByName("image.width")[0].value;
		 		var yImgOriginal     = document.getElementsByName("image.height")[0].value;		
				objImagen.width      = parseFloat(wImgOriginal)*relaZoom;
				objImagen.height     = parseFloat(yImgOriginal)*relaZoom;
				objImagen.style.left = 0;
				objImagen.style.top  = 0;
				objDivImg.style.left = 0;
				objDivImg.style.top  = 0;
			}
			<% } else { %>
				var objImagen        = document.getElementById("imgView");
				var relaZoom         = objZoom.value;
				var wImgOriginal     = document.getElementsByName("image.width")[0].value;
		 		var yImgOriginal     = document.getElementsByName("image.height")[0].value;		
				objImagen.width      = parseFloat(wImgOriginal)*relaZoom;
				objImagen.height     = parseFloat(yImgOriginal)*relaZoom;
				objImagen.style.left = 0;
				objImagen.style.top  = 0;
				objDivImg.style.left = 0;
				objDivImg.style.top  = 0;
			<% } %>
		}
		
		function ocultaBotones() {
			<%if (oculto.equals("si")) { %>
				document.getElementById("ir_primero").style.display  = 'none';
				document.getElementById("ir_atras").style.display    = 'none';
				document.getElementById("ventanitas").style.display  = 'none';
				document.getElementById("ir_adelante").style.display = 'none';
				document.getElementById("ir_ultimo").style.display   = 'none';
				document.getElementById("r_izq").style.display       = 'none';
				document.getElementById("r_der").style.display       = 'none';
				document.getElementById("restablecer").style.display = 'none';
				
// 				Botones que se muestran solo en forma de lista
				document.getElementById("zoom_mas").style.display   = 'block';
				document.getElementById("zoom_menos").style.display = 'block';
				document.getElementById("descargarZip").style.display     = 'block';
				document.getElementById("descargarPdf").style.display     = 'block';
				document.getElementById("redimensiona").style.display     = 'block';
			<%} %>
		}
		
		function actualizaDatosImgVisor(rotate) {
           var objImg   = document.getElementById("imgView");
		   if (rotate==0 || rotate==180) {
	           parent.inputViewerFrame.document.getElementById("widthImagen").value  = objImg.width;
	           parent.inputViewerFrame.document.getElementById("heightImagen").value = objImg.height;				   
		   } else {
			   parent.inputViewerFrame.document.getElementById("widthImagen").value  = objImg.height;
	           parent.inputViewerFrame.document.getElementById("heightImagen").value = objImg.width;
		   }
		   parent.inputViewerFrame.document.getElementById("imgIndex").value = <%=outputIndex%>;	           
		}
		
		function mantieneZoom(width,height) {
            var imgWidth  = document.getElementsByName("image.width")[0];
            var imgHeight = document.getElementsByName("image.height")[0];
            var imgMaxVal = parseInt(document.getElementsByName("totPage")[0].value) - 1;
            
            <%if (oculto.equals("si")) { %>		
			for(var i = 0; i <= imgMaxVal; i++) {
				if(i == 0)
					var cadena = "imgView";
				else
					var cadena = "imgView" + i;
				var objImg      = document.getElementById(cadena);		
	            imgWidth.value  = width;
	            imgHeight.value = height;
	            objImg.width    = imgWidth.value;
	            objImg.height   = imgHeight.value;
			}
			<% } else { %>
				var objImg      = document.getElementById("imgView");		
	            imgWidth.value  = width;
	            imgHeight.value = height;
	            objImg.width    = imgWidth.value;
	            objImg.height   = imgHeight.value;
			<% } %> 
		}
		
		$(document).ready(function() {   
			$(window).load(function () {
				$(window).resize();
			});
			$(window).resize(function () {
				var hWindow   = $(window).height();
				var wWindow   = $(window).width();
				var hInferior = hWindow-40;
				$("div#DivSup").css({width:wWindow,top:"5px"});
				$("div#imgDiv").css({width:wWindow-2,height:hInferior,overflow:"auto"});
				
			<% if (outputMaxIndex>0) { %>
				var varWidthImagen  = parent.inputViewerFrame.document.getElementById("widthImagen").value;
				var varHeightImagen = parent.inputViewerFrame.document.getElementById("heightImagen").value;
            	var rotate          = document.getElementsByName("image.rotate")[0].value;
				if((varWidthImagen === 0 || varWidthImagen === "0" || varWidthImagen === "") && (varHeightImagen === 0 || varHeightImagen === "0"|| varHeightImagen === "")) {
					var anchoImgOriginal = parseFloat(document.getElementsByName("image.width")[0].value);
					var anchoPantalla    = parseFloat(document.getElementById("imgDiv").style.width)-20;
					document.getElementById("zoom").value = anchoPantalla/anchoImgOriginal;
					 dimensionaImagen();
				} else if (rotate==0 || rotate==180) {
					mantieneZoom(varWidthImagen,varHeightImagen);
				}
				actualizaDatosImgVisor(rotate);
			<% } %>
			});
			ocultaBotones();
	 	});
	</script>
	</head>
	<body onload="selectOption()">
		<div id="DivSup" align="center">
			<table border="0">
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0">
							<tr>
							<% if ("A".equalsIgnoreCase(operacion)) { %>
								<td id="importar">
								<span class="ic"></span>
									<a class="button" href="javascript:imageManager(2)"><img src="../imagenes/visornew/importar.png" alt="Agregar imagen" width="22" height="22" border="0"></a>
								</td>
							<% }%>
								<td id="ir_primero">
									<a class="button" href="javascript:imageManager(7)"><img src="../imagenes/visornew/ir_primero.png" alt="Primera" width="22" height="22" border="0"></a>
								</td>
								<td id="ir_atras">
									<a class="button" href="javascript:imageManager(8)"><img src="../imagenes/visornew/atras.png" alt="Anterior" width="22" height="22" border="0"></a>
								</td>
								<td id="ventanitas">
									<table cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<span>P&aacute;gina</span>&nbsp;
											</td>
											<td>
												<input name="currPage" type="text" readonly="readonly" value="<%=(outputMaxIndex>0 ? (outputIndex+1) : 0)%>" size="3" maxlength="3">
											</td>
											<td>
												&nbsp;<span>de</span>&nbsp;
											</td>
											<td>
												<input name="totPage" type="text" readonly="readonly" value="<%=outputMaxIndex%>" size="3" maxlength="3">
											</td>
										</tr>
									</table>
								</td>
								<td id="ir_adelante">
									<a class="button" href="javascript:imageManager(9)"><img src="../imagenes/visornew/adelante.png" alt="Siguiente" width="22" height="22" border="0"></a>
								</td>
								<td id="ir_ultimo">
									<a class="button" href="javascript:imageManager(10)"><img src="../imagenes/visornew/ir_ultimo.png" alt="&Uacute;ltima" width="22" height="22" border="0"></a>
								</td>
								<td>&nbsp;</td>
								<td id="zoom_mas">
									<a class="button" href="javascript:imageManager(<%if (oculto.equals("si")) { %>21<% } else { %>11<% } %>)"><img src="../imagenes/visornew/zoom_mas.png" alt="Zoom +" width="22" height="22" border="0"></a>
								</td>
								<td id="zoom_menos">
									<a class="button" href="javascript:imageManager(<%if (oculto.equals("si")) { %>22<% } else { %>12<% } %>)"><img src="../imagenes/visornew/zoom_menos.png" alt="Zoom -" width="22" height="22" border="0"></a>
								</td>
								<td id="r_izq">
									<a class="button" href="javascript:imageManager(13)"><img src="../imagenes/visornew/rotar_izq.png" alt="Rotar Izquierda" width="22" height="22" border="0"></a>
								</td>
								<td id="r_der">
									<a class="button" href="javascript:imageManager(14)"><img src="../imagenes/visornew/rotar_der.png" alt="Rotar derecha" width="22" height="22" border="0"></a>
								</td>
								<td>&nbsp;</td>
								<td id="restablecer">
									<a class="button" href="javascript:imageManager(15)"><img src="../imagenes/visornew/restablecer.png" alt="Restablecer" width="22" height="22" border="0"></a>
								</td>
							<!-- 	<td>&nbsp;</td>
								<td id="descargarZip">
									<a class="button" href="javascript:imageManager(16)"><img src="../imagenes/visornew/descargar_zip.png" alt="Respaldar a Zip en PC" width="22" height="22" border="0"></a>
								</td>
								<td id="descargarPdf">
									<a class="button" href="javascript:imageManager(17)"><img src="../imagenes/visornew/descargar_pdf.png" alt="Respaldar a Pdf en PC" width="22" height="22" border="0" style="top: 3px"></a>
								</td> -->
								<td>&nbsp;</td>
							<!-- 	<td id="redimensiona">
									<a class="button" href="javascript:imageManager(20)"><img src="../imagenes/visornew/redimensiona.png" alt="Ampliaci&oacute;n de pantalla" width="22" height="22" border="0"></a>
								</td> -->
								<%-- <% if ("A".equalsIgnoreCase(operacion)) { %>
								<td id="eliminar">
									<a class="button" href="javascript:imageManager(18)"><img src="../imagenes/visornew/eliminar.png" alt="Eliminar Documento" width="22" height="22" border="0"></a>
								</td>
								<% } %> --%>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id="imgDiv" style="position: absolute; width: 100%; height: 100%; overflow: auto; border: 1px solid #017dfc;">
			<form name="mngPage" id="mngPage" action="VisualizadorDeImagenExterno.jsp?aplicacion=<%=aplicacion%>&select=<%=select%>&image.index=<%=outputIndex%>" method="post">
				<div id="div1" style="top: 0px; left: 0px; width: 100%; height: 100%; position: absolute; overflow: auto;">
				<% if (Integer.parseInt(strMaxIndex)>=0) {
				System.out.println( "ENTRA A ABRIR IMAGEVIEWER EXTERNO"); %>
					<image:imageviewerExterno id="imgView" param="select"  quality="1" aplicacion="<%=aplicacion%>"/>
					<input type="hidden" id="hImagenOriginal" name="hImagenOriginal"/>
					<input type="hidden" id="wImagenOriginal" name="wImagenOriginal"/>
				<% } %>
				</div>
			</form>
			<form name="delPage" id="delPage" target="_self" action="../delpagekeeper?select=<%=select%>&image.index=<%=outputIndex%>" method="post" style="display: none;"></form>
			<form name="disPage" id="disPage" target="_self" action="../imgmng/dispagekeeper" method="post" style="display: none;">
				<input type="hidden" id="srcNode" name="srcNode" value="<%=select%>">
				<input type="hidden" id="srcIdx" name="srcIdx" value="<%=outputIndex%>">
				<input type="hidden" id="selIdx" name="selIdx">
				<input type="hidden" id="docId" name="docId">
				<input type="hidden" id="zoom" name="zoom" value="1"/>
			</form>
			<form name="liberDocu" id="liberDocu" target="_self" action="../imgmng/liberDocument?select=<%=select%>&image.index=<%=outputIndex%>" method="post" style="display: none;"></form>
		</div>
	</body>
	<%	String loadType = request.getParameter("image.load");
		if (loadType != null) { %>
			<script language="javascript">
			<%if ("last".equals(loadType)) { %>
				updateImagesList(parent.listFrame.document.getElementById("paginate"), parseInt(document.getElementsByName("totPage")[0].value) - 1);
			<% } else if ("current".equals(loadType)) {%>
				updateImagesList(parent.listFrame.document.getElementById("paginate"), <%=Integer.parseInt(indexVal)%>);
			<% } %>
			</script>
	<% } %>
</html>