import java.util.*;
//sieve of Eratosthenes
public class primesBetwen1ToN {
    //TC:O(n*n)
    public static List<Integer> getAllPrime1(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=(n/2); i++){
            if(prime[i]){
                //make all multiples false
                for(int j=2*i; j<=n; j=j+i){
                    prime[j] = false;
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(prime[i])
                list.add(i);
        }
        return list;
    }
    //TC:O(n*log(log(n)))
    public static List<Integer> getAllPrime2(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        List<Integer> list = new ArrayList<>();
        for(int i=2; i*i<=n; i++){
            if(prime[i]){
                for(int j=i*i; j<=n; j+=i){
                    prime[j] = false;
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(prime[i])
                list.add(i);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(getAllPrime1(n));
        System.out.println(getAllPrime2(n));
    }
}
