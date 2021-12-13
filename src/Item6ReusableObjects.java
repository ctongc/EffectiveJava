import java.util.regex.Pattern;

/**
 * Item 6
 * Avoid creating unnecessary objects
 */
class RomanNumeral {
    private static final String ROMAN_NUMERAL_EXPRESSION = "^(?=.)M*(C[MD]|D?C{0,3})X[CL]|L?X{0,3}(I[XV]|V?I{0,3})$";
    private static final Pattern ROMAN = Pattern.compile(ROMAN_NUMERAL_EXPRESSION);

    static boolean isRomanNumeral(final String s) {
        return ROMAN.matcher(s).matches();
    }
}

public class Item6ReusableObjects {
}
