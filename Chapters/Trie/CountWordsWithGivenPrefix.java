public class CountWordsWithGivenPrefix {
    private class TrieNode{
        TrieNode[] children;
        int prefixCount=0;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode it = root;
            for(char ch : word.toCharArray()){
                int index=ch-'a';
                if(it.children[index]==null){
                    it.children[index] = new TrieNode();
                }
                it = it.children[index];
                it.prefixCount++;
            }
        }
        return root;
    }

    public int countPrefix(TrieNode root, String prefix){
        TrieNode it = root;
        for(char ch : prefix.toCharArray()){
            int index = ch-'a';
            if(it.children[index] == null){
                return 0;
            }
            it = it.children[index];
        }
        return it.prefixCount;
    }

    public int prefixCount(String[] words, String pref) {
        TrieNode root = buildTrie(words);
        return countPrefix(root, pref);
    }
}
