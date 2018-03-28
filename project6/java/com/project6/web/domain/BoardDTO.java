package com.project6.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class BoardDTO {
	private int bbsSeq,viewCount,good;
	private String title,content, writedate,userid;
}
