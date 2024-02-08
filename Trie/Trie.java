/* 208. Implement Trie (Prefix Tree)
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith. */

public class Trie {

    TrieNode root;

    public class TrieNode{
        TrieNode[] childNode = new TrieNode[26];
        boolean isEndOfString;
    }
    
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = this.root;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'a';
            if(currentNode.childNode[c] == null) currentNode.childNode[c] = new TrieNode();
            currentNode = currentNode.childNode[c];
        }
        currentNode.isEndOfString = true;
    }
    
    public boolean search(String word) {
        TrieNode currentNode = this.root;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'a';
            if(currentNode.childNode[c] == null) return false;
            currentNode = currentNode.childNode[c];
        }
        return currentNode.isEndOfString;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = this.root;
        int n = prefix.length();
        for(int i = 0; i < n; i++) {
            int c = prefix.charAt(i) - 'a';
            if(currentNode.childNode[c] == null) return false;
            currentNode = currentNode.childNode[c];
        }
        return true;
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("test");
        System.out.println(trie.search("test")); //true
        System.out.println(trie.search("tes")); //false
        System.out.println(trie.startsWith("tes")); //true
    }
}
