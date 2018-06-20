/** 

* <p>Title: Demo03.java</p>  

* <p>Description: 三元操作符的类型务必一致</p>  

* <p>Copyright: Copyright (c) 2018</p>  

* @author Administrator 

* @date 2018年6月20日  

* @version 1.0  

*/  

package demo03;

/**  

* <p>Title: Demo03</p>  

* <p>Description:三元操作符的类型务必一致 </p>  

* @author Administrator 

* @date 2018年6月20日  

*/
public class Demo03 {
	
	public static void main(String[] args) {
		int i = 80;
		String s = String.valueOf(i<100?90:100);
		String s1 = String.valueOf(i<100?90:100.0);
		System.out.println(" 两者是否相等 :"+s.equals(s1));
		}

}
