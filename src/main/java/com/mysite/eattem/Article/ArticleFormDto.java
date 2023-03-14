package com.mysite.eattem.Article;

import java.util.Arrays;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleFormDto {


	@NotEmpty
	private String pdName;
	
	@NotEmpty
	private String pdInfo;
	
	@NotEmpty
	private String manufacturer;
	
	@NotEmpty
	private String[] vender;
	
	@NotEmpty
	private int price;

	private String[] taste;

	private String url;


	
	

}
