package com.spring.ProductRepositoryImplTest;



import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Product.Product;
import com.spring.Repository.productRepository;
import com.spring.productRepositoryImpl.productRepositoryImpl;

public class productRepositoryUpdate {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		productRepository productRepository = applicationContext.getBean("productRepositoryImpl",
				productRepositoryImpl.class);

		Product product = productRepository.listById(101);
		
		product.setName("bulgu");
		
		boolean sonuc =productRepository.update(product);
		if (sonuc) {
			System.out.println("UPDATED");
		}
		applicationContext.close();
	}
}
