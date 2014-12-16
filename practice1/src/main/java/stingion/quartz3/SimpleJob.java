package stingion.quartz3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by ievgen on 9/17/14 4:17 PM.
 */
public class SimpleJob implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("doing simple job. " + new Date());
    }
}
