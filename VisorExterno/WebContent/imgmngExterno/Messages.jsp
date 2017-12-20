<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<%boolean isOk = "true".equals(request.getParameter("ok"));
 boolean close = "true".equals(request.getParameter("close"));

if ("true".equals(request.getParameter("applet"))) {
	isOk = "true".equals((String)session.getAttribute("uploadStatus"));

	session.removeAttribute("pageCount");
	session.removeAttribute("uploadStatus");
	session.removeAttribute("docImaxFileAnt");

}

String msg[] = (String[]) session.getAttribute("msg");
String bodyAtt = (String) session.getAttribute("bodyAttributes");
bodyAtt = (bodyAtt == null) ? "" : " " + bodyAtt;
String scrptPrfix[] = (String[]) session.getAttribute("scriptPrefix");
String scrptSufix[] = (String[]) session.getAttribute("scriptSufix"); %>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="expires" content="-1"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mensaje</title>
<link href="../css/fortimax_sistema.css" rel="stylesheet" type="text/css">
<%if (scrptPrfix != null) {%>
<script type="text/javascript">
<%for (int i = 0; i < scrptPrfix.length; i++) { out.println(scrptPrfix[i]); }%>
	</script>
<%}%>
</head>
<body<%=bodyAtt%>>
<p>&nbsp;</p>
<div style="display: block; height: 405px; overflow: auto; width: 100%; margin-top: 0px;" >
<table border="0" align="center" cellpadding="0" cellspacing="0" class="bordes">
	<tr>
		<td>
		<table align="center" width="100%" height="100%" id="texto" >
			<tr>
			<%if (isOk) {%>
				<td class="bordetit"><img src="../imagenes/aceptar.gif" width="36" height="36" hspace="15" align="top"><strong>Mensajes
				Fortimax</strong>&nbsp;&nbsp;&nbsp;</td>
			<%} else {%>
				<td class="bordetit"><img src="../imagenes/cancelar.gif" width="36" height="36" hspace="15" align="top"><strong>Mensajes
				Fortimax</strong>&nbsp;&nbsp;&nbsp;</td>
			<%}%>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
<%if (msg != null) { for (int i = 0; i < msg.length; i++) { if (msg[i] != null) { %>
			<tr>
				<td align="center" <%=isOk ? "" : "class=\"advertencia\""%>><%=msg[i]%></td>
			</tr>
<% } } }%><%if (!isOk && close) {%>
<!--			<tr>-->
<!--				<td align="right"><a href="javascript:window.close()">Cerrar</a></td>-->
<!--			</tr>-->
		<%} else if (!isOk) {%>
			<tr>
				<td align="right"><a href="javascript:history.go(-1)">Regresar</a></td>
			</tr>
		<%}%>
		</table>
		</td>
	</tr>
</table>
</div>
<%if (scrptSufix != null) {%>
<script type="text/javascript">
<%for (int i = 0; i < scrptSufix.length; i++) { out.println(scrptSufix[i]); }%>
	</script>
<%}%>
</body>
</html>
<%	session.removeAttribute("msg");
	session.removeAttribute("bodyAttributes");
	session.removeAttribute("scriptPrefix");
	session.removeAttribute("scriptSufix"); %>