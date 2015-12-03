package stingion.train;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by joe on 03.12.15.
 */
@NoArgsConstructor
public class Stack {
    @Getter
    @Setter
    private Object data;

    @Getter
    private Stack top;

    public Stack(Object data) {
        this.data = data;
    }

    public void addToStack(Stack stack) {
        Object swap = stack.data;
        stack.data = this.data;
        stack.top = this;
        this.data = swap;
    }

    public Stack getElement() {
        try {
            return this;
        } finally {

        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack("a1");
        stack.addToStack(new Stack("a2"));
        stack.addToStack(new Stack("a3"));
        stack.addToStack(new Stack("a4"));
        stack.addToStack(new Stack("a5"));

    }
}
