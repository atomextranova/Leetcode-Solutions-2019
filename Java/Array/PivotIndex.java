// https://leetcode.com/problems/find-pivot-index/
public class PivotIndex {
    public int pivotIndex1(int[] nums) {
        int sumRight = 0;
        for (int i : nums) {
            sumRight += i;
        }
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            sumRight -= element;
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += element;
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int partialSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int sumExceptPivot = sum - element;
            if (sumExceptPivot % 2 == 0 && partialSum == sumExceptPivot / 2) {
                return i;
            }
            partialSum += element;
        }
        return -1;
    }
}
