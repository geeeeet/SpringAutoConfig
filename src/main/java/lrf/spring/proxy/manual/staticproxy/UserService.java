package lrf.spring.proxy.manual.staticproxy;

/**
 * 定义接口
 *
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:34
 */
public interface UserService {
    void login(String username, String password);
    String getUserName(int id);
}
