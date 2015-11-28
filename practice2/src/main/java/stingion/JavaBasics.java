package stingion;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by joe on 28.11.15.
 */
@AllArgsConstructor
public class JavaBasics {
    private int i;
    private String str;

    public static void main(String[] args) {
        System.out.println("Sounds good!");
        JavaBasics jb1 = new JavaBasics(23, "baa");
        JavaBasics jb2 = new JavaBasics(23, "baa");
        System.out.println(jb1.equals(jb2));
        System.out.println(jb1.hashCode() == jb2.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        JavaBasics other = (JavaBasics) obj;
        return new EqualsBuilder().append(i, other.i).append(str, other.str).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(i).append(str).toHashCode();
    }
}
