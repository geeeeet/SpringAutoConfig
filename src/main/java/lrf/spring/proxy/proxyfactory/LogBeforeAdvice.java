package lrf.spring.proxy.proxyfactory;

import org.jspecify.annotations.Nullable;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-14 14:49
 */
public class LogBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("【前置通知】调用方法: " + method.getName() + ", 参数: " + Arrays.toString(args));
    }
}
