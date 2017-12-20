<html>
<head>
<title>Fortimax - Barra de Herramientas</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="expires" content="-1"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-store"/>

<link rel="shortcut icon" href="../../favicon.ico"/>
<link href="../css/fortimax_sistema.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/fortimax_sistema.js"></script>
<script type="text/javascript" src="../js/jquery-1.2.6.min.js"></script>
<style type="text/css">
	
</style>
<script type="text/javascript">

	$(document).ready(function() {
		window.setInterval("CambiaFecha()",1000);
	} );
		
	function CambiaFecha() {
		var olblWeekDay = document.getElementById('lblWeekDay');
		var olblDia = document.getElementById('lblDia');
		var olblMes = document.getElementById('lblMes');
		var olblHora = document.getElementById('lblHora');
	
		var Avui = new Date();
		var diaSet = Avui.getDay();
	
		if (diaSet == 0)
			diaSet = "Dom";
		else if (diaSet == 1)
			diaSet = "Lun";
		else if (diaSet == 2)
			diaSet = "Mar";
		else if (diaSet == 3)
			diaSet = "Mi\u00E9";
		else if (diaSet == 4)
			diaSet = "Jue";
		else if (diaSet == 5)
			diaSet = "Vie";
		else
			diaSet = "S\u00E1b";
	
		var diaMes = Avui.getDate();
		var mes = Avui.getMonth() + 1;
	
		if (mes == 1)
			mes = "ENE";
		else if (mes == 2)
			mes = "FEB";
		else if (mes == 3)
			mes = "MAR";
		else if (mes == 4)
			mes = "ABR";
		else if (mes == 5)
			mes = "MAY";
		else if (mes == 6)
			mes = "JUN";
		else if (mes == 7)
			mes = "JUL";
		else if (mes == 8)
			mes = "AGO";
		else if (mes == 9)
			mes = "SEP";
		else if (mes == 10)
			mes = "OCT";
		else if (mes == 11)
			mes = "NOV";
		else
			mes = "DIC";
	
		var any = Avui.getYear();
		if (any < 2000)
			any = any + 1900;
		olblWeekDay.innerHTML = diaSet;
		olblDia.innerHTML = (diaMes > 9 ? diaMes : "0" + diaMes);
		olblMes.innerHTML = mes;
		var iHora = Avui.getHours();
		var iMin = Avui.getMinutes();
		var iSeg = Avui.getSeconds();
		olblHora.innerHTML = (iHora > 9 ? iHora : "0" + iHora) + ":"
				+ (iMin > 9 ? iMin : "0" + iMin) + ":"
				+ (iSeg > 9 ? iSeg : "0" + iSeg);
	}
	
	function funcMuestra(){
		document.getElementById('botones').style.margin='40px';
		document.getElementById('botones').style.align="center";
	}
			
	function funcOculta(){
		document.getElementById('botones').style.margin='66px';
		document.getElementById('botones').style.align="center";	
	}
</script>

</head>
<body> 
	<table  border="0px" cellspacing="0px" cellpadding="0px" width="100%" style="background-image: url(../imagenes/interfaz/i_sistema_fondo_menu.png);">
		<tr>
			<td nowrap="nowrap" width="180px" valign="top" >
				<img src="../imagenes/interfaz/i_sistema_logotipo.png"/>
			</td>
			
			<td nowrap="nowrap" align="left"  valign="top" style="padding-top:30px;FONT-SIZE: 10pt; FONT-WEIGHT: bold; color: White; font-family: Verdana, Arial, Helvetica, sans-serif;padding-left:10px;">
				Bienvenido: Usuario Externo
			</td>
			<td align="center">
				<div id="botones" onmouseover="funcMuestra();" onmouseout="funcOculta();" align="center" style="height:40px; width:100%; margin-top:66px; display: none;">
					<table align="center" cellspacing="0px" cellpadding="0px" border="0px" style="background-image: url(../imagenes/interfaz/i_sistema_fondo_menu3.gif); background-repeat:no-repeat; height:35px; width:160px;">
						<tr align="center">
							<td nowrap="nowrap">
								<img id="brespaldararchivo" src="../imagenes/tituloarriba/b_cargar_web.gif"        title="Respaldar documento en el nivel seleccionado"              style="margin-top:10px;display:none;cursor:pointer;"  onclick="importaDoctoExterno();"/>
							</td>
							<td nowrap="nowrap">
								<img id="beliminar"         src="../imagenes/tituloarriba/b_eliminar.gif"          title="Eliminar contenido de selecci&oacute;n actual"             style="margin-top:10px;display:none;cursor:pointer;" onclick="eliminaDoctoExterno();"/>
							</td >
						  </tr>
					  </table>
				  </div>
			</td>
			
			<td width="55px" valign="top">	
				<div id="divCalendario" style="position:relative;top:0px;">
					<img  id="imgCalendario" src="../imagenes/interfaz/calendario.gif" border="0" alt="calendario" style="position: absolute; top: 0px;"/>
					<span id="lblWeekDay" style="position:absolute;top:9px;left:19px;font-size:8pt;COLOR:gray;"></span>
					<span id="lblDia"     style="position:absolute;top:20px;left:16px;font-size:14pt;"></span>
					<span id="lblMes"     style="position:absolute;top:39px;left:16px;font-size:9pt;font-weight:bold;"></span>
					<span id="lblHora"    style="position:absolute;top:57px;left:2px;font-size:10pt;font-weight:bold;color:white;"></span>
				</div>
			</td>
			<td width="154px" valign="top" style="margin: 0px; padding-top: 0px; border-collapse: collapse; border: 0px;">
				<img src="../imagenes/interfaz/i_sistema_logotipo2.png" align="right"/>
			</td>
		</tr>
	</table>
</body>
</html>