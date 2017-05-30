package top.auok.cbps.ssm.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.auok.cbps.ssm.model.Authorization;
import top.auok.cbps.ssm.service.AuthorizationService;

@Controller
@RequestMapping("/ams/auth")
public class AuthorizationController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	private static Log logger = LogFactory.getLog(AuthorizationController.class);
	
	@RequestMapping(value = "add", method = RequestMethod.POST) 
    @ResponseBody
	public String addAuthorization(@RequestBody Authorization authorization) {
		
		authorizationService.getByAuthorizationName(authorization.getAuthName());
		logger.info(authorizationService.getByAuthorizationName(authorization.getAuthName()));
		authorizationService.createAuthorization(authorization);
		return "success";
	}
}
