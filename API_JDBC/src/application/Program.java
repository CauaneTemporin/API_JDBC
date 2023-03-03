package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		
		SellerDao dao = DaoFactory.createSellerDao();
		
		System.out.println("------- Teste 01: Seller e Department findById -------");
		Seller seller = dao.findById(3);
		
		System.out.println(seller);
	}
}