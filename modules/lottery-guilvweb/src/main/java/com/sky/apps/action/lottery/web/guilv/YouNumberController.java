package com.sky.apps.action.lottery.web.guilv;

 

import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
 


@Controller
@RequestMapping(value = "/system/younumber")
public class YouNumberController {
	 
	private final static String URL = "redirect:/system/wordType";
	private final static String BASE_PATH = "younumber/"; 
	
	@RequestMapping(value = "")
	public String word(HttpServletRequest request) {

		return BASE_PATH + "index";
	}
 
}
