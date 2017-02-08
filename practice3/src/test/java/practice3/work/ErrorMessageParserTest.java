package practice3.work;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by royalflush on 08.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testContext.xml")
public class ErrorMessageParserTest {

    @Test
    public void testReturnNull() {
    }

    @Test
    public void testReturnInvalidCVV2() {
    }

}