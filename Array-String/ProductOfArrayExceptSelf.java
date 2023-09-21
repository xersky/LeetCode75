/* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int productOfAll = 1;
        int numOfZeros = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) numOfZeros++;
            else productOfAll *= nums[i];

            if(numOfZeros >= 2) break;
        }

        if(numOfZeros >= 2){
            for(int i = 0; i < answer.length; i++) answer[i] = 0;
        } else if(numOfZeros == 1) {
            for(int i = 0; i < answer.length; i++) {
                if (nums [i] != 0) answer[i] = 0;
                else answer[i] = productOfAll;
            }
        } else if((productOfAll == 1 || productOfAll == -1)){
            for(int i = 0; i < answer.length; i++) answer[i] = nums[i] * productOfAll;
        } else {
            /* for(int i = 0; i < nums.length; i++) {
                answer[i] = 1;
                for(int j = 0; j < nums.length; j++) {
                    if(i != j) answer[i] *= nums[j];
                }
            } */
            int productParser = 1;
            answer[0] = 1;
            for(int i = 1; i < nums.length; i++) {
                productParser *= nums[i - 1];
                answer[i] = productParser;
            }
            productParser = 1;
            for(int i = nums.length - 1; i >= 0; i--) {
                answer[i] *= productParser;
                productParser *= nums[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(productExceptSelf(nums));
    }
}




