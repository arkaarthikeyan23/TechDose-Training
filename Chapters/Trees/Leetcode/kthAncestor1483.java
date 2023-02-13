package Leetcode;
import java.util.Arrays;

public class kthAncestor1483 {
    //Binary Lifting
    int maxAncestor;
    int[][] parentTable;
    public kthAncestor1483(int n, int[] parent) {//TC:O(NlogN)
        //Preprocessing
        maxAncestor = (int)Math.ceil(Math.log(n)/Math.log(2));
        parentTable = new int[n][maxAncestor];

        for(int i=0; i<n; i++){
            Arrays.fill(parentTable[i], -1);
            parentTable[i][0] = parent[i];
        }

        //Fill all other cols
        for(int col=1; col<maxAncestor; ++col){
            for(int v=0; v<n; ++v){
                int tempParent = parentTable[v][col-1]==-1?0:parentTable[v][col-1];
                parentTable[v][col] = parentTable[tempParent][col-1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int col = maxAncestor-1; col>=0; --col){
            if(k >= (1<<col) && parentTable[node][col]!=-1){
                node = parentTable[node][col];
                k -= (1<<col);
            }
        }
        return k==0?node : -1;
    }
}
