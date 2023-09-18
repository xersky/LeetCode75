/* You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length */

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1 && flowerbed[0] == 0) return true;

        boolean potentialPlantedFlower = true;
        int possibleAdjacentFlowersNumber = 0;

        for(int i = 0; i < flowerbed.length - 1; i++) {
                if(flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    if(potentialPlantedFlower || i == flowerbed.length - 1) {
                        possibleAdjacentFlowersNumber++;
                        potentialPlantedFlower = false;
                    } else potentialPlantedFlower = true;
                } else potentialPlantedFlower = false;
        }
        
        if(possibleAdjacentFlowersNumber >= n) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }
}
