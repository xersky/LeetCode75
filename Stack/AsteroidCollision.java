/* We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0 */

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
/*         Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < asteroids.length; i++) {
            if(stack.empty()) {
                stack.push(asteroids[i]);
            } else {
                int lastAsteroid = stack.peek();
                if(lastAsteroid * asteroids[i] < 0) {
                    if(lastAsteroid + asteroids[i] == 0) stack.pop();
                    else {
                        if(Math.abs(lastAsteroid) < Math.abs(asteroids[i])) {
                            stack.pop();
                            i--;
                        }
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            }
        }
        return Arrays.stream(stack.toArray(new Integer[stack.size()])).mapToInt(Integer::intValue).toArray(); */

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;

        for(int i = 0; i < asteroids.length; i++) {
            if(stack.empty()) {
                stack.push(asteroids[i]);
            } else {
                if(stack.peek() < 0) stack.push(asteroids[i]);
                else {          
                    if(asteroids[i] > 0) stack.push(asteroids[i]);
                    else if(stack.peek() == -asteroids[i]) stack.pop();
                    else if(stack.peek() < -asteroids[i]) {
                        stack.pop();
                        i--;
                        if(asteroids[i] > max) stack.push(asteroids[i]);
                    }
                }
            }
            if(max < asteroids[i]) max = asteroids[i];
        }

        return Arrays.stream(stack.toArray(new Integer[stack.size()])).mapToInt(Integer::intValue).toArray();
    }

    
    public static void main(String[] args) {

        int[] array = new int[] {-2,-2,1,-2};
        int[] arrayR = asteroidCollision(array);

        for (int i : arrayR) {
            System.out.println(i);
        }
        
    }
}
