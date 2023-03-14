package com.mysite.eattem.comment;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private Long id;
	@JsonProperty("article_id")
	private Long articleId;
	private String nickname;
	private String body;
	public static CommentDto createCommentDto(Comment comm) {

		return new CommentDto(
				comm.getId(),
				comm.getArticle().getId(),
				comm.getNickname(),
				comm.getBody()
				);
	}
}
