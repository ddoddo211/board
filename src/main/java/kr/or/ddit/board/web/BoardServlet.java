package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BrdVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/brdServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardServiceInf bs = new BoardService();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//어떤 게시판을 클릭했는지 확인
		String brd_brdt = request.getParameter("brdt_id");
		System.out.println("brd_brdt : "+brd_brdt);
		//전체 갯수 불러옴
		int totalCnt = bs.countBoardAll(brd_brdt);
		//set attibute
		request.setAttribute("totalCnt", totalCnt);
		
		//현재 페이지 불러옴
		int pageNum;
		//불러온 페이지값이 없다면 1로 초기화
		if(request.getParameter("pageNum")==null){
			pageNum = 1;
		} else {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
	
		
		//해당되는 게시판 데이터 전체 불러옴
		//불러오기위해 게시판 객체 생성
		BrdVo brdVo = new BrdVo();
		brdVo.setBrd_pageSize(10); // 보여줄 갯수총량
		brdVo.setBrd_brdt(brd_brdt); // 원하는 게시판 타입
		if(totalCnt/brdVo.getBrd_pageSize()!=0){
			if(pageNum<1){
				pageNum=1;
			} else if (pageNum>totalCnt/brdVo.getBrd_pageSize()) {
				pageNum=totalCnt/brdVo.getBrd_pageSize()+1;
			}
			
		}
		
		if(pageNum<1){
			pageNum=1;
		}
		
		brdVo.setBrd_page(pageNum); // 원하는 페이지
		//생성한 객체를 이용해서 리스트를 불러온다
		List<BrdVo> boardList = bs.selectBoardAll(brdVo);
		request.setAttribute("boardList", boardList);
		request.setAttribute("brdVo", brdVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//어떤 게시판을 클릭했는지 확인
				String brd_brdt = request.getParameter("brdt_id");
				System.out.println("brd_brdt : "+brd_brdt);
				//전체 갯수 불러옴
				int totalCnt = bs.countBoardAll(brd_brdt);
				//set attibute
				request.setAttribute("totalCnt", totalCnt);
				
				//현재 페이지 불러옴
				int pageNum;
				//불러온 페이지값이 없다면 1로 초기화
				if(request.getParameter("pageNum")==null){
					pageNum = 1;
				} else {
					pageNum = Integer.parseInt(request.getParameter("pageNum"));
				}
				
			
				
				//해당되는 게시판 데이터 전체 불러옴
				//불러오기위해 게시판 객체 생성
				BrdVo brdVo = new BrdVo();
				brdVo.setBrd_pageSize(10); // 보여줄 갯수총량
				brdVo.setBrd_brdt(brd_brdt); // 원하는 게시판 타입
				if(totalCnt/brdVo.getBrd_pageSize()!=0){
					if(pageNum<1){
						pageNum=1;
					} else if (pageNum>totalCnt/brdVo.getBrd_pageSize()) {
						pageNum=totalCnt/brdVo.getBrd_pageSize()+1;
					}
					
				}
				
				if(pageNum<1){
					pageNum=1;
				}
				
				brdVo.setBrd_page(pageNum); // 원하는 페이지
				//생성한 객체를 이용해서 리스트를 불러온다
				List<BrdVo> boardList = bs.selectBoardAll(brdVo);
				request.setAttribute("boardList", boardList);
				request.setAttribute("brdVo", brdVo);
				
				RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
				rd.forward(request, response);
	}

}
