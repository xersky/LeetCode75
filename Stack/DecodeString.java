/*Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300]. */

public class DecodeString {
    public static String decodeString(String s) {
        StringBuffer kBuffer = new StringBuffer();
        int k = 1;
        StringBuffer encodedString = new StringBuffer();
        StringBuffer result = new StringBuffer();
        boolean isBracketOn = false;
        
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) kBuffer.append(s.charAt(i));
            else if(!isBracketOn && s.charAt(i) != '[' && s.charAt(i) != ']') {
                encodedString.append(s.charAt(i));
            } else if(!isBracketOn && s.charAt(i) == '[') {
                isBracketOn = true;
                if(Integer.parseInt(kBuffer.toString()) == 0) k = 1;
                else k = Integer.parseInt(kBuffer.toString());
                kBuffer.delete(0,kBuffer.length());
                result.append(encodedString);
                encodedString.delete(0,encodedString.length());
            } else if(s.charAt(i) == ']') {
                isBracketOn = false;
                for(int j = 0; j < k; j++) result.append(encodedString);
                kBuffer.delete(0,kBuffer.length());
                encodedString.delete(0,encodedString.length());
                k = 1;
            } else if(s.charAt(i) == '[') {
                int r = k;
                if(Integer.parseInt(kBuffer.toString()) == 0) k = 1;
                else k = Integer.parseInt(kBuffer.toString());
                kBuffer.delete(0,kBuffer.length());
                encodedString.append(decodeString(String.valueOf(k) + s.substring(i, s.indexOf(']', i - 1) + 1)));
                k = r;
                i = s.indexOf(']', i - 1);
            } else if(s.charAt(i) != ']' && s.charAt(i) != '[') {
                encodedString.append(s.charAt(i));
            }
        }
        result.append(encodedString);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}