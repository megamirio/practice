package stingion.newek.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by royalflush on 07.12.16.
 */
@Configuration
public class AConfig {
    private String ok = "new";

    @Autowired
    @Qualifier("abc")
    private String abc222;

    @Bean
    @Autowired
    @Lazy
    public String abc(String tempo3) {
        return String.valueOf(tempo3.length());
    }
}
