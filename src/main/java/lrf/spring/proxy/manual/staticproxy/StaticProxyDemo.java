package lrf.spring.proxy.manual.staticproxy;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:36
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        // 创建目标对象
        UserService target = new UserServiceImpl();

        // 创建代理对象
        UserService proxy = new UserServiceProxy(target);

        // 通过代理调用
        proxy.login("admin", "123456");
        System.out.println("-------------------");
        String name = proxy.getUserName(10086);
        System.out.println("最终返回: " + name);
    }
}
