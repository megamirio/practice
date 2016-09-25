package stingion.now.temp;

import java.util.Random;

class Discont {
    class DiscontInner {

    }
}

public class Newk {
    public static void main(String[] args) {
        Random r = new Random();
        long b = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(r.nextInt());
        }

        Integer iI = 5;
        int i = iI;
        String st = sb.toString();
        System.out.println(System.nanoTime() - b);
    }
}

