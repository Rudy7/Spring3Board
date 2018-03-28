package com.project6.web.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.project6.web.domain.BoardDTO;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.PagiDTO;


@Component
public interface BoardMapper {
	public void insertBoard(BoardDTO board);
	public void updateBoard(BoardDTO board);
	public void deleteBoard(CommonDTO common);
	public BoardDTO selectOne(BoardDTO board);
	public List<BoardDTO> selectList(BoardDTO board);
	public List<BoardDTO> selectAll(PagiDTO pagi);
	public int count();
	
}
