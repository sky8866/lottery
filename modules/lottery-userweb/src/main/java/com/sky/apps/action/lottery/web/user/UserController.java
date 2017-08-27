package com.sky.apps.action.lottery.web.user;

 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.Maxresult;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.Aes;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.entity.user.UserLog;
import com.sky.modules.lottery.entity.user.UserVip;
import com.sky.modules.lottery.hc.utils.DimensionalCodeManager;
import com.sky.modules.lottery.hc.utils.Ticket;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.service.user.UserLogService;
import com.sky.modules.lottery.service.user.UserVipService;
import com.sky.modules.lottery.web.WebMessage;
 
 
 


@Controller
@RequestMapping(value = "/system/user")
public class UserController {
	  
	private final static String BASE_PATH = "user/"; 
	@Autowired private MemberManager memberManager;
	
	@Autowired private UserVipService vipService;
	
	@Autowired private UserLogService logService;
	
	
	@RequestMapping(value = "log")
	public String log(HttpServletRequest request) {
		PageView<UserLog> pageView = new PageView<UserLog>();
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		 
		filters.add(new PropertyFilter("createDate", MatchType.GT, UtilDate.getDateFormatters(new Date()))); 
		
		filters.add(new PropertyFilter("createDate", MatchType.LE, UtilDate.getDateFormatters(UtilDate.getDateFormatter(new Date(), "yyyy-MM-dd")+" 23:59:59","yyyy-MM-dd HH:mm:ss"))); 
		
		List<UserLog> logs=this.logService.findPageUser(pageView, filters).getResultlist();
		int qxc_sum_error=0;
		int qxc_limit=0;
		int qxc_allRight=0;
		int qxc_plan=0;
		int pl5_sum_error=0;
		int cq_sum_error=0;
		int share_plan=0;
		int pl5_plan=0;
		int cq_plan=0;
		for(UserLog l:logs){
			if("qxc_sum_error".equals(l.getModules())){
				 
				qxc_sum_error++;
			}else if("qxc_limit".equals(l.getModules())){
				qxc_limit++;
			}else if("qxc_allRight".equals(l.getModules())){
				qxc_allRight++;
			}else if("qxc_plan".equals(l.getModules())){
				qxc_plan++;
			}else if("pl5_sum_error".equals(l.getModules())){
				pl5_sum_error++;
			}else if("cq_sum_error".equals(l.getModules())){
				cq_sum_error++;
			}else if("share_plan".equals(l.getModules())){
				share_plan++;
			}else if("pl5_plan".equals(l.getModules())){
				pl5_plan++;
			}else if("cq_plan".equals(l.getModules())){
				cq_plan++;
			}   
		}
		

		List<String> strings=new ArrayList<String>();
		strings.add(qxc_plan+"");
		strings.add(qxc_allRight+"");
		strings.add(qxc_sum_error+"");
		strings.add(qxc_limit+"");
		strings.add(cq_sum_error+"");
		strings.add(pl5_sum_error+"");
		strings.add(cq_plan+"");
		strings.add(pl5_plan+"");
		strings.add(share_plan+"");
		 
		request.setAttribute("userlogs", strings.toString());
		return BASE_PATH+"user_log";
	}
	
	public static void main(String[] args) {
		List<String> strings=new ArrayList<String>();
		strings.add("1");
		strings.add("2");
		System.out.println(strings.toString());
	}
	
	
	@RequestMapping(value = "ticket")
	public String word(HttpServletRequest request) {
		 String code = request.getParameter("code");
		WebMessage web = new WebMessage();
		Map<String, String> tokenMap = web.getAccessToken(code);
	 
		String openId = tokenMap.get("openid");
		
		User user=this.memberManager.findUser("openId", openId);
		
		String ticket=user.getTicket();
		
		if(!StringUtils.isNotEmpty(user.getTicket())){
			try{
				Ticket t = DimensionalCodeManager.getTicket(openId); 
				ticket=t.getTicket();
				user.setTicket(ticket);
				this.memberManager.updateUser(user);
			}catch (Exception e) {
				 
			}
		}
		
	 
		
	 
		 //return "redirect:https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket.getTicket();
	 
		
		 
		 
		
		if(user.getIsVip()==1){
			UserVip vip=this.vipService.findUserVip("openId", openId);
			user.setEndDate(vip.getEndtime());
		} 
		
		List<User> users=this.memberManager.findUsers("openId", openId);
		
		 
		 
	 
		request.setAttribute("user", user);
		request.setAttribute("ticket", ticket);
		request.setAttribute("user_qrscene", users.size());
		return BASE_PATH+"index";
	}
 
	
	@RequestMapping(value = "qrscene/{id}")
	public String uid(@PathVariable("id") String id, HttpServletRequest request) {
		User user=this.memberManager.findUser(Long.valueOf(Aes.deparameter(id)));
		request.setAttribute("qrscene", "qrscene_"+user.getOpenId());
		return BASE_PATH+"qrscene";
	}
 
	
}
