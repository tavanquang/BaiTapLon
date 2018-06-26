package com.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public interface FileOut {

	String readFiletoString(File file) throws FileNotFoundException, IOException;
	
	
	void saveFile(String Conten,File file);
	
	public FileInputStream Out(File fileIn,  File fileOut);
	
}
