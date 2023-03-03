package com.mysite.eattem.Member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Member saveMember(Member member) {
		validateDuplicateMember(member);

		
		return memberRepository.save(member);
	}
	
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findById(member.getIdx());
		if(findMember !=null) {
			throw new IllegalStateException("이미 가입된 회원입니다");
		}
	}
	


}
