
/**  
* @Title: Demo04_2.java
* @Package demo04
* @Description: 构造函数尽量简化
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo04;

/**
 * @ClassName: Demo04_2
 * @Description: 构造函数尽量简化
 * @author ZRF
 * @date 2018年6月23日
 */

public class Demo04_2 {
	public static void main(String[] args) {
		Server1 s = new SimpleServer1(1000);
		s.Start();
	}
}

// 定义一个服务
abstract class Server1 {
	public final static int DEFAULT_PORT = 40000;

	/**************************************/
	public void Start() {
		// 获得子类提供的端口号
		int port = getPort();
		System.out.println(" 端口号： " + port);
		/* 进行监听动作 */
	}

	/**************************************/

	// 由子类提供端口号， 并做可用性检查
	protected abstract int getPort();
}

class SimpleServer1 extends Server1 {
	private int port = 100;

	// 初始化传递一个端口号
	public SimpleServer1(int _port) {
		port = _port;
	}

	// 检查端口号是否有效， 无效则使用默认端口， 这里使用随机数模拟
	@Override
	protected int getPort() {
		return Math.random() > 0.5 ? port : DEFAULT_PORT;
	}
}