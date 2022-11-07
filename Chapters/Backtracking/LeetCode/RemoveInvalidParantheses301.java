import java.util.*;

public class RemoveInvalidParantheses301{
    public int getMinInvalid(String s){
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stk.push(ch);
            }else if(ch==')'){
                if(!stk.isEmpty() && stk.peek()=='('){
                    stk.pop();
                }else{
                    stk.push(ch);
                }
            }
        }
        return stk.size();
    }
    
    public void dfs(String s, int min, List<String> list, Map<String,Integer> map){
        if(map.get(s)!=null && (int)map.get(s)!=0){
            return;
        }else{
            map.put(s,1);
        }
        //Base case
        if(min<0)   return;
        if(min==0){
            if(getMinInvalid(s)==0)
                list.add(s);
            return;
        }
        for(int i=0; i<s.length(); i++){
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            dfs(left+right, min-1, list, map);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int min = getMinInvalid(s);
        dfs(s, min, list, map);
        return list;
    }
}