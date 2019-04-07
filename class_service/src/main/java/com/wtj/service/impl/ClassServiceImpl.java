package com.wtj.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wtj.entity.GtClass;
import com.wtj.mapper.ClassMapper;
import com.wtj.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {

	@Autowired
	private ClassMapper classMapper;

	@Override
	public List<GtClass> getList() {
		return classMapper.selectList(null);
	}

	@Override
	public GtClass getClass(int id) {
		return classMapper.selectById(id);
	}

	@Override
	public void addClass(GtClass gtClass) {
		classMapper.insert(gtClass);
	}
}
