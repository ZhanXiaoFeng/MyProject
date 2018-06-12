package service;

import entity.Admin;

public interface AdminService {

	// 管理员登录
	Admin login(Admin admin);

	// 查询个人信息
	Admin selectByCondition(int id);

	// 更新个人信息
	int updateById(Admin admin);

}
