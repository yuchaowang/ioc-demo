package ioc;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFacroty {
	private Map<String, Object> beanMap = new HashMap<String, Object>();

	@SuppressWarnings({ "unchecked" })
	public void init(String xml) {
		try {
			SAXReader reader = new SAXReader();

			// 获取xml文件
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			InputStream ins = classLoader.getResourceAsStream(xml);

			// 解析xml
			Document doc = reader.read(ins);
			Element root = doc.getRootElement();
			Element ele;

			for (Iterator i = root.elementIterator("bean"); i.hasNext();) {
				ele = (Element) i.next();
				// 获取bean的属性id和class
				Attribute id = ele.attribute("id");
				Attribute cls = ele.attribute("class");
				// 通过class的名称获取Class对象
				Class bean = Class.forName(cls.getText());
				// 实例化对象
				Object obj = bean.newInstance();
				// 设置对象属性值
				for (Iterator ite = ele.elementIterator("property"); ite
						.hasNext();) {

					Element ele2 = (Element) ite.next();
					// 获取property的name
					Attribute name = ele2.attribute("name");
					String attributemane = "set" + name.getValue();
					String value = null;

					// 获取property的value
					for (Iterator ite1 = ele2.elementIterator("value"); ite1
							.hasNext();) {

						Element ele3 = (Element) ite1.next();
						value = ele3.getText();
						Method entryPoint = bean.getMethod(attributemane,
								String.class);
						entryPoint.invoke(obj, value);
						break;
					}
				}
				// 将对象放入beanMap中
				beanMap.put(id.getText(), obj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public Object getBean(String beanName) {
		Object obj = beanMap.get(beanName);
		return obj;
	}
}
