package lrf.spring.proxy.jdkproxy;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-13 09:45
 */
@Component
public class MaleStudent implements Student {

    @Override
    public void study() {
        System.out.println("I am Student, I am studying");
    }

    @Override
    public void studyEx() {
        System.out.println("学习过程抛异常了");
        int i =1/0;
    }

    @Override
    public String study(String name, int age) {
        System.out.println("I am "+name+" I am "+age);

        // 直接使用 this调用方法是不会触发代理的逻辑的，因为this在这里只是原始对象，不是代理对象。
        //this.play();

        // 解决this失效的方法是，@EnableAspectJAutoProxy(exposeProxy = true) ，关键在这里！
        // 正确写法：通过代理对象调用
        Student proxy = (Student) AopContext.currentProxy(); // 必须强制转换为接口类型（Student），不能转实现类（MaleStudent），因为 JDK 动态代理只能转接口。
        proxy.play();

        return "study finished";
    }

    @Override
    public String eat() {
        System.out.println("我在吃东西");
        return "吃完了";
    }

    @Override
    public void sleep() {

    }

    @Override
    public void play() {
        System.out.println("我在玩");
    }

}
