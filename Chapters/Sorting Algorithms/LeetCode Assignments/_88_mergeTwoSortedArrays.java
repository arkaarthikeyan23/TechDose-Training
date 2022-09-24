public class _88_mergeTwoSortedArrays{
    //TC:O(m+n)
    //SC:O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeArr = new int[m+n];
        int index=0, i=0, j=0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                mergeArr[index++] = nums1[i++];
            }
            else{
                mergeArr[index++] = nums2[j++];
            }
        }
        for(; i<m; i++){
            mergeArr[index++] = nums1[i];
        }
        for(; j<n; j++){
            mergeArr[index++] = nums2[j];
        }
        for(i=0; i<m+n; i++){
            nums1[i] = mergeArr[i];
        }
    }
}