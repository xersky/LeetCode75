/* Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 

Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000 */

import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurences {
    public static boolean uniqueOccurrences(int[] arr) {
        Set<Integer> setOfArr = new HashSet<Integer>();
        Set<Integer> setOfCounter = new HashSet<Integer>();
        int counter = 0;

        for (int elem : arr) setOfArr.add(elem);

        for (Integer elem : setOfArr) {
            for(int i = 0; i < arr.length; i++) if(elem == arr[i]) counter++;
            setOfCounter.add(counter);
            counter = 0;
        }
        return setOfCounter.size() == setOfArr.size();
    }

    public static void main(String[] args) {
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }
}
