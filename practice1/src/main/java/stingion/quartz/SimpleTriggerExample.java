package stingion.quartz;

/**
 * Created by ievgen on 9/17/14 2:18 PM.
 */
public class SimpleTriggerExample {

    public static void main( String[] args ) throws Exception
    {
        /*
        JobDetail job = new JobDetail();
        job.setName("dummyJobName");
        job.setJobClass(HelloJob.class);

        JobDetail job2 = new JobDetail();
        job2.setName("dummyJobName2");
        job2.setJobClass(HelloJob.class);

        //configure the scheduler time
        SimpleTrigger trigger = new SimpleTrigger();
        trigger.setName("simple1");
        trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        trigger.setRepeatInterval(3000);
        trigger.setEndTime(new Date(System.currentTimeMillis() + 25000));

        //configure the scheduler time
        SimpleTrigger trigger2 = new SimpleTrigger();
        trigger2.setName("simple2");
        trigger2.setStartTime(new Date(System.currentTimeMillis() + 1000));
        trigger2.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        trigger2.setRepeatInterval(4000);
        trigger2.setEndTime(new Date(System.currentTimeMillis() + 15000));

        //schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
        scheduler.scheduleJob(job2, trigger2);
        TimeUnit.SECONDS.sleep(7);
        scheduler.shutdown();*/
    }
}
