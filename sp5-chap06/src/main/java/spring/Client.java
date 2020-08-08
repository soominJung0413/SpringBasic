package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Client implements InitializingBean, DisposableBean {

	private String host;

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client의 afterPropertiesSet() 실행");
	}

	public void send() {
		System.out.println("Cilent.send() to " + host);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Client의 destory() 실행");
	}

}
