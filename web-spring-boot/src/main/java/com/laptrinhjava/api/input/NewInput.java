package com.laptrinhjava.api.input;

public class NewInput {
	private Integer page;
	private Integer limit;
	
	public NewInput(Integer page, Integer limit) {
		this.page = page;
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
