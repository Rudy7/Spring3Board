package com.project6.web.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.project6.web.service.BoardService;

@Component
public class PageProxy {
	private static final Logger logger = LoggerFactory.getLogger(PageProxy.class);
	@Autowired PageAdaptor adapter;
	@Autowired Command cmd;
	@Autowired BoardService bService;
	@Autowired PagiDTO pagi;
	
	public void execute(Model model, Object o) {
		cmd = adapter.attr((PagiDTO)o);  //이건 어떤 의미인가요?\
		logger.info("getStartRow {}", cmd.getPagi().getStartRow());
		logger.info("getEndRow {}", cmd.getPagi().getEndPage());
		pagi = cmd.getPagi();
		model.addAttribute("pagi", pagi);
		model.addAttribute("list", bService.findByName(cmd));
		
	}
}
