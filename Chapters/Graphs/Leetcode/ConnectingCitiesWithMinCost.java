import java.util.*;

public class ConnectingCitiesWithMinCost{
    int[] dsuf;

    public int find(int u){
        if(dsuf[u] == -1){
            return u;
        }
        return dsuf[u] = find(dsuf[u]);
    }

    public int minimumCost(int n, int[][] connections) {
        //Sort the edges in increasing order of cost
        Arrays.sort(connections, (a,b)->a[2]-b[2]);

        dsuf = new int[n+1];
        Arrays.fill(dsuf, -1);

        int ans=0;
        for(int[] connection : connections){
            int x = connection[0];
            int y = connection[1];
            int cost = connection[2];
            int xParent = find(x);
            int yParent = find(y);

            if(xParent == yParent){//If cycle formed, skip the edge
                continue;
            } 
            ans += cost;
            dsuf[xParent] = yParent; //Union
        }
        int count=0;
        for(int i=1; i<=n; i++){
            if(dsuf[i]==-1){
                count++;
            }
        }
        if(count==1){//Single component
            return ans;
        }
        return -1;
    }
}
