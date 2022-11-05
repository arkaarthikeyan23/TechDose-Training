package Assignments;
import java.util.ArrayList;

public class GenerateAllSubsets1{
    static ArrayList<String> list = new ArrayList<>();
    public static void getSubsets(String s, int pos, String curr){
        if(pos == s.length()){
            list.add(curr);
            return;
        }
        getSubsets(s, pos+1, curr);//EXCLUDE
        curr+=s.charAt(pos);
        getSubsets(s, pos+1, curr);//INCLUDE
    }

    public static void main(String[] args) {
        String s = "abc";
        getSubsets(s,0,"");
        System.out.println(list);
    }
}