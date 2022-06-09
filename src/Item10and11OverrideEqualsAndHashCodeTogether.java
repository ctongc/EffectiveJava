public class Item10and11OverrideEqualsAndHashCodeTogether {

    // @AutoValue - considering using Google's opensource framework
    static final class PhoneNumber {
        private final short areaCode;
        private final short prefix;
        private final short lineNum;

        private int hashCode;

        public PhoneNumber(short areaCode, short prefix, short lineNum) {
            this.areaCode = rangeCheck(areaCode, 999, "areaCode");
            this.prefix = rangeCheck(prefix, 999, "prefix");
            this.lineNum = rangeCheck(lineNum, 9999, "line num");
        }

        private static short rangeCheck(int val, int max, String arg) {
            if (val < 0 || val > max) {
                throw new IllegalArgumentException(arg + ": " + val);
            }
            return (short) val;
        }

        @Override
        public boolean equals(Object o) { // don't substitute another type
            if (this == o) {
                return true;
            }
            if (!(o instanceof PhoneNumber)) {
                return false;
            }
            PhoneNumber phoneNumber = (PhoneNumber) o;
            return areaCode == phoneNumber.areaCode
                    && prefix == phoneNumber.prefix
                    && lineNum == phoneNumber.lineNum;
        }

        @Override
        public int hashCode() { // must override hashCode in every class that override equals

            /* Objects.hash runs slowly since it entail array creation to pass a variable number
             * of arguments, as well as boxing and unboxing if the arguments are of primitives */
            // return Objects.hash(areaCode, prefix, lineNum);
            
            int result = hashCode; // lazily initialized cached hash code

            /* the value 31 was chosen because it is an odd prime
             * if it were even and the multiplication overflowed, information would be lost
             * because multiplication by 2 is equivalent to shifting
             * a nice property of 31 is that the multiplication can be replaced by a shift
             * and a subtraction for better performance on some architectures: 31 * i == (i << 5) - i */
            if (result == 0) {
                result = Short.hashCode(areaCode);
                result = 31 * result + Short.hashCode(prefix);
                result = 31 * result + Short.hashCode(lineNum);
                hashCode = result;
            }

            return result;
        }
    }
}
