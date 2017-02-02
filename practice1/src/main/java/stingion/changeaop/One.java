package stingion.changeaop;

import org.springframework.stereotype.Component;

@Component
public class One {
    @Memoize
    public Object obj(Object one) {
        return one;
    }
}
