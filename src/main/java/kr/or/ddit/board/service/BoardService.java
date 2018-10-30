package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BrdVo;
import kr.or.ddit.board.model.BrdtVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.RplVo;
import kr.or.ddit.board.model.UserVo;

public class BoardService implements BoardServiceInf {

	BoardDaoInf bd = new BoardDao();
	
	@Override
	public List<BrdVo> selectBoardAll(BrdVo brdVo) {
		// TODO Auto-generated method stub
		return bd.selectBoardAll(brdVo);
	}

	@Override
	public BrdVo selectBoard(String brd_id) {
		// TODO Auto-generated method stub
		return bd.selectBoard(brd_id);
	}

	@Override
	public int insertBoard(BrdVo brdVo) {
		// TODO Auto-generated method stub
		return bd.insertBoard(brdVo);
	}

	@Override
	public int updateBoard(BrdVo brdVo) {
		// TODO Auto-generated method stub
		return bd.updateBoard(brdVo);
	}

	@Override
	public List<RplVo> selectReplyAll(String brd_id) {
		// TODO Auto-generated method stub
		return bd.selectReplyAll(brd_id);
	}

	@Override
	public int deleteReply(RplVo rplVo) {
		// TODO Auto-generated method stub
		return bd.deleteReply(rplVo);
	}

	@Override
	public List<FileVo> selectFileAll(String brd_id) {
		// TODO Auto-generated method stub
		return bd.selectFileAll(brd_id);
	}

	@Override
	public List<BrdtVo> selectBoardTypeAll() {
		// TODO Auto-generated method stub
		return bd.selectBoardTypeAll();
	}

	@Override
	public int updateBoardType(BrdtVo brdtVo) {
		// TODO Auto-generated method stub
		return bd.updateBoardType(brdtVo);
	}

	@Override
	public UserVo selectUser(String userId) {
		// TODO Auto-generated method stub
		return bd.selectUser(userId);
	}

	@Override
	public int insertReplyBoard(BrdVo brdVo) {
		// TODO Auto-generated method stub
		return bd.insertReplyBoard(brdVo);
	}

	@Override
	public int insertBoardType(BrdtVo brdtVo) {
		// TODO Auto-generated method stub
		return bd.insertBoardType(brdtVo);
	}

	@Override
	public int countBoardAll(String brdt_id) {
		// TODO Auto-generated method stub
		return bd.countBoardAll(brdt_id);
	}

	@Override
	public int insertReply(RplVo rplVo) {
		// TODO Auto-generated method stub
		return bd.insertReply(rplVo);
	}

	@Override
	public int insertFile(FileVo fileVo) {
		// TODO Auto-generated method stub
		return bd.insertFile(fileVo);
	}

	@Override
	public int maxBoard() {
		// TODO Auto-generated method stub
		return bd.maxBoard();
	}

}
