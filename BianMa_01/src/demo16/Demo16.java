
/**  
* @Title: Demo16.java
* @Package demo16
* @Description: 易变业务使用脚本语言编写
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo16;

import java.io.FileReader;
import java.util.Scanner;
import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @ClassName: Demo16
 * @Description: 易变业务使用脚本语言编写
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo16 {
	public static void main(String[] args) throws Exception {
		// 获得一个 JavaScript 的执行引擎
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		// 建立上下文变量
		Bindings bind = engine.createBindings();
		bind.put("factor", 1);
		// 绑定上下文， 作用域是当前引擎范围
		engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int first = input.nextInt();
			int sec = input.nextInt();
			System.out.println(" 输入参数是： " + first + "," + sec);
			// 执行 js 代码
			engine.eval(new FileReader("c:/model.js"));
			// 是否可调用方法
			if (engine instanceof Invocable) {
				Invocable in = (Invocable) engine;
				// 执行 js 中的函数
				Double result = (Double) in.invokeFunction("formula", first, sec);
				System.out.println(" 运算结果： " + result.intValue());
			}
		}
	}
}
