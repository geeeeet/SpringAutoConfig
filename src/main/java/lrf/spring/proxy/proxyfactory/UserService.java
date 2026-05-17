package lrf.spring.proxy.proxyfactory;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-14 14:48
 */
public interface UserService {

    String getUserName(int id);
    void saveUser(String name);

}
