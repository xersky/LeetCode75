/* Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length */

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static int maxVowels(String s, int k) {

        String vowels = "aoeui";

        int numberOfVowels = 0;
        int maxNumberOfVowels = 0;

        for(int i = 0; i < k; i++) {
            if(vowels.indexOf(s.charAt(i)) != -1) {
                numberOfVowels++;
            }
        }

        if(maxNumberOfVowels < numberOfVowels) maxNumberOfVowels = numberOfVowels;
        if(maxNumberOfVowels == k) return maxNumberOfVowels;

        for(int i = k; i < s.length(); i++) {

            if(vowels.indexOf(s.charAt(i - k)) != -1) numberOfVowels--;
            if(vowels.indexOf(s.charAt(i)) != -1) numberOfVowels++;

            if(maxNumberOfVowels < numberOfVowels) maxNumberOfVowels = numberOfVowels;

            if(maxNumberOfVowels == k) return maxNumberOfVowels;

        }

        return maxNumberOfVowels;
    }

    public static void main(String[] args) {

        String s = "abciiidef";

        System.out.println(maxVowels(s, 3));
    }
}
