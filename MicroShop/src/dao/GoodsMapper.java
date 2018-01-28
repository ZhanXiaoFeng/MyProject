package dao;

import java.util.List;

import entity.Goods;

public interface GoodsMapper {
	public Goods selectById(int id);

	public List<Goods> selectCondition(Goods goods);

	public int insert(Goods goods);

	public int delete(int id);

	public int updateCondition(Goods goods);
	
	public List<Goods> selectAll();
	
	public List<Goods> selectAllByCategory(Goods goods);
	
}
