import java.util.ArrayList;
import java.util.PriorityQueue;
//Insertion sort : TC:O(NK)
//Heap : TC:O(Nlogk) -->optimal
public class sortKsortedArray {
    ArrayList <Integer> nearlySorted2(int arr[], int num, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        //If n is less than k+1
        int minCount = Math.min(arr.length, k+1);
        
        for(int i=0; i<minCount; i++){
            pq.add(arr[i]);
        }
        
        for(int i=k+1; i<arr.length; i++){
            list.add(pq.poll());
            pq.offer(arr[i]);
        }
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        
        return list;
    }
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int val : arr){
            al.add(val);
        }
        return al;
    }
}
