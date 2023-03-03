package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	//A classe mostra um método que retorna do tipo da interface 
	//mas internamente retorna uma implementação
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
}
