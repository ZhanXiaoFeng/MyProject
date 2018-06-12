package dao;

import entity.Admin;

/**
 * 管理员数据访问层接口
 * 
 * @author CETC
 *
 */
public interface AdminMapper {

	// 管理员登录
	Admin login(Admin admin);

	// 查询个人信息
	Admin selectByCondition(int id);

	// 更新个人信息
	int updateById(Admin Admin);

}
