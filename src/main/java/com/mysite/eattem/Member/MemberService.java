package com.mysite.eattem.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{


	private final MemberRepository memberRepository;

	
	public Member saveMember(Member member) {
		validateDuplicateMember(member);

		
		return memberRepository.save(member);
	}
	
	private void validateDuplicateMember(Member member) {
	     Optional<Member> findMember = this.memberRepository.findByemail(member.getEmail());
	        if(findMember.isPresent()){
	            throw new IllegalStateException("이미 가입된 회원입니다.");
	        }
	}
	


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 Optional<Member> member = this.memberRepository.findByemail(email);

	        if(member.isEmpty()){
	            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
	        }
	        Member members=member.get();
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        if("ADMIN".equals(email)) {
	        	authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
	        }else {
	        	authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
	        }
	        
	        return new User(members.getEmail(),members.getPw(),authorities);
	    }





}
