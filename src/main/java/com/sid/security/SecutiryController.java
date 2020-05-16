package com.sid.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class SecutiryController {
	
	@RequestMapping(value="/")
public String home() {

	return "redirect:/ajouterGerant";
}
	
	
	@RequestMapping(value="/403")
public String accessdenied() {
	return "403";
}
	
	
	


	/*
	 * @RequestMapping(value="/getLogedUser") public Map<String, Object>
	 * getLogedUser(HttpServletRequest httpServletRequest){ HttpSession
	 * httpSession=httpServletRequest.getSession(); SecurityContext
	 * securityContext=(SecurityContext)httpSession.getAttribute(
	 * "SPRING_SECURITY_CONTEXT"); String
	 * username=securityContext.getAuthentication().getName(); List<String>
	 * roles=new ArrayList<>(); for(GrantedAuthority
	 * ga:securityContext.getAuthentication().getAuthorities()) {
	 * roles.add(ga.getAuthority()); } Map<String, Object>params=new HashMap<>();
	 * params.put("username", username); params.put("roles", roles); return params;
	 * }
	 */


}

