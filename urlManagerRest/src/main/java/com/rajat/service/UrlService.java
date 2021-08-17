package com.rajat.service;

import java.util.List;

import com.rajat.DAO.UrlDAO;
import com.rajat.entities.UrlEntity;

public class UrlService {
	UrlDAO dao = new UrlDAO();
	public String getCount(String url) {
		List<Integer> list = dao.getCount(url);
		if(list.size() == 0) {
			return "No Data Found";
		} else {
			return list.get(0).toString();
		}
	}

	public void addUrl(UrlEntity urlEntity) {
		// TODO Auto-generated method stub
		dao.addUrl(urlEntity);
	}

	public String getShortKey(String url) {
		List<String> list = dao.getShortKey(url);
		if(list.size() == 0) {
			return "No Data Found";
		} else {
			return list.get(0);
		}
	}

	public void increaseUsageCount(String url) {
		dao.increaseUsageCount(url);
	}

	public List<UrlEntity> getList(int page, int size) {
		return dao.getList(page,size);
	}

}
