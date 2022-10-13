public class NumberOfLaserBeams2125 {
    public int numberOfBeams(String[] bank) {
        int result=0;
        int prev=0;
        for(String s : bank){
            int curr=0;
            for(char ch : s.toCharArray()){
                if(ch=='1'){
                    curr++;
                }
            }
            if(curr>0){
                result += (curr*prev);
                prev = curr;
            }
        }
        return result;
    }
}
