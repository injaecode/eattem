package com.mysite.eattem.Article;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.eattem.comment.CommentDto;
import com.mysite.eattem.comment.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
	private final ArticleRepository articleRepository;
	private final ImgService imgService;

	//private final ImgRepository imgRepository;
	
	public void saveArticle(ArticleFormDto articleFormDto, MultipartFile file) throws Exception  {
		Article article = new Article();
		article.setPdName(articleFormDto.getPdName());
		article.setPdInfo(articleFormDto.getPdInfo());
		article.setPrice(articleFormDto.getPrice());
		article.setManufacturer(articleFormDto.getManufacturer());
		article.setVender(articleFormDto.getVender());
		article.setTaste(articleFormDto.getTaste());
		article.setUrl(this.imgService.returnImg(file));
		
		this.articleRepository.save(article);
	}
	
	public List<Article> articleList(){
		return articleRepository.findAll();
	}
	

	
	public Article view(Long id) {
		Optional<Article> article = this.articleRepository.findById(id);
		
		return article.get();
	}
	
	public void delete(Long id) {
		articleRepository.deleteById(id);
	}
	
}
