import java.util.*;
public class __17countFrequency {
    public static void printFrequency(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        printFrequency(s);
    }   
}
