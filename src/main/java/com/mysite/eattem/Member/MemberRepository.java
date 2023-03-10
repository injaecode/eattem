package com.mysite.eattem.Member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByemail(String email);
	
	boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
