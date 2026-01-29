package lrf.spring.main;

import lrf.spring.config.ConfigClass;
import lrf.spring.handle.Handleinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring自动配置
 *
 * @author lirufeng
 * @date 2019/4/15 22:42
 */
public class MainClass {

    public static void main(String[] args) {
        /**
         * 这是通过java配置创建的Spring上下文
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        Handleinter h = context.getBean(Handleinter.class);
        h.handleduty();

        /**
         * 这是通过xml配置创建的Spring上下文
         */
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("classpath:Spring.xml");
        Handleinter h1 = context1.getBean(Handleinter.class);
        h1.handleduty();
    }
}
