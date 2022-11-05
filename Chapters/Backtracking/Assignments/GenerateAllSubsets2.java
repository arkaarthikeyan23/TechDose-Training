package Assignments;
import java.util.*;
public class GenerateAllSubsets2 {
    static List<List<Integer>> allSubSets = new ArrayList<>();

    public static void generateSubsets(int[] arr, int pos, List<Integer> curr){
        if(pos == arr.length){
            allSubSets.add(new ArrayList<>(curr));
            return;
        }
        generateSubsets(arr, pos+1, curr);//Include
        curr.add(arr[pos]);
        generateSubsets(arr, pos+1, curr);//Exclude
        curr.remove(curr.size()-1);//Save the state to it's previous state
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        generateSubsets(arr,0,new ArrayList<>());
        System.out.println(allSubSets);
    }
}
