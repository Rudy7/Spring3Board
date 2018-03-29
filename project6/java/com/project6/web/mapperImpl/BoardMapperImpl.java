package com.project6.web.mapperImpl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project6.web.domain.BoardDTO;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.PagiDTO;
import com.project6.web.mapper.BoardMapper;

@Repository
public class BoardMapperImpl implements BoardMapper{
	private static final Logger logger = LoggerFactory.getLogger(BoardMapperImpl.class);	
	@Autowired SqlSessionTemplate sqlSession;
	@Autowired BoardDTO board;
	@Autowired PagiDTO pagi;
	String ns = "com.project6.web.mapperImpl.BoardMapperImpl."; 
				
	@Override
	public void insertBoard(BoardDTO board) {
		logger.info("보더 매퍼임플 insertBoard 입니다.=========================");
		logger.info("제목 입니다 {}", board.getTitle());
		logger.info("내용 입니다 {}", board.getContent());
		logger.info("아이디 입니다 {}", board.getUserid());
		logger.info("ns의 값은 {}", ns);
		sqlSession.insert(ns +"insertBoard", board);
	}

	@Override
	public void updateBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(CommonDTO common) {
		sqlSession.delete(ns+"deleteBoard", common);
	}

	@Override
	public BoardDTO selectOne(BoardDTO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> selectList(BoardDTO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> selectAll(PagiDTO pagi) {
		logger.info("보더 매퍼임플 넘어온 페이지 pN은 {} ",	pagi.getPN());
		List<BoardDTO> s = sqlSession.selectList(ns +"selectAll", pagi);
		logger.info("보드 매퍼임플 selectAll=============================");
		logger.info(" s는 {}", s);
		logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ board값은 {}", pagi);
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{}", board.getContent());	
		logger.info("board.getBbsSeq()값은 {}", board.getBbsSeq());
		return s;
	}

	@Override
	public int count() {
		int v = sqlSession.selectOne(ns+"count");
		return v;
	}

}
