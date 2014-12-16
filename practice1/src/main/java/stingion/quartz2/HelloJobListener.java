package stingion.quartz2;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Created by ievgen on 9/17/14 3:32 PM.
 */
public class HelloJobListener implements JobListener {

    public static final String LISTENER_NAME = "dummyJobListenerName";

    @Override
    public String getName() {
        return LISTENER_NAME; //must return a name
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {

        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("jobToBeExecuted");
        System.out.println("Job : " + jobName + " is going to start...");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("jobExecutionVetoed");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("jobWasExecuted");

        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("Job : " + jobName + " is finished...");

        if (!jobException.getMessage().equals("")) {
            System.out.println("Exception thrown by: " + jobName + " Exception: " + jobException.getMessage());
        }

    }
}
