package com.test.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;


public class CreateBase64 {

	
	public static byte[] encodeFileToBase64Binary(File fileName)
			throws IOException {
 
		byte[] bytes = loadFile(fileName);
		byte[] encoded = Base64.encodeBase64(bytes);
		//String encodedString = new String(encoded);
 
		return encoded;
	}
 
	public static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);
 
	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }
 
	    is.close();
	    return bytes;
	}
	
}
