package com.project6.web.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.project6.web.domain.BoardDTO;
import com.project6.web.domain.Command;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.PagiDTO;

@Component
public interface BoardService {
	public void addBoard(BoardDTO board);
	public void modify(BoardDTO board);
	public void remove(CommonDTO common);
	public BoardDTO findById(BoardDTO board);
	public List<BoardDTO> findByName(Command cmd);
	public List<BoardDTO> findAll(PagiDTO pagi);
	public int count();
	
	
}
