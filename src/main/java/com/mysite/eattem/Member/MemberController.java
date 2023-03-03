package com.mysite.eattem.Member;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
//	@GetMapping("/")
//	public String signup(EattemUserForm eattemUserform) {
//		return "signup";
//	}
	
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
	
	@PostMapping("/new")
		public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
			if(bindingResult.hasErrors()) {
				return "signup";
			}
		
			if(!memberFormDto.getPw1().equals(memberFormDto.getPw2())) {
				bindingResult.rejectValue("pw2", "PasswordInCorrect", "패스워드가 일치하지 않습니다.");
				return "signup";
			}
	        try {
	        	this.memberService.saveMember(memberFormDto.getId(), memberFormDto.getPw1(), memberFormDto.getNickname());
	        }catch(DataIntegrityViolationException e) {
	            e.printStackTrace();
	            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
	            return "signup";
	        }catch(Exception e) {
	            e.printStackTrace();
	            bindingResult.reject("signupFailed", e.getMessage());
	            return "signup";
	        }
		
			
			return "redirect:/";
		}
	
	
}
