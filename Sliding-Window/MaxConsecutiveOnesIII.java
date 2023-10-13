/* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length */

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {

        int max = 0;
        int count = 0;
        boolean isConsecutive = true;
        int startingPoint = 0;
        int flipper = k;
        int i = 0;

        while(i < nums.length) {
            
            if(isConsecutive) {
                isConsecutive = false;
                startingPoint = i;
            }

            if(nums[i] == 1) count++;
            else if(nums[i] == 0 && flipper > 0) {
                count++;
                flipper--;
            } 
            
            if(nums[i] == 0 && flipper == 0) {
                if (max < count) max = count;
                flipper = k;
                count = 0;
                i = startingPoint;
                isConsecutive = true;
            }

            if(max < count) max = count;

            i++;
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] nums= {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums, 3));
    }
}
