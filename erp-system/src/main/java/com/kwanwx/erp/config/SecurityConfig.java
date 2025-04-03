package com.kwanwx.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kwanwx.erp.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain sercuityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable()) // CSRF 비활성화(테스트용)
			.authorizeHttpRequests(auth -> auth
					// 회원가입과 로그인은 인증 없이 접근 허용
					.requestMatchers("/users/register", "/users/login").permitAll() 
					// 그 외의 모든 요청은 인증 필요
					.anyRequest().authenticated()
			)
			.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// JWT 인증 필터 추가(기존 UsernamePasswordAuthenticationFilter 전에 적용)
		http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
