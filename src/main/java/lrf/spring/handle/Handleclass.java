package lrf.spring.handle;

import lrf.spring.duty.DutyInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 实现Handleinter接口
 *
 * @author lirufeng
 e 2019/4/15 22:24
 */
@Component
public class Handleclass implements Handleinter {

    private DutyInter inter;

    @Autowired
    public Handleclass(DutyInter inter) {
        this.inter = inter;
    }

    @Override
    public void handleduty() {
        inter.say();
    }
}
