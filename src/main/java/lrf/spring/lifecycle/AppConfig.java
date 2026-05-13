package lrf.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lirufeng
 * @version 1.0.0
 * @project SpringAutoConfig
 * @date 2026-01-30 09:37
 */
@Configuration
public class AppConfig {
    /**
     * 创建MyBean对象
     *
     * @return
     */
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public MyBean myBean() {
        MyBean bean = new MyBean();
        bean.setName("Test");
        return bean;
    }

}
