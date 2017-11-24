package ioc;

public class FirstBean {
	private String beanName = "firstBean";
	private String beanInfo;
	private String beanMessage;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanInfo() {
		return beanInfo;
	}

	public void setBeanInfo(String beanInfo) {
		this.beanInfo = beanInfo;
	}

	public String getBeanMessage() {
		return beanMessage;
	}

	public void setBeanMessage(String beanMessage) {
		this.beanMessage = beanMessage;
	}

}
