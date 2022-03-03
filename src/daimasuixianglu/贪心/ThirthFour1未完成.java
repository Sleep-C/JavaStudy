package daimasuixianglu.贪心;

public class ThirthFour1未完成 {
    public static void main(String[] args) {

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1){
            return 0;
        }
        for (int i = 0; i < gas.length; i++){
            gas[i] = gas[i] - cost[i];
        }
        int left = 0;
        int right;
        int rest = gas[left];
        // while (left < gas.length && gas[left] < 0){
        //     left++;
        // }
        // if (left == gas.length){
        //     return -1;
        // }
        // right = left;
        for (; left < gas.length; left++){
            rest -= gas[left];
            if (gas[left] < 0){
                continue;
            }
            right = left;

        }


        return -1;
    }
}
