package com.mysite.eattem;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public EattemUser saveUser(String id, String pw, String nickname) {
		EattemUser user = new EattemUser();
		
		user.setId(id);
		user.setPw(passwordEncoder.encode(pw));
		user.setNickname(nickname);
		
		this.userRepository.save(user);
		
		return user;
	}


}
