package dao;

import java.util.List;

import entity.Category;

/**
 * 商品分类接口
 * 
 * @author CETC
 *
 */
public interface CategoryMapper {

	// 创建商品类别y
	int insert(Category category);

	// 条件创建商品类别y
	int insertCondition(Category category);

	// 通过id查看商品类别y
	Category selectById(int id);

	// 条件查看所有商品类别y
	List<Category> selectCondition();

	// 查看在集合内所有商品类别y
	List<Category> selectIn(int arry[]);
	
	// 查看商品类别y
	List<Category> selectAll();

	// 通过ID更新商品类别
	int updateById(Category category);

	// 通过id删除指定商品类别
	int deleteById(int id);
	
}