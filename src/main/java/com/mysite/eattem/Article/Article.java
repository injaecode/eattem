package com.mysite.eattem.Article;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String pdName;
	
	@Column
	private String pdInfo;
	
	@Column
	private String manufacturer;
	
	@Column
	private String[] vender;
	
	@Column
	private int price;
	
	@Column
	private String[] taste;

	
	private String url;
	
	
}
