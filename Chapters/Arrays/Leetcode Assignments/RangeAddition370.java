import java.util.Scanner;
public class RangeAddition370 {

    static int[] getModifiedArray(int length, int[][] queries){
        int[] result = new int[length];

        for(int i=0; i<queries.length; i++){
            int index1 = queries[i][0];
            int index2 = queries[i][1];
            int incrementBy = queries[i][2];

            result[index1] += incrementBy;
            if(index2+1<length){
                result[index2+1] -= incrementBy;
            }

        }
        for(int i=1; i<length; i++){
            result[i] += result[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int no_of_queries = sc.nextInt();
        int[][] queries = new int[no_of_queries][3];
        for(int i=0; i<no_of_queries; i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }
        sc.close();
        int[] result = getModifiedArray(length,queries);
        for(int i=0; i<length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
/*
I/P:
5 ->length
3 ->queries length
1 3 2
2 4 3
0 2 -2
O/P:
-2 0 3 5 3

I/P:
10
3
2 4 6
5 6 8
1 9 -4
O/P:
0 -4 2 2 2 4 4 -4 -4 -4 
 */
