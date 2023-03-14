package com.mysite.eattem.comment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.metamodel.relational.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import com.mysite.eattem.Article.Article;
import com.mysite.eattem.Article.ArticleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private CommentRepository commentRepository;
	private ArticleRepository articleRepository;
	
	public List<CommentDto> comments(Long articleId){
		List<Comment> comments=commentRepository.findByArticleId(articleId);
		List<CommentDto> dtos=new ArrayList<CommentDto>();
		for(int i =0;i<comments.size();i++) {
			Comment comm = comments.get(i);
			CommentDto dto = CommentDto.createCommentDto(comm);
			dtos.add(dto);
		}
		return dtos;
	}
	@Transactional
	public CommentDto create(Long articleId, CommentDto dto) {
		Article article=articleRepository.findById(articleId).orElseThrow(()-> new IllegalIdentifierException("댓글 생성 실패! 대상 게시글이 없습니다."));
		
		Comment comment = Comment.createComment(dto, article);
		Comment created = commentRepository.save(comment);
		
		return 	CommentDto.createCommentDto(created);
	}
	
	@Transactional
	public CommentDto update(Long id, CommentDto dto) {
		Comment target= commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));
		target.patch(dto);
		
		Comment updated = commentRepository.save(target);
		return CommentDto.createCommentDto(updated);
		
	
	}
	@Transactional
	public CommentDto delete(Long id) {
		Comment target= commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글 삭제 실패! 대상 댓글이 없습니다."));
		commentRepository.delete(target);
		return CommentDto.createCommentDto(target);
	}
}
