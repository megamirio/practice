package stingion.now.temp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoAgain {
    public static void main(String[] args) {

            List<String> myList = new ArrayList<>();

            myList.add("1");
            myList.add("2");
            myList.add("3");
            myList.add("4");
            myList.add("5");

            Iterator<String> it = myList.iterator();
            while(it.hasNext()){
                String value = it.next();
                System.out.println("List Value:"+value);
//                if(value.equals("3")) myList.remove(value);
                break;

            }
        String value = it.next();
        myList.remove(0);
        System.out.println(myList);



    }
}
