/* For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters. */

class GreatestCommunDivisorOfStrings {

    static int gcdByEuclids(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclids(n2, n1 % n2);
    }

    public static String gcdOfStrings(String str1, String str2) {

        if ((str1 + str2).equals(str2 + str1)) {
            String potentialGcr = new String(str2.substring(0, gcdByEuclids(str1.length(), str2.length())));
            // I doubt this check is necessary
            if(str1.equals(potentialGcr.repeat(str1.length() / potentialGcr.length()))) return potentialGcr;
            else return "";
        } else return "";
    } 


        // String x = new String("");

        // int str1Len = str1.length();
        // int str2Len = str2.length();
        
        // if(str1Len >= str2Len) {
        //     if(str2Len % 2 == 1) {
        //         if(str1Len % str2Len == 0 && str1.equals(str2.repeat(str1Len / str2Len))) x = str2;
        //         else if(str1Len % str2Len != 0){
        //             String pureString = new String("");
        //             pureString = str2.substring(0, str1Len % str2Len);
        //             if (str2.equals(pureString.repeat(str2Len / pureString.length()))) x = pureString;
        //         }
        //     }

        //     else if(str2.length() % 2 == 0) {
        //         String comp1 = new String("");
        //         String comp2 = new String("");
        //         String dividor = new String(str2);

        //         while(str2.length() % 2 == 0) {
        //             comp1 = str2.substring(0, str2.length() / 2);
        //             comp2 = str2.substring(str2.length() / 2, str2.length());

        //             if(comp1.equals(comp2)) dividor = comp1;
        //             else break;
        //             str2 = comp1;
        //         }
        //         if (dividor.length() != 0 && str1.equals(dividor.repeat(str1Len / dividor.length()))) x = dividor;

        //     }
        // } else return gcdOfStrings(str2, str1);
        // return x;
    

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}

