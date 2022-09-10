public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xorValue = x^y;
        int setBitsCount=0;
        for(int i=0; i<32; i++){
            if(((xorValue>>i)&1 )== 1){
                setBitsCount++;
            }
        }
        return setBitsCount;
    }
}
