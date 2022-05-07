package daimasuixianglu.贪心;

public class ThirtyFour1多考虑特殊情况合流 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }
    //官方解答简洁，将多种特殊情况考虑放到一起处理
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        if (gas.length == 1){
//            return 0;
//        }
//        for (int i = 0; i < gas.length; i++){
//            gas[i] = gas[i] - cost[i];
//        }
//        int left = 0;
//        int right;
//
//        while (left < gas.length && gas[left] < 0){
//            left++;
//        }
//        if (left == gas.length){
//            return -1;
//        }
//        int rest = 0;
//        right = left;
//        if (right == gas.length){
//            right = 0;
//        }
//        int label = 0;
//        while(left < gas.length){
//            rest += gas[right];
//            if (rest < 0){
//                if (left >= right){
//                    return -1;
//                }
//                rest = 0;
//                label = 0;
//                left = right + 1;
//            }else {
//                if (label == 1 && right == left){
//                    return left;
//                }
//            }
//            right++;
//            if (right == gas.length){
//                label = 1;
//                right = 0;
//            }
//        }
//        return -1;
//    }
}
