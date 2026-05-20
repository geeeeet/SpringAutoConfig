package lrf.spring.proxy.AspectAOP;

/**
 * 账户类
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-20 14:53
 */
public class Account {

    // 用于测试 get / set 拦截的字段
    private double balance;
    private String accountNo;

    // 用于测试 initialization / execution(new) 的构造器
    public Account(String accountNo, double initialBalance) {
        System.out.println("   [Account 构造器执行] 创建账户: " + accountNo);
        this.accountNo = accountNo;
        this.balance = initialBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

}
