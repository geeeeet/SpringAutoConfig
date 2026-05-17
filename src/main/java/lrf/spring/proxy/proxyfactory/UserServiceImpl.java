package lrf.spring.proxy.proxyfactory;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-14 14:49
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName(int id) {
        System.out.println("目标方法执行: getUserName(" + id + ")");
        return "User-" + id;
    }

    @Override
    public void saveUser(String name) {
        System.out.println("目标方法执行: saveUser(" + name + ")");
    }
}
