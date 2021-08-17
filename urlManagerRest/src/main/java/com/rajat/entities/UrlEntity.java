package com.rajat.entities;

public class UrlEntity {
	int id;
	String url;
	String shortKey;
	int usageCount;
	public UrlEntity() {
		
	}
	public UrlEntity(int id, String url, String shortKey, int usageCount) {
		this.id = id;
		this.url = url;
		this.shortKey = shortKey;
		this.usageCount = usageCount;
	}
	public UrlEntity(String url, String shortKey) {
		this.url = url;
		this.shortKey = shortKey;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShortKey() {
		return shortKey;
	}
	public void setShortKey(String shortKey) {
		this.shortKey = shortKey;
	}
	public int getUsageCount() {
		return usageCount;
	}
	public void setUsageCount(int usageCount) {
		this.usageCount = usageCount;
	}
	
	
}
