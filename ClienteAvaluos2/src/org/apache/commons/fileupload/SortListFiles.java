package org.apache.commons.fileupload;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItem;

public class SortListFiles {
	public List LisFilesSorter(List unsortedList){
	List sorted= new ArrayList();
	List fileNames = new ArrayList();
	Iterator i = unsortedList.iterator();
		while (i.hasNext()) {//Para obener y meter todos los nombre de los archivos en un arreglo de Strings.
			FileItem item = (FileItem) i.next();
		   if (item.getName()!=null){
			 fileNames.add((item.getName()));//Obtiene el nombre de los items Archivo que vienen
		   }
		}
		
   //Ya obtenido el arreglo lo sorteamos con el comparador;
     /*******************Si existen 2 o mas elementos***********************************************/
		if (fileNames.size()>1){
			try{
				Collections.sort(fileNames, String.CASE_INSENSITIVE_ORDER); //segun con esto la lo sorteamos
			}catch(Exception e){
				e.printStackTrace();
		
			}
	
			Iterator k =fileNames.iterator();
			//Con este viene lo bueno, usamos tres listas una con los nombre ordenados, la que nos viene de parametro y la que va a ser para meter los archivos
			
			while (k.hasNext()) {//Para obener y meter todos los nombre de los archivos en un arreglo de Strings.
				String tmpFile = (String) k.next();	
				//System.out.print("\n"+tmpFile +"\n\n");
			
				Iterator j = unsortedList.iterator();
				while (j.hasNext()){
					FileItem item2 = (FileItem) j.next();
					//System.out.print(tmpFile+"  "+item2.getName() +"\n");
		    		       
			           if (tmpFile.equals(item2.getName())){//Verifica el nombre del archivo se igual al del item
			    	   sorted.add(item2);
			    	   break;
			    	   }//Lo mete en cuyo caso
			       }
		}
		}else {
			sorted=unsortedList;
			
		}	
		/*************************************************************/	
		System.out.print(sorted);
		return sorted; 
	}
}
