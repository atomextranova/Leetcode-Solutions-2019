public class RomanToInt {
    public static int romanToInt(String s) {
        int sum = 0;
        final int LENGTH = s.length();
        if (LENGTH == 0) {
            return 0;
        }
        final int LAST_INDEX = LENGTH - 1;
        // Avoid using charAt() every time, more efficient
        char[] stringArray = s.toCharArray();
        // check for Null and
        for (int i = 0; i < LENGTH; i++) {
            switch (stringArray[i]) {
                // One more braces to define local variables nextChar in different cases
                case 'I': {
                    if (i != LAST_INDEX) {
                        char nextChar = stringArray[i + 1];
                        if (nextChar == 'X' | nextChar == 'V') {
                            sum -= 1;
                        } else {
                            sum += 1;
                        }
                    } else {
                        sum += 1;
                    }
                }
                break;
                case 'X': {
                    if (i != LAST_INDEX) {
                        char nextChar = stringArray[i + 1];
                        if (nextChar == 'L' | nextChar == 'C') {
                            sum -= 10;
                        } else {
                            sum += 10;
                        }
                    } else {
                        sum += 10;
                    }

                }
                break;
                case 'C': {
                    if (i != LAST_INDEX) {
                        char nextChar = stringArray[i + 1];
                        if (nextChar == 'D' | nextChar == 'M') {
                            sum -= 100;
                        } else {
                            sum += 100;
                        }
                    } else {
                        sum += 100;
                    }

                }
                break;
                case 'M':
                    sum += 1000;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'D':
                    sum += 500;
                    break;
            }
        }
        return sum;
    }

    // makeittrue posted @ https://leetcode.com/problems/roman-to-integer/discuss/6529/My-solution-for-this-question-but-I-don't-know-is-there-any-easier-way
    public static int romanToIntOptimal(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    // >= 5 ==> I is before V
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String testCase1 = "LVIII";
        System.out.println(RomanToInt.romanToInt(testCase1));
    }
}
