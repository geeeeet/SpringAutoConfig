package lrf.spring.proxy.proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jspecify.annotations.Nullable;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-14 14:54
 */
public class AroundAdvice implements MethodInterceptor {
    @Override
    public @Nullable Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("【环绕通知】Before: " + invocation.getMethod().getName());
        long start = System.currentTimeMillis();

        Object result = invocation.proceed();   // 执行目标方法

        long end = System.currentTimeMillis();
        System.out.println("【环绕通知】After: " + invocation.getMethod().getName() + ", 耗时: " + (end - start) + "ms");
        return result;
    }
}
