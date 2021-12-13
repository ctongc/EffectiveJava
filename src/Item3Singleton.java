/**
 * Item 3
 * Enforce the singleton property with a private constructor or an enum type
 */
class SingletonWithPublicFinalField {
    public static final SingletonWithPublicFinalField INSTANCE = new SingletonWithPublicFinalField();

    private SingletonWithPublicFinalField() {
    }

    public void doSomething() {
    }
}

class SingletonWithStaticFactory {
    private static final SingletonWithStaticFactory INSTANCE = new SingletonWithStaticFactory();

    private SingletonWithStaticFactory() {
    }

    public static SingletonWithStaticFactory getInstance() {
        return INSTANCE;
    }

    public void doSomething() {
    }
}

enum SingletonWithEnum {
    INSTANCE;

    public void doSomething() {
    }
}

// @Singleton
public class Item3Singleton {
}
