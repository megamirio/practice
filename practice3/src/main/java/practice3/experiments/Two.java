package practice3.experiments;

import practice3.insertone.One;

public class Two {

    void main() {
        One one = new One();
        one.third(null);
        String str = one.getStr(null, 2);
        System.out.println(str);
        one.second(null);
    }

    public static void main(String[] args) {
        new Two().main();
        String a = null;
        if(a.equals("ss")){
            int i = 10;
        }
    }
}
