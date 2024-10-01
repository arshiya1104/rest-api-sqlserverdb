package com.alloymobile.restapi.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alloymobile.restapi.persistence.Department;
import com.alloymobile.restapi.service.DepartmentService;

@RestController
public class DepartmentResource {
	
	DepartmentService service;

	public DepartmentResource(DepartmentService service) {
		this.service = service;
	}
	
	
	@GetMapping(value= "/departments")
	public List<Department> getAll() {
		return this.service.getAll();
	}


	@GetMapping(value = "/deparments/{id}")
	public Department getID(@PathVariable Long Id) {
		return this.service.getByID(Id);
	}

	@PostMapping(value="/departments")
	public Department add(Department dep) {
		return this.service.add(dep);
	}

	@PutMapping(value= "/departments/{id}" , consumes = "application/json")
	public Department update(@PathVariable Long Id, Department dep) {
		return this.service.update(Id, dep);
	}
	
    @DeleteMapping(value ="/departments/{id}")
	public void remove(@PathVariable Long Id) {
    	this.service.remove(Id);
	}
	

}
