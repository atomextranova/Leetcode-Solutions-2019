/*
In a given integer array nums, there is always exactly one largest element.
Find whether the largest element in the array is at least twice as much as every other number in
the array.
If it is, return the index of the largest element, otherwise return -1.
 */

public class LargestNumberTwice {

    // Warning: This method assumes that all numbers >= 0
    // Analysis:
    // Time: O(n) Scan the array once
    // Space: O(1) Store a few primitive variables
    public int dominantIndex(int[] nums) {
        int largest = nums[0];
        int largestIndex = 0;
        int secondLargest = -1;
        for (int i = 1; i < nums.length; i++) {
            int element = nums[i];
            if (element > largest) {
                secondLargest = largest;
                largestIndex = i;
                largest = element;
            }
            else if (element > secondLargest) {
                secondLargest = element;
            }
        }
        return largest >= secondLargest * 2 ? largestIndex : -1;
    }
}
