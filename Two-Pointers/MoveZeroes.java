/* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1 */

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int j;
        if(nums.length > 1) {
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] == 0) {
                    j = i + 1;
                    while(j < nums.length) {
                        if(nums[j] == 0) {
                            j++;
                        }else {
                            nums[i] = nums[j];
                            nums[j] = 0;
                            break;
                        }
                    }
                }
            }
        }
        
        

        for (int num : nums) {
            System.out.println(num);
        }

    }

    public static void main(String[] args) {
        int[] pog = new int[]{1 ,2 ,2 ,5 ,0 ,0 ,0 ,3 ,0};
        moveZeroes(pog);
    }
}
