package com.mysite.eattem.Member;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberFormDto {

	@NotEmpty (message = "아이디를 입력하세요")
    @Email(message = "이메일 형식으로 입력해주세요.")
	private String email;
	
	@NotEmpty (message = "비밀번호를 입력하세요")
	@Size(min=8, max=16, message = "비밀번호는 8~16자로 입력하세요")
	private String pw1;

	@NotEmpty (message = "비밀번호를 한 번 더 입력하세요")
	@Size(min=8, max=20)
	private String pw2;
	
	@NotEmpty (message = "닉네임을 입력하세요")
	@Size(min=3, max=5, message = "닉네임은 3~5자로 입력하세요")
	private String nickname;
	
	private String gender;
	
	
	private String[] taste;


	@Override
	public String toString() {
		return "MemberFormDto [email=" + email + ", pw1=" + pw1 + ", pw2=" + pw2 + ", nickname=" + nickname
				+ ", gender=" + gender + ", taste=" + Arrays.toString(taste) + "]";
	}
	
	
}
