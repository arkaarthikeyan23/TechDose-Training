public class ImplementTrieII_PrefixTree {
    private class TrieNode{
        TrieNode[] children;
        int wordEnd=0;
        int prefixCount=0;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public ImplementTrieII_PrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode it = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(it.children[index] == null){
                it.children[index] = new TrieNode();
            }
            it = it.children[index];
            it.prefixCount++;
        }
        it.wordEnd++;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode it = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(it.children[index]==null){
                return 0;
            }
            it = it.children[index];
        }
        return it.wordEnd;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode it = root;
        for(char ch : prefix.toCharArray()){
            int index = ch-'a';
            if(it.children[index]==null){
                return 0;
            }
            it = it.children[index];
        }
        return it.prefixCount;
    }
    
    public void erase(String word) {
        TrieNode it = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            it = it.children[index];
            it.prefixCount--;
        }
        it.wordEnd--;
    }
}
