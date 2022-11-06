import java.util.*;
public class LongestDuplicateSubstring1044 {
    //TC:O(nlogn)
    private int primeNo = 37;
    
    public String longestDupSubstring(String s) {
        int low=0, high = s.length();
        String ans = "";
        while(low<high){
            int mid = low+(high-low)/2;
            String str = getDuplicate(s,mid);
            if(str!=null && str.length()!=0){
                ans = str;
                low = mid+1;
            }else{
                high=mid;
            }
        }
        return ans;
    }
    
    public String getDuplicate(String s, int len){
        //Hashes for particular string
        Set<Long> set = new HashSet<>();
        long currHash = getHash(s.substring(0,len));
        set.add(currHash);
        
        long pow=1;//max pow in a string
        for(int i=1; i<len; i++){
            pow *= primeNo;
        }
        
        for(int i=1; i<=s.length()-len; i++){
            currHash = nextHash(pow,currHash,s.charAt(i-1),s.charAt(i+len-1));
            if(set.contains(currHash)){
                return s.substring(i,i+len);
            }
            set.add(currHash);
        }
        return null;
    }
    
    public long nextHash(long pow, long oldHash, char left, char right){
        return (oldHash - left*pow)*primeNo + right;
    }
    
    public long getHash(String s){
        long hash = 0;
        long factor = 1;
        int n = s.length();
        for(int i=n-1; i>=0; i--){
            hash += s.charAt(i)*factor;
            factor *= primeNo;
        }
        return hash;
    }
}
