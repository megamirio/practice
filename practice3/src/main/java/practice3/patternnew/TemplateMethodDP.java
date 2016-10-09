package practice3.patternnew;

abstract class TemplateMethod {
    abstract void meth();

    void callMeth() {
        meth();
    }
}

class TemplateMethod2 extends TemplateMethod {
    @Override
    void meth() {
        System.out.println("Method2");
    }
}

class TemplateMethod3 extends TemplateMethod {
    @Override
    void meth() {
        System.out.println("Method3");
    }
}

public class TemplateMethodDP {
    public static void main(String[] args) {
        System.out.println("Template Method DP");
        new TemplateMethod2().meth();
        new TemplateMethod3().meth();
    }
}
