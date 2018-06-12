package service;

import java.util.List;

import entity.Category;

public interface CategoryService {

	/*
	 * 插入商品类别
	 */
	int insert(Category category);

	/*
	 * 条件创建商品类别
	 */
	int insertCondition(Category category);

	/*
	 * 通过id查看商品类别
	 */
	Category selectById(int id);

	/*
	 * 条件查看所有商品类别
	 */
	List<Category> selectCondition();

	/*
	 * 查看在集合内所有商品类别
	 */
	List<Category> selectIn(int[] arry);

	/*
	 * 查看商品类别
	 */
	List<Category> selectAll();

	/*
	 * 通过ID更新商品类别
	 */
	int updateById(Category category);

	/*
	 * 通过id删除指定商品类别
	 */
	int deleteById(int id);

}
