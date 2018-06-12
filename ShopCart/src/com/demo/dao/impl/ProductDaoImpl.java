package com.demo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.ProductDao;
import com.demo.entity.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void addProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delSelectById(String[] ids) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> findByCondition(String id, String category, String name, String minPrice, String maxPrice)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
