package service;

import java.util.List;

import entity.Addr;

/**
 * AddrService服务层
 * 
 * @author CETC
 *
 */
public interface AddrService {
	// 添加地址信息
	int insert(Addr addr);
	//通过顾客ID查询地址
	Addr selectByCustomerId(int customerId);

	// 条件添加地址信息
	int insertCondition(Addr addr);

	// 通过id查询地址信息
	Addr selectById(int id);

	// 条件查询地址信息
	List<Addr> selectAll();

	// 条件更新地址信息
	int updateByCondition(Addr addr);

	// 删除地址信息
	int deleteById(int id);
}
