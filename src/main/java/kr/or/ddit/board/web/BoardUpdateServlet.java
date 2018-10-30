package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BrdVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/brdUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf bs = new BoardService();  
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brd_id = request.getParameter("brd_id");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		BrdVo brdVo = bs.selectBoard(brd_id);
		
		//보낸곳이 update 일때와 delete 일때
		if(request.getParameter("stat").equals("update")){
			
			
			request.setAttribute("brd_brdt", request.getAttribute("brd_brdt"));
			//답글작성일때만 진입
			if(request.getParameter("re")!=null){
				if(request.getParameter("re").equals("ply")){
					brdVo = new BrdVo();
					request.setAttribute("brd_pid", brd_id);
				}
				
			} else {
				request.setAttribute("brdVo", brdVo);
				
			}
			request.setAttribute("pageNum", pageNum);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardUpdate.jsp");
			rd.forward(request, response);
			
		} else if(request.getParameter("stat").equals("delete")){
			//삭제시 작업
			brdVo.setBrd_del(2); // 삭제시 2
			brdVo.setBrd_title("삭제된 게시글입니다");
			int cnt = bs.updateBoard(brdVo);
			
			//후에 리스트 가기전 작업
			System.out.println("delete 파트에서 id:" + brdVo.getBrd_brdt());
			request.setAttribute("brdt_id", brdVo.getBrd_brdt());
			request.setAttribute("pageNum", pageNum);
			
			//리스트로 이동
			response.sendRedirect("/brd/brdServlet?brdt_id="+brdVo.getBrd_brdt()+"&pageNum="+pageNum);
//			RequestDispatcher rd = request.getRequestDispatcher("/brdServlet");
//			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
