package com.mysite.eattem;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EattemUserForm {

	@NotEmpty (message = "아이디를 입력하세요")
	@Size(min = 3, max=10)
	private String id;
	
	@NotEmpty (message = "비밀번호를 입력하세요")
	@Size(min=8, max=20)
	private String pw1;

	@NotEmpty (message = "비밀번호를 다시 입력하세요")
	@Size(min=8, max=20)
	private String pw2;
	
	@NotEmpty (message = "닉네임을 입력하세요")
	@Size(min=3, max=5)
	private String nickname;
	
	
}
