package com.project6.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.project6.web.domain.BoardDTO;
import com.project6.web.domain.Command;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.MemberDTO;
import com.project6.web.domain.PageProxy;
import com.project6.web.domain.PagiDTO;
import com.project6.web.factory.ContextFactory;
import com.project6.web.service.BoardService;

@SessionAttributes("loginUser")
@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired ContextFactory contextFactory;
	@Autowired BoardDTO board;
	@Autowired BoardService bService;
	@Autowired PagiDTO pagi;
	@Autowired CommonDTO common;
	@Autowired Command cmd;
	@Autowired PageProxy pagePxy;
	
	@RequestMapping(value="/list/{pn}",method=RequestMethod.GET)
	public String list(Model model,
			@PathVariable("pn")String pn,
			@RequestParam(value="pageSize",defaultValue="5")String pageSize,
			@RequestParam(value="blockSize",defaultValue="5")String blockSize,
			@RequestParam(value="pageNum",defaultValue="1")String pageNum,
			@RequestParam(value="nowPage",defaultValue="1")String nowPage
			) {
		logger.info("보더 컨트롤러 list도착===========================");	
		pagi.setPageSize(Integer.parseInt(pageSize));
		pagi.setBlockSize(Integer.parseInt(blockSize));
		pagi.setPageNum(Integer.parseInt(pageNum));
		pagi.setNowPage(Integer.parseInt(nowPage));
		pagePxy.execute(model, pagi);
		logger.info("보더 컨트롤러 list pagi는 {}", pagi);
		logger.info("getPageSize는 {}",pagi.getPageSize());
		logger.info("getBlockSize는 {}",pagi.getBlockSize());
		logger.info("getPageNum는 {}",pagi.getPageNum());
		logger.info("getNowPage는 {}",pagi.getNowPage());
		pagi.setPn(pn);
		logger.info("보더 컨트롤러 넘어온 페이지는{} ", pagi.getPn());
		model.addAttribute("list", bService.findAll(pagi));
		logger.info("bService.findAll(pagi)의 값은 {}", bService.findAll(pagi));
	/*	model.addAttribute("totalCount", bService.count());*/
		logger.info("보더 컨트롤러 list에서 count의 값은 {}", bService.count()); //PageAdaptor에서정의요
		logger.info("list에서 star의 값은 {}", pagi.getStartPage()); //PageAdaptor에서정의요
		logger.info("list에서 end의 값은 {}", pagi.getEndPage()); //PageAdaptor에서정의요
		return "board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		logger.info("보더 컨트롤러 write입니다===========================");
		return "board/write";
	}
	
	@RequestMapping(value="/write/insert", method=RequestMethod.POST)
	public String writeInsert(Model model,
			@RequestParam("inp-write-title")String title,
			@RequestParam("inp-write-content")String content,
			@ModelAttribute("loginUser")MemberDTO user
			) {
		logger.info("보더 컨트롤러 writeInsert입니다.=========================");
		board.setTitle(title);
		board.setContent(content);
		board.setUserid(user.getUserid());
		logger.info("제목 입니다 {}", board.getTitle());
		logger.info("내용 입니다 {}", board.getContent());
		logger.info("아이디 입니다 {}", board.getUserid());
		logger.info("아이디 입니다 {}", user.getUserid());
		bService.addBoard(board);
		return "redirect:/list/1";
	}
	
	@RequestMapping(value="/list/delete/{deleNum}", method=RequestMethod.GET)
	public String listDelete(Model model,
			@PathVariable("deleNum")String deleNum
			) {
		logger.info("보드 컨트롤러 listDelete입니다.=====================================");
		common.setDeleNum(deleNum);;
		logger.info("dele의 값은 {}", common.getDeleNum());
		bService.remove(common);
		model.addAttribute("list", bService.findAll(pagi));
		logger.info("bService.findAll(pagi)의 값은 {}", bService.findAll(pagi));
		return "board/list";
	}
	
	
}
	
