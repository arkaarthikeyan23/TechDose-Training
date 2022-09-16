public class _022stringToInt {
    public int myAtoi(String s) {
        int index=0, result=0, n = s.length();
        boolean negative=false;
        //Trimming whitespaces
        while(index<n && s.charAt(index)==' '){
            index++;
        }
        //Determine + or -
        if(index<n && s.charAt(index)=='+'){
            index++;
        }
        else if(index<n && s.charAt(index)=='-'){
            negative = true;
            index++;
        }
        //generate number and avoid overflow
        while(index<n && s.charAt(index)>='0' && s.charAt(index)<='9'){
            int digit = s.charAt(index)-'0';
            /*check overflow (result*10+digit)>max
              result > (max-digit)/10*/
            if(result > (Integer.MAX_VALUE - digit)/10){
                if(negative){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            result = result*10 + digit;
            index++;
        }
        if(result==0){
            return result;
        }
        else{
            if(negative){
                return -result;
            }
            else{
                return result;
            }
        }
    }
}
