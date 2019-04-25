package com.spring.productRepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.spring.Product.Product;
import com.spring.Repository.productRepository;
import com.spring.rowmapper.productRowMapper;

@Repository
public class productRepositoryImpl implements productRepository {

	JdbcTemplate jdbcTemplate;

	public boolean createProductTable() {

		String sqlQuery = "CREATE TABLE product(productId INT NOT NULL, name VARCHAR(20) , price DOUBLE , avaible INT , addTime DATETIME , PRIMARY KEY(productId) )";

		try {
			jdbcTemplate.execute(sqlQuery);

		} catch (RuntimeException e) {
			System.out.println("HATA :" + e);
			return false;
		}

		return true;

	}

	public boolean save(Product product) {

		String sqlQuery = "INSERT INTO product(productId,name,price,avaible,addTime) VALUES (?,?,?,?,?)";
		try {

			/*
			 * update(qury,arg) burda bir sql sorgusu ve product classından nesne yada
			 * nesneler istiyor object classı tüm sınıfların anası olduğu icin product
			 * nesnelerini buraya koyabiliriz..
			 */
			Object[] objects = new Object[] { product.getProductId(), product.getName(), product.getPrice(),
					product.getAvaible(), product.getAddTime() };

			jdbcTemplate.update(sqlQuery, objects);

		} catch (RuntimeException e) {
			System.out.println("HATA :" + e);
			return false;
		}
		return true;
	}

	public boolean saveBatch(final List<Product> products) {

		String sqlQuery = "INSERT INTO product(productId,name,price,avaible,addTime) VALUES (?,?,?,?,?)";

		try {

			jdbcTemplate.batchUpdate(sqlQuery, new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {

					Product product = products.get(i);
					ps.setInt(1, product.getProductId());
					ps.setString(2, product.getName());
					ps.setDouble(3, product.getPrice());
					ps.setInt(4, product.getAvaible());
					ps.setTimestamp(5, Timestamp.from(product.getAddTime().toInstant()));

				}

				public int getBatchSize() {

					return products.size();
				}
			});

		} catch (RuntimeException e) {
			System.out.println("HATA : " + e);
		}
		return true;
	}

	public Product listById(int id) {

		String sqlQeury = "SELECT * FROM product WHERE productId = ?";

		Product product = null;
		try {
			product = this.jdbcTemplate.queryForObject(sqlQeury, new Object[] { id }, new productRowMapper());
		} catch (RuntimeException e) {
			System.out.println("HATA :" + e);
		}
		return product;
	}

	public List<Product> findProducts() {

		String sqlQeury = "SELECT * FROM product";
		List<Product> products = null;
		try {
			products = this.jdbcTemplate.query(sqlQeury, new productRowMapper());

		} catch (Exception e) {
			// TODO: handle exception
		}
		return products;
	}

	public boolean update(final Product product) {
		String sqlQuery = "UPDATE product SET name = ? , price= ? , avaible = ? WHERE productId = ?";
		try {

			this.jdbcTemplate.update(sqlQuery, new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {

					ps.setString(1, product.getName());
					ps.setDouble(2, product.getPrice());
					ps.setInt(3, product.getAvaible());
					ps.setInt(4, product.getProductId());

				}
			});

		} catch (Exception e) {

			System.out.println("HATA :" + e);
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		
		String sqlQeury = "DELETE FROM product WHERE productId = ?";
		try {
			
			this.jdbcTemplate.update(sqlQeury, new Object[] {id});
			
		} catch (Exception e) {
			System.out.println("HATA :" + e);
			return false;
		}
		return true;
	}

	@Autowired
	public void dataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
}