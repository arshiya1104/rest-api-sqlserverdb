package com.alloymobile.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alloymobile.restapi.persistence.Department;
import com.alloymobile.restapi.persistence.DepartmentRepository;

@Service
public class DepartmentService {

	DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public List<Department> getAll() {
		return this.departmentRepository.findAll();
	}

	// Use findById():
	// When immediate loading of the entity’s state is necessary.
	// In situations where you anticipate the entity to exist in the database.
	// When handling cases where both existing and non-existing entities need
	// explicit treatment.

	// Use getReferenceById():
	// When you solely require a reference to the entity without loading its state
	// immediately.
	// In scenarios where deferring the database query until necessary can improve
	// performance.
	// When dealing with cases where the existence of the entity is certain, or
	// missing entities are inconsequential.

	public Department getByID(Long Id) {
		return this.departmentRepository.getOne(Id);
	}

	public Department add(Department dep) {
		return this.departmentRepository.save(dep);
	}

	public Department update(Long Id, Department dep) {
		Department deparmentRef = this.departmentRepository.getReferenceById(Id);
		if (deparmentRef != null) {
			deparmentRef.setName(dep.getName());
			return this.departmentRepository.save(deparmentRef);
		}

		throw new RuntimeException();
	}

	public void remove(Long Id) {
		this.departmentRepository.deleteById(Id);
	}
}
