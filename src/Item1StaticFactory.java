import lombok.Value;

/**
 * Item 1
 * Consider static factory methods instead of constructors
 */
class StaticFactoryUser {
    private final String name;
    private final String email;
    private final String country;

    private StaticFactoryUser(final String name, final String email, final String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public static StaticFactoryUser create(final String name, final String email, final String country) {
        return new StaticFactoryUser(name, email, country);
    }

    public static StaticFactoryUser createTestUser() {
        return new StaticFactoryUser(TEST_USER_NAME, TEST_USER_NAME_EMAIL, COUNTRY_AUSTRALIA);
    }

    public static StaticFactoryUser createWithDefaultCountry(final String name, final String email) {
        return new StaticFactoryUser(name, email, COUNTRY_CHINA);
    }

    private static final String TEST_USER_NAME = "Miranda Kerr";
    private static final String TEST_USER_NAME_EMAIL = "Kristal@mirandakerr.com";
    private static final String COUNTRY_AUSTRALIA = "Australia";
    private static final String COUNTRY_CHINA = "China";
}

@Value(staticConstructor = "of")
class StaticFactoryPoint {
    int x;
    int y;
}

public class Item1StaticFactory {
    public static Boolean valueOf(final boolean b) {
        return b ? Boolean.FALSE : Boolean.TRUE;
    }

    public static void main(String[] args) {
        StaticFactoryUser user = StaticFactoryUser.createTestUser();
        StaticFactoryPoint name = StaticFactoryPoint.of(COORDINATE_X, COORDINATE_Y);
    }

    private static final int COORDINATE_X = 8;
    private static final int COORDINATE_Y = 8;
}
