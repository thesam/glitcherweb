package se.timberline.glitcher;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.timberline.glitcher.domain.Glitcher;
import se.timberline.glitcher.persistence.JpaGlitcherDao;

// added comment

public class Main {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"META-INF/spring/app-context.xml");
//		Greeter g = (Greeter) factory.getBean("greeter");
//		g.greet();
		Glitcher g = (Glitcher) factory.getBean("glitcher");
		GlitcherDao dao = (JpaGlitcherDao) factory.getBean("glitcherDao");
		dao.addGlitcher(g);
	}
}
