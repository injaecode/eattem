package com.mysite.eattem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class EattemUser {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	
	@Column (unique=true)
	private String id;
	
	@Column	(length= 200)
	private String pw;
	
	@Column(length= 100, unique=true)
	private String nickname;
	
	@Column
	private String gender;

	
}
