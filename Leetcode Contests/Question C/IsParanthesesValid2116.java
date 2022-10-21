public class IsParanthesesValid2116 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2==1)  return false;
        //Left to Right
        int count=0, balance=0;
        for(int i=0; i<n; i++){
            if(locked.charAt(i)=='0'){
                count++;
            }
            else{
                balance += s.charAt(i)=='('?1:-1;
                if(balance==-1){
                    balance=0;
                    if(count>0) count--;
                    else return false;
                }
            }
        }
        //Right to Left
        count=0;
        balance=0;
        for(int i=n-1; i>=0; i--){
            if(locked.charAt(i)=='0'){
                count++;
            }
            else{
                balance += s.charAt(i)==')'?1:-1;
                if(balance==-1){
                    balance=0;
                    if(count>0) count--;
                    else return false;
                }
            }
        }
        return true;
    }
}
