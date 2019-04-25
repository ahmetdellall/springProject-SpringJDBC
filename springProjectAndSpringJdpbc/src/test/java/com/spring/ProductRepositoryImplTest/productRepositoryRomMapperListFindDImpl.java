package com.spring.ProductRepositoryImplTest;

import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Product.Product;
import com.spring.Repository.productRepository;
import com.spring.productRepositoryImpl.productRepositoryImpl;

public class productRepositoryRomMapperListFindDImpl {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		productRepository productRepository = applicationContext.getBean("productRepositoryImpl",
				productRepositoryImpl.class);

		List<Product> products =productRepository.findProducts();
		
		for (Product product : products) {
			
			System.out.println(product.getName() +" "+product.getPrice() +" "+ product.getAvaible() +" "+ product.getProductId()+ " "+ product.getAddTime());
		}

		applicationContext.close();
	}

}
