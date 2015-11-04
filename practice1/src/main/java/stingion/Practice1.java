package stingion;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;

/**
 * Created by ievgen on 8/8/14 9:19 AM.
 */
public class Practice1 {

    Logger log = Logger.getLogger(Practice1.class);

    public static void main(String[] args) {
        String[] args1 = {"a", "b", "abc"};
        String str = String.format("ABC %s = %s : %s", args1);
        System.out.println(str);
        Practice1 p = new Practice1();
        p.print();
        p.pushNDCContext();
        p.print();
        String arg1 = NDC.pop();
        System.out.println("arg1 = " + arg1);
        p.print();
        NDC.pop();
        p.pushMDCContext();
        p.print();
        MDC.get("key1");
        p.print();
        MDC.get("key3");
        MDC.get("key2");
        MDC.remove("key3");
        MDC.remove("key2");
        MDC.clear();
        p.print();
    }

    void pushNDCContext() {
        NDC.push("one");
        NDC.push("two");
    }

    void pushMDCContext() {
        MDC.put("key1", "value1");
        MDC.put("key2", "value2");
    }

    void print() {
        log.info("Tell me why why why");
    }
}
