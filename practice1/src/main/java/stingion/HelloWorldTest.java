package stingion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ievgen on 8/3/14 6:02 PM.
 */
public class HelloWorldTest {

    @Test
    public void testGetHelloWorld() throws Exception {
        assertEquals("Hello World!", new HelloWorld().getHelloWorld());
    }
}

