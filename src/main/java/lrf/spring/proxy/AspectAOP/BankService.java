package lrf.spring.proxy.AspectAOP;

/**
 * 银行服务类
 *
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-05-20 14:53
 */
public class BankService {

    // 用于测试 cflow (控制流拦截)：此方法会触发一系列下游调用
    public void executeVIPTransaction(Account account, double amount) {
        System.out.println("====== [VIP业务开始] BankService.executeVIPTransaction ======");
        internalCheck(account);
        // 修改余额（会触发 set 拦截）
        account.setBalance(account.getBalance() + amount);
        System.out.println("====== [VIP业务结束] ======");
    }

    private void internalCheck(Account account) {
        System.out.println("   [BankService] 内部风控合规检查中...");
    }
}
