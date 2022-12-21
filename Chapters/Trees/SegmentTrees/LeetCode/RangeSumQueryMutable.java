package SegmentTrees.LeetCode;

class RangeSumQueryMutable {
    int[] st;
    int n;

    public void buildSegTree(int[] nums, int st_index, int start, int end){
        if(start>end)   return;
        if(start==end){//Leaf Node
            st[st_index] = nums[start];
            return;
        }
        //Internal Node
        int mid = start+(end-start)/2;
        buildSegTree(nums, 2*st_index, start, mid);
        buildSegTree(nums, 2*st_index+1, mid+1, end);
        st[st_index] = st[2*st_index] + st[2*st_index+1];
    }

    public int query(int qs, int qe, int st_index, int start, int end){
        if(qs>end || qe<start){//No Overlap
            return 0;
        }
        if(qs<=start && end<=qe){//Total Overlap
            return st[st_index];
        }
        //Partial Overlap
        int mid = start + (end-start)/2;
        int lsum = query(qs, qe, 2*st_index, start, mid);
        int rsum = query(qs, qe, 2*st_index+1, mid+1, end);
        return lsum + rsum;
    }

    public void updateNode(int st_index, int start, int end, int pos, int newValue){
        if(start > pos || end < pos){//No Overlap
            return;
        }
        if(start == end){//Total Overlap
            st[st_index] = newValue;
            return;
        }
        //Partial Overlap
        int mid = start + (end-start)/2;
        updateNode(2*st_index, start, mid, pos, newValue);
        updateNode(2*st_index+1, mid+1, end, pos, newValue);
        st[st_index] = st[2*st_index] + st[2*st_index+1];
    }

    public RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        int height = (int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size = (1<<height)-1; //2^h-1;
        st = new int[size+1];
        int st_index=1, start=0, end=n-1;
        buildSegTree(nums, st_index, start, end);
    }
    
    public void update(int index, int val) {
        int st_index=1, start=0, end=n-1;
        updateNode(st_index, start, end, index, val);
    }
    
    public int sumRange(int left, int right) {
        int st_index=1, start=0, end=n-1;
        return query(left, right, st_index, start, end);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */