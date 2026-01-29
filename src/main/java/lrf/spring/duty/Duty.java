package lrf.spring.duty;

import org.springframework.stereotype.Component;

/**
 * 实现DutyInter接口
 *
 * @author lirufeng
 * @date 2019/4/15 22:21
 */
@Component
public class Duty implements DutyInter {

    @Override
    public void say() {
        System.out.println("I am Interface1");
    }
}
