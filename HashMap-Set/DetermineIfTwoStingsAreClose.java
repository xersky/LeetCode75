/* Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
 

Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 contain only lowercase English letters. */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DetermineIfTwoStingsAreClose {
    public static boolean closeStrings(String word1, String word2) {
        int word1Length = word1.length();

        if(word1Length != word2.length()) return false;

        SortedSet<Character> word1Set = new TreeSet<Character>();
        SortedSet<Character> word2Set = new TreeSet<Character>();
        char[] word1CharArr = word1.toCharArray();
        char[] word2CharArr = word2.toCharArray();

        for(int i = 0; i < word1Length; i++) {
            word1Set.add(word1CharArr[i]);
            word2Set.add(word2CharArr[i]);
        }

        if(!word1Set.equals(word2Set)) return false;

        Map<Character,Integer> mapOfWord1Occurences = new HashMap<Character,Integer>();
        Map<Character,Integer> mapOfWord2Occurences = new HashMap<Character,Integer>();
        
        for (char elem : word1CharArr) mapOfWord1Occurences.put(elem, mapOfWord1Occurences.getOrDefault(elem, 0) + 1);
        for (char elem : word2CharArr) mapOfWord2Occurences.put(elem, mapOfWord2Occurences.getOrDefault(elem, 0) + 1);

        List<Integer> ListOfWord1Occurences = new ArrayList<Integer>(mapOfWord1Occurences.values());
        List<Integer> ListOfWord2Occurences = new ArrayList<Integer>(mapOfWord2Occurences.values());

        ListOfWord1Occurences.sort(null);
        ListOfWord2Occurences.sort(null);

        return ListOfWord1Occurences.equals(ListOfWord2Occurences);
    }

    public static void main(String[] args) {
        String word1 = "cabbba", word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }
}
