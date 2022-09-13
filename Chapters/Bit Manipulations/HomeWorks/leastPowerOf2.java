public class leastPowerOf2 {
    public static void main(String[] args) {
        int n = 87;
        while(n>0 && (n & (n-1))>0){
            n = n&(n-1);
        }
        System.out.println(n);
    }
}
