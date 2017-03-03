package stingion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HelloWorldTest {

    @Test
    public void test() {
        int expected = 10;
        int actual = 101;
        assertNotEquals("Some value wasn't expected", expected, actual);
    }
}