package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.AddrMapper;
import entity.Addr;
import service.AddrService;

/**
 * AddrService µœ÷¿‡
 * 
 * @author CETC
 *
 */
@Service("addrService")
public class AddrServiceImpl implements AddrService {

	@Autowired
	@Qualifier("addrMapper")
	private AddrMapper addrMapper;

	public AddrMapper getAddrMapper() {
		return addrMapper;
	}

	public void setAddrMapper(AddrMapper addrMapper) {
		this.addrMapper = addrMapper;
	}

	@Override
	public int insert(Addr addr) {
		return addrMapper.insert(addr);
	}

	@Override
	public int insertCondition(Addr addr) {
		return addrMapper.insertCondition(addr);
	}

	@Override
	public Addr selectById(int id) {
		return addrMapper.selectById(id);
	}

	@Override
	public List<Addr> selectAll() {
		return addrMapper.selectAll();
	}

	@Override
	public int updateByCondition(Addr addr) {
		return addrMapper.updateByCondition(addr);
	}

	@Override
	public int deleteById(int id) {
		return addrMapper.deleteById(id);
	}

	@Override
	public Addr selectByCustomerId(int customerId) {
		return addrMapper.selectByCustomerId(customerId);
	}

}
