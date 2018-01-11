<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%String idNode ="";
String idNodeLiga=""; %>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body >
<div id="Form">  
  <script>
  function agregar(){
	var totRutas = document.getElementById("totFile").value;
	//alert ("totRutas="+totRutas);
	var puedeEnviar = true;
	var msg = "";
	
	
	if(totRutas!=""){	
		for(var i=0;i<totRutas;i++){
			var varFile = document.getElementById("file"+i).value;
			if(varFile==""){
				msg = "No ha seleccionado una ruta";
				puedeEnviar = false;
				break;
			}else if(varFile.indexOf(".")==-1){
				msg = "Un documento no tiene extension";
				puedeEnviar = false;
				break;
			}
		}
	}else{
		msg = "No ha seleccionado una ruta";
		puedeEnviar = false;
	}	
	
	if(puedeEnviar){
			soloesperar('../imagenes/loadingAnimation.gif');
			document.getElementById("form1").submit();
		
	}else{
		alert(msg);
	}	
}
  </script>

<body onload="" >
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="texto">

	<tr>
		<td colspan="2" align="right">
			<form action="./UploadServlet" name="form1" enctype="multipart/form-data" method="post">
				<div id="divFileUpload" style="overflow: auto; width: 100%; height: 326; border-right: #333399 1px solid; border-top: #333399 1px solid; border-left: #333399 1px solid; border-bottom: #333399 1px solid">
					<table id="tableFile" width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
						<tr>
							<td><input type="file" name="file0" id="file0" size="40" maxlength="256"></td>
						</tr>
					</table>
				</div>
				<table width="100%" cellspacing="0" cellpadding="0" border="0" id="Texto">
					<tr>
					
						<td width="10%"><input type="hidden" id="totFile" value="" size="3" readonly></td>
						<td width="40%">
						 &nbsp;&nbsp; <input type="submit" value="Enviar">
						</td>
					</tr>
				</table>	
			</form>
		</td>
	</tr>
</table>

</body>
</html>
