package stingion.tdd;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by royalflush on 02.02.17.
 */
public class StringCalculatorTest {

    @Test(expected = RuntimeException.class)
    public void whenMoreThan2NumbersAreUsedThanThrownAnException() {
        StringCalculator.add("1,2,3");
    }

    @Test(expected = RuntimeException.class)
    public void whenLessThan2NumbersAreUsedThanThrownAnException() {
        StringCalculator.add("1");
    }

    @Test
    public void when2NumbersAreUsed() {
        StringCalculator.add("1,2");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }
}