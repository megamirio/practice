package stingion.spring.integration;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.beans.ConstructorProperties;

@ToString
@NoArgsConstructor
public class GoNow {
    private int id;
    private String name;

    @ConstructorProperties({"i", "s"})
    public GoNow(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    public int getI(){
//        return id;
//    }
//
//    public String getS(){
//        return name;
//    }
//
//    public void setI(int i){
//        id = i;
//    }
//
//    public void setS(String s){
//        name = s;
//    }
}
