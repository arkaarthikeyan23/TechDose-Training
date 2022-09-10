public class DecodeXoredPermutation {
    public int[] decode(int[] encoded) {
        int totalXor=0, N = encoded.length;
        int[] result = new int[N+1];
        for(int i=1; i<=N+1; i++){
            totalXor = totalXor^i;
        }
        int encodedXor=0;
        for(int i=1; i<N; i+=2){
            encodedXor = encodedXor^encoded[i];
        }
        result[0] = totalXor ^ encodedXor;
        for(int i=0; i<N; i++){
            result[i+1] = result[i]^encoded[i];
        }
        return result;
    }
}
