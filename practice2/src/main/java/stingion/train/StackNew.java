package stingion.train;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by joe on 03.12.15.
 */
public class StackNew {

    private Element current;

    public void push(Element element) {
        element.next = current;
        current = element;
    }

    public Element pull() {
        try {
            return current;
        } finally {
            current = current.next;
        }
    }

    @ToString(of = "data")
    public static class Element {
        private Object data;

        private Element next;

        public Element(Object data) {
            this.data = data;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalize " + toString());
            super.finalize();
        }
    }

    public static void main(String[] args) {
        StackNew stack = new StackNew();
        for (int i = 0; i < 1000000; i++) {
            stack.push(new Element("a" + i));
        }
        for (int i = 0; i < 990000; i++) {
            stack.pull();
        }

        System.gc();
    }
}
