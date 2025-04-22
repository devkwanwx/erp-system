package com.kwanwx.erp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kwanwx.erp.dto.ApiResponse;
import com.kwanwx.erp.model.User;
import com.kwanwx.erp.service.UserService;

@RestController
@RequestMapping("/users") // 기본 URL
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/register") // 회원가입 API
	public ResponseEntity<ApiResponse<User>> registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return ResponseEntity.ok(ApiResponse.of(user)); // 성공 시 응답 메시지
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<Map<String, String>>> login(@RequestBody Map<String, String> loginRequest) { // JSON으로 받은 아이디/비밀번호를 Map으로 변환
		String userName = loginRequest.get("userName");
		String password = loginRequest.get("password");

		String token = userService.login(userName, password);
		if (token != null) {
			return ResponseEntity.ok(ApiResponse.of(Map.of("token", token)));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다."));
		}
	}

	@GetMapping("/me")
	public ResponseEntity<ApiResponse<Map<String, String>>> getCurrentUser() {
		// SecurityContextHolder에서 현재 인증된 사용자 정보 가져오기
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() != null) {
			String userName = auth.getPrincipal().toString();
			return ResponseEntity.ok(ApiResponse.of(Map.of("userName", userName)));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("인증 정보가 없습니다."));
		}
	}

	@GetMapping("/admin")
	public ResponseEntity<ApiResponse<String>> adminEndpoint() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean isAdmin = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

		// admin 사용자만 접근 허용
		if (isAdmin) {
			return ResponseEntity.ok(ApiResponse.of("관리자 전용 데이터입니다."));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.error("접근이 거부되었습니다."));
		}
	}
}
