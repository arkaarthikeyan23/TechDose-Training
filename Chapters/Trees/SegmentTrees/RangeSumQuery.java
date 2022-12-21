package SegmentTrees;

public class RangeSumQuery {
    static int[] st;

    public static void buildSegTree(int[] arr, int st_index, int start, int end){
        if(start == end){//Leaf Node
            st[st_index] = arr[start];
            return;
        }
        //Internal Node
        int mid = start + (end-start)/2;
        buildSegTree(arr, 2*st_index, start, mid);
        buildSegTree(arr, 2*st_index+1, mid+1, end);
        st[st_index] = st[2*st_index] + st[2*st_index+1];
    }

    public static int query(int qs, int qe, int st_index, int start, int end){
        if(qs>end || qe<start){//No Overlap
            return 0;
        }
        if(qs<=start && end<=qe){//Total Overlap
            return st[st_index];
        }
        //Partial Overlap
        int mid = start  + (end-start)/2;
        int lsum = query(qs, qe, 2*st_index, start, mid);
        int rsum = query(qs, qe, 2*st_index+1, mid+1, end);
        return lsum + rsum;
    }

    public static void updateNode(int st_index, int start, int end, int pos, int newValue){
        if(start>pos || end<pos){//No Overlap
            return;
        }
        if(start==end){//Total Overlap
            st[st_index] = newValue;
            return;
        }
        //Partial Overlap
        int mid = start + (end-start)/2;
        updateNode(2*st_index, start, mid, pos, newValue);
        updateNode(2*st_index+1, mid+1, end, pos, newValue);
        st[st_index] = st[2*st_index] + st[2*st_index+1];
    }


    public static void main(String[] args) {
        int n=6;
        int[] arr = {1,3,2,-2,4,5};

        st = new int[4*n+1];
        int st_index=1;
        int start = 0, end = n-1;

        //Preprocess
        buildSegTree(arr, st_index, start, end);
        System.out.println("Segment Tree is:");
        for(int i=0; i<=4*n; i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();

        System.out.println("Query is 0-based indexed");
        System.out.println("RangeSum(2,4): "+query(2,4,st_index, start, end));
        System.out.println("RangeSum(1,4): "+query(1,4,st_index, start, end));
        System.out.println("RangeSum(3,3): "+query(3,3,st_index, start, end));

        arr[2] = 100;
        //st_index=1;
        updateNode(st_index, start,end, 2, 100);
        System.out.println("Segment Tree is:");
        for(int i=0; i<=4*n; i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();

        System.out.println("Query is 0-based indexed");
        System.out.println("RangeSum(2,4): "+query(2,4,st_index, start, end));
        System.out.println("RangeSum(1,4): "+query(1,4,st_index, start, end));
        System.out.println("RangeSum(3,3): "+query(3,3,st_index, start, end));
    }
}
