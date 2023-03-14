package com.mysite.eattem.Article;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysite.eattem.Member.Member;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	Optional<Article> findById(Long id);
	}
