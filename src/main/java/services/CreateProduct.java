package services;

import dto.ProductDTO;
import entities.Product;

public class CreateProduct {

	public static void main(String[] args) {
		Product p1 = new Product("Notebook", 2500.00);
		
		ProductDTO<Product> dto = new ProductDTO<>(Product.class);
		dto.openTransaction().create(p1).closeTransaction();
		

	}

}
