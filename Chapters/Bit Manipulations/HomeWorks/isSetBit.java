public class isSetBit {
    public static void main(String[] args) {
        int n = 10, i=4, mask=1;
        mask = mask<<(i-1);
        if((n & mask)>0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
