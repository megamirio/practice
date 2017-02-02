package stingion.aoptrain;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

/**
 * Created by royalflush on 01.02.17.
 */
public class AnimalAdvice implements MethodInterceptor {

    private static Logger log = Logger.getLogger(AnimalAdvice.class);

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object retVal = invocation.proceed();

        StringBuilder sb = new StringBuilder();
        sb.append("Target Class:").append(invocation.getThis()).append("\n").append(invocation.getMethod()).append("\n");
        sb.append(" return value:").append(retVal).append("\n");
        log.info(sb.toString());
        return retVal;
    }
}
