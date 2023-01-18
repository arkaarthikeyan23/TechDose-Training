import java.util.*;

import javafx.util.Pair;

public class EvaluateDivision{
    int index;
    double[] ans;
    boolean isVisited;

    public void dfs(Map<String,List<Pair<String,Double>>> map, Set<String> visited, String src, String dest, double value){
        visited.add(src);
        if(src.equals(dest)){
            ans[index++] = value;
            isVisited = true;
            return;
        }
        for(Pair<String,Double> pair : map.get(src)){
            String adj = pair.getKey();
            Double weight = pair.getValue();
            if(!visited.contains(adj)){
                dfs(map, visited, adj, dest, value*weight);
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair<String,Double>>> map = new HashMap<>();
        index=0;
        for(List<String> equation : equations){
            String u = equation.get(0);
            String v = equation.get(1);
            double w = values[index++];
            if(!map.containsKey(u)){
                map.put(u, new ArrayList<>());
            }
            if(!map.containsKey(v)){
                map.put(v, new ArrayList<>());
            }
            map.get(u).add(new Pair<>(v, w));
            map.get(v).add(new Pair<>(u, 1/w));
        }
        index=0;
        ans = new double[queries.size()];
        for(List<String> query : queries){
            String src = query.get(0);
            String dest = query.get(1);
            if(!map.containsKey(src) || !map.containsKey(dest)){
                ans[index++] = -1.0;
            } 
            else{
                isVisited = false;
                Set<String> visited = new HashSet<>();
                double value = 1.0;
                dfs(map, visited, src, dest, value);
                if(isVisited == false){
                    ans[index++] = -1.0;
                }
            }
        }
        return ans;
    }
}
