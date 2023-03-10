package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("------- Teste 01: Seller e Department findById -------");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n------- Teste 02: Seller e Department findByDepartment -------");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n------- Teste 03: Seller e Department findAll-------");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n------- Teste 04: Seller e Department Insert-------");
		Seller sellerInsert = new Seller(null, "Greg", "greg@gmail.com", new Date(), 400.0, department);
		sellerDao.insert(sellerInsert);
		System.out.println("Inserido! Nova id: " + sellerInsert.getId());
		
	    System.out.println("\n------- Teste 05: Seller e Department Update-------");
	    seller = sellerDao.findById(1);
	    seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n------- Teste 06: Seller e Department Delete-------");
		System.out.print("Entre com ID para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
	}
}