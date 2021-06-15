package dto;

import entities.Product;

public class ProductDAO extends ProductDTO<Product> {
	
	public ProductDAO() {
		super(Product.class);
	}

}
