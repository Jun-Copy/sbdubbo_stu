package com.wtj.service;

import com.wtj.entity.GtStudent;
import com.wtj.entity.NewStudent;

import java.util.List;

public interface IStuService {
	public List<NewStudent> getList();
	public void addStudent(GtStudent student);
}
