import java.util.*;

public class DSUFoptimized{
    class node{
        int parent, rank;
    }    
    static node dsuf[];

    //FIND by PATH COMPRESSION
    public static int find(int v){
        if(dsuf[v].parent == -1){
            return v;
        }
        return dsuf[v].parent = find(dsuf[v].parent);//path compression
    }

    //UNION by RANK
    public static void union(int fromP, int toP){
        if(dsuf[fromP].rank > dsuf[toP].rank){//fromP has higher rank
            dsuf[toP].parent = fromP;
        }
        else if(dsuf[toP].rank > dsuf[fromP].rank){//toP has higher rank
            dsuf[fromP].parent = toP;
        }
        else{//If same rank increment the absolute parent by 1
            dsuf[fromP].parent = toP;
            dsuf[toP].rank +=1;
        }
    }

    public static boolean isCyclic(List<int[]> edges){
        for(int[] curr : edges){
            int fromP = curr[0];
            int toP = curr[1];

            if(find(fromP) == find(toP)){
                return true;
            }
            union(fromP, toP);
        }
        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<e; i++){
            int fromP = sc.nextInt();
            int toP = sc.nextInt();

            edges.add(new int[]{fromP, toP});
        }
        sc.close();
        dsuf = new node[v];
        for(int i=0; i<v; i++){
            dsuf[i].parent = -1;
            dsuf[i].rank = 0;
        }

        if(isCyclic(edges)){
            System.out.println("Cycle is detected!!");
        }else{
            System.out.println("Cycle is not detected!!");
        }
    }
}