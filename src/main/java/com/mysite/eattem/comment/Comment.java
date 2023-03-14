package com.mysite.eattem.comment;

import com.mysite.eattem.Article.Article;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;
	
	@Column
	private String nickname;
	
	@Column
	private String body;
	
	public static Comment createComment(CommentDto dto, Article article) {
		if(dto.getId()!=null) 
			throw new IllegalArgumentException("댓글 생성 실패! 댓글의 아이디가 없어야 합니다.");
		
		if(dto.getArticleId() != article.getId()) 
			throw new IllegalArgumentException("댓글 생성 실패! 게시글 아이디가 잘못되었습니다.");
		return new Comment(
				dto.getId(), article, dto.getNickname(),dto.getBody()
				);
	}

	public void patch(CommentDto dto) {
		if(this.id !=dto.getId())
			throw new IllegalArgumentException("댓글 수정 실패! 잘못된 ID가 입력되었습니다.");
		
		if(dto.getNickname() !=null)
			this.nickname = dto.getNickname();
		if(dto.getBody() !=null)
			this.body=dto.getBody();
		
	}
}
