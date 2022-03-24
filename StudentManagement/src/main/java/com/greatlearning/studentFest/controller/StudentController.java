package com.greatlearning.studentFest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentFest.entity.Student;
import com.greatlearning.studentFest.service.StudentService;

@Controller
@RequestMapping("/student")

public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/list")
	public String liststudent(Model theModel) {
		
		List<Student> students = studentService.findAll();
		
		theModel.addAttribute("students", students);
		
		return "list-Students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student student = new Student();
		theModel.addAttribute("student", student);
		
		return "Student-form";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id,Model theModel) {
		Student student = new Student();
		student = studentService.findById(id);
		theModel.addAttribute("student", student);
		return "Student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
								@RequestParam("name") String name,
								@RequestParam("department") String department,
								@RequestParam("country") String country) {
		
		Student student;
		if (id!=0) {
			student=studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}else {
			student = new Student(name, department, country);
		}
		studentService.save(student);
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		
		studentService.deleteById(id);
		return "redirect:/student/list";
	}

}
