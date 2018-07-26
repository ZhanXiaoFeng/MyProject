
/**
* @Title: XMLToBeanValue.java
* @Package com.gxsfdx.study.transform
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月24日
* @version V1.0  
*/

package com.gxsfdx.study.transform;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gxsfdx.study.bean.BeanValue;

/**
 * @ClassName: XMLToBeanValue
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月24日
 */

public class XMLToBeanValue {
	public static BeanValue readXml(String filename) throws Exception {
		BeanValue bean = new BeanValue();
		Document document = init(filename);
		// <student>
		Element element = (Element) document.getChildNodes().item(0);
		String className = element.getAttribute("class");
		bean.setClassName(className);
		bean.setPropertyValues(getFiled(element));
		document = null;
		return bean;
	}

	private static Map<String, SimpleEntry<String, String>> getFiled(Element element) {
		Map<String, SimpleEntry<String, String>> map = new HashMap();
		NodeList nodeList = element.getChildNodes();
		System.out.println(nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node temp = nodeList.item(i);
			// 找到所有子节点下的value值
			if (temp.getNodeType() == Node.ELEMENT_NODE) {
				String strName = temp.getNodeName();
				// System.out.println(temp.getNodeName());
				Element name = (Element) temp;
				String sValue = getValue(name, "value");
				String sType = getValue(name, "type");
				map.put(strName, new SimpleEntry(sValue, sType));
			}
		}
		return map;
	}

	private static String getValue(Element name, String value) {
		String sValue = name.getAttribute(value);
		// 如果属性不存在，找子节点
		if (sValue == null || sValue.equals("")) {
			sValue = ((Element) name.getElementsByTagName(value).item(0)).getTextContent();
		}
		return sValue;
	}

	public static Document init(String fileName) throws ParserConfigurationException, SAXException, IOException {
		// 工厂模式
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 构建模式
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		// Class里边的getResourceAsStream("/");如果以/开头，就到啊classPath中找这个文件
		// &nbsp; &gt; &quot; "/student.xml"
		InputStream is = XMLToBeanValue.class.getResourceAsStream(fileName);
		Document document = documentBuilder.parse(is);
		return document;
	}

	// 数据类的对应类型转化
	public static Class stringToClass(String name) {
		Class c = null;
		switch (name) {
		case "byte":
			c = byte.class;
			break;
		case "short":
			c = short.class;
			break;
		case "int":
			c = int.class;
			break;
		case "long":
			c = long.class;
			break;
		case "char":
			c = char.class;
			break;
		case "boolean":
			c = boolean.class;
			break;
		case "double":
			c = double.class;
			break;
		case "float":
			c = float.class;
			break;
		default:
			try {
				c = Class.forName(name);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		return c;
	}

	public static Object string2Object(Class class1, String value) {
		Object obj = null;
		if (class1 == String.class) {
			obj = value;
		} else if (class1 == boolean.class || class1 == Boolean.class) {
			obj = Boolean.valueOf(value);
		} else if (class1 == char.class || class1 == Character.class) {
			obj = value.charAt(0);
		} else if (class1 == double.class || class1 == Double.class) {
			obj = Double.valueOf(value);
		} else if (class1 == float.class || class1 == Float.class) {
			obj = Float.valueOf(value);
		} else if (class1 == byte.class || class1 == Byte.class) {
			obj = Byte.valueOf(value);
		} else if (class1 == short.class || class1 == Short.class) {
			obj = Short.valueOf(value);
		} else if (class1 == int.class || class1 == Integer.class) {
			obj = Integer.valueOf(value);
		} else if (class1 == long.class || class1 == Long.class) {
			obj = Long.valueOf(value);
		}
		return obj;
	}
}
