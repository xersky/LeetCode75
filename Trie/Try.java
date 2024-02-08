/* My first try to implement a trie, loved implementing it recursively,
*  but the problem persists in overwriting inserted values
*  which is logical because there is no array nor list of Tries Nodes.
*  so it's just a try not a trie yet.
*/
 

public class Try {
    
    Character value;
    Try childNode;
    boolean isEndOfString;

    public Try() {
    }

    public void insert(String word) {
        int n = word.length();
        if(childNode == null) childNode = new Try();
        childNode.value = word.charAt(0);
        if(n > 1) childNode.insert(word.substring(1, n));
        else childNode.isEndOfString = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        boolean result = true;
        boolean lastCharOfString = true;

        if(childNode == null) return false;

        if(!word.isEmpty() && childNode.value != word.charAt(0)) return false;

        if(n > 1) result = childNode.search(word.substring(1, n));
        else lastCharOfString = childNode.isEndOfString;

        return result && lastCharOfString;
    }

    public boolean startsWith(String prefix) {

        int n = prefix.length();
        boolean result = true;

        if(childNode == null) return false;

        if(!prefix.isEmpty() && childNode.value != prefix.charAt(0)) return false;
        if(n > 1) result = childNode.startsWith(prefix.substring(1, n));

        return result;
    }

    public static void main(String[] args) {
        Try trie = new Try();

        trie.insert("tex");

        System.out.println(trie.search("tex"));
    }
}
