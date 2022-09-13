import java.util.*;
/*
 LCM = (a*b)/GCD(a,b)
 GCD = (a*b)/LCM(a,b)
 */
public class _3_lcm {
    public static List<Integer> getPrimeFactors(int num){
        List<Integer> primeFactors = new ArrayList<>();
        for(int i=2; i*i<=num; i++){
            while(num%i==0){
                primeFactors.add(i);
                num = num / i;
            }
        }
        if(num>1)
            primeFactors.add(num);
        return primeFactors;
    }

    
    public static int getGCD(int a, int b){
        if(a==0)
            return b;
        return getGCD(b%a, a);
    }

    //Using Prime factors method
    public static int getLCM2(int a, int b){
        List<Integer> l1 = getPrimeFactors(a);
        List<Integer> l2 = getPrimeFactors(b);
        int lcm = 1;
        //Union of two lists
        for(Integer val : l1){
            lcm = lcm*val;
        }
        for(Integer val : l2){
            if(!l1.contains(val)){
                lcm = lcm*val;
            }
        }
        return lcm;
        
    }
    //Efficient Solution
    public static int getLCM1(int a, int b){
        return (a/getGCD(a,b) * b);// Distributive Property
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=sc.nextInt(), num2=sc.nextInt();
        sc.close();
        System.out.println(getLCM1(num1,num2));
        System.out.println(getLCM2(num1, num2));
    }
}
