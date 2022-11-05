package Assignments;
public class StringPermutations {

    public static void swap(char[] arr, int start, int end){
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void permute(char[] arr, int start, int end){
        if(start == end){
            System.out.println(new String(arr));
        }
        else{
            for(int i=start; i<=end; i++){
                swap(arr,start,i);//find combinations
                permute(arr, start+1, end);
                swap(arr,start,i);//backtrack
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        permute(str.toCharArray(),0,str.length()-1);
    }
}
