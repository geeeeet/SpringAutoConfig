package lrf.spring.proxy.AspectAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-20 14:53
 */
@Aspect
public class AdvancedAspect {

    // =========================================================================
    // 绝技 1: staticinitialization — 静态代码块加载拦截 (Spring AOP ❌)
    // =========================================================================
    @Before("staticinitialization(lrf.spring.proxy.AspectAOP.Account)")
    public void beforeStaticInit(JoinPoint joinPoint) {
        System.out.println("[【绝技 1: staticinitialization】] 检测到 Account 类首次被 JVM 加载！");
    }

    // =========================================================================
    // 绝技 2: set — 属性赋值拦截 (Spring AOP ❌)
    // =========================================================================
    @Before("set(private double lrf.spring.proxy.AspectAOP.Account.balance) && args(newValue) && target(account)")
    public void beforeSetBalance(JoinPoint joinPoint, double newValue, Account account) {
        System.out.printf("[【绝技 2: set】] 拦截到属性直接赋值！目标对象：%s，旧余额：%s，试图写入的新值：%s\n",
                account, account.getBalance(), newValue);
    }

    // =========================================================================
    // 绝技 3: get — 属性读取拦截 (Spring AOP ❌)
    // =========================================================================
    @AfterReturning(pointcut = "get(private double lrf.spring.proxy.AspectAOP.Account.balance)", returning = "currentVal")
    public void afterGetBalance(JoinPoint joinPoint, double currentVal) {
        System.out.println("[【绝技 3: get】] 拦截到属性读取行为！当前读取到的值是: " + currentVal);
    }

    // =========================================================================
    // 绝技 4: call — 调用端拦截 (Spring AOP ❌)
    // =========================================================================
    // 拦截“谁在调用 BankService 的方法”，切面会织入到 Main 类的调用处
    @Before("call(* lrf.spring.proxy.AspectAOP.BankService.executeVIPTransaction(..))")
    public void beforeCall(JoinPoint joinPoint) {
        System.out.println("[【绝技 4: call】] 拦截到【外部调用点】！调用者正在发起交易，即将进入服务...");
    }

    // =========================================================================
    // 绝技 5: cflow — 控制流生命周期拦截 (Spring AOP ❌)
    // =========================================================================
    // 定义核心流切点：executeVIPTransaction 的执行
    @Pointcut("execution(* lrf.spring.proxy.AspectAOP.BankService.executeVIPTransaction(..))")
    public void vIPTxFlow() {}

    // 拦截：只要处于 VIP 交易流内部触发的【任何方法执行】（包括内部私有方法、其他类的方法）
    // 同时排除掉切面类自己，避免死循环
    //@Before("cflow(vIPTxFlow()) && !within(lrf.spring.proxy.AspectAOP.AdvancedAspect)")
    @Before("cflow(vIPTxFlow()) && execution(* *(..)) && within(lrf.spring.proxy..*) && !within(lrf.spring.proxy.AspectAOP.AdvancedAspect)")
    public void beforeAnyInsideFlow(JoinPoint joinPoint) {
        System.out.println("   -> [【绝技 5: cflow 追踪】] 捕获当前事务链深处的方法: " + joinPoint.getSignature().toShortString());
    }

    // =========================================================================
    // 绝技 6: initialization — 构造器初始化生命周期 (Spring AOP ❌)
    // =========================================================================
    @Before("initialization(lrf.spring.proxy.AspectAOP.Account.new(..))")
    public void beforeInit(JoinPoint joinPoint) {
        System.out.println("[【绝技 6: initialization】] 发现一个新账户正在初始化生命周期...");
    }
}
