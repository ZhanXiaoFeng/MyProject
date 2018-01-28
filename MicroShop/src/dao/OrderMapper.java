package dao;

import java.util.List;

import entity.Order;

/**
 * 订单表
 * 
 * @author CETC
 *
 */
public interface OrderMapper {
	// 新建订单
	int insertOrder(Order order);

	// 条件新建订单
	int insertCondition(Order order);

	// 查找新插入的订单
	Order selectOrderByStatus(int status);

	// 通过订单id查询部分订单记录
	List<Order> selectByPrimaryKey(int id);

	// 通过用户id查询全部订单记录
	Order selectAllByUserId(int id);

	// 条件更新订单记录
	int updateByPrimaryKeySelective(Order order);

	// 订单表删除（15分钟内订单未付款，订单自动取消）
	int deleteByPrimaryKey(int id);
	
	Order selectOrderById(int orderId);

	// 根据订单ID更新订单的状态
	int updateOrderStatusById(Order order);
	
	//查看购物车
	List<Order> showCartByCustidAndStatus(int orderId);
}