public class LongestSubstringWithoutRepeatingCharacters3{
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), start=0, end=0, max=0;
        int[] hash = new int[128];
        while(end<len){
            hash[s.charAt(end)]++;
            while(hash[s.charAt(end)]>1){
                hash[s.charAt(start)]--;
                start++;
            }
            max = Math.max(max,end-start+1);
            end++;
        }
        return max;
    }
}