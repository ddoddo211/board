package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BrdVo;
import kr.or.ddit.board.model.BrdtVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.RplVo;
import kr.or.ddit.board.model.UserVo;

public interface BoardDaoInf {

	//게시글관련-------------------------------------------------------
		/**
		 * 
		 * Method : selectBoardAll
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brd_brdt
		 * @return
		 * Method 설명 : 게시판 타입을 매개변수로 받아 
		 * board 테이블에서 해당 매개변수를 가지고 있는 모든 게시판 글을 불러오는 메서드
		 */
		public List<BrdVo> selectBoardAll(BrdVo brdVo);
		
		/**
		 * 
		 * Method : selectBoard
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brd_id
		 * @return
		 * Method 설명 : 게시판목록에서 특정 게시글을 클릭했을때 해당 글의 내용을 보기위해
		 * 매개변수로 brd_id 를 받아 BrdVo 객체를 리턴하는 메서드
		 */
		public BrdVo selectBoard(String brd_id);
		
		/**
		 * 
		 * Method : insertBoard
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brdVo
		 * @return
		 * Method 설명 : BrdVo 를 매개변수로 받아 해당 Vo를 Db에 추가하는 메서드
		 */
		public int insertBoard(BrdVo brdVo);
		
		/**
		 * 
		 * Method : insertReplyBoard
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brdVo
		 * @return
		 * Method 설명 : 답글을 작성하는 메서드 insertBoard 와 같지만 brd_pid 부분을 작성한다
		 */
		public int insertReplyBoard(BrdVo brdVo);
		
		
		/**
		 * 
		 * Method : updateBoard
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brdVo
		 * @return
		 * Method 설명 : brdVo 를 매개변수로 받아 해당 db를 수정하는 메서드
		 * 삭제 할때도 사용(db에서 삭제가 아닌 내용을 변경)
		 */
		public int updateBoard(BrdVo brdVo);
		
		//------------------------------------------------------------
		
		//댓글관련-------------------------------------------------------
		/**
		 * 
		 * Method : selectReplyAll
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brd_id
		 * @return
		 * Method 설명 : brd_id 를 매개변수로 받아 해당게시글에 달려있는 모든 댓글을 List 로 리턴하는 메서드
		 */
		public List<RplVo> selectReplyAll(String brd_id);
		
		/**
		 * 
		 * Method : deleteReply
		 * 작성자 : bms
		 * 변경이력 :
		 * @param rplVo
		 * @return
		 * Method 설명 : rplVo 를 매개변수로 받아 해당 덧글을 삭제하는 메서드 (내용이 "삭제된댓글입니다" 로 변경된다)
		 */
		public int deleteReply(RplVo rplVo);

		//------------------------------------------------------------
		
		
		//첨부파일관련-------------------------------------------------------
		/**
		 * 
		 * Method : selectFileAll
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brd_id
		 * @return
		 * Method 설명 : brd_id 를 매개변수로 받아 해당 게시글에 달려있는 첨부파일리스트를 불러오는 메서드
		 */
		public List<FileVo> selectFileAll(String brd_id);
		
		//------------------------------------------------------------
		
		//게시판 타입 관련-------------------------------------------------------
		
		/**
		 * 
		 * Method : selectBoardTypeAll
		 * 작성자 : bms
		 * 변경이력 :
		 * @return
		 * Method 설명 : 존재하는 모든 종류의 게시판 을 불러오는 메서드
		 */
		public List<BrdtVo> selectBoardTypeAll();
		
		/**
		 * 
		 * Method : updateBoardType
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brdtVo
		 * @return
		 * Method 설명 : brdtVo 를 매개변수로 받아 해당 게시판의 정보를 수정하는 메서드(사용여부 변경)
		 */
		public int updateBoardType(BrdtVo brdtVo);
		
		/**
		 * 
		 * Method : insertBoardType
		 * 작성자 : bms
		 * 변경이력 :
		 * @param brdtVo
		 * @return
		 * Method 설명 : 게시판 타입 추가
		 */
		public int insertBoardType(BrdtVo brdtVo);
		
		
		//------------------------------------------------------------
		
		//유저 관련------------------------------------------------------
		/**
		 * 
		 * Method : selectUser
		 * 작성자 : bms
		 * 변경이력 :
		 * @param userId
		 * @return
		 * Method 설명 : 로그인한 유저의 아이디를 매개변수로 받아 해당 유저의 정보를 받아오는 메서드
		 */
		public UserVo selectUser(String userId);

		public int countBoardAll(String brdt_id);

		public int insertReply(RplVo rplVo);

		public int insertFile(FileVo fileVo);

		public int maxBoard();
		

		
		

		
		
		//------------------------------------------------------------
	
}
