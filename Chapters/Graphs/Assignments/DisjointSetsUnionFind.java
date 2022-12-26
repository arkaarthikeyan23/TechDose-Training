
import java.util.*;
//TC:O(V*E)
public class DisjointSetsUnionFind{
    static int[] dsuf;
    public static int find(int v){
        if(dsuf[v] == -1){
            return v;
        }
        return find(dsuf[v]);
    }

    public static void union(int fromP, int toP){
        fromP = find(fromP);
        toP = find(toP);
        dsuf[fromP] = toP;
    }

    public static boolean isCyclic(List<int[]> edges){
        for(int[] edge : edges){
            int fromP = edge[0];//absolute parent
            int toP = edge[1];

            if(find(fromP) == find(toP)){//if same absolute parent , then cycle is formed
                return true;
            }

            union(fromP, toP);//perform union operation on two sets;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        List<int[]> edges = new ArrayList<>();

        dsuf = new int[v+1];
        Arrays.fill(dsuf,-1);
        for(int i=0; i<e; i++){
            int fromP = sc.nextInt();
            int toP = sc.nextInt();

            edges.add(new int[]{fromP, toP});
        }
        sc.close();

        if(isCyclic(edges)){
            System.out.println("Cycle is detected!!");
        }else{
            System.out.println("Cycle is not detected!!");
        }
        
    }
}