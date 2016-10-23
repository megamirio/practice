package practice3.patternnew;

import java.util.HashMap;
import java.util.Map;

class Factory {
    private Map<String, Object> map = new HashMap<>();

    public Object getObj(String color) {
        if (map.get(color) != null)
            return map.get(color);

        map.put(color, new Object());
        return map.get(color);
    }
}


public class FlyweightDP {
    public static void main(String[] args) {
        System.out.println("Flyweight DP");
        Factory f = new Factory();
        System.out.println(f.getObj("a"));
        System.out.println(f.getObj("a"));
        System.out.println(f.getObj("b"));
        System.out.println(f.getObj("c"));
        System.out.println(f.getObj("a"));
    }
}
