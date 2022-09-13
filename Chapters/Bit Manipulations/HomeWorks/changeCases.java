public class changeCases {

    public static String toLower(String s){
        String ans="";
        for(char ch : s.toCharArray()){
            ans +=(char)(ch | (1<<5)); // 1<<5 == 32--> 'ch' + 32 
        }
        return ans;
    }

    public static String toUpper(String s){
        String ans="";
        for(char ch : s.toCharArray()){
            ans += (char)(ch & (~(1<<5))); // 1<<5 == 32--> 'ch' - 32 
        }
        return ans;
    }

    public static String toggle(String s){
        String ans="";
        for(char ch : s.toCharArray()){
            ans += (char)(ch ^ (1<<5));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "APPLE", s2="apple", s3="Apple";
        System.out.println(toLower(s1));
        System.out.println(toUpper(s2));
        System.out.println(toggle(s3));
    }
}
