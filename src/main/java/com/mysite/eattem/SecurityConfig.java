package com.mysite.eattem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration	//security 설정 적용 어노테이션

public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().
			requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
		.and()
			//H2 데이터베이스는 http로 통신하는 db이므로 csrf가 적용되지 않도록 설정 
			.csrf().ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
		.and()
			.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
		.and()
			//Spring Security 로그인 처리 부분
			.formLogin().loginPage("/user/login").defaultSuccessUrl("/")
		.and()
			//Spring Security 로그아웃 처리부분
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/")
			.invalidateHttpSession(true)//세션에 담긴 모든 값을 삭제
			;
	
	return http.build();

	
	}
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
