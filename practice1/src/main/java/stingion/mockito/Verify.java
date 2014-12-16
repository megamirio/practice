package stingion.mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ievgen on 9/24/14 5:36 PM.
 */
public class Verify {
    public static void main(String[] args) {
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
        verify(mockedList).add("two");
    }
}
