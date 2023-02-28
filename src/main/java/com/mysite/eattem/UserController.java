package com.mysite.eattem;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	@GetMapping("/")
	public String signup(EattemUserForm eattemUserform) {
		return "signup";
	}
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/user/listup")
	public String enroll(EattemUserForm eattemUserform) {
		return "signup";
	}
	
	@PostMapping("/user/listup")
		public String enroll(@Valid EattemUserForm eattemUserform, BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return "signup";
			}
		
			if(!eattemUserform.getPw1().equals(eattemUserform.getPw2())) {
				bindingResult.rejectValue("pw2", "PasswordInCorrect", "패스워드가 일치하지 않습니다.");
				return "signup";
			}
	        try {
	        	this.userService.saveUser(eattemUserform.getId(), eattemUserform.getPw1(), eattemUserform.getNickname());
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
