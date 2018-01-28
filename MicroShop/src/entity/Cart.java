package entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车模块购物车类
 * @author tiger
 *
 */
public class Cart {
	
	// 条目集合：map集合，便于移除，key：pid，value：CartItem
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
		
	// 得到CartItem集合：方便显示
	/*public Collection<CartItem> getCartItems() {
		return map.values();
	}
	*/
	
	
	
	//总计
	private double total;
	
	public double getTotal() {
		return total;
	}
	
	//购物车功能
	//1. 将购物条目添加到购物车
	public void addCart(CartItem cartItem) {
		// 判断该类商品是否已存在
		// 存在，数量，和小计累加(小计自动累加),累加总计
		// 不存在，添加新条目，累加总计
		Integer gid = cartItem.getGoods().getId();
		
	if (map.containsKey(gid)) {
			CartItem _cartItem = map.get(gid);							// 得到已存在条目
			int count = cartItem.getCount() + _cartItem.getCount();  			// 累加数量
			_cartItem.setCount(count);
		} else {
			map.put(gid, cartItem);
		}
		
		/* if(map.containsKey(gid)) {//判断原来车中是否存在该条目
	            CartItem _cartItem = map.get(gid);//返回原条目
	            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());//设置老条目的数量为，其自己数量+新条目的数量
	            map.put(cartItem.getGoods().getId(), _cartItem);
	        } else {
	            map.put(cartItem.getGoods().getId(),cartItem);
	        }*/
		total += cartItem.getSubtotal();
	}
	
	
	//2. 删除购物条目
	public void removeCartItem(Integer gid) {
		CartItem cartItem = map.remove(gid);	// 删除条目
		total -= cartItem.getSubtotal();			// 减去删除条目的小计
	}
	
	//3. 清除购物车
	public void clearCart() {
		map.clear();							// 清除购物车
		total = 0;									//总计设置为0
	}
	
	public Collection<CartItem> getCartItems() {
        return map.values();
    }
}
