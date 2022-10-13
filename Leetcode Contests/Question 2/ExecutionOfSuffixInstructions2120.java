public class ExecutionOfSuffixInstructions2120
{
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            int x = startPos[0], y = startPos[1];
            int moves=0;
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                if(ch=='L'){
                    y--;
                }else if(ch=='R'){
                    y++;
                }else if(ch=='U'){
                    x--;
                }else if(ch=='D'){
                    x++;
                }
                if(x<0 || x>=n || y<0 || y>=n){
                    break;
                }else{
                    moves++;
                }
            }
            result[i] = moves;
        }
        return result;
    }
}