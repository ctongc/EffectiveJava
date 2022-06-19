import java.util.Comparator;

public class Item14ImplementComparableForValueObject {
    static final class PhoneNumber implements Comparable<PhoneNumber> {

        private short areaCode;
        private short prefix;
        private short lineNum;

        /* In compareTo() method, fields are compared for order rather than equality.
         * Some Object's compareTo() method is inconsistent with equals(), eg. BigDecimal */

        // 1. multiple-filed Comparable with primitive fields
        @Override
        public int compareTo(PhoneNumber pn) {
            // use static compare methods instead of relational operators < and >
            int result = Short.compare(areaCode, pn.areaCode);
            if (result == 0) {
                result = Short.compare(prefix, pn.prefix);
                if (result == 0) {
                    result = Short.compare(lineNum, pn.lineNum);
                }
            }
            return result;
        }

        // 2. Comparable with comparator construction methods with static import
        private static final Comparator<PhoneNumber> COMPARATOR =
                Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode) // Java type inference not able to figure out
                        .thenComparingInt(pn -> pn.prefix) // After the first lambda explicitly specifies, it figured
                        .thenComparingInt(pn -> pn.lineNum);

        public int compareTo2(PhoneNumber pn) {
            return COMPARATOR.compare(this, pn);
        }
    }
}
