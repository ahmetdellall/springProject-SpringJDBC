package com.spring.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.spring.Product.Product;

public class productRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 int productId = rs.getInt(1);
		 String name =rs.getString(2);
		 double price = rs.getDouble(3);
		 int avaible = rs.getInt(4);
		 Date addtime = rs.getDate(5);
		 
		 Product product =new Product(productId, name, price, addtime, avaible);
		
		 return product;
	}

}
