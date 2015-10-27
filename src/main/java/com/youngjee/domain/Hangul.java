package com.youngjee.domain;

public class Hangul {
	
	private String searchText;
	
	public Hangul() {
		this.searchText="N/A";
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "Hangul [searchText=" + searchText + "]";
	}

	

}
