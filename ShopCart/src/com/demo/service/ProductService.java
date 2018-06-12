package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.entity.Product;

public interface ProductService {
	// 添加商品
	public void addProduct(Product p) throws SQLException;

	// 查询所有商品
	public List<Product> findAll() throws SQLException;

	// 根据id查询商品
	public Product findProductById(String id) throws SQLException;

	// 修改商品
	public void editProduct(Product p) throws SQLException;

	// 删除选中
	public void delSelectById(String[] ids) throws SQLException;

	// 条件查找
	public List<Product> findByCondition(String id, String category, String name, String minPrice, String maxPrice)
			throws SQLException;

}