
/**
* @Title: XmlEx.java
* @Package com.zrf.ex.xml
* @Description: xml文件使用
* @author ZRF
* @date 2018年7月24日
* @version V1.0  
*/

package com.zrf.ex.xml;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.zrf.ex.bean.Student;

/**
 * @ClassName: XmlEx
 * @Description: xml文件使用
 * @author ZRF
 * @date 2018年7月24日
 */

public class XmlEx {
	@Test
	public void readXml() throws Exception {
		// 工厂模式
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 构建模式
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		InputStream is = this.getClass().getResourceAsStream("/student.xml");
		Document document = documentBuilder.parse(is);
		Element element = (Element) document.getChildNodes().item(0);
		System.out.println(element.getNodeName() + "\t" + element.getNodeValue());

		// 获取zhangsan
		NodeList nodeList = element.getElementsByTagName("name");
		Element name = (Element) nodeList.item(0);
		String attr = name.getAttribute("value");
		System.out.println(attr);

		// 获取165
		NodeList nodeListHeight = element.getElementsByTagName("height");
		Element height = (Element) nodeListHeight.item(0);
		String text = height.getTextContent();
		System.out.println(text);

		// 获取165
		Text firstChild = (Text) height.getFirstChild();
		System.out.println(firstChild.getNodeValue().trim());
		System.out.println(firstChild.getWholeText());

		// 获取sex-->true
		NodeList nodeListSex = element.getElementsByTagName("sex");
		Element sex = (Element) nodeListSex.item(0);
		String text1 = sex.getTextContent();
		System.out.println(text1);

		Text lastChild = (Text) sex.getLastChild();
		System.out.println(lastChild.getNodeValue().trim());

		// 利用反射机制调用有参构造方法
		Class clazz = Class.forName("com.zrf.ex.bean.Student");
		// 调用构造函数
		Student s = (Student) clazz.newInstance();
		// 指定数据类型
		Constructor cons = clazz.getConstructor(String.class, double.class, boolean.class);
		Student s1 = (Student) cons.newInstance(attr, Double.parseDouble(text), Boolean.parseBoolean(text1));
		Stream.of(s1).forEach(System.out::println);
	}

	@Test
	public void testXmlReflect() throws Exception {
		Document document = init();
		Element element = (Element) document.getChildNodes().item(0);// student节点

		// 获取Class类
		// 得到com.zrf.ex.bean.Student
		String className = element.getAttribute("class");
		System.out.println("类名为：：" + className);

		// 获取名称-值-类型(name-zhangsan-java.lang.String)
		NodeList nameList = document.getElementsByTagName("name");
		Element item = (Element) nameList.item(0);
		String name = item.getNodeName();
		System.out.println("属性名称：：" + name);
		String nameValue = item.getElementsByTagName("value").item(0).getTextContent();
		System.out.println("属性值：：：" + nameValue);
		String nameType = item.getElementsByTagName("type").item(0).getTextContent();
		System.out.println("属性类型：：" + nameType);

		// 获取名称-值-类型(height-165-double)
		NodeList nameList1 = document.getElementsByTagName("height");
		Element item1 = (Element) nameList1.item(0);
		String height = item1.getNodeName();
		System.out.println("属性名称：：" + height);
		String heightValue = item1.getElementsByTagName("value").item(0).getTextContent();
		System.out.println("属性值：：：" + heightValue);
		String heightType = item1.getElementsByTagName("type").item(0).getTextContent();
		System.out.println("属性类型：：" + heightType);

		// 获取名称-值-类型(sex-true-boolean)
		NodeList nameList2 = document.getElementsByTagName("sex");
		Element item2 = (Element) nameList2.item(0);
		String sex = item2.getNodeName();
		System.out.println("属性名称：：" + sex);
		String sexValue = item2.getElementsByTagName("value").item(0).getTextContent();
		System.out.println("属性值：：：" + sexValue);
		String sexType = item2.getElementsByTagName("type").item(0).getTextContent();
		System.out.println("属性类型：：" + sexType);
	}

	/**
	 * @Title: init @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @return @param @throws
	 * ParserConfigurationException @param @throws SAXException @param @throws
	 * IOException 参数 @return Document 返回类型 @throws
	 */

	private Document init() throws ParserConfigurationException, SAXException, IOException {
		// 工厂模式
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 构建模式
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		InputStream is = this.getClass().getResourceAsStream("/student1.xml");
		Document document = documentBuilder.parse(is);
		return document;
	}
}
