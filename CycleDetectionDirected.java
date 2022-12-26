import java.util.*;

//For Directed graph, 2 colors (T-->processed/F-->unvisited)
//TC:O(V.E)
public class CycleDetectionDirected {

    public static boolean isCyclic_Util(List<List<Integer>> al, boolean[] visited, int curr){
        if(visited[curr] == true){
            return true;
        }
        visited[curr] = true;
        boolean flag = false;
        for(int val : al.get(curr)){
            if(visited[val] == false){
                flag = isCyclic_Util(al, visited, val);
                if(flag == true){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclic(List<List<Integer>> al, int n){
        

        boolean flag = false;
        for(int i=0; i<n; i++){
            boolean[] visited = new boolean[n];
            //visited[i] = true;
            for(int val : al.get(i)){
                flag = isCyclic_Util(al, visited, val);
                if(flag==true){
                    return true;
                }
            }
            visited[i] = false;
        }
        return false;
    }


    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
        int n = 5;
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        //0->1
        al.get(0).add(1);
        //2->1->3
        al.get(2).add(1);
        al.get(2).add(3);
        //3->4
        al.get(3).add(4);
        //4->0->2
        al.get(4).add(0);
        al.get(4).add(2);

        if(isCyclic(al, n)){
            System.out.println("Cycle is Detected!!");
        }else{
            System.out.println("Cycle is not Detected!!");
        }
    }
}
