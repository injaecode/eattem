package com.mysite.eattem.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	private String index() {
		return "index";
	}
	
    @GetMapping("/my_eattem")
    public String show() {
        return "eattemList";
    }
}
