
/**
* @Title: BeanValueToBean.java
* @Package com.gxsfdx.study.transform
* @Description: BeanValueToBean
* @author ZRF
* @date 2018年7月24日
* @version V1.0  
*/

package com.gxsfdx.study.transform;

import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Method;
import java.util.AbstractMap.SimpleEntry;
import com.gxsfdx.study.bean.BeanValue;
import com.gxsfdx.study.bean.Student;

/**
 * @ClassName: BeanValueToBean
 * @Description: BeanValueToBean
 * @author ZRF
 * @date 2018年7月24日
 */

public class BeanValueToBean {
	public Student transform(BeanValue beanValue) throws Exception {
		String className = beanValue.getClassName();
		Class clazz = Class.forName(className);
		Object target = clazz.newInstance();
		this.repair(clazz, target, beanValue.getPropertyValues());
		return (Student) target;
	}

	public void repair(Class clazz, Object obj, Map<String, SimpleEntry<String, String>> map) {
		map.forEach((name, pair) -> {
			String methodName = this.getMethodName(name);
			Class paramClass = XMLToBeanValue.stringToClass(pair.getValue());
			try {
				Method method = clazz.getMethod(methodName, paramClass);
				method.invoke(obj, XMLToBeanValue.string2Object(paramClass, pair.getKey()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public String getMethodName(String filed) {
		return "set" + StringUtils.capitalize(filed);
	}

}
