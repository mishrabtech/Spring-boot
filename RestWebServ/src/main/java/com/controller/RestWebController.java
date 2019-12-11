package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.Empdata;

import com.repositories.employeeDao;

@RestController
@RequestMapping("/employees")
public class RestWebController {

	@Autowired
	employeeDao empdao;

	@RequestMapping(value = "/")
	public ModelAndView EmployeeDetail() {
		System.out.println("enter in controller1");
		ModelAndView mv = new ModelAndView("index");
		System.out.println("enter in controller2");
		return mv;
	}

	// Method to save an Employee
	@PostMapping(value = "/empAdd", produces = "text/plain", consumes = "application/json")
	public String EmployeeSave(@RequestBody Empdata edata) {
		System.out.println("enter in controller3");
		System.out.println("edata>>>=" + edata);
		empdao.save(edata);
		System.out.println("enter in controller4");
		return "Employee Data Save successfully.";
	}
	
	// Method Update and save Employee
		@PostMapping(value = "/update/{updateId}", produces = "text/plain", consumes = "application/json")
		public String EmployeeUpdate(@PathVariable int updateId,@RequestBody Empdata edata) {
			System.out.println("enter in Update Method");
			System.out.println("Updated data>>>=" + edata);
			edata.setId(updateId);
			empdao.save(edata);
			System.out.println("enter in after update method");
			return "Employee Data Update and Save successfully.";
		}
		
		
//		@PostMapping("/update/{id}")
//		public String updateUser(@PathVariable("id") long id, @Valid Empdata user, 
//		  BindingResult result, Model model) {
//		    if (result.hasErrors()) {
//		        user.setId(id);
//		        return "update-user";
//		    }
//		         
//		    userRepository.save(user);
//		    model.addAttribute("users", userRepository.findAll());
//		    return "index";
//		}
		

	// Method to return all the employees
	@GetMapping(value = "/fetchEmp", produces = "application/json")
	public Iterable<Empdata> getAllEmp() {
		System.out.println("enter");
		return empdao.findAll();
	}

	// Method to return an the employees using id
	@GetMapping(value = "/fetchById/{id}", produces = "application/json")
	public Empdata getEmpByid(@PathVariable int id) {
		Optional<Empdata> fetched = empdao.findById(id);
		if (fetched.isPresent())
			return fetched.get();
		else
			return null;
	}

	// Method to return an the employees using id
	@GetMapping(value = "/delById/{idDel}", produces = "text/plain")
	public String delEmpByid(@PathVariable int idDel) {
		System.out.println("id in delete method" + idDel);
		empdao.deleteById(idDel);
		System.out.println("return after deleting boolean");
		return "success";

	}

}
