package daimasuixianglu.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeventySeven非递归组合的一个有趣例子_速度差别在于对于无效遍历的早舍弃 {
    public static void main(String[] args) {

    }

    LinkedList<Integer> tmp = new LinkedList<>();
    List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        recall(n,k,0);
        return list;
    }
    public void recall(int n,int k,int last){
        if (k == tmp.size()){
            // List<Integer> new_list = new ArrayList<>(tmp);
            list.add(new ArrayList<>(tmp));
        }else {
            for (int i = last + 1; i <= n - (k - tmp.size()) + 1; i++){
//              for (int i = last + 1; i <= n; i++){
                //原本是这样，多算了很多已经确定无用没有意义的数据。时间从30ms优化到了1ms
                // set.add(i);
                tmp.add(i);
                recall(n,k,i);
                // set.remove(i);
                tmp.removeLast();
            }
        }
    }

//    public List<List<Integer>> combine(int n, int k) {
//        List<Integer> temp = new ArrayList<Integer>();
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        // 初始化
//        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
//        // 末尾加一位 n + 1 作为哨兵
//        for (int i = 1; i <= k; ++i) {
//            temp.add(i);
//        }
//        temp.add(n + 1);
//
//        int j = 0;
//        while (j < k) {
//            ans.add(new ArrayList<Integer>(temp.subList(0, k)));
//            j = 0;
//            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
//            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
//            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
//                temp.set(j, j + 1);
//                ++j;
//            }
//            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
//            temp.set(j, temp.get(j) + 1);
//        }
//        return ans;
//    }


//
}
