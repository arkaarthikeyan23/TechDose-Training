import java.util.Arrays;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
public class CarFleet853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Map<Integer,Float> map = new HashMap<>();
        for(int i=0; i<n; i++){
            float time = (float)(target - position[i]) / speed[i] ;
            map.put(position[i],time);
        }
        Arrays.sort(position);
        Stack<Float> stk = new Stack<>();
        stk.push(map.get(position[n-1]));
        for(int i=n-2; i>=0; i--){
            if(map.get(position[i]) > stk.peek()){
                stk.push(map.get(position[i]));
            }
        }
        return stk.size();
    }
}
