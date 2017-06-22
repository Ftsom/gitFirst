package com.liu.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liu.domain.User;
import com.liu.service.UserService;

@Controller  
@RequestMapping("/ash")  
public class UserController {  

	@Autowired
    private UserService userService;  
	
	@RequestMapping("/")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index");   
        User user = userService.selectUserById(1);  
        mav.addObject("user", user);   
        return mav;    
    }    

	@RequestMapping("/getuserbyid")    
	@ResponseBody
    public Map<String, Object> getUser(){  
		Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.selectUserById(1);  
        map.put("user", user);
        return map;    
    }    
	
	@RequestMapping("/export")
	@ResponseBody
    public Map<String, Object> exportOutUserExcel(){  
		Map<String, Object> map = new HashMap<String, Object>();
        userService.exportDataToExcel();
        return map;    
    }    
	
	public static void main(String[] args) {
		int tempNumber = 11;
		String str =  String.format("%04d", tempNumber);
		System.out.println(str);
		
		final String STR_FORMAT = "0000";	
		
		Integer inHao = Integer.parseInt("021");
		
		inHao++;
		
		DecimalFormat df = new DecimalFormat(STR_FORMAT);
		
		System.out.println(df.format(inHao));
	}
}  