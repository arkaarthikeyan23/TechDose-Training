import java.util.Stack;
import javafx.util.Pair;
//LC:901
class StockSpanner {
    Stack<Pair<Integer,Integer>> stk = new Stack<>();
    int index;
    public StockSpanner() {
        index=-1;
    }
    
    public int next(int price) {
        index++;
        //PGE
        while(!stk.isEmpty() && price>=stk.peek().getValue()){
            stk.pop();
        }
        if(stk.isEmpty()){
            stk.push(new Pair<>(index,price));
            return index+1;
        }
        int topIndex = stk.peek().getKey();
        stk.push(new Pair<>(index,price));
        return index-topIndex;
    }
}
