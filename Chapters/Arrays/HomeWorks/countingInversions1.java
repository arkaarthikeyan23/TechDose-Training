//counting inversions in two sorted array
public class countingInversions1
{
    public static int getInversions(int[] a, int[] b){
        int m=a.length, n=b.length;
        int count=0, i=0, j=0;
        while(i<m && j<n){
            if(a[i]>b[j]){
                count += (m-i);
                j++;
            }
            else{
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a1 = {2,4,6,8};
        int[] a2 = {1,5,7,8};
        System.out.println(getInversions(a1,a2));
    }
}