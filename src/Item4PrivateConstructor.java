/**
 * Item 4
 * Enforce noninstantiability with a private constructor
 */
public class Item4PrivateConstructor {
    // suppress default constructor
    private Item4PrivateConstructor() {
        throw new AssertionError();
    }
}
