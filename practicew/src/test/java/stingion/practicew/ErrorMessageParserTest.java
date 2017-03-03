package stingion.practicew;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by royalflush on 08.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testingContext.xml")
public class ErrorMessageParserTest {

    @Autowired
    private String one;

    @Test
    public void testReturnNull() {
        Assert.assertTrue(one.length() > 0);
        Assert.assertTrue(one.length() > 10);
    }

    @Test
    public void testReturnInvalidCVV2() {
    }

}