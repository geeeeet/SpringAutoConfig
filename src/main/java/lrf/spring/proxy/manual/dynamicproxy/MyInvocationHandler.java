package lrf.spring.proxy.manual.dynamicproxy;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-15 11:47
 */
import java.lang.reflect.Method;

@FunctionalInterface
public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
