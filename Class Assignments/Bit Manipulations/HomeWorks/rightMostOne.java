class rightMostOne
{

    public static int rightMostOneValue(int n){
        return n & (~n+1);
    }
    
    public static int rightMostOnePosition(int n){
        int pos=1;
        while((n&1)==0){
            n = n>>1;
            pos++;
        }
        return pos;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(rightMostOneValue(n));
        System.out.println(rightMostOnePosition(n));
    }    
}