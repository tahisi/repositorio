<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function Iniciar(){
	document.forms.frmPrincipal.action ="./principal"; 
		document.forms.frmPrincipal.submit();
	}
	</script>
</head>
<body>
 <input type="button" value="INICIAR PROCESO"  onclick="Iniciar();">
   <form id="frmPrincipal" name="frmPrincipal" method="post">
	</form>
</body>
</html>
