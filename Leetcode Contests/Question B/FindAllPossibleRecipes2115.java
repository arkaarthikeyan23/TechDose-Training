import java.util.*;
public class FindAllPossibleRecipes2115{
    //Topological sort & BFS
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,List<String>> adj = new HashMap<>();
        Map<String,Integer> indegree = new HashMap<>();
        
        for(int i=0; i<ingredients.size(); i++){
            for(int j=0; j<ingredients.get(i).size(); j++){
                adj.putIfAbsent(ingredients.get(i).get(j),new ArrayList<>());
                adj.get(ingredients.get(i).get(j)).add(recipes[i]);
                indegree.put(recipes[i],indegree.getOrDefault(recipes[i],0)+1);
            }
        }
        Queue<String> q = new LinkedList<>();
        for(String s : supplies){
            q.offer(s);
        }
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            String front = q.poll();
            if(!adj.containsKey(front)){
                continue;
            }
            for(String s : adj.get(front)){
                indegree.put(s,(int)indegree.get(s)-1);
                if(indegree.get(s)==0){
                    q.offer(s);
                    ans.add(s);
                }
            }
        }
        return ans;
    }
}