package dao;

import java.util.List;

import entity.Category;

public interface CategoryMapper {
	// 创建商品类别y
	public int insert(Category category);

	// 条件创建商品类别y
	public int insertCondition(Category category);

	// 通过id查看商品类别y
	public Category selectById(int id);

	// 条件查看所有商品类别y
	public List<Category> selectCondition();

	// 查看在集合内所有商品类别y
	public List<Category> selectIn(int arry[]);

	// 查看商品类别y
	public List<Category> selectAll();

	// 通过ID更新商品类别
	public int updateById(Category category);

	// 通过id删除指定商品类别
	public int deleteById(int id);

}
