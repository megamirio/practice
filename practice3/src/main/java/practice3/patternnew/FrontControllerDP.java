package practice3.patternnew;

class HomeView {
    public void show() {
        System.out.println("Student");
    }
}

class StudentView {
    public void show() {
        System.out.println("Home");
    }
}

class Dispatcher {
    private HomeView homeView = new HomeView();
    private StudentView studentView = new StudentView();

    void request(String name) {
        if (name.equalsIgnoreCase("student")) {
            studentView.show();
        } else {
            homeView.show();
        }
    }
}

class FrontController {
    Dispatcher dispatcher = new Dispatcher();

    boolean isAuth() {
        System.out.println("auth is true");
        return true;
    }

    void processRequest(String name) {
        if (isAuth()) {
            dispatcher.request(name);
        }
    }
}

public class FrontControllerDP {
    public static void main(String[] args) {
        System.out.println("It's Front Controller DP");
        FrontController controller = new FrontController();
        controller.processRequest("okey");
        controller.processRequest("studenT");
        controller.processRequest("someone");
    }
}
