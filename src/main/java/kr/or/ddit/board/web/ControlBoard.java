package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BrdtVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/controlBoard")
public class ControlBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public BoardServiceInf bs = new BoardService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("brdt_update"));
		if(request.getParameter("brdt_update")!=null){
			System.out.println("brdt_update notnull");
			if(request.getParameter("brdt_update").equals("Y")){
				updateBrdt(request,response);
			} else if(request.getParameter("brdt_update").equals("N")){
				insertBrdt(request,response);
			}
			
		}
		
		//왼쪽 메뉴 목록 application 에 설정
		List<BrdtVo> brdtList = bs.selectBoardTypeAll();
		getServletContext().setAttribute("boardTypeList", brdtList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/controlBoard.jsp");
		rd.forward(request, response);
	}

	private void insertBrdt(HttpServletRequest request,
			HttpServletResponse response) {
		String brdt_name = request.getParameter("brdt_name");
		String userId = request.getParameter("userId");
		BrdtVo brdtVo = new BrdtVo();
		brdtVo.setBrdt_name(brdt_name);
		brdtVo.setBrdt_user(userId);
		int cnt = bs.insertBoardType(brdtVo);
		
	}

	private void updateBrdt(HttpServletRequest request, HttpServletResponse response) {
		String brdt_id = request.getParameter("brdt_id");
		int brdt_useable = Integer.parseInt(request.getParameter("brdt_useable"));
		String brdt_name = request.getParameter("brdt_name");
		System.out.println(brdt_id);
		System.out.println(brdt_name);
		System.out.println(brdt_useable);
		BrdtVo brdtVo = new BrdtVo();
		brdtVo.setBrdt_id(brdt_id);
		brdtVo.setBrdt_name(brdt_name);
		brdtVo.setBrdt_useable(brdt_useable);
		int cnt = bs.updateBoardType(brdtVo);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
