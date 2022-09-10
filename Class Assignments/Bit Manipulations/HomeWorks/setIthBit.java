public class setIthBit {
    public static void main(String[] args) {
        int n=10, i=3;
        int mask = 1;
        mask = mask<<(i-1);
        n = n | mask;   
        System.out.println(n);
        //unset
        int m=10, pos=3;
        m = m & (~(1<<(pos-1)));
        System.out.println(m);
    }
}
