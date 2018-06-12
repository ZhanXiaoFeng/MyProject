package service;

import java.util.List;

import entity.Pic;

public interface PicService {
	public Pic selectById(int id);

	public List<Pic> selectCondiction(Pic pic);

	public int insert(Pic pic);

	public int delete(int id);

	public int updateCondiction(Pic pic);

	public List<Pic> selectAll();

	public List<Pic> selectAllByCategory(Pic pic);

}
