package daimasuixianglu.动态规划;

public class Seven3线段树重要 {
    public static void main(String[] args) {
        Seven3线段树重要 s = new Seven3线段树重要(new int[]{-1});
        System.out.println(s.sumRange(0,0));
        s.update(0,1);
        System.out.println(s.sumRange(0,0));
    }
    //自下而上构建线段树，官方解答，非常简洁
    int[] tree;
    int n;
    public Seven3线段树重要(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
//    int[] A;
//    int[] Sum;
//    public Seven3线段树重要(int[] nums) {
//        A = nums;
//        Sum = new int[nums.length*4];
//        SumBuild(A , Sum, 1, 1, nums.length);
//    }
//    private void SumBuild(int[] a, int[] sum, int rt,int l, int r){
//        if (l == r){
//            sum[rt] = a[l - 1];
//            return;
//        }
//        int m = (l + r)/2;
//        SumBuild(a,sum,rt*2,l,m);
//        SumBuild(a,sum,rt*2 + 1, m + 1, r);
//        sum[rt] = sum[rt*2] + sum[rt*2 + 1];
//    }
//
//    public void update(int index, int val) {
//        int max = A.length;
//        updateAll( 1, 1, max, index + 1, val);
//    }
//    private void updateAll(int rt, int l, int r, int index, int val){
//        if (l == r){
//            A[l - 1] = val;
//            Sum[rt] = val;
//            return;
//        }
//        int m = (l + r)/2;
//        if (m >= index) updateAll(rt*2, l, m, index, val);
//        else updateAll(rt*2 + 1, m + 1, r, index, val);
//        Sum[rt] = Sum[rt*2] + Sum[rt*2 + 1];
//    }
//
//    public int sumRange(int left, int right) {
//        return sumAll(1, A.length, left + 1, right + 1, 1);
//    }
//    private int sumAll(int l, int r, int left, int right, int rt){
//        if (l >= left && r <= right){
//            return Sum[rt];
//        }
//        int m = (l + r)/2;
//        int ret = 0;
//        if (m >= left) ret += sumAll(l, m, left, right, rt*2);
//        if (m + 1 <= right) ret += sumAll(m + 1, r, left, right, rt*2 + 1);
//        return ret;
//    }
}
