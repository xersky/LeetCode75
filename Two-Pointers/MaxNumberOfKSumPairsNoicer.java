/* You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109 */

import java.util.Arrays;

public class MaxNumberOfKSumPairsNoicer {
    
    public static int maxOperations(int[] nums, int k) {

        int operationNumber = 0;

        int leftParser = 0;
        int rightParser = nums.length - 1;

        Arrays.sort(nums);

        while(leftParser < rightParser) {
            if((nums[leftParser] + nums[rightParser]) > k) rightParser--;
            else if((nums[leftParser] + nums[rightParser]) < k) leftParser++;
            else {
                operationNumber++;
                leftParser++;
                rightParser--;
            }
        }
        
        return operationNumber;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        System.out.println(maxOperations(nums, 5));
    }
}
