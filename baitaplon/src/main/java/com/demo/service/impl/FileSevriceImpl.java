package com.demo.service.impl;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.openqa.selenium.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.service.FileOut;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;


@Service
@Transactional
public class FileSevriceImpl implements FileOut {

	@Override
	public String readFiletoString(File file)   {
		
		
		FileReader fr;
		String filetostring = "";
		try {
			fr = new FileReader(file);
			// Bước 2: Đọc dữ liệu
			BufferedReader br = new BufferedReader(fr);
			
			while (br.ready()) {
				filetostring += br.readLine();
				filetostring += "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return filetostring;
	}




	
//	public FileInputStream Out(InputStream fileInput,  File fileOut) {
//		 Document document = new Document();
//		 // step 2
//		 PdfWriter writer;
//		try {
//			writer = PdfWriter.getInstance(document,new FileOutputStream(fileOut));
//			 // step 3
//			 document.open();
//			 // step 4
//			 XMLWorkerHelper.getInstance().parseXHtml(writer, document,fileInput);
//			 //step 5
//			 document.close();
//			 
//				 
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 FileInputStream fileInputStream = null;
//		try {
//			fileInputStream = new FileInputStream(fileOut);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	
//	 
//		return fileInputStream;
//	}




	@Override
	public ByteArrayInputStream Out(InputStream Input, ByteArrayOutputStream OutStream) throws FileNotFoundException {
		 Document document = new Document();
		 // step 2
		 PdfWriter writer;
		try {
			writer = PdfWriter.getInstance(document,OutStream);
			 // step 3
			 document.open();
			 // step 4
			 XMLWorkerHelper.getInstance().parseXHtml(writer, document,Input);
			 //step 5
			 document.close();
			 
			 
			
			 ByteArrayInputStream inStream = new ByteArrayInputStream( OutStream.toByteArray());
			 
			 return inStream;
			 
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	
	 
		
	}









	
}
