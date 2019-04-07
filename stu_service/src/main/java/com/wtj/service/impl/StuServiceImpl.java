package com.wtj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.wtj.entity.GtClass;
import com.wtj.entity.GtStudent;
import com.wtj.entity.NewStudent;
import com.wtj.mapper.StuMapper;
import com.wtj.service.IClassService;
import com.wtj.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

	@Autowired
	private StuMapper stuMapper;
	@Reference
	private IClassService classService;

	@Override
	public List<NewStudent> getList() {
		//学生集合
		List<GtStudent> stuList = stuMapper.selectList(null);
		//班级集合
		List<GtClass> clList = classService.getList();
		//学生信息带班级名称集合
		List<NewStudent> nStuList = new ArrayList<>();
		NewStudent newStudent = null;
		for(int i=0;i<stuList.size();i++){
			GtStudent stu = stuList.get(i);
			for(int j=0;j<clList.size();j++){
				if (clList.get(j).getClId()==stu.getClId()){
					newStudent = new NewStudent(stu.getStuId(),stu.getStuName(),
							stu.getStuSex(),stu.getStuDescribe(),stu.getClId(),
							clList.get(j).getClName());
					nStuList.add(newStudent);
				}
			}
		}
		return nStuList;
	}

	@Override
	public void addStudent(GtStudent student) {
		stuMapper.insert(student);
	}
}
