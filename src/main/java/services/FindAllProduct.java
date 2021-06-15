package services;

import java.util.List;

import dto.ProductDAO;
import entities.Product;

public class FindAllProduct {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		List<Product> products = dao.findALL();
		
		for(Product product : products) {
			System.out.println("ID" + product.getId() + ", Nome: " + product.getName());
		}
		
		double priceTotal = products.stream()
				.map(p -> p.getPrice())
				.reduce(0.0, (t, p) -> t + p)
				.doubleValue();
		
		System.out.println("O valor total é R$: " + priceTotal);
		
		dao.close();
	}

}
