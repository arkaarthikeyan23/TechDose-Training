import java.util.*;
public class DesignBitSet2166{
    private int size;
    private Set<Integer> one = new HashSet<>();
    private Set<Integer> zero = new HashSet<>();
    public void Bitset(int size) {
        this.size = size;
        for(int i=0; i<size; i++){
            zero.add(i);
        }
    }
    
    public void fix(int idx) {
        zero.remove(idx);
        one.add(idx);
    }
    
    public void unfix(int idx) {
        one.remove(idx);
        zero.add(idx);
    }
    
    public void flip() {
        Set<Integer> temp = zero;
        zero = one;
        one = temp;
    }
    
    public boolean all() {
        return one.size()==size;
    }
    
    public boolean one() {
        return one.size()>=1;
    }
    
    public int count() {
        return one.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            if(one.contains(i)) sb.append("1");
            else if(zero.contains(i)) sb.append("0");
        }
        return sb.toString();
    }
}