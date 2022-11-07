import java.util.*;
public class _0048WordBreak {
    private class TrieNode{
        private TrieNode[] children;
        private boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    private TrieNode buildTrie(List<String> words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode ptr = root;
            for(char ch : word.toCharArray()){
                int index = ch-'a';
                if(ptr.children[index] == null){
                    ptr.children[index] = new TrieNode();
                }
                ptr = ptr.children[index];
            }
            ptr.isEnd = true;
        }
        return root;
    }
    
    private boolean bfs(String s, TrieNode root){
        int n = s.length();
        //Queue to keep track of end node during the search
        Queue<Integer> q = new LinkedList<>();
        //To keep track of visited node
        boolean[] visited = new boolean[n];
        q.offer(0);
        
        outter:
        while(!q.isEmpty()){
            int start = q.poll();
            //If path is already visited, we can skip it
            if(visited[start] == true) continue;
            visited[start] = true;
            TrieNode ptr = root;
            for(int i=start; i<n; i++){
                int index = s.charAt(i)-'a';
                ptr = ptr.children[index];
                if(ptr == null) continue outter;
                if(ptr.isEnd == true && i<n-1){
                    q.offer(i+1);
                }
            }
            if(ptr.isEnd == true){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        return bfs(s, root);
    }
}
