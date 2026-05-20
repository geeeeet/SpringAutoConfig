package lrf.spring.proxy.AspectAOP;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-20 14:55
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== 1. 触发类加载与实例化 ===");
        // 实例化会触发 staticinitialization, initialization 和 set/get
        Account account = new Account("6225-8888", 1000.0);

        System.out.println("\n=== 2. 模拟外部调用与控制流 ===");
        BankService bankService = new BankService();

        // 调用会触发 call 和 cflow 链路追踪
        bankService.executeVIPTransaction(account, 500.0);
    }
}
