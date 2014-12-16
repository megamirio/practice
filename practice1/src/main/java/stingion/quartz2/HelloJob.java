package stingion.quartz2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by ievgen on 9/17/14 3:30 PM.
 */
public class HelloJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("Hello Quartz! 123");

        //Throw exception for testing
        throw new JobExecutionException("Testing Exception");
    }
}
