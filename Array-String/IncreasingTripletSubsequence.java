/* Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1 */

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {

        if(nums.length < 3) return false;

        int i = nums[0];
        int j = nums[1];
        int k;

        for(int index = 0; index < nums.length - 2; index++) {
            
            k = nums[index + 2];
            if(i < j && j < k) return true;

            if(nums[index] < nums[index + 1] && i > nums[index]) i = nums[index];
            else if(nums[index] > nums[index + 1] && i > nums[index + 1]) i = nums[index + 1];

            if(nums[index + 1] < nums[index + 2] && i < nums[index + 1]) j = nums[index + 1]; 
            else if(i < nums[index + 2] && i <= j) j = nums[index + 2];

            if(i < j && j < k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,0,10,0,0,0,10000};
        System.out.println(increasingTriplet(nums));
    }
}
