package com.wtj.service;

import com.wtj.entity.GtClass;

import java.util.List;

public interface IClassService {
	public List<GtClass> getList();
	public GtClass	getClass(int id);
	public void addClass(GtClass gtClass);
}
