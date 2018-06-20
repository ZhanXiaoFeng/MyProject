/** 

* <p>Title: Const.java</p>  

* <p>Description: 生成一个int型随机数 </p>  

* <p>Copyright: Copyright (c) 2018</p>  

* @author Administrator 

* @date 2018年6月20日  

* @version 1.0  

*/  

package demo02;

import java.util.Random;

/**  

* <p>Title: Const接口</p>  

* <p>Description:生成随机数 </p>  

* @author Administrator 

* @date 2018年6月20日  

*/
public interface Const {
	
	public static final int RAND_CONST = new Random().nextInt();

}
