import java.util.*;
public class kthSmallestElementInSortedMatrix {
    //Approach 1:
    //Priority Queue -->TC:O(NlogK)
    public int kthSmallest(int[][] matrix, int k) {
        //Create MAX HEAP 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
    //Approach 2: using Binary Search
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int low=matrix[0][0], high=matrix[n-1][n-1];
        while(low<high){
            int mid = low+(high-low)/2;
            if(getCount(matrix,mid)<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return high;
    }
    public int getCount(int[][] mat, int target){
        int n = mat.length;
        int i=0, j=n-1;
        int count=0;
        while(i<n && j>=0){
            if(mat[i][j]<=target){
                count+=j+1;
                i++;
            }
            else{
                j--;
            }
        }
        return count;
    }
}
