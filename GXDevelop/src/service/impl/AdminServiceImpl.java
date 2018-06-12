package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.AdminMapper;
import entity.Admin;
import service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier("adminMapper")
	AdminMapper adminMapper;

	public AdminMapper getAdminMapper() {
		return adminMapper;
	}

	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public Admin login(Admin admin) {
		return adminMapper.login(admin);
	}

	@Override
	public Admin selectByCondition(int id) {
		return adminMapper.selectByCondition(id);
	}

	@Override
	public int updateById(Admin admin) {
		return adminMapper.updateById(admin);
	}

}
