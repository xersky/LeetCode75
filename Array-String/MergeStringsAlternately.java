/*  You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

 

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
 

Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters. */


class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        StringBuilder mergedWords = new StringBuilder("");

        for(int i = 0; i < word1Len || i < word2Len; i++) {

            if (i < word1Len){
                mergedWords.append(word1.charAt(i));
            } else {
                mergedWords.append(word2.substring(i, word2Len));
                break;
            }

            if (i < word2Len) {
                mergedWords.append(word2.charAt(i));
            } else {
                mergedWords.append(word1.substring(i + 1, word1Len));
                break;
            }
        }
        
        return mergedWords.toString();
    }

    public static void main(String[] args){
        //Testing
        System.out.println(mergeAlternately("cow", "elgato"));
        System.out.println(mergeAlternately("eltoro", "cat"));
        System.out.println(mergeAlternately("cow", "cat"));
    }

    //Submitted Solved
}