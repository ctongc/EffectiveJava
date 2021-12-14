import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.WeakHashMap;

/**
 * Item 7
 * Eliminate obsolete object references
 */
class MyStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MyStack() {
        this.size = DEFAULT_INITIAL_CAPACITY;
    }

    public void push(final Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // return elements[--size];
        Object result = elements[--size];
        elements[size] = null; // eliminate obsolete reference
        return result;
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity
     * each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

public class Item7ObsoleteReference {
    public static void main(String[] args) {
        WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();
    }
}
