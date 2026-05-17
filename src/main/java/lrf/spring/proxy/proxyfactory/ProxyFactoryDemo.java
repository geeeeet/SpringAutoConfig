package lrf.spring.proxy.proxyfactory;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-14 14:55
 */
public class ProxyFactoryDemo {
    public static void main(String[] args) {

        // 创建目标对象
        UserService target = new UserServiceImpl();

        // 创建 ProxyFactory
        ProxyFactory factory = new ProxyFactory(target);   // 推荐方式：传入 target

        // 添加多个通知
        factory.addAdvice(new LogBeforeAdvice());
        factory.addAdvice(new LogAfterReturningAdvice());
        factory.addAdvice(new AroundAdvice());

        // 可选配置
        factory.setProxyTargetClass(false);   // false = JDK 动态代理（默认，推荐有接口时使用）
        // factory.setProxyTargetClass(true); // true = CGLIB 代理（对类代理）
        factory.setExposeProxy(true);         // 允许在目标方法中使用 AopContext.currentProxy()
        // factory.setFrozen(true);           // 冻结配置，提高性能

        // 获取代理对象
        UserService proxy = (UserService) factory.getProxy();

        // 调用代理方法
        String name = proxy.getUserName(100);
        System.out.println("最终结果: " + name);

        proxy.saveUser("张三");
    }
}
