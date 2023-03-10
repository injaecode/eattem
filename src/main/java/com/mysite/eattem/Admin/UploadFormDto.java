package com.mysite.eattem.Admin;

import com.mysite.eattem.Article.SellStatus;

import jakarta.validation.constraints.NotBlank;

public class UploadFormDto {
	
	private Long id;
	
	@NotBlank(message = "제품명은 필수 입력 값입니다.")
	private String eattemName;
	
	@NotBlank(message = "제조사는 필수 입력 값입니다.")
	private String manufacturer;
	
	@NotBlank(message = "판매처는 필수 입력 값입니다.")
	private String vender;
	
	private SellStatus sellStatus;
	
	
}
