/* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104 */

public class ContainerWithMostWaterNoicer {
    public static int maxArea(int[] height) {
        int max = 0;
        int temp;
        
        int leftParser = 0;
        int rightParser = height.length - 1;

        while(leftParser < rightParser) {
            if(height[leftParser] >= height[rightParser]) {
                temp = height[rightParser] * (rightParser - leftParser);
                if(max < temp) max = temp;
                rightParser--;
                    
            } else {
                temp = height[leftParser] * (rightParser - leftParser);
                if(max < temp) max = temp;
                leftParser++;
            }
        }


        /* for(int i = 0; i < height.length - 1; i++) { 
            for(int j = i + 1; j < height.length; j++) {    
                if(height[i] >= height[j]) {
                    temp = height[j] * (j - i);
                  if(max < temp) max = temp;
                    
                } else {
                    temp = height[i] * (j - i);
                   if(max < temp) max = temp;
                }
            }   
        } */
        return max;
    }

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    } 
}