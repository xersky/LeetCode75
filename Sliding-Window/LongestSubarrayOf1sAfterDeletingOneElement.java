/* Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {

        int count = 0;
        int index = 0;
        int max = 0;
        boolean isZeroDeleted = false;
        boolean isItemDeleted = false;
        int rollBackIndex = 0;

        while (index < nums.length) {
            if(nums[index] == 1) count++;
            else if(nums[index] == 0 && !isZeroDeleted) {
                isZeroDeleted = true;
                isItemDeleted = true;
                rollBackIndex = index;
            } else if(nums[index] == 0 && isZeroDeleted) {
                index = rollBackIndex;
                count = 0;
                isZeroDeleted = false;
            }
            if(max < count) max = count;
            index++;
        }

        if (!isItemDeleted) max--;
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,1,1,0,1,1,0,1};

        System.out.println(longestSubarray(nums));
    }
}
