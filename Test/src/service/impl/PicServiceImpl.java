package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.PicMapper;
import entity.Pic;
import service.PicService;

@Service("picService")
public class PicServiceImpl implements PicService {

	@Autowired
	@Qualifier("picMapper")
	private PicMapper picMapper;

	public PicMapper getPicMapper() {
		return picMapper;
	}

	public void setPicMapper(PicMapper picMapper) {
		this.picMapper = picMapper;
	}

	@Override
	public Pic selectById(int id) {
		return picMapper.selectById(id);
	}

	@Override
	public List<Pic> selectCondiction(Pic pic) {
		return picMapper.selectCondiction(pic);
	}

	@Override
	public int insert(Pic pic) {
		return picMapper.insert(pic);
	}

	@Override
	public int delete(int id) {
		return picMapper.delete(id);
	}

	@Override
	public int updateCondiction(Pic pic) {
		return picMapper.updateCondiction(pic);
	}

	@Override
	public List<Pic> selectAll() {
		return picMapper.selectAll();
	}

	@Override
	public List<Pic> selectAllByCategory(Pic pic) {
		return picMapper.selectAllByCategory(pic);
	}

}
