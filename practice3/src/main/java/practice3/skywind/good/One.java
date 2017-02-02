package practice3.skywind.good;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by royalflush on 13.12.16.
 */
public class One {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

//        List<String> listR =new ArrayList<>();
//        listR.add(null);
//        listR.add(null);
//
//        Object obj =  Optional.ofNullable(list)
//                .filter(r -> r.size() > 0)
//                .orElse(Lists.newArrayList(null,null)).get(0);

//        System.out.println(obj);
        System.out.println(new ArrayList<>(10));
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());


    }
}

