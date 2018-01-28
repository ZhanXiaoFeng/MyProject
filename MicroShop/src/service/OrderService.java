package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	// 新建订单
	int insertOrder(Order order);

	// 查询订单
	List<Order> selectByPrimaryKey(int orderId);

	// 通过用户id查询全部订单记录
	Order selectAllByUserId(int userId);

	// 查找新插入的订单
	Order selectOrderByStatus(int status);

	// 更新订单
	int updateByPrimaryKeySelective(Order order);

	// 订单表删除
	int deleteByPrimaryKey(int id);

	Order selectOrderById(int orderId);

	// 根据订单ID更新订单的状态
	int updateOrderStatusById(Order order);

	// 查看购物车
	List<Order> showCartByCustidAndStatus(int orderId);
}
