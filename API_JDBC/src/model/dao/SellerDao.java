package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller obj);
	
	void update(Seller obj);
	
	void deleteById(Integer id);
	
	//Retorna um departamento por meio do ID
	Seller findById(Integer id);
	
	//Retorna todos departamentos
	List<Seller> findAll();
	
	//Retorna um departamento por meio do Departamento
	List<Seller> findByDepartment(Department department);
}
