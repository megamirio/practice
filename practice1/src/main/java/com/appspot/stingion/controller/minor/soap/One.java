package com.appspot.stingion.controller.minor.soap;

/**
 * Created by royalflush on 21.12.16.
 */
public class One {
    public static void main(String[] args) {
        SimpleSoapService service = new SimpleSoapService();
        SimpleSoap simpleSoap = service.getSimpleSoapPort();
        System.out.println(simpleSoap.getIt("one"));
    }
}
