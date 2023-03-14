package com.mysite.eattem.comment;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private CommentService commentService;
	
	@GetMapping("eattem/view?id={articleId}/comments")
	public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId){
		 List<CommentDto> dtos=commentService.comments(articleId);
		
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
	@PostMapping("eattem/view?id={articleId}/comments")
	public ResponseEntity<CommentDto> create(@PathVariable Long articleId, @RequestBody CommentDto dto){
		CommentDto createDto = commentService.create(articleId, dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(createDto);
	}
	
	@PatchMapping("eattem/view?id={id}/comments")
	public ResponseEntity<CommentDto> update(@PathVariable Long id, @RequestBody CommentDto dto){
		CommentDto updateDto = commentService.update(id, dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateDto);
	}
	
	@DeleteMapping("eattem/view?id={id}/comments")
	public ResponseEntity<CommentDto> delete(@PathVariable Long id){
		CommentDto updateDto = commentService.delete(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateDto);
	}
}
