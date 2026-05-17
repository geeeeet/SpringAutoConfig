package lrf.spring.proxy.manual.staticproxy;

/**
 * 代理类（手工实现代理逻辑）
 *
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:35
 */
public class UserServiceProxy implements UserService {

    // 持有目标对象
    private final UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void login(String username, String password) {
        // 前置增强
        System.out.println("【代理前置】记录登录日志 - " + username);
        long start = System.currentTimeMillis();

        try {
            // 调用目标方法
            target.login(username, password);
        } finally {
            // 后置增强
            long end = System.currentTimeMillis();
            System.out.println("【代理后置】登录耗时: " + (end - start) + "ms");
        }
    }

    @Override
    public String getUserName(int id) {
        System.out.println("【代理前置】权限校验 - 用户ID: " + id);

        String result = target.getUserName(id);

        System.out.println("【代理后置】查询结果: " + result);
        return result;
    }
}
