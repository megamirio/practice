package stingion.mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

/**
 * Created under not commercial project
 */
@RunWith(MockitoJUnitRunner.class)
public class InjTest {
    @Mock
    private List obj1;
    @Mock
    private Date obj2;

    @Spy
    private Some some;

    @Spy
    private ToInj toInj;

    @InjectMocks
    private Inj inj;

    @Before
    public void init() {
        //MockitoAnnotations.initMocks(this);
        when(some.exec(anyObject())).thenThrow(new RuntimeException("no"));
        //doThrow(new RuntimeException()).when(inj).ok();
    }

    @Test
    public void test(){
        some.exec(new Date());
        inj.ok();
    }
}

