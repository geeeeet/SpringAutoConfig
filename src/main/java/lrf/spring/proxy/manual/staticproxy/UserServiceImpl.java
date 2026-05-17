package lrf.spring.proxy.manual.staticproxy;

/**
 * 目标类（被代理的真实对象）
 *
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:34
 */
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        System.out.println("【目标方法】用户登录: " + username);
        // 模拟业务逻辑
    }

    @Override
    public String getUserName(int id) {
        System.out.println("【目标方法】查询用户ID: " + id);
        return "张三";
    }
}