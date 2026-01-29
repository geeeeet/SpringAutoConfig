import lrf.spring.config.ConfigClass;
import lrf.spring.handle.Handleinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigClass.class)
public class AutoConfigTest {

    @Autowired
    Handleinter handleinter;

    /**
     * 测试是否创建了Handleinter bean
     */
    @Test
    public void test() {
        assertNotNull(handleinter);
    }

    /**
     * 测试调用方法
     */
    @Test
    public void test1() {
        handleinter.handleduty();
    }
}
