package com.rajat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
@Entity
@FilterDef(name = "urlFilter", parameters = @ParamDef(name = "url", type = "string"))
@Filter(name = "urlFilter", condition = "url = :url")
@Table(name="url_data")
public class UrlEntity {
	@Id
	@Column(name="id")
	int id;
	@Column(name="url",unique = true)
	String url;
	@Column(name="short_key")
	String shortKey;
	@Column(name="usage_count")
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
