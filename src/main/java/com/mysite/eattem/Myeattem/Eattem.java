package com.mysite.eattem.Myeattem;

import java.util.List;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ToString
public class Eattem {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String itmName;
	
	@Column
	private String manufacturer;
	
	@Column
	private String vender;
	
	@Column
	private int price;
	
	@Lob
	@Column
	private String eattemDetail;
//	@Column
//	private List<Nutrition> nutritionFacts;
//	@Column
//	private List<Taste> tasteList;
}
