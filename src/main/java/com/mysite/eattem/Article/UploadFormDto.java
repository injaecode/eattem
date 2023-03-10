package com.mysite.eattem.Article;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadFormDto {


	@NotEmpty
	private String pdName;
	
	@NotEmpty
	private String pdInfo;
	
	@NotEmpty
	private String manufact;
	
	@NotEmpty
	private String seller;
	
	
	
}
