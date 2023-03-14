package com.mysite.eattem.Article;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.eattem.comment.CommentDto;
import com.mysite.eattem.comment.CommentService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor 
public class ArticleController {
	private final ArticleService articleService;
	private final CommentService commentService;
	
	
	@GetMapping("/eattem/upload")
	public String itemPage(Model model) {
		model.addAttribute("articleFormDto", new ArticleFormDto());
		return "admin_upload_form";
	}
	
	@PostMapping("/eattem/create")
	public String createPage(ArticleFormDto form, MultipartFile file) throws Exception {


		this.articleService.saveArticle(form, file);
	
		
		return "redirect:/";
	}
	
	@GetMapping("eattem/list")
	public String articleList(Model model) {
	model.addAttribute("list", articleService.articleList());
	return "itm_list";
	}
	
	@GetMapping("/eattem/view")
	public String view(Model model, Long id) {

		model.addAttribute("Article", articleService.view(id));

		
		return "itm_detail2";
		
	}
	
	@GetMapping("/eattem/delete")
	public String delete(Long id) {
		articleService.delete(id);
		return "redirect:/eattem/list";
	}
	
	@GetMapping("eattem/modify/{id}")
	public String modify(@PathVariable("id") Long id, Model model) {
		model.addAttribute("Article", articleService.view(id) );
		return "itm_modify";
	}
	
	@PostMapping("eattem/update/{id}")
	public String update(@PathVariable("id") Long id, ArticleFormDto articleFormDto, MultipartFile file) throws Exception{
		Article updateArt = articleService.view(id);
		updateArt.setPdName(articleFormDto.getPdName());
		updateArt.setPdInfo(articleFormDto.getPdInfo());
		updateArt.setManufacturer(articleFormDto.getManufacturer());
		updateArt.setPrice(articleFormDto.getPrice());
		updateArt.setVender(articleFormDto.getVender());
		updateArt.setTaste(articleFormDto.getTaste());
		updateArt.setUrl(articleFormDto.getUrl());
		
		articleService.saveArticle(articleFormDto, file);
		return "redirect:/eattem/list";
		
	}
}
