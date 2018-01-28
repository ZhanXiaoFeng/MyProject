package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.GoodsMapper;
import entity.Goods;
import service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	@Qualifier("goodsMapper")
	private GoodsMapper goodsmapper;

	public GoodsMapper getGoodsmapper() {
		return goodsmapper;
	}

	public void setGoodsmapper(GoodsMapper goodsmapper) {
		this.goodsmapper = goodsmapper;
	}

	public Goods selectById(int id) {
		return goodsmapper.selectById(id);
	}

	public List<Goods> selectCondition(Goods goods) {
		return goodsmapper.selectCondition(goods);
	}

	public int insert(Goods goods) {
		return goodsmapper.insert(goods);
	}

	public int delete(int id) {
		return goodsmapper.delete(id);
	}

	public int updateCondition(Goods goods) {
		return goodsmapper.updateCondition(goods);
	}

	@Override
	public List<Goods> selectAll() {
		return goodsmapper.selectAll();
	}

	@Override
	public List<Goods> selectAllByCategory(Goods goods) {
		return goodsmapper.selectAllByCategory(goods);
	}

}
