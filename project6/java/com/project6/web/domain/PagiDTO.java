package com.project6.web.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PagiDTO {
	private static final Logger logger = LoggerFactory.getLogger(PagiDTO.class);
	private String pn;
	int nowPage// 현재 위치한 페이지
		,totalCount// 리스트 총 갯수
		,blockSize// 화면에 출력할 리스트 갯수(한 페이지에 보이는 리스트 수)
		,startRow// 화면의 리스트 시작 //startRow = pageNum*blockSize-blockSize;  //startRow=((pageNum-1)*blockSize)+1;
									   //this.startRow = (startRow<0)?1:startRow+1; 0보다작을수가없어서 0이아니냐0이냐를말하고있다고봐야합니다.페이지넘버가1이면0이되는데그때+1해주면된다는의미입니다.
		,endRow// 화면의 리스트 끝    //endRow=pageNum*blockSize-1;
									  //this.endRow = (endRow>=totalCount)?totalCount+1:endRow+1;
		,pageNum// 이동할 페이지
		,startPage// 화면의 페이지 시작  //startPage=((pageNum-1)/pageSize)*pageSize+1;
										 //this.startPage = startPage;
		,endPage// 화면의 페이지 끝		//endPage=((pageNum-1)/pageSize)*pageSize+pageSize;  스타트페이지에서 1대신에 페이지사이즈를 더한겁니다.5일수도10일수도있어서요
										//this.endPage = (endPage>=totalPageCount)?totalPageCount:endPage;
		,pageSize// 화면에 보여줄 이동할 페이지 숫자(화면하단에 보이는 페이지 개수)
		,totalPageCount// 페이지 총 갯수 
				//this.totalPageCount = ((totalCount%blockSize==0)?(totalCount/blockSize):((totalCount/blockSize)+1));
		;
	public String getPn() {
		return pn;
	}
	public void setPn(String pn) {
		this.pn = pn;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		startRow = pageNum*blockSize-blockSize;
		this.startRow = (startRow<0)?1:startRow+1;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		endRow=pageNum*blockSize-1;
		this.endRow = (endRow>=totalCount)?totalCount+1:endRow+1;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		//pageNum=((rowNum-1)/blockSize)+1;
		//blockNum=(rowNum-1)/(blckSize*pageSize);
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		startPage=((pageNum-1)/pageSize)*pageSize+1;
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		endPage=((pageNum-1)/pageSize)*pageSize+pageSize;
		logger.info("PagiDTO에서 EndPage는 {}", endPage );
		this.endPage = (endPage>=totalPageCount)?totalPageCount:endPage;
	  //this.endPage = ((nowPage+pageSize-1)>=totalPageCount)?totalPageCount:nowPage+pageSize-1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = ((totalCount%blockSize==0)?(totalCount/blockSize):((totalCount/blockSize)+1));
	}
	public static Logger getLogger() {
		return logger;
	}
	
	/* BlockEnd 1 = pageEnd 5
	 * BlockEnd 2 = pageEnd10
	 * pageBlock 1 : pageEnd 5
	 * pageBlock 2 : pageEnd 10
	 * pageBlock 3 : pageEnd 15
	 * */
	
}
