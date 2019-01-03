import java.util.*;

public class ZigZagString {
    //    public String convert(String s, int numRows) {
//        char[] original = s.toCharArray();
//        int LENGTH = s.length();
//        if (LENGTH != 0) {
//            int lengthForOneRpeat = (numRows * 2 - 2);
//            int repeat = LENGTH / numRows / lengthForOneRpeat;
////            int remains = LENGTH - repeat * numRows * (numRows * 2 - 2);
//            char[][] array = new char[numRows][repeat + numRows - 2];
//            int column_index = 0;
//            int row_index = -1;
//            for (int i = 0; i < LENGTH; i++) {
//                int repeatIndex = i / lengthForOneRpeat;
//                int indexWithinRepeat = i % lengthForOneRpeat;
//                if (indexWithinRepeat < numRows - 1) {
//                    array[row_index][column_index] = original[i];
//                    row_index += 1;
//                }
//                else if (indexWithinRepeat >= numRows) {
//                    column_index += 1;
//                }
//                else {
//
//                }
//                array[row_index][column_index] = original[i];
//            }
//            return String.valueOf(array);
//        }
//        else {
//            return "";
//        }
//    }
    /*
    We can use min(numRows,len(s))\text{min}( \text{numRows}, \text{len}(s))
    min(numRows,len(s))
    lists to represent the non-empty rows of the Zig-Zag Pattern.
    Iterate through sss from left to right, appending each character to the
    appropriate row.
    The appropriate row can be tracked using two variables: the current row
    and the current direction.
    The current direction changes only when we moved up to the topmost row or
     moved down to the bottommost row.
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    public String convert3(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            {
                sb[idx].append(c[i++]);
            }
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
            {
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}
