package com.mysite.eattem.Article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;
	
	
	@GetMapping("/eattem/upload")
	public String itemPage(Model model) {
		model.addAttribute("FormDto", new UploadFormDto());
		return "admin_upload_form";
	}
}
