import java.util.*;
public class primeFactors {
    public static List<Integer> getPrimeFactors(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=2; i*i<=n; i++){
            while(n%i==0){
                n/=i;
                list.add(i);
            }
        }
        if(n>1)
            list.add(n);
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(getPrimeFactors(n));
        
    }
}
