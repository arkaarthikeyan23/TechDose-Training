//LC:380
import java.util.*;
class RandomizedSet {
    List<Integer> list = null;
    Map<Integer,Integer> map = null;//(val,index in arrayList)
    Random rand = null;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            Integer lastNodeVal = list.get(list.size()-1);
            int index = map.get(val);
            list.set(index,lastNodeVal);
            map.put(lastNodeVal,index);
            list.remove(list.size()-1);
            map.remove(new Integer(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int size = list.size();
        int index = rand.nextInt(size);
        return list.get(index);
    }
}
