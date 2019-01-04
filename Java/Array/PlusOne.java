import java.lang.reflect.Array;
import java.util.Arrays;


// Solution for Plus One
// https://leetcode.com/problems/plus-one/

public class PlusOne {
    // Will overflow on large numbers
//    public int[] plusOne(int[] digits) {
//        long number = 0;
//        long coefficient = 1;
//        for (int i = digits.length -1; i >= 0; i--) {
//            number += digits[i] * coefficient;
//            coefficient *= 10;
//        }
//        number += 1;
//        int newLength = 0;
//        long tempNumber = number;
//        while (tempNumber >= 1) {
//            tempNumber /= 10;
//            newLength += 1;
//        }
//        int[] newDigits = new int[newLength];
//        for (int i = newLength -1; i >= 0; i--) {
//            newDigits[i] = (int)(number % 10);
//            number /= 10;
//        }
//        return newDigits;
//    }

    // Time: O(n) for average and worst cases
    // Space: O(1) for best cases, O(n) for worst cases (Reallocate new array)
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            index -= 1;
        }
        if (index == -1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        } else {
            digits[index] += 1;
            return digits;
        }
    }

    // diaa posted @ https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution\
    // Accessed 01/03/2019
    // Require slightly fewer checks
    // Time: O(n) for average and worst cases
    // Space: O(1) for best cases, O(n) for worst cases (Reallocate new array)
    public int[] plusOneOptimal(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        int[] test = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0
                ,6};
        int[] test2 = {9, 9};
        PlusOne testClass = new PlusOne();
        System.out.println(Arrays.toString(testClass.plusOne(test)));
        System.out.println(Arrays.toString(testClass.plusOne(test2)));
    }
}
