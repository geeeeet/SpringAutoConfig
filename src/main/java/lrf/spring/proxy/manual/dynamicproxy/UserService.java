package lrf.spring.proxy.manual.dynamicproxy;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:46
 */
public interface UserService {
    void login(String username, String password);
    String getUserName(int id);
    void logout();
}
