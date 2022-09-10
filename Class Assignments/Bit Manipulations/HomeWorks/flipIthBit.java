public class flipIthBit {
    public static void main(String[] args) {
        int n=8, i=2, mask=1;
        n = n^(mask<<(i-1));
        System.out.println(n);
    }
}
