import java.util.*;

public class GraphValidTree {
    int[] dsuf;

    public int find(int u){
        if(dsuf[u] == -1)
            return u;
        return dsuf[u] = find(dsuf[u]);
    }

    public boolean validTree(int n, int[][] edges) {
        dsuf = new int[n];
        Arrays.fill(dsuf, -1);

        for(int[] edge : edges){
            int Xparent = find(edge[0]);
            int Yparent = find(edge[1]);

            if(Xparent == Yparent){//Cycle Detected
                return false;
            }

            dsuf[Xparent] = Yparent;//Union
        }

        if(n-1 == edges.length){//Single Component
            return true;
        }
        return false;
    }
}
