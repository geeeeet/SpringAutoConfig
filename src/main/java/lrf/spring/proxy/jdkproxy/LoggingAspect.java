package lrf.spring.proxy.jdkproxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-13 10:00
 */
@Aspect // 标志成代理类，否则不会被Spring容器识别成代理类
@Component
public class LoggingAspect {

    /**
     * （1）value 属性
     * 一、execution(修饰符? 返回值类型 类路径.方法名(参数) throws异常?)
     * 其中：
     * 1、修饰符（可选）：如 public、private 等
     * 2、返回值类型（必填）：如 void、String、*（任意类型）
     * 3、类路径（必填）：完整的类名或接口名
     * 4、方法名（必填）：具体的方法名或使用 * 匹配所有方法
     * 5、参数（必填）：() 表示无参，(..) 表示任意参数
     * 6、异常（可选）：如 throws Exception
     *
     * 二、例子：
     * 无参数
     * execution(* Student.study())
     *
     * 一个任意类型的参数
     * execution(* Student.study(*))
     *
     * 两个参数，第一个是 String，第二个是任意类型
     * execution(* Student.study(String, *))
     *
     * 任意数量和类型的参数
     * execution(* Student.study(..))
     *
     * 至少一个参数，第一个是 String
     * execution(* Student.study(String, ..))
     *
     * 组合条件（与、或、非）、匹配 Student 的所有方法，但排除 toString() 方法
     * execution(* lrf.spring.proxy.jdkproxy.Student.*(..)) && !execution(* lrf.spring.proxy.jdkproxy.Student.toString(..))
     *
     * 三、除了 execution，还有其他指示符：
     * within: 匹配特定类或包中的所有方法
     * within(lrf.spring.proxy.jdkproxy.*)
     *
     * this: 匹配代理对象是指定类型的方法
     * this(lrf.spring.proxy.jdkproxy.Student)
     *
     * target: 匹配目标对象是指定类型的方法
     * target(lrf.spring.proxy.jdkproxy.Student)
     *
     * args: 匹配方法参数符合指定类型
     * args(String, ..)
     *
     * @annotation: 匹配带有特定注解的方法
     * @annotation(org.springframework.web.bind.annotation.GetMapping)
     *
     * （2）pointcut: 这是value的别名，优先级别value高，同时定义时，会优先使用pointcut。
     * 定义一个切入点，可以理解为匹配规则，匹配规则可以匹配方法，也可以匹配类，也可以匹配包，
     * 也可以匹配注解，也可以匹配属性，也可以匹配构造方法，也可以匹配方法
     *
     * （3）argNames: 指定参数名称，作用是匹配参数名称，并且可获取到参数值，必须与方法参数名称一致，否则会报错
     *
     * （4）returning：定义返回值的名称，可以获取到方法返回值，如果argNames也定义的话，必须与returning定义的名称一致，否则拿不到返回值
     * 当然，argNames可以省略不写。
     *
     * （5）throwing：定义异常的名称，可以获取到异常对象，如果argNames也定义的话，必须与throwing定义的名称一致，否则拿不到异常对象。
     */

    /**
     * JoinPoint：切入点对象，包含了被代理方法的相关信息，如方法名、参数等·
     * 它也可以拿到参数的值，也可以与argNames配合使用，获取到参数值。
     */

    /////////////////////////////////////// @Before ////////////////////////////////////////
    // 目标方法执行之前执行
    @Before(value = "execution(* lrf.spring.proxy.jdkproxy.Student.study())")
    //@Before(value = "execution(* Student.study())")
    public void before() {
        System.out.println("学习之前");
    }

    // @Before(value = "execution(* lrf.spring.proxy.jdkproxy.Student.study(String, int))")
    // //@Before(value = "execution(* Student.study(String, int))")
    // public void before(JoinPoint jp) {
    //     System.out.println("学习之前");
    //     System.out.println("方法: " + jp.getSignature().getName());
    //     System.out.println("方法所属类名称: " + jp.getSignature().getDeclaringTypeName());
    //     System.out.println("方法所属类: " + jp.getSignature().getDeclaringType());
    //     System.out.println("方法参数数量: " + jp.getArgs().length);
    //     System.out.println("方法参数值: " + java.util.Arrays.toString(jp.getArgs()));
    //     System.out.println("参数: " + jp.getArgs()[0] + ", " + jp.getArgs()[1]);
    //     System.out.println("连接点的类型: " + jp.getKind());
    //     System.out.println("连接点对象: " + (Student)jp.getThis());
    //     System.out.println("连接点对象: " + (Student)jp.getTarget());
    //     System.out.println("当前指示符: " + jp.getStaticPart());
    //     System.out.println("当前完整指示符（包含默认）: " + jp.toLongString());
    //     System.out.println("当前完整指示符（最短）: " + jp.toShortString());
    //     System.out.println("完整方法: " + jp.getSignature().toString());
    //     System.out.println("完整方法(包含默认): " + jp.getSignature().toLongString());
    //     System.out.println("完整方法(最短): " + jp.getSignature().toShortString());
    //
    // }

    @Before(value="execution(* Student.study(String, int)) && args(name,age)",argNames = "name,age")
    //@Before(value="execution(* Student.study(String, int)) && args(name,age)",argNames = "jp,name,age") // 可以把jp写进去，但是必须放在第一位
    public void before(JoinPoint jp, String name, int age) {
        System.out.println("方法: " + jp.getSignature().getName());
        System.out.println("方法所属类: " + jp.getSignature().getDeclaringTypeName());
        System.out.println("方法参数数量: " + jp.getArgs().length);
        System.out.println("方法参数值: " + java.util.Arrays.toString(jp.getArgs()));
        System.out.println("参数: " + name + ", " + age);
    }

    // 匹配所有Student类下的所有方法
    // @Before("execution(* lrf.spring.proxy.jdkproxy.Student.*(..))")
    // public void dobefore() {
    //     System.out.println("Student做这件事之前");
    // }

    // 匹配所有jdkproxy包下的所有方法
    // @Before("execution(* lrf.spring.proxy.jdkproxy.*.*(..))")
    // public void doallbefore() {
    //     System.out.println("做这件事之前");
    // }

    /////////////////////////////////////// @After ////////////////////////////////////////
    // 目标方法执行之后执行
    // @After("execution(* lrf.spring.proxy.jdkproxy.Student.study())")
    // public void after() {
    //     System.out.println("学习之后");
    // }

    @After(value="execution(* lrf.spring.proxy.jdkproxy.Student.study(String,int)) && args(name,age)",argNames = "name,age")
    public void after1(String name, int age) {
        System.out.println("学习之后参数: " + name + ", " + age);
    }

    @After(value="execution(* Student.study(String, int)) && args(name,age)",argNames = "name,age")
    public void after2(JoinPoint jp, String name, int age) {
        System.out.println("之后-方法: " + jp.getSignature().getName());
        System.out.println("之后-方法所属类: " + jp.getSignature().getDeclaringTypeName());
        System.out.println("之后-方法参数数量: " + jp.getArgs().length);
        System.out.println("之后-方法参数值: " + java.util.Arrays.toString(jp.getArgs()));
        System.out.println("之后-参数: " + name + ", " + age);
    }

    ////////////////////////////////////// @AfterReturning /////////////////////////////////////////

    // 目标方法返回之后执行
    @AfterReturning("execution(* lrf.spring.proxy.jdkproxy.Student.study())")
    public void afterReturn() {
        System.out.println("AfterReturning-学习之后");
    }

    @AfterReturning(value = "execution(* lrf.spring.proxy.jdkproxy.Student.study(String,int)) && args(name,age)",argNames = "name,age")
    public void afterReturn1(String name, int age) {
        System.out.println("AfterReturning-学习之后参数: " + name + ", " + age);
    }

    // 获取返回值（@AfterReturning 中使用 argNames）,returning = "result"必须与argNames = "result"一致，但argNames中的result可以省略，直接使用returning = "result"即可获取返回值
    @AfterReturning(value = "execution(* lrf.spring.proxy.jdkproxy.Student.study(String,int))",
            returning = "result"
            //,argNames = "result" // 可省略
    )
    public void afterReturn(Object result1) {
        System.out.println("AfterReturning-方法返回值: " + result1);
    }

    // 获取返回值（@AfterReturning 中使用 argNames）
    @AfterReturning(value = "execution(* lrf.spring.proxy.jdkproxy.Student.study(String,int)) && args(name,age)",
            returning = "result",
            argNames = "result,name,age") // 不能省略argNames
    public void afterReturn1(Object result1, String name, int age) {
        System.out.println("AfterReturning1-方法返回值: " + result1);
        System.out.println("AfterReturning1-方法返回值-学习之后参数: " + name + ", " + age);
    }

    //////////////////////////////////////// @AfterThrowing ///////////////////////////////////////
    // 抛出异常之后执行
    @AfterThrowing(value = "execution(* lrf.spring.proxy.jdkproxy.Student.studyEx())")
    public void afterThrowing() {
        System.out.println("AfterThrowing-学习之后抛异常");
    }

    @AfterThrowing(value = "execution(* lrf.spring.proxy.jdkproxy.Student.studyEx())",throwing = "ex"
            //,argNames = "ex" // 可省略，但写时必须与throwing = "ex"一致
    )
    public void afterThrowing1(Exception ex1) {
        System.out.println("AfterThrowing1-学习之后抛异常");
        System.out.println("AfterThrowing1-异常信息: " + ex1.getMessage());
    }

    //////////////////////////////////////// @AfterThrowing ///////////////////////////////////////
    /**
     * 该接口的作用是：在目标方法执行前后添加功能，ProceedingJoinPoint继承了JoinPoint，所以该接口也可以获取JoinPoint的所有属性和方法
     *
     * @param jp
     * @return
     */
    @Around("execution(* lrf.spring.proxy.jdkproxy.Student.study(String,int))")
    public Object around(ProceedingJoinPoint jp) {
        System.out.println("Around-学习之前");
        Object result = null;
        try {
            result = jp.proceed(); // 执行目标方法
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("Around-学习之后");
        return result;
    }

    /**
     * 测试this。play()失效的原因，是：AOP代理对象是JDK代理对象，JDK代理对象无法代理this，只能代理接口方法
     * @param jp
     * @return
     */
    @Around("execution(* lrf.spring.proxy.jdkproxy.Student.play())")
    public Object around1(ProceedingJoinPoint jp) {
        System.out.println("Around-玩之前");
        Object result = null;
        try {
            result = jp.proceed(); // 执行目标方法
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("Around-玩之后");
        return result;
    }


    //////////////////////////////////////// @Pointcut ///////////////////////////////////////
    // 定义一个切入点，匹配study(String,int)方法，并且获取参数值
    @Pointcut(value = "execution(* lrf.spring.proxy.jdkproxy.Student.study(String,int)) && args(name,age)")
    public void pointcut1(String name, int age){}

    @Before(value = "pointcut1(name,age)",argNames = "name,age")
    public void beforePointcut1(String name, int age) {
        System.out.println("@Pointcut-Before-切入点-学习之前参数: " + name + ", " + age);
    }

}
