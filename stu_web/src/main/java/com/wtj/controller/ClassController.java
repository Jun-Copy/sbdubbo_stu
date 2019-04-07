package com.wtj.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wtj.entity.GtClass;
import com.wtj.service.IClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {

	@Reference
	private IClassService classService;

	@RequestMapping("/list")
	public String getList(ModelMap modelMap){
		System.out.println(classService);
		List<GtClass> list = classService.getList();
		modelMap.put("classList",list);
		return "class_list";
	}

	@RequestMapping("/getById")
	@ResponseBody
	public GtClass getClassById(int classId){
		GtClass gtClass = classService.getClass(classId);
		return gtClass;
	}

	@RequestMapping("toAdd")
	public String toAdd(){
		return "class_add";
	}

	@RequestMapping("/add")
	public String add(GtClass gtClass){
		classService.addClass(gtClass);
		return "redirect:/class/list";
	}
}
