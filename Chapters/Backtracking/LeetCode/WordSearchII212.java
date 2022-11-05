import java.util.*;
public class WordSearchII212 {
    //TC:O(m*n)
    private class TrieNode{
        private TrieNode[] children;
        private String word;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(ans, board, root, i, j);
            }
        }
        return ans;
    }
    
    private void dfs(List<String> ans, char[][] board, TrieNode ptr, int i, int j){
        char ch = board[i][j];
        if(board[i][j] == '$' || ptr.children[ch-'a']==null){
            return;
        }
        ptr = ptr.children[ch-'a'];
        if(ptr.word!=null){
            ans.add(ptr.word);
            ptr.word = null;//Re assign the word to null to avoid duplicate entries
        }
        board[i][j] = '$';//update visited
        
        if(i>0) dfs(ans, board, ptr, i-1, j);
        if(j>0) dfs(ans, board, ptr, i, j-1);
        if(i<board.length-1) dfs(ans, board, ptr, i+1, j);
        if(j<board[0].length-1) dfs(ans, board, ptr, i, j+1);
        
        board[i][j] = ch;
        
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode ptr = root;
            for(char ch : w.toCharArray()){
                int index = ch-'a';
                if(ptr.children[index] == null){
                    ptr.children[index] = new TrieNode();
                }
                ptr = ptr.children[index];//move the ptr in Trie
            }
            ptr.word = w;//store the original word at the end
        }
        return root;
    }
}
