import java.util.*;

public class _0090WordBreakII {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode buildTrie(List<String> words){
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
    
    void bfs(String s, TrieNode root, List<String> ans){
        int n = s.length();
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{"","0"});
        outter:
        while(!q.isEmpty()){
            String[] arr = q.poll();
            int start = Integer.parseInt(arr[1]);
            TrieNode temp = root;
            for(int i=start; i<n; i++){
                int index = s.charAt(i)-'a';
                temp = temp.children[index];
                if(temp==null)  continue outter;
                if(temp.isEnd==true && i<n-1){
                    q.offer(new String[]{arr[0]+" "+(s.substring(start,i+1)), (i+1)+""});
                }
            }
            if(temp.isEnd == true){
                String str = arr[0]+" "+(s.substring(start));
                ans.add(str.substring(1));
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(wordDict);
        bfs(s, root, ans);
        return ans;
    }
}
