package lrf.spring.proxy.proxyfactory;

import org.jspecify.annotations.Nullable;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-14 14:53
 */
public class LogAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("【afterReturning后置通知】方法 " + method.getName() + " 执行完成, 返回值: " + returnValue);
    }
}
