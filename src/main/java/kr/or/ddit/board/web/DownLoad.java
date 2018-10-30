package kr.or.ddit.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dl")
public class DownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 진입");
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fileName = request.getParameter("file_name"); //get으로 들어온 인자 받기
	        String sDownloadPath = "C:\\A_TeachingMaterial\\6.JspSrpgin\\workspace\\board\\src\\main\\webapp\\";
	        String sFilePath = sDownloadPath + fileName;
	        
	        byte b[] = new byte[4096];
	        FileInputStream fileInputStream = new FileInputStream(sFilePath);
	        
	        String sMimeType = getServletContext().getMimeType(sFilePath);
	        
	        if(sMimeType == null) sMimeType = "application/octet-stream";
	        
	        response.setContentType(sMimeType);
	        
	        //한글업로드
	        String sEncoding = new String(fileName.getBytes("euc-kr"),"8859_1");
	        response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
	        
	        ServletOutputStream servletOutStream = response.getOutputStream();
	        
	        int numRead;
	        while((numRead = fileInputStream.read(b,0,b.length))!= -1){
	            servletOutStream.write(b,0,numRead);            
	        }
	        
	        servletOutStream.flush();
	        servletOutStream.close();
	        fileInputStream.close();


				
	}

}
