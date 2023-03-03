package com.mysite.eattem.Member;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

	@NotEmpty (message = "아이디를 입력하세요")
	@Size(min = 4, max=10, message = "아이디는 4~10자로 입력하세요" )
	private String id;
	
	@NotEmpty (message = "비밀번호를 입력하세요")
	@Size(min=8, max=16, message = "비밀번호는 8~16자로 입력하세요")
	private String pw1;

	@NotEmpty (message = "비밀번호를 한 번 더 입력하세요")
	@Size(min=8, max=20)
	private String pw2;
	
	@NotEmpty (message = "닉네임을 입력하세요")
	@Size(min=3, max=5, message = "닉네임은 3~5자로 입력하세요")
	private String nickname;
	
	private String birthday;
	private String gender;
	private String taste;
}
