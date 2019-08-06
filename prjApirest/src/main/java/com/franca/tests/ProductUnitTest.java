package com.franca.tests;

import org.junit.Test;
import com.franca.models.Product;

import junit.framework.TestCase;

public class ProductUnitTest extends TestCase {
	public ProductUnitTest() {
		super();
	}

	@Test
	public void test() {
		Product product = new Product();
		product.setDescricao("1lt");
		product.setNome("cerveja");
		product.setQuantidade(10);
		product.setPrecoVenda((float) 9.45);
		product.setId(1);

		assertEquals("1lt", product.getDescricao());
		assertEquals("cerveja", product.getNome());
		assertEquals(10, product.getQuantidade());
		assertEquals((float) 9.45, product.getPrecoVenda());
		assertEquals(1, product.getId());

	}

}
