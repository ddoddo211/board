package kr.or.ddit.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.Builder;
import kr.or.ddit.board.model.BrdVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardDaoTest {

	

	@Test
	public void selectBoardTest() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<BrdVo> boardList = session.selectList("board.selectBoardAll","brdt1");
		session.close();
		
		
		assertEquals(3, boardList.size());
	}

}
