package Chapters.Graphs.Assignments;
import java.util.*;
//TC:O(ElogV)
public class DSUF_PathCompression_UnionByRank{
    static int[][] dsuf;
    //FIND by PATH COMPRESSION
    public static int find(int v){
        if(dsuf[v][0] == -1){
            return v;
        }
        return dsuf[v][0] = find(dsuf[v][0]);//path compression
    }

    //UNION by RANK
    public static void union(int fromP, int toP){
        if(dsuf[fromP][1] > dsuf[toP][1]){//fromP has higher rank
            dsuf[toP][0] = fromP;
        }
        else if(dsuf[toP][1] > dsuf[fromP][1]){//toP has higher rank
            dsuf[fromP][0] = toP;
        }
        else{//If same rank increment the absolute parent by 1
            dsuf[fromP][0] = toP;
            dsuf[toP][1] +=1;
        }
    }

    public static boolean isCyclic(List<int[]> edges){
        for(int[] curr : edges){
            int fromP = find(curr[0]);
            int toP = find(curr[1]);

            if(fromP == toP){
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

        dsuf = new int[v][2];
        for(int i=0; i<v; i++){
            dsuf[i][0] = -1;
            dsuf[i][1] = 0;
        }

        List<int[]> edges = new ArrayList<>();
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