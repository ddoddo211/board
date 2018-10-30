package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.BrdVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.RplVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/brdDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf bs = new BoardService();  
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brd_id = request.getParameter("brd_id");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		if(request.getParameter("rpl_text")!=null){
			String rpl_brd = brd_id;
			String rpl_text = request.getParameter("rpl_text");
			String rpl_user = request.getParameter("rpl_user");
			RplVo rplVo = new RplVo();
			rplVo.setRpl_brd(rpl_brd);
			rplVo.setRpl_text(rpl_text);
			rplVo.setRpl_user(rpl_user);
			int check = bs.insertReply(rplVo);
		}
		
		if(request.getParameter("rpl_id")!=null){
			String rpl_id=request.getParameter("rpl_id");
			String rpl_text = "삭제된 댓글입니다";
			String rpl_user = "--";
			RplVo rplVo = new RplVo();
			rplVo.setRpl_id(rpl_id);
			rplVo.setRpl_text(rpl_text);
			rplVo.setRpl_user(rpl_user);
			
			int check = bs.deleteReply(rplVo);
			
		}
		
		BrdVo brdVo = bs.selectBoard(brd_id);
		List<RplVo> rplList = bs.selectReplyAll(brd_id);
		List<FileVo> fileList = bs.selectFileAll(brd_id);
		
		request.setAttribute("rplList",rplList);
		request.setAttribute("fileList",fileList);
		request.setAttribute("brdVo", brdVo);
		request.setAttribute("pageNum", pageNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("brd_id").equals("none")){
			String brd_title = request.getParameter("brd_title");
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			String brd_text = request.getParameter("smarteditor");
			String brd_brdt = request.getParameter("brd_brdt");
			String brd_user = request.getParameter("brd_user");
			System.out.println("detailServlet brd=brdt = " + brd_brdt);
			
			
			
			
			BrdVo brdVo = new BrdVo();
			brdVo.setBrd_title(brd_title);
			brdVo.setBrd_text(brd_text);
			brdVo.setBrd_brdt(brd_brdt);
			brdVo.setBrd_user(brd_user);
			if(request.getParameter("re")!=null){
				if(request.getParameter("re").equals("ply")){
					//insertboard reply
					String brd_pid = request.getParameter("brd_pid");
					String brd_gn = ((BrdVo)bs.selectBoard(brd_pid)).getBrd_gn();
					brdVo.setBrd_pid(brd_pid);
					brdVo.setBrd_gn(brd_gn);
					//insertboard
					int cnt = bs.insertReplyBoard(brdVo);
					
					request.setAttribute("brdVo", brdVo);
					request.setAttribute("pageNum", pageNum);
					
					response.sendRedirect("/brd/brdServlet?brdt_id="+brd_brdt+"&pageNum="+pageNum);
				} 
				
			} else {
				//insertboard
				int cnt = bs.insertBoard(brdVo);
				
				//방금 insert한 board 의 id
				int id = bs.maxBoard();
				String file_brd = "brd"+id;
				
				//가져온 파일이 있을때
				List<FileVo> fileList = new ArrayList<FileVo>();
				
				//첨부파일 넣기
				List<Part> partList = new ArrayList<Part>();
				System.out.println(request.getPart("file_path"));
				if(request.getPart("file_path")!=null){
					partList.add(request.getPart("file_path"));
				}
				for(int i = 1 ; i < 5;i++){
					if(request.getPart("file_path"+i)!=null){
						partList.add(request.getPart("file_path"+i));
					}
					
				}
				String file_path="";
				if(partList!=null){
					for(Part profilePart : partList){
						String sontentDisposition = profilePart.getHeader("Content-disposition");
						System.out.println(profilePart.getHeader("Content-disposition"));
						String fileName="";
						
						int indexFilename = sontentDisposition.indexOf("filename");
						int indexEnd = sontentDisposition.lastIndexOf("\"");
						fileName = sontentDisposition.substring(indexFilename+10,indexEnd);
						file_path = fileName;
						System.out.println("."+file_path+".");
						if(!file_path.equals("")){
							profilePart.write("C:\\A_TeachingMaterial\\6.JspSrpgin\\workspace\\board\\src\\main\\webapp\\"+fileName);
							profilePart.delete();
							FileVo fileVo = new FileVo();
							fileVo.setFile_brd(file_brd);
							fileVo.setFile_path(file_path);
							fileList.add(fileVo);
							
						}
						
					}
					if(!file_path.equals("")){
						for(FileVo fileVo : fileList){
							int cc = bs.insertFile(fileVo);
						}
						
					}
					
				}
				
				
				
				request.setAttribute("brdVo", brdVo);
				request.setAttribute("pageNum", pageNum);
				
				response.sendRedirect("/brd/brdServlet?brdt_id="+brd_brdt+"&pageNum="+pageNum);
				
			}
			
		} else {
			//수정할때 포스트로 진입
			String brd_id = request.getParameter("brd_id");
			String brd_title = request.getParameter("brd_title");
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			String brd_text = request.getParameter("smarteditor");
			
			//수정작업진행
			BrdVo brdVo = new BrdVo();
			brdVo.setBrd_title(brd_title);
			brdVo.setBrd_id(brd_id);
			brdVo.setBrd_text(brd_text);
			brdVo.setBrd_del(1);
			int cnt = bs.updateBoard(brdVo);
			
			//수정된거 다시 불러옴
			brdVo = bs.selectBoard(brd_id);
			request.setAttribute("brdVo", brdVo);
			request.setAttribute("pageNum", pageNum);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	}

}
