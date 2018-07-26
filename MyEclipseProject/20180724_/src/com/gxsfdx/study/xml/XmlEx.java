package com.gxsfdx.study.xml;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.gxsfdx.study.bean.BeanValue;
import com.gxsfdx.study.bean.Student;
import com.gxsfdx.study.transform.BeanValueToBean;
import com.gxsfdx.study.transform.XMLToBeanValue;

public class XmlEx {
	@Test
	public void testBean() throws Exception {
		BeanValueToBean beanValueToBean = new BeanValueToBean();
		Student stu = beanValueToBean.transform(XMLToBeanValue.readXml("/student.xml"));
		System.out.println(stu);
	}

	@Test
	public void test() {
		BeanValue bean = null;
		try {
			bean = XMLToBeanValue.readXml("/student.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(bean);
	}

	@Test
	public void testTriValue() {
		String s1 = "name";
		String t1 = "java.lang.String";
		String v1 = "zhangsan";

		String s2 = "height";
		String t2 = "double";
		String v2 = "166";

		String s3 = "sex";
		String t3 = "boolean";
		String v3 = "true";

		Map<String, SimpleEntry<String, String>> map = new HashMap<>();
		map.put(s1, new SimpleEntry(t1, v1));
		map.put(s2, new SimpleEntry(t2, v2));
		map.put(s3, new SimpleEntry(t3, v3));

		map.forEach((name, typeAndValue) -> System.out
				.println(name + "\t" + typeAndValue.getKey() + "\t" + typeAndValue.getValue()));
	}
}
