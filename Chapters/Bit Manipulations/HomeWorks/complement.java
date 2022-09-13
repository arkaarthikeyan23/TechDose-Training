import java.util.*;
public class complement {
    
    public static  int getOnesComplement(int n){
        return (~(n));
    }

    public static int getTwosComplement(int n){
        return (~n)+1;
    }

    public static int getOnesComplementUptoMSB(int n){
        for(int i=0; (n>>i)!=0; i++){
            n = n^(1<<i);
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(getOnesComplement(n));
        System.out.println(getTwosComplement(n));
        System.out.println(getOnesComplementUptoMSB(n));
    }
}
