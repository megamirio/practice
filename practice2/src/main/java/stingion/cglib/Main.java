package stingion.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        // 1. create the 'real' object
        Executable exe = new  Executable ();
        // 2. create the proxy
        Executable proxifiedExecutable = createProxy(exe);
        // 3. execute the proxy - as we see it has the same API as the real object
        proxifiedExecutable.executeMe();
    }
    // given the obj, creates its proxy
    // the method is generified - just to avoid downcasting...
    public static <T> T createProxy(T obj) {
        // this is the main cglib api entry-point
        // this object will 'enhance' (in terms of CGLIB) with new capabilities
        // one can treat this class as a 'Builder' for the dynamic proxy
        Enhancer e = new Enhancer();
        // the class will extend from the real class
        e.setSuperclass(obj.getClass());
        // we have to declare the interceptor  - the class whose 'intercept'
        // will be called when any method of the proxified object is called.
        e.setCallback(new MyInterceptor(obj));
        // now the enhancer is configured and we'll create the proxified object
        T proxifiedObj = (T) e.create();
        // the object is ready to be used - return it
        return proxifiedObj;
    }
}
