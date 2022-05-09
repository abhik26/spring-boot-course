package com.example.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmployeeService;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	
	private final EmployeeService employeeService;
	
	public ThymeleafController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/hello-world")
	public String thymeleafHelloWorld(Model model) {
		model.addAttribute("serverDate", new Date());
		
		return "thymeleafHelloWorld.html";
	}
	
	@GetMapping("/dummy-employees")
	public String getDummyEmployees(Model model) {
		model.addAttribute("employees", getEmployees());
		
		return "employees.html";
	}
	
	private List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee = null;
		employee = new Employee(1L, "Dummy Employee", "one", "dummy.employee.one@email.com");
		employees.add(employee);
		employee = new Employee(2L, "Dummy Employee", "two", "dummy.employee.two@email.com");
		employees.add(employee);
		employee = new Employee(3L, "Dummy Employee", "three", "dummy.employee.three@email.com");
		employees.add(employee);
		employee = new Employee(4L, "Dummy Employee", "four", "dummy.employee.four@email.com");
		employees.add(employee);
		
		return employees;
	}
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAllByOrderByFirstNameAsc());
		
		return "/employees/employees.html";
	}
	
	@GetMapping("/employees/add-employee-form")
	public String getAddEmployeeForm(Model model) {
		model.addAttribute("newEmployee", new Employee());
		
		return "employees/new-employee.html";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveOrUpdate(employee);
		
		return "redirect:/thymeleaf/employees";
	}
	
	@GetMapping("/employees/update-form/{employeeId}")
	public String getEmployeeUpdateForm(Model model, @PathVariable Long employeeId) {
		model.addAttribute("employeeToUpdate", employeeService.findById(employeeId));
		
		return "employees/update-form.html";
	}
	
	@GetMapping("/employees/delete")
	public String deleteEmployee(@RequestParam Long employeeId) {
		employeeService.deleteById(employeeId);
		
		return "redirect:/thymeleaf/employees";
	}
}
