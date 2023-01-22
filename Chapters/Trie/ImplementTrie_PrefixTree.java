public class ImplementTrie_PrefixTree{
    private class TrieNode{
        TrieNode[] children;
        boolean wordEnd = false;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public ImplementTrie_PrefixTree () {
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
        }
        it.wordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode it = root;
        for(char ch : word.toCharArray()){
            int index=ch-'a';
            if(it.children[index]==null){
                return false;
            }
            it = it.children[index];
        }
        return it.wordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode it = root;
        for(char ch : prefix.toCharArray()){
            int index = ch-'a';
            if(it.children[index] == null){
                return false;
            }
            it = it.children[index];
        }
        return true;
    }
}