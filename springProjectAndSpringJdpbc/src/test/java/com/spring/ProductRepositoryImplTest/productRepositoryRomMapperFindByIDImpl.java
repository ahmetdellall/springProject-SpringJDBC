package com.spring.ProductRepositoryImplTest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Product.Product;
import com.spring.Repository.productRepository;
import com.spring.productRepositoryImpl.productRepositoryImpl;

public class productRepositoryRomMapperFindByIDImpl {

	public static void main(String[] args) {
		
ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		productRepository productRepository =applicationContext.getBean("productRepositoryImpl", productRepositoryImpl.class);
		
		Product product =productRepository.listById(101);
		System.out.println("BULUNAN PRODUCT"+ " "+product.getName()+" "+product.getProductId()+" "+product.getPrice()+" "+product.getAvaible()+" "+product.getAddTime());
		
		applicationContext.close();
	}
}
