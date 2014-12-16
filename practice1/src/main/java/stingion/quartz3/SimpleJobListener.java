package stingion.quartz3;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

import java.util.Date;

/**
 * Created by ievgen on 9/17/14 4:19 PM.
 */
public class SimpleJobListener implements JobListener {

    public String getName() {
        return "SimpleJobListener";
    }

    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("jobToBeExecuted has execute. " + new Date());
    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("jobExecutionVetoed has execute. " + new Date());
    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("jobWasExecuted has execute. " + new Date() + "\r\n");
    }
}
