/* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters. */

public class ReverseVowelsOfAString {

    public static String reverseVowels(String s) {

        String vowels = "aeiouAEIOU";
        StringBuilder reverseVowels = new StringBuilder("");
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(vowels.indexOf(s.charAt(i)) != -1){
                reverseVowels.append(s.charAt(i));
            }
        }
        
        reverseVowels.reverse();

        StringBuilder reversedSring = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(vowels.indexOf(s.charAt(i)) != -1){
                reversedSring.append(reverseVowels.charAt(j));
                j++;
            } else reversedSring.append(s.charAt(i));
        }
        return reversedSring.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("tesoteot"));
    }
}
