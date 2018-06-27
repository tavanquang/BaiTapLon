package com.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public interface FileOut {

	String readFiletoString(File file) throws FileNotFoundException, IOException;
	
	public ByteArrayInputStream Out(InputStream stream, ByteArrayOutputStream outStream) throws FileNotFoundException;


}
