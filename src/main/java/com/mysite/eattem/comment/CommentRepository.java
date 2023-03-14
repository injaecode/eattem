package com.mysite.eattem.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

@Controller
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query(value="SELECT * FROM comment WHERE article_id= :articleId", nativeQuery=true)
	List<Comment> findByArticleId(Long articleId);
	
	List<Comment> findByNickname(String nickname);
	
}
