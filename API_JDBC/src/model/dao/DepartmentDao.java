package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);
	
	void update(Department obj);
	
	void deleteById(Integer id);
	
	//Retorna um departamento por meio do ID
	Department findById(Integer id);
	
	//Retorna todos departamentos
	List<Department> findAll();
}
