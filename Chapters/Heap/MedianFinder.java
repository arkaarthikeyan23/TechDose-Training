package TechDose_Training.Chapters.Heap;
import java.util.*;
class MedianFinder {
    private PriorityQueue<Integer> minHeap = null;
    private PriorityQueue<Integer> maxHeap = null;
    /*Initialize the data structure here*/
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b)->(a-b));
        maxHeap = new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0 || maxHeap.peek()>=num){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        //Balancing the Heap
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        else if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }
        else{
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
    }
}

