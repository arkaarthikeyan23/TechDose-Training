import java.util.*;
public class MinimumOperationsToMakeArrayKincreasing {
    //Perform Binary Search to get next greater element
    public int get(List<Integer> list, int key){
        int left=0, right = list.size()-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(list.get(mid) <= key){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    public int LIS_Length(List<Integer> list){
        List<Integer> incrlist = new ArrayList<>();
        incrlist.add(list.get(0));

        for(int i=1; i<list.size(); i++){
            int lastItem = incrlist.get(incrlist.size()-1);
            if(list.get(i) >= lastItem){
                incrlist.add(list.get(i));
            }else{
                int ceilIndex = get(incrlist, list.get(i));
                incrlist.set(ceilIndex, list.get(i));
            }
        }
        return incrlist.size();
    }

    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ans=0;
        for(int i=0; i<k; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=i; j<n; j+=k){
                list.add(arr[j]);
            }
            ans+= list.size() - LIS_Length(list);
        }
        return ans;
    }
}
