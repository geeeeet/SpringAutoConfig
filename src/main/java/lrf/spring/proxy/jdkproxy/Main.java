package lrf.spring.proxy.jdkproxy;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-13 09:52
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigClass.class);
        context.refresh();
        Student student = context.getBean(Student.class);
        //student.study();
        student.study("lrf", 18);
        //student.studyEx();

        System.out.println("\n---查看代理对象信息---");

        System.out.println("是否是代理对象：" + AopUtils.isAopProxy(student));           // true
        System.out.println("是否是 JDK 代理：" + AopUtils.isJdkDynamicProxy(student));   // true
        System.out.println("是否是 CGLIB 代理：" + AopUtils.isCglibProxy(student));     // false

        // 可以强转成 Advised，查看内部配置
        Advised advised = (Advised) student;
        System.out.println("目标类：" + advised.getTargetClass());
        System.out.println("通知数量：" + advised.getAdvisors().length);

    }
}
