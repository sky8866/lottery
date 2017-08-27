package com.sky.apps.action.lottery.web.user;

 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.modules.core.utils.Aes;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UUID;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.utils.user.MD5Utils;
    
  

/**
 * 用户注册的Controller. sky
 */
@Controller
@RequestMapping(value = "/web/register")
public class RegisterController {

    @Autowired
     MemberManager accountService;  
      

    @RequestMapping(method = RequestMethod.POST)
    public String reg( String groupName, @Valid User user, HttpSession session,HttpServletRequest request) {

        try {
            if(StringUtils.isNotEmpty(user.getLoginName())){
                if (this.accountService.findUserByMobile( user.getLoginName())==null) {
                	 user.setPwd(MD5Utils.getMD5Str(user.getPlainPassword()));
                     user.setTokenId(UUID.getUUID());
                     
                     user.setSource("web");
                  
                     this.accountService.saveUser(user);
                     
                    
                  
                  

                    session.setAttribute("message", "您的账号已经创建成功！");
                } else {
                    session.setAttribute("message", "此账号已经被注册，请换一个重试!");
                }  
            }else{
                session.setAttribute("message", "注册失败,手机号码不能为空！");   
            }
           

        } catch (Exception e) {
                     
            session.setAttribute("message", "注册失败");
        }

        return "redirect:/";
    }

  

    @RequestMapping(value = "checkAccount")
    @ResponseBody
    public String checkAccount(@RequestParam("loginName") String loginName,@RequestParam(value = "aesid", required = false)String aesid) {
    	if(StringUtils.isNotEmpty(aesid)&&!"undefined".equals(aesid)){
			User  user=this.accountService.findUser(Long.valueOf(Aes.deparameter(aesid)));
			if(user.getLoginName().equals(loginName)){
				return "true";
			}
		}
		 
        if (this.accountService.findUserByMobile( loginName)==null) {
            return "true";
        } else {
            return "false";
        }
    }
    
   
    

}
