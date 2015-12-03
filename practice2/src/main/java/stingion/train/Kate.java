package stingion.train;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by joe on 30.11.15.
 */
public class Kate {
    public static void main(String[] args) {
        Detek[] deteks1 = new Detek[]{new Detek(2), new Detek(3), new Detek(5)};
        Detek[] deteks2 = Detek.deepClone(deteks1);

        System.out.println(Arrays.toString(deteks1));
        System.out.println(Arrays.toString(deteks2));

        List<String> list = new LinkedList<>();
        list.add("abc");
        list.add("abc33");
        list.add("abc");
        list.add("sgg");
        list = Collections.unmodifiableList(list);
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "dd");
        map = Collections.unmodifiableMap(map);
//        map.put(3, "b");

        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
//            if (value.equals("13")) myList.add(value+"a");
        }

        Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while(it1.hasNext()){
            String key = it1.next();
            System.out.println("Map Value:"+myMap.get(key));
            if(key.equals("2")){
                myMap.remove("4");
                //myMap.put("4", "4");
            }
        }

    }


}

@ToString
class Detek implements Cloneable {
    private int i;

    private int thisObj = this.hashCode();

    public Detek(int i) {
        this.i = i;
    }

    @Override
    public Detek clone() {
        return new Detek(i);
    }

    public static Detek[] deepClone(Detek[] deteks) {
        Detek[] deteksClone = new Detek[deteks.length];
        for (int i = 0; i < deteks.length; i++) {
            deteksClone[i] = deteks[i].clone();
        }
        return deteksClone;
    }
}
