package com.project6.web.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project6.web.service.BoardService;

@Component
public class PageAdaptor {
	@Autowired Command cmd;
	@Autowired BoardService bService;
	
	public Command attr(PagiDTO pagi) {
		pagi.setTotalCount(bService.count());
		pagi.setTotalPageCount(0);
		pagi.setEndRow(0);
		pagi.setStartRow(0);
		pagi.setStartPage(0);
		pagi.setEndPage(0);
		cmd=new Command();
		cmd.setPagi(pagi);
		return cmd;
	}
	/* BlockEnd 1 = pageEnd 5
	 * BlockEnd 2 = pageEnd10
	 * pageBlock 1 : pageEnd 5
	 * pageBlock 2 : pageEnd 10
	 * pageBlock 3 : pageEnd 15
	 * */
}
