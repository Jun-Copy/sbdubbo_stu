package com.wtj.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wtj.entity.GtClass;
import com.wtj.entity.GtStudent;
import com.wtj.entity.NewStudent;
import com.wtj.service.IClassService;
import com.wtj.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {

	@Reference
	private IStuService stuService;
	@Reference
	private IClassService classService;

	@RequestMapping("/list")
	public String getList(ModelMap modelMap){
		List<NewStudent> list = stuService.getList();
		modelMap.put("stuList",list);
		return "stu_list";
	}

	@RequestMapping("toAdd")
	public String toAdd(ModelMap modelMap){
		List<GtClass> list = classService.getList();
		modelMap.put("clList",list);
		return "stu_add";
	}

	@RequestMapping("add")
	public String add(GtStudent gtStudent){
		stuService.addStudent(gtStudent);
		return "redirect:/stu/list";
	}

}
