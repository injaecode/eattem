package com.mysite.eattem.Member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	
    @GetMapping("/login")
    public String loginMember() {
        return "login";
    }
    
    @GetMapping("/login/error")
	public String loginError(Model model) {
    	model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
    	return "login";
    }
    
	@GetMapping("/new")
	public String newMember(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());
		
		return "signup";
	}
//	
//	@PostMapping("/create")
//	public String createMember(MemberFormDto dto) {
//		this.memberService.saveMember(dto.getEmail(), dto.getPw1(), dto.getGender(), dto.getNickname(), dto.getTaste());
//		System.out.println(dto.toString());
//		return "redirect:/";
//	}
//	
	@PostMapping("/create")
		public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
			if(bindingResult.hasErrors()) {
				return "signup";
			}
		
			if(!memberFormDto.getPw1().equals(memberFormDto.getPw2())) {
				bindingResult.rejectValue("pw2", "PasswordInCorrect", "패스워드가 일치하지 않습니다.");
				return "signup";
			}
	        try {
	        	Member member=Member.saveMember(memberFormDto, passwordEncoder);
	        	this.memberService.saveMember(member);
	        }catch(DataIntegrityViolationException e) {
	            e.printStackTrace();
	            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
	            return "signup";
	        }catch(Exception e) {
	            e.printStackTrace();
	            bindingResult.reject("signupFailed", e.getMessage());
	            return "signup";
	        }
		   System.out.println(memberFormDto.toString());
			
			return "redirect:/member/login";
		}
	



	
}
