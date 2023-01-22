public class DesignAddandSearchDataStructure {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean wordEnd=false;
    }
    TrieNode root;
    public DesignAddandSearchDataStructure() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        char[] arr = word.toCharArray();
        return solve(root, arr, 0);
    }
    public boolean solve(TrieNode node, char[] arr, int pos){
        for(int i=pos; i<arr.length; i++){
            if(arr[i]=='.'){
                for(int j=0; j<26; j++){
                    if(node.children[j] != null){
                        if(solve(node.children[j], arr, i+1)){
                            return true;
                        }
                    }
                }
                return false;
            }else{
                int index = arr[i]-'a';
                if(node.children[index]==null){
                    return false;
                }
                node = node.children[index];
            }
        }
        return node.wordEnd;
    }
}
