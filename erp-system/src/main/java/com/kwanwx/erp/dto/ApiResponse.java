package com.kwanwx.erp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResponse<T> {
	private boolean success; // 처리 성공 여부
	private ErrorInfo error; //에러 메시지 또는 부가 설명
	private T data; // 실제 payload
	
	// 성공 응답 헬퍼
	public static <T> ApiResponse<T> of(T data) {
		ApiResponse<T> r = new ApiResponse<>();
		r.setSuccess(true);
		r.setData(data);
		r.setError(null);
		return r;
	}
	
	// 실패 응답 헬퍼
	public static <T> ApiResponse<T> error(String message) {
		ApiResponse<T> r = new ApiResponse<>();
		r.setSuccess(false);
		r.setData(null);
		r.setError(new ErrorInfo(message));
		return r;
	}
	
	@Getter @Setter
	public static class ErrorInfo {
		private String message;
		public ErrorInfo(String msg) { this.message = msg; }
	}
}
