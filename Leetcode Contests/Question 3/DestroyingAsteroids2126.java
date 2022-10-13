import java.util.*;
public class DestroyingAsteroids2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr = (long)mass;
        for(int val : asteroids){
            if((long)val > curr)
                return false;
            curr += val;
        }
        return true;
    }
}
