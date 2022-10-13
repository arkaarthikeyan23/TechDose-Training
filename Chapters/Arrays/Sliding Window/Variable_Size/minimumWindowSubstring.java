package Variable_Size;
public class minimumWindowSubstring
{
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int start=0, end=0, minStart=0, minLen=Integer.MAX_VALUE, counter=t.length();
        while(end < s.length()){
            char curr = s.charAt(end);
            if(freq[curr]>0){
                counter--;
            }
            freq[curr]--;
            end++;
            while(counter==0){
                int currLen = end-start;
                if(currLen < minLen){
                    minLen = currLen;
                    minStart = start;
                }
                char startCh = s.charAt(start);
                freq[startCh]++;
                if(freq[startCh]>0){
                    counter++;
                }
                start++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }
}