var print = false;
var edo = true;

function imageManager(type) {
 var inc = 1.5;
 var max_inc = 4500;
 var min_inc = 1;
 var imgWidth = document.getElementsByName("image.width")[0];
 var imgHeight = document.getElementsByName("image.height")[0];
 var rotate = document.getElementsByName("image.rotate")[0];
 var imgIndex = document.getElementsByName("image.index")[0];

 var imgList = parent.listFrame.document.getElementById("paginate");
 var href = window.location.href;
 var imgMaxVal = parseInt(document.getElementsByName("totPage")[0].value) - 1;
 var idxPosIni = href.lastIndexOf("=") + 1;
 var indexVal;
 indexVal  = (imgIndex == undefined ? indexVal : parseInt(imgIndex.value));
// var indexVal;
 var anchoVisor, altoVisor;
//alerta
	if ((indexVal < 0) && (type > 2))
			return;

	switch (type) {
		case 1: // Escanear
		 	var select = top.main.viewerFrame.getNodeSelect();
			openCenteredWindow("PageDocumentScan.jsp?select=" + select, "_blank", 520, 771);
			break;
		case 2: // Importar Imagen
			 var select     = getNodeSelect();
			 var selectliga = getNodeSelectLigaPadre();
			 var status     = getNodeSelectStatus();
			 var isInterno  = getIsInterno();
			 if (!status &&  selectliga!=null){
			 	alert("No es posible importar fotos al documento para mantener la integridad del expediente.\nDebido a que el estatus notificado por HOST es <no activo> para esta verificación.");
			 } else if(isInterno == "true"){
				openCenteredWindow("PageDocumentUpload.jsp?select=" + select + "&selectliga=" + selectliga, "_blank", 450, 479);
			 } else{ 
			 	openCenteredWindow("PageDocumentUploadExterno.jsp?select=" + select + "&selectliga=" + selectliga, "_blank", 450, 479);
			 }
			break;
		case 3: // Exportar Imagen
			break;
		case 4: // Exportar Imagen (todas)
			break;
		case 5: // Guardar
			break;
		case 6: // Imprimr
			/*if (navigator.appVersion.indexOf("MSIE") != -1) {
				print = true;
				window.print();
			}*/
			/* Lineas originales
			 var select = top.main.viewerFrame.getNodeSelect();	
			 var page_actual = top.main.viewerFrame.getPageActual();
			openCenteredWindow("PageDocumentPrint.jsp?select=" + select +"&page_actual=" + page_actual, "_blank", 1,1);
			*/
			var select = top.main.viewerFrame.getNodeSelect();
			var page_actual = top.main.viewerFrame.getPageActual();
			openCenteredWindow("PageDocumentPrint.jsp?select=" + select +"&page_actual=" + indexVal, "_blank", 15,300);
			break;
		case 7: // Primera
			imgWidth.value = 0;
			imgHeight.value = 0;
			rotate.value = 0;
			imgIndex.value = "0";
			href = href.substring(0, idxPosIni) + "0";
			window.location.href = href;
			updateImagesList(imgList, 0);
			break;
		case 8: // Anterior
			imgWidth.value = 0;
			imgHeight.value = 0;
			rotate.value = 0;
			outIndex = ((indexVal - 1) < 0)? 0: indexVal - 1;
			href = href.substring(0, idxPosIni) + outIndex;
			imgIndex.value = outIndex;
			if (outIndex != indexVal) {
				window.location.href = href;
				updateImagesList(imgList, outIndex);
			}
			break;
		case 9: // Siguiente
			imgWidth.value = 0;
			imgHeight.value = 0;
			rotate.value = 0;
			outIndex = ((indexVal + 1) > imgMaxVal)? imgMaxVal: indexVal + 1;
			href = href.substring(0, idxPosIni) + outIndex;
			imgIndex.value = outIndex;
			if (outIndex != indexVal) {
				window.location.href = href;
				updateImagesList(imgList, outIndex);
			}
			break;
		case 10: // Ultima
			imgWidth.value = 0;
			imgHeight.value = 0;
			rotate.value = 0;
			href = href.substring(0, idxPosIni) + imgMaxVal;
			window.location.href = href;
			imgIndex.value = imgMaxVal;
			updateImagesList(imgList, imgMaxVal);
			break;
		case 11: // Zoom +
			var objImg = document.getElementById("imgView");
			var currWidth = parseInt(objImg.width);
			var currHeight = parseInt(objImg.height);
			imgWidth.value = (parseInt(currWidth * inc) > max_inc) ? currWidth: parseInt(currWidth * inc);
			imgHeight.value = parseInt((parseInt(imgWidth.value) * currHeight) / currWidth);
			objImg.width = imgWidth.value;
			objImg.height = imgHeight.value;
			objImg.alt = "Tamaño : " + imgWidth.value + " x " + imgHeight.value;
			actualizaDatosImgVisor(parseInt(rotate.value));
			break;
		case 12: // Zoom -
			var objImg = document.getElementById("imgView");
			var currWidth = parseInt(objImg.width);
			var currHeight = parseInt(objImg.height);
			imgWidth.value = (parseInt(currWidth / inc) < min_inc) ? min_inc: parseInt(currWidth / inc);
			imgHeight.value = parseInt((parseInt(imgWidth.value) * currHeight) / currWidth);
			objImg.width = imgWidth.value;
			objImg.height = imgHeight.value;
			objImg.alt = "Tamaño : " + imgWidth.value + " x " + imgHeight.value;
			actualizaDatosImgVisor(parseInt(rotate.value));
			break;
		case 13: // Rotar Der.
			rotate.value = (((parseInt(rotate.value) - 90) < 0) ? 270 : parseInt(rotate.value) - 90);
			document.getElementById("mngPage").submit();
			break;
		case 14: // Rotar Izq.
			rotate.value = (((parseInt(rotate.value) + 90) > 270) ? 0 : parseInt(rotate.value) + 90);
			document.getElementById("mngPage").submit();
			break;
		case 15: // Restablecer
		    parent.inputViewerFrame.document.getElementById("widthImagen").value  = 0;
		    parent.inputViewerFrame.document.getElementById("heightImagen").value = 0;
			imgWidth.value  = 0;
			imgHeight.value = 0;
			rotate.value    = 0.0;
			document.getElementById("mngPage").submit();
			break;
		case 16:
			if (confirm(" Desea descargar en ZIP el documento?")) {
				var select = getNodeSelect();
				window.location.href = "../GetFormatFileServlet?selectId=" + select +"&formato=zip&token=sin";
			}
			
			break;
		case 17:
			if (confirm(" Desea descargar en PDF el documento?")) {
				var select = getNodeSelect();
				window.location.href = "../GetFormatFileServlet?selectId=" + select +"&formato=pdf&token=sin";
			}			
			break;
		case 18: // Eliminar
			if (confirm("Desea eliminar la pagina actual?")) {
//				var select = top.main.viewerFrame.getNodeSelect();
				var select = getNodeSelect();
				var isInterno  = getIsInterno();
				if(isInterno == "true"){
//					openCenteredWindow("../delpagekeeper?select=" + select + "&image.index=" + indexVal, "_blank", 450, 479);
					window.location.href = "../delpagekeeper?select=" + select + "&image.index=" + indexVal;
				}else{
//					openCenteredWindow("../delpagekeeperexterno?select=" + select + "&image.index=" + indexVal, "_blank", 450, 479);
					location.href = "../delpagekeeperexterno?select=" + select + "&image.index=" + indexVal;
				}
			}
			break;
		case 19:
			document.getElementById("tblNota").style.display = (edo)?"":"none";
			document.getElementById("divNota").style.display = (edo)?"":"block";
			document.getElementById("imgDiv").style.display = (edo)?"none":"";
			edo = !edo;
			
			outIndex = ((indexVal - 1) < 0)? 0: indexVal - 1;
			imgIndex.value = outIndex;
			break;
		case 20:
			parent.redimensiona();
			break;
		case 21 : // ZoomLista +
			var numeroAgrandamiento = 1.2;
			var zoom = parseFloat(document.getElementById("zoom").value);
			document.getElementById("zoom").value = (zoom * numeroAgrandamiento);
			zoom = (zoom * numeroAgrandamiento);
			
			for(var i = 0; i <= imgMaxVal; i++) {
				var objDivImg = document.getElementById("div1");
				if(i==0)
					var cadena = "imgView";
				else
					var cadena = "imgView" + i;
				var objImg = document.getElementById(cadena);
				var nuevoOrigenX = parseFloat(objDivImg.style.left);
				var nuevoOrigenY = parseFloat(objDivImg.style.top);
				var wImgOriginal =document.getElementsByName("image.width")[0].value ;
				var yImgOriginal =document.getElementsByName("image.height")[0].value ;
				/*Se multiplica por el factor de agrandamiento*/
				objImg.width = eval(wImgOriginal + '*' + zoom);
				objImg.height = eval(yImgOriginal + '*' + zoom);
				/*Se traslada al punto cero (Se mueve el div1 por que div1 = imgView en alto y ancho)*/
				nuevoOrigenX = nuevoOrigenX * numeroAgrandamiento ;
				nuevoOrigenY = nuevoOrigenY * numeroAgrandamiento ;
				objDivImg.style.left = nuevoOrigenX +"px";
				objDivImg.style.top  = nuevoOrigenY +"px";
				document.getElementById('imgDiv').scrollTop = 0;				
				if(objImg.width <= anchoVisor){
					objDivImg.style.left = 0;		
				}
				if(objImg.height <= altoVisor){
					objDivImg.style.top = 0;		
				}
			}
			actualizaDatosImgVisor(parseInt(rotate.value));
			break;
		case 22 : // ZoomLista -
			var numeroAgrandamiento = 0.8;
			var zoom = parseFloat(document.getElementById("zoom").value);
			document.getElementById("zoom").value = (zoom * numeroAgrandamiento);
			zoom = (zoom * numeroAgrandamiento);
			
			for(var i = 0; i <= imgMaxVal; i++){
				var objDivImg = document.getElementById("div1");
				if(i==0)
					var cadena = "imgView";
				else
					var cadena = "imgView" + i;
				var objImg = document.getElementById(cadena);
				
				var nuevoOrigenX = parseFloat(objDivImg.style.left);
				var nuevoOrigenY = parseFloat(objDivImg.style.top);
				var img_w = "image.width" + i;
				var img_h = "image.height" + i;
				var wImgOriginal =document.getElementsByName("image.width")[0].value ;
				var yImgOriginal =document.getElementsByName("image.height")[0].value ;
				
				/*Se multiplica por el factor de agrandamiento*/
				objImg.width = eval(wImgOriginal + '*' + zoom);
				objImg.height = eval(yImgOriginal + '*' + zoom);
				/*Se traslada al punto cero (Se mueve el div1 por que div1 = imgView en alto y ancho)*/
				nuevoOrigenX = nuevoOrigenX * numeroAgrandamiento ;
				nuevoOrigenY = nuevoOrigenY * numeroAgrandamiento ;
				objDivImg.style.left = nuevoOrigenX +"px";
				objDivImg.style.top  = nuevoOrigenY +"px";
				document.getElementById('imgDiv').scrollTop = 0;				
				if(objImg.width <= anchoVisor){
					objDivImg.style.left = 0;		
				}
				if(objImg.height <= altoVisor){
					objDivImg.style.top = 0;		
				}
			}
			actualizaDatosImgVisor(parseInt(rotate.value));
			break;
	}
}

function updateImagesList(imgSelect, currIdx) {
	if (imgSelect) {
		for (i = 0; i < imgSelect.length; i++) {
			pos = imgSelect.options[i].value.indexOf('-');
			imgIni = parseInt(imgSelect.options[i].value.substring(0, pos));
			imgFin = parseInt(imgSelect.options[i].value.substring(pos + 1)) - 1;
			if ((currIdx >= imgIni) && (currIdx <= imgFin) && !imgSelect.options[i].selected) {
				imgSelect.value = imgSelect.options[i].value;
				parent.listFrame.document.forms[0].submit();
				break;
			} else if ((currIdx >= imgIni) && (currIdx <= imgFin) && imgSelect.options[i].selected) {
				imageBorder(currIdx, imgIni, imgFin);
			}
		}
	}
}

function getImageIndex(list) {
 var currName = document.getElementsByName("image.name")[0];

	if (currName) {
		for (var i = 0; i < list.length; i++) {
			var name = list[i].href.substring(list[i].href.indexOf("=") + 1, list[i].href.indexOf("&"));
			if (name == currName.value)
				return i;
		}
	}

	return -1;
}

function getPagesNumber() {
 var currPage = document.getElementsByName("currPage")[0];
 var totPage = document.getElementsByName("totPage")[0];
 var list = parent.listFrame.document.getElementsByName("imgList");

	if (document.getElementsByName("image.name")) {
		var i = getImageIndex(list);
		currPage.value = i + 1;
		totPage.value = list.length;
	} else {
		currPage.value = 0;
		totPage.value = list.length;
	}
}

function resizeImageViewer() {
var images = document.getElementById("imgDiv");
var notas  = document.getElementById("divNota");

	if (navigator.appName.indexOf("Microsoft") != -1) {
		width = (document.body.clientWidth - document.body.leftMargin) - 1;
		if (print)
			height = "90%";
		else
			height = document.body.clientHeight - 101;//42;
		print = false;
	} else {
		width = window.innerWidth - 2;
		height = window.innerHeight - 40;
	}

	images.style.width = width;
	images.style.height = height;
	
	notas.style.width = width;
	notas.style.height = height;
	window.scroll(0,0);
}

function openCenteredWindow( url, name, height, width, parms )

{
 var left = Math.floor( (screen.width - width) / 2);
 var top = Math.floor( (screen.height - height) / 2);
 var winParms = "top=" + top + ",left=" + left + ",height=" + height + ",width=" + width + ",scrollbar=yes,status=yes";

	if (parms) { winParms += "," + parms; }
	var win = window.open(url, name, winParms);
	if (parseInt(navigator.appVersion) >= 4) { win.window.focus(); }
	return win;
}

function validityLength(theField, length)
{	var retval = true;
	if (window.event.keyCode == 13) { return false; }
	if (theField.value.length >= length)
	{	if ((window.event.keyCode != 8) &&
		   (window.event.keyCode != 37) &&
		   (window.event.keyCode != 38) &&
		   (window.event.keyCode != 39) &&
		   (window.event.keyCode != 40) &&
		   (window.event.keyCode != 46))
		{	theField.value = theField.value.substring(0, length);
			alert("Se alcanzo la longitud máxima de " + length + ".");
			retval = false;
		}
	}
	return retval;
}
// FEP
function imageBorder(index, iniPaginate, finPaginate) {
//	alert("indice = "+index+" iniPaginate = "+iniPaginate+" iniPaginateNuevo = "+index.substring(0,1)+"0"+" finPaginateeeee = "+finPaginate);
	if(iniPaginate<finPaginate) {
		for(i=iniPaginate; i<=finPaginate; i++) {
	    	if(i == index) {
	    		parent.listFrame.document.getElementById("imagen"+i).style.border = '2px #333399 solid';
	    	} else {
				parent.listFrame.document.getElementById("imagen"+i).style.border = 'none';
			}
		}
	}
	return;
}
// FEP