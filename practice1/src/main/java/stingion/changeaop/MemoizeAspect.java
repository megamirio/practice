package stingion.changeaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.WeakHashMap;

@Aspect
@Component
public class MemoizeAspect {
    private WeakHashMap<Object[], Object> cache = new WeakHashMap<Object[], Object>();

    @Around("@annotation(stingion.changeaop.Memoize)")
    public Object handledMemoize(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Handling memoize");
        Object[] args = pjp.getArgs();

        if (args != null) {
            Object response = cache.get(Arrays.asList(args));
            if (response != null) {
                return response;
            }
        }
        Object obj = pjp.proceed();
        if (args != null) {
            cache.put(args, obj);
        }
        return obj;
    }
}
