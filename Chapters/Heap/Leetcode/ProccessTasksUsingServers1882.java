import java.util.PriorityQueue;

public class ProccessTasksUsingServers1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        //(weight,index)
        PriorityQueue<int[]> available = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        for(int i=0; i<servers.length; i++){
            available.add(new int[]{servers[i],i});
        }
        
        //(weight,index,finish time)
        PriorityQueue<int[]> working = new PriorityQueue<>((a,b)->{
            if(a[2]==b[2]){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
            
            return a[2]-b[2];
        });
        int[] result = new int[tasks.length];
        for(int i=0; i<tasks.length; i++){
            int task = tasks[i];
            while(working.size()>0 && working.peek()[2]<=i){
                int[] free_Server = working.poll();
                available.add(new int[]{free_Server[0],free_Server[1]});
            }
            
            if(available.size()>0){
                int[] available_Server = available.poll();
                result[i] = available_Server[1];
                working.add(new int[]{available_Server[0],available_Server[1],i+task});
            }else{
                int[] next_available_Server = working.poll();
                result[i] = next_available_Server[1];
                working.add(new int[]{next_available_Server[0],next_available_Server[1],next_available_Server[2]+task});
            }
        }
        return result;
    }
}
