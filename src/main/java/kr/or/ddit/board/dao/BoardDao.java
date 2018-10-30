package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BrdVo;
import kr.or.ddit.board.model.BrdtVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.RplVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.dao.Builder;

public class BoardDao implements BoardDaoInf {

	@Override
	public List<BrdVo> selectBoardAll(BrdVo brdVo) {
		//매개변수로 받는 brdVo 에는 게시판의 종류와, 페이지번호, 페이지사이즈가 들어가야한다
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		System.out.println("dao brd_brdt : "+brdVo.getBrd_brdt());
		System.out.println("dao brd_page : "+brdVo.getBrd_page());
		System.out.println("dao brd_pagesize : "+brdVo.getBrd_pageSize());
		List<BrdVo> boardList = session.selectList("board.selectBoardAll",brdVo);
		session.close();
		return boardList;
	}

	@Override
	public BrdVo selectBoard(String brd_id) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		BrdVo brdVo = session.selectOne("board.selectBoard",brd_id);
		session.close();
		return brdVo;
	}

	@Override
	public int insertBoard(BrdVo brdVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//brd_gn 은 자동으로 SEQ 처리되고, brd_pid  는 null 이여야 한다
		int cnt = session.insert("board.insertBoard", brdVo);
		session.commit();
		session.close();
		return cnt;
	}
	
	@Override
	public int insertReplyBoard(BrdVo brdVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//brd_gn 은 부모의 gn 과 같은 값이여야 하며, brd_pid 는 부모의 id를 입력해야 한다
		int cnt = session.insert("board.insertReplyBoard", brdVo);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int updateBoard(BrdVo brdVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int cnt = session.update("board.updateBoard", brdVo);
		session.commit();
		
		session.close();
		return cnt;
	}

	@Override
	public List<RplVo> selectReplyAll(String brd_id) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<RplVo> replyList = session.selectList("board.selectReplyAll",brd_id);
		
		session.close();
		return replyList;
	}

	@Override
	public int deleteReply(RplVo rplVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.update("board.deleteReply",rplVo);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public List<FileVo> selectFileAll(String brd_id) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<FileVo> fileList = session.selectList("board.selectFileAll",brd_id);
		session.close();
		return fileList;
	}

	@Override
	public List<BrdtVo> selectBoardTypeAll() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<BrdtVo> brdtList = session.selectList("board.selectBoardTypeAll");
		session.close();
		return brdtList;
	}

	@Override
	public int updateBoardType(BrdtVo brdtVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.update("board.updateboardType",brdtVo);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public UserVo selectUser(String userId) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		UserVo userVo = session.selectOne("board.selectUser",userId);
		session.close();
		return userVo;
	}

	@Override
	public int insertBoardType(BrdtVo brdtVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.insert("board.insertBoardType",brdtVo);
		session.commit();
		session.close();
		
		return cnt;
	}

	@Override
	public int countBoardAll(String brdt_id) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.selectOne("board.countBoardAll",brdt_id);
		session.close();
		
		return cnt;
	}

	@Override
	public int insertReply(RplVo rplVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.insert("board.insertReply",rplVo);
		session.commit();
		session.close();
		
		return cnt;
	}

	@Override
	public int insertFile(FileVo fileVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.insert("board.insertFile",fileVo);
		session.commit();
		session.close();
		
		return cnt;
	}

	@Override
	public int maxBoard() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.selectOne("board.maxBoard");
		session.close();
		
		return cnt;
	}



}
