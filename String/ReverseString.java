public class ReverseString {

    // 2ms
    public static String reverseStringCharArray(String s) {
        char[] array = s.toCharArray();
        final int LENGTH = array.length;
        char[] reverse = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            reverse[LENGTH - i - 1] = array[i];
        }
        return String.valueOf(reverse);
    }

    // 4ms
    public static String reverseStringWithStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String test = "hello";
        ReverseString.reverseStringCharArray(test);
    }
}
