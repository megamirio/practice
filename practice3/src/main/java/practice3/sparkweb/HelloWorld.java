package practice3.sparkweb;

import practice3.Streamer;
import spark.Service;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {

        Service service = Service.ignite();
        service.port(4555);
        service.init();
        service.get("/hello", (rq, rs) -> {
            rs.header("val15", "15");
            rs.header("val18", "18");
            System.out.println(rq.headers("val15"));
            rs.body("abc !!!");
            return 565;
        });

        service.post("/hello", (rq, rs) -> {
            rs.header("val15", "15");
            rs.header("val18", "16");
            System.out.println(rq.headers("val16"));
            System.out.println(rq.body());
            return "Hello world!";
        });

        service.get("/throwexception", (request, response) -> {
            throw new Exception();
        });

        service.exception(Exception.class, (exception, request, response) -> {
            response.status(404);
            response.body("Resource not found");
            return;
        });


//        Thread.sleep(5000);
//        System.out.println("Stopped");
//        service.stop();

//        get("/hello", (rq, rs) -> "Hello world!");
//        get("/hello/:name", (request, response) -> {
//            System.out.println(request.params("name"));
//            return "Hello: " + request.params(":name");
//        });
//        stop();
    }
}
