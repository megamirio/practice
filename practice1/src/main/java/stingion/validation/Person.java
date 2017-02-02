package stingion.validation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by royalflush on 05.01.17.
 */
@Getter
@Setter
@ToString
public class Person {

    @Min(1)
    @Max(100)
    private int id;

    @NotEmpty
    @NotNull
    private String name;

    @Email
    private String email;
}
