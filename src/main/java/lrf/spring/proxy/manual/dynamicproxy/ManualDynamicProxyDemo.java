package lrf.spring.proxy.manual.dynamicproxy;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:48
 */
public class ManualDynamicProxyDemo {
    public static void main(String[] args) {

        UserService target = new UserServiceImpl();

        // 创建自定义处理器（类似 JDK 的 InvocationHandler）
        MyInvocationHandler handler = (proxy, method, args1) -> {
            String methodName = method.getName();

            System.out.println("【代理前置】即将调用方法: " + methodName);
            long start = System.currentTimeMillis();

            try {
                // 执行目标方法
                Object result = method.invoke(target, args1);

                System.out.println("【代理后置】方法 " + methodName + " 执行完成");
                return result;
            } catch (Exception e) {
                System.out.println("【代理异常】方法 " + methodName + " 执行失败");
                throw e;
            } finally {
                long end = System.currentTimeMillis();
                System.out.println("【耗时统计】" + methodName + " 耗时: " + (end - start) + "ms\n");
            }
        };

        // 创建动态代理对象
        UserService proxy = new MyDynamicProxy(target, handler);

        // 调用代理
        proxy.login("admin", "123456");
        proxy.getUserName(10086);
        proxy.logout();
    }
}