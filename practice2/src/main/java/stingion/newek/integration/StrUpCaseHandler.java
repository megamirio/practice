package stingion.newek.integration;

/**
 * Created by royalflush on 09.12.16.
 */
public class StrUpCaseHandler {
    public String handler(String msg) {
        try {
//            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg.toUpperCase();
    }
}
