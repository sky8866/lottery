package com.sky.apps.action.lottery.web.user;

 
 
import javax.servlet.http.HttpServletRequest;  
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
 


@Controller
@RequestMapping(value = "/system/about")
public class AboutController {
	  
	private final static String BASE_PATH = "about/"; 
	
	@RequestMapping(value = "")
	public String word(HttpServletRequest request) {

		return BASE_PATH + "index";
	}
 
}
