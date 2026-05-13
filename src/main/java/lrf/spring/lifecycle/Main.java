package lrf.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-01-30 09:38
 */
public class Main {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //MyBean bean = context.getBean(MyBean.class);
        //context.close();  // 触发销毁

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        MyBean bean = context.getBean(MyBean.class);
        context.close();  // 触发销毁
    }
}
