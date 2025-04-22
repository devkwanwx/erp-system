package com.kwanwx.erp.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageInfo<T> {
	private long total; // 전체 레코드 수
	private int pageNum; // 현재 페이지 번호
	private int pageSize; // 페이지 당 건수
	private List<T> list; // 데이터 리스트
	
	public PageInfo(com.github.pagehelper.PageInfo<T> ph) {
		this.total = ph.getTotal();
		this.pageNum = ph.getPageNum();
		this.pageSize = ph.getPageSize();
		this.list = ph.getList();
	}
}
