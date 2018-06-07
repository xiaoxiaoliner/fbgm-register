package com.fbgm.register;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/register")
public class RegistController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping
	String register(Model model) {
		
		logger.info("entry register page....");
		
		model.addAttribute("message", "entry ok.");
		
		return "register";
		
	}
	@PostMapping
	String doRegister(@RequestParam(name = "username")String name, @RequestParam(name="passwd") String password, Model model) {
		
		logger.info(name + ":" + password);
		
		//db handle
		jdbcTemplate.update("insert into user (name,password) values (?,?)", name, password);
		model.addAttribute("message", "db ok.");
		return null;
		
		
	}

}
