public class countSetBits {
    public static void main(String[] args) {
        int n = 10, mask=1, count=0;
        while(mask>0){
            if((mask & n) > 0){
                count++;
            }
            mask = mask<<1;
        }
        System.out.println(count);
    }
}
