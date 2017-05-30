package top.auok.cbps.ssm.web.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.auok.cbps.ssm.model.Operator;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String index() {
		
		Operator operator = (Operator) SecurityUtils.getSubject().getSession().getAttribute("operator");
		if(operator == null) return "sys/login";
		return "sys/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		Operator operator = (Operator) SecurityUtils.getSubject().getSession().getAttribute("operator");
		if(operator == null) return "sys/login";
		return "sys/index";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		
		SecurityUtils.getSubject().getSession().removeAttribute("operator");
		return "sys/login";
	}
}
