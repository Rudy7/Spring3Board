package com.project6.web.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.project6.web.controller.HomeController;
import com.project6.web.domain.Path;

@Component
public class ContextFactory {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired Path path;
	
	public String path() {
		return  ((ServletRequestAttributes)
                RequestContextHolder
                .currentRequestAttributes())
                .getRequest()
                .getContextPath().toString()
                ;
	}
	
	public Path road() {
		logger.info("컨텍스트팩토리 road() {}", "들어옴");
		path.setContext(path());
		path.setCss(path()+"/resources/css");
		path.setImage(path()+"/resources/image");
		path.setJs(path()+"/resources/js");
		return path;
		
	}
}
