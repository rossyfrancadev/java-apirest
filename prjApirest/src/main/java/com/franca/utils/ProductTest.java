package com.franca.utils;

import com.franca.dao.ProductDao;
import com.franca.models.Product;

public class ProductTest {

	public static void main(String[] args) {
		Product product = new Product();
		product.setNome("teste3");
		product.setDescricao("teste 3");
		product.setPrecoVenda(985);
		product.setQuantidade(59);
		// product.setId(1);
		// ProductDao.save(product);
		// ProductDao.update(product);
		// System.out.println(ProductDao.findAll());
		ProductDao.removeById(3);
	}

}
