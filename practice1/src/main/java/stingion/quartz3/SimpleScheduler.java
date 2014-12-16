package stingion.quartz3;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by ievgen on 9/17/14 4:21 PM.
 */
public class SimpleScheduler {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("SimpleJob").build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("SimpleJob")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.getListenerManager().addJobListener(new SimpleJobListener());
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
