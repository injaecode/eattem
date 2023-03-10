package com.mysite.eattem.Member;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mysite.eattem.Article.SellStatus;
import com.mysite.eattem.Article.Taste;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@Column (unique=true)
	private String email;
	
	@Column	(length= 200)
	private String pw;
	
	@Column(length= 100, unique=true)
	private String nickname;
	
	
	
    private String gender;

	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@CreationTimestamp
	private Timestamp createDate;

	private String[] taste;
//	@Embedded
//	private Taste taste;

	public static Member saveMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setEmail(memberFormDto.getEmail());
		String password= passwordEncoder.encode(memberFormDto.getPw1());
		member.setPw(password);
		member.setNickname(memberFormDto.getNickname());
		member.setGender(memberFormDto.getGender());
		member.setTaste(memberFormDto.getTaste());
		member.setRole(Role.ADMIN);
	
		return member;
	}
	

}


