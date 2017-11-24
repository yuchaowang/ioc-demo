package ioc;

public class TestIoc {
	public static void main(String[] args) {
		BeanFacroty facroty = new BeanFacroty();
		facroty.init("beans.xml");
		FirstBean firstBean = (FirstBean) facroty.getBean("firstBean");
		System.out.println("name=" + firstBean.getBeanName());
		System.out.println("info=" + firstBean.getBeanInfo());
		System.out.println("message=" + firstBean.getBeanMessage());
		SecondBean secondBean = (SecondBean) facroty.getBean("secondBean");
		System.out.println("name=" + secondBean.getBeanName());
		System.out.println("info=" + secondBean.getBeanInfo());
		System.out.println("message=" + secondBean.getBeanMessage());

	}
}
