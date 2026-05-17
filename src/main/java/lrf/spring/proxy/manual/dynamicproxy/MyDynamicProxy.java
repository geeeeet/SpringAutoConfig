package lrf.spring.proxy.manual.dynamicproxy;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:47
 */
import java.lang.reflect.Method;

public class MyDynamicProxy implements UserService {

    private final Object target;                    // 目标对象
    private final MyInvocationHandler handler;      // 自定义处理器

    public MyDynamicProxy(Object target, MyInvocationHandler handler) {
        this.target = target;
        this.handler = handler;
    }

    // ====================== 代理方法 ======================

    @Override
    public void login(String username, String password) {
        invokeMethod("login", new Class[]{String.class, String.class}, new Object[]{username, password});
    }

    @Override
    public String getUserName(int id) {
        return (String) invokeMethod("getUserName", new Class[]{int.class}, new Object[]{id});
    }

    @Override
    public void logout() {
        invokeMethod("logout", new Class[]{}, new Object[]{});
    }

    /**
     * 统一反射调用 + 经过 handler
     */
    private Object invokeMethod(String methodName, Class<?>[] paramTypes, Object[] args) {
        try {
            Method method = target.getClass().getMethod(methodName, paramTypes);

            // 通过 handler 执行（这里可以加入前置、后置、异常处理等）
            return handler.invoke(this, method, args);

        } catch (Throwable e) {
            throw new RuntimeException("代理调用失败", e);
        }
    }
}
