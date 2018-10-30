package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BrdtVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.encrypt.sha.KISA_SHA256;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardServiceInf bs = new BoardService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식으로 login.jsp 에서 보내온 id, password 를 받아둔다
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//id를 이용해 userVo 객체 를 구한다
		UserVo userVo = bs.selectUser(userId);
		String encryptPass = KISA_SHA256.encrypt(password);
		System.out.println("userId" + userVo.getUserId());
		if(userVo.getPass().equals(encryptPass)){
			//왼쪽 메뉴 application 에 설정
			List<BrdtVo> brdtList = bs.selectBoardTypeAll();
			getServletContext().setAttribute("boardTypeList", brdtList);
			
			// 로그인 성공시 메인화면으로 보낸다
			request.getSession().setAttribute("userVo", userVo);
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("/brd/login.jsp");
		}
		
		
	}

}
