package com.mysite.eattem.Member;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mysite.eattem.Home.Role;
import com.mysite.eattem.Myeattem.SellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Member {

	
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
	private String birthday;
	
	 @Enumerated(EnumType.STRING)
    private Gender gender;
	
	 @Column
	private List<String> taste;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setId(memberFormDto.getId());
		member.setNickname(memberFormDto.getNickname());
		String password = passwordEncoder.encode(memberFormDto.getPw1());
		member.setPw(password);
		member.setGender(Gender.none);
		member.setRole(Role.USER);
		member.setBirthday(memberFormDto.getBirthday());
		return member;
		
	}
}
