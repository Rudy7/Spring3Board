package com.project6.web.serviceImpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project6.web.domain.BoardDTO;
import com.project6.web.domain.Command;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.MemberDTO;
import com.project6.web.domain.PagiDTO;
import com.project6.web.mapper.BoardMapper;
import com.project6.web.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);	
	@Autowired BoardMapper mapper;
	@Autowired BoardDTO board;
	@Autowired MemberDTO member;
	@Autowired CommonDTO common;
	@Autowired PagiDTO pagi;
	
	@Override
	public void addBoard(BoardDTO board) {
		logger.info("보더 서비스임플 addBoard입니다.=========================");
		logger.info("제목 입니다 {}", board.getTitle());
		logger.info("내용 입니다 {}", board.getContent());
		logger.info("아이디 입니다 {}", board.getUserid());
		mapper.insertBoard(board);
	}

	@Override
	public void modify(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(CommonDTO common) {
		logger.info("보더 서비스임플 remove입니다==============================");
		logger.info("dele의 값은 {}", common.getDeleNum());
		mapper.deleteBoard(common);
	}

	@Override
	public BoardDTO findById(BoardDTO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> findByName(Command cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> findAll(PagiDTO pagi) {
		List<BoardDTO> t = mapper.selectAll(pagi);
		logger.info("보드 서비스임플 findAll=============================");
		logger.info(" t는 {}", t);
		logger.info("보더 서비스임플 넘어온 페이지 pN은 {} ",	pagi.getPN());
		return t;
	}

	@Override
	public int count() {
		int a = mapper.count();
		logger.info("@@@@@@@@@@@@@@@@@ count{}", a);
		return a;
	}

}
