package com.kwanwx.erp.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kwanwx.erp.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Authorization 헤더에서 "Bearer" 토큰 추출
		String authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			String token = authorizationHeader.substring(7);
			try {
				// JWT 토큰에서 userName 추출
				String userName = JwtUtil.extractUserName(token);
				String role = JwtUtil.extractUserRole(token);

				// 인증 정보가 없으면 SecurityContext에서 설정
				if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					String authority = "ROLE_" + role.toUpperCase();
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userName, null, Collections.singleton(() -> authority));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			} catch (Exception e) {
				// 토큰 검증 실패 시 로그 출력
				System.out.println("JWT 토큰 검증 실패: " + e.getMessage());
			}
		}
		filterChain.doFilter(request, response);
	}
}
