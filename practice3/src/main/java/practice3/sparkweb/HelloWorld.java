package practice3.sparkweb;

import spark.Service;

import java.util.concurrent.TimeUnit;

import static spark.Spark.get;
import static spark.Spark.stop;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {

        Service service = Service.ignite();
        service.port(4555);
        service.init();
        service.get("/hello", (rq, rs) -> "Hello world!");

        Thread.sleep(5000);
        System.out.println("Stopped");
        service.stop();

//        get("/hello", (rq, rs) -> "Hello world!");
//        get("/hello/:name", (request, response) -> {
//            System.out.println(request.params("name"));
//            return "Hello: " + request.params(":name");
//        });
//        stop();
    }
}
