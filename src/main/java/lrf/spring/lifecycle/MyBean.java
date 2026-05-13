package lrf.spring.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-01-30 09:36
 */
public class MyBean implements InitializingBean, DisposableBean,
        BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private String name;

    // 构造器
    public MyBean() {
        System.out.println("1. 实例化: Constructor");
    }

    // 属性注入（setter）
    public void setName(String name) {
        this.name = name;
        System.out.println("2. 属性注入: setName");
    }

    // Aware 接口
    @Override
    public void setBeanName(String name) {
        // 获取到bean名称
        System.out.println("3. Aware: setBeanName - " + name);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // 获取到bean工厂
        System.out.println("3. Aware: setBeanFactory");
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 获取到ApplicationContext
        System.out.println("3. Aware: setApplicationContext");
    }

    // 初始化阶段

    /**
     * 建议使用，不与Spring耦合
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("4.1. 初始化: @PostConstruct");
    }

    /**
     * 不建议使用，与Spring耦合，因为我们定义的bean需要实现InitializingBean接口
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("4.2 初始化: afterPropertiesSet");
    }

    /**
     * 建议使用，不与Spring耦合
     */
    public void initMethod() {
        System.out.println("4.3 初始化: init-method");
    }

    // 销毁阶段

    /**
     * 建议使用，不与Spring耦合
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("5.1 销毁: @PreDestroy");
    }

    /**
     * 不建议使用，与Spring耦合，因为我们定义的bean需要实现DisposableBean接口
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("5.2 销毁: destroy");
    }
    /**
     * 建议使用，不与Spring耦合
     */
    public void destroyMethod() {
        System.out.println("5.3 销毁: destroy-method");
    }

}
