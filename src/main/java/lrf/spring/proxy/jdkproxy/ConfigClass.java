package lrf.spring.proxy.jdkproxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * java配置类
 *
 * @author lirufeng
 * @date 2026-05-13 09:51
 */
@Configuration
@ComponentScan(basePackages = "lrf.spring.proxy.jdkproxy")
//@EnableAspectJAutoProxy(proxyTargetClass = false) // 表示开启动态代理，proxyTargetClass = false使用JDK动态代理，proxyTargetClass = true使用CGLIB动态代理
@EnableAspectJAutoProxy(exposeProxy = true) // expose-proxy=true 会使用 ThreadLocal 存放代理对象，会有轻微性能损耗。不是全局都要开启，只在需要内部自调用的地方使用即可。
public class ConfigClass {
}