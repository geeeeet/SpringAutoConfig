package lrf.spring.proxy.manual.dynamicproxy;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:46
 */
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        System.out.println("【真实对象】用户登录: " + username);
    }

    @Override
    public String getUserName(int id) {
        System.out.println("【真实对象】查询用户: " + id);
        return "李四";
    }

    @Override
    public void logout() {
        System.out.println("【真实对象】用户退出登录");
    }
}