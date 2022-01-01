package LeetcodeAll.week271;

import java.util.Deque;
import java.util.LinkedList;

public class Four21考虑用单调栈_完成n时间复杂度未完成 {
    public static void main(String[] args) {

    }
    //使用单调栈，求得所有数组最大数之和与最小数之和
    // 重写根据下标取值方法，-1和n返回MAX_VALUE，用于求取子数组最大值的过程中
    private int getElement1(int[] nums, int n, int i) {
        if (i == -1 || i == n) {
            return Integer.MAX_VALUE;
        }
        return nums[i];
    }

    // 重写根据下标取值方法，-1和n返回MIN_VALUE，用于求取子数组最小值的过程中
    private int getElement2(int[] nums, int n, int i) {
        if (i == -1 || i == n) {
            return Integer.MIN_VALUE;
        }
        return nums[i];
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;

        // 单调栈（准确的说是单调递增栈），求取每个元素作为子数组最大值的贡献度
        Deque<Integer> stack = new LinkedList<>();
        // 将下标-1和n作为两个哨兵元素，它们对应的元素为MAX_VALUE
        // -1作为最左边界，n作为最右边界
        for (int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getElement1(nums, n, stack.peek()) < getElement1(nums, n, i)) {
                int cur = stack.pop();
                ans = ans + (long)(cur - stack.peek()) * (i - cur) * nums[cur];
            }
            stack.push(i);
        }

        // 重新恢复成空的单调栈（准确的说是单调递减栈），求取每个元素作为子数组最小值的贡献度
        stack.clear();
        // 将下标-1和n作为两个哨兵元素，它们对应的元素为MIN_VALUE
        // -1作为最左边界，n作为最右边界
        for (int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getElement2(nums, n, stack.peek()) > getElement2(nums, n, i)) {
                int cur = stack.pop();
                ans = ans - (long)(cur - stack.peek()) * (i - cur) * nums[cur];
            }
            stack.push(i);
        }
        return ans;
    }
//
//    作者：yimeixiaobai
//    链接：https://leetcode-cn.com/problems/sum-of-subarray-ranges/solution/xiao-bai-lang-si-wei-zhuan-huan-dan-diao-xjj7/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
