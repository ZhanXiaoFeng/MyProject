package com.demo.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.ProductDao;
import com.demo.entity.Product;
import com.demo.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao dao = new ProductDao();

	// 添加商品
	public void addProduct(Product p) throws SQLException {

		try {
			dao.addProduct(p);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加商品失败");
		}
	}

	// 查询所有商品
	public List<Product> findAll() throws SQLException {
		return dao.findAll();
	}

	// 根据id查询商品
	public Product findProductById(String id) throws SQLException {
		return dao.findProductById(id);
	}

	// 修改商品
	public void editProduct(Product p) throws SQLException {
		dao.editProduct(p);
	}

	// 删除选中
	public void delSelectById(String[] ids) throws SQLException {
		dao.delSelectById(ids);
	}

	// 条件查找
	public List<Product> findByCondition(String id, String category, String name, String minPrice, String maxPrice)
			throws SQLException {

		return dao.findByCondition(id, category, name, minPrice, maxPrice);
	}

}
