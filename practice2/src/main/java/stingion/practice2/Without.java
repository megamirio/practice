package stingion.practice2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joe on 20.01.16.
 */
//@Getter
//@Setter
@Component
public class Without {
    @Autowired
    private Integer inter;
    @Autowired
    private String str;
}
