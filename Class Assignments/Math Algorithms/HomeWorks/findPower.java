import java.util.*;
public class findPower{
    //TC:O(n)
    public static int findPower1(int base, int power){
        int result=1;
        for(int i=1; i<=power; i++){
            result = result*base;
        }
        return result;
    }

    //TC:O(log(n))
    public static int findPower2(int base, int power){
        int result=1;
        while(power>0){
            if(power%2==1){
                result = result*base;
            }
            base = base*base;
            power = power/2;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int power = sc.nextInt();
        sc.close();
        System.out.println(findPower1(base,power));
        System.out.println(findPower2(base,power));
    }
}