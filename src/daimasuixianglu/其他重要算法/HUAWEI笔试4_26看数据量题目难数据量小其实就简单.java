package daimasuixianglu.其他重要算法;

public class HUAWEI笔试4_26看数据量题目难数据量小其实就简单 {
    //10个判断题（2分）10个单选题（4分）5个多选题（8分），累计3个错误中止考试计算分数，
    //分数为N，算出可能答题情况的个数（0《n《100不会是不可能考出来的分数）
    //例 94：100     100：1
    public static void main(String[] args) {
        System.out.println(huawei1(96));
    }
    static int[] arr;

    public static int huawei1(int target){
        arr = new int[25];
        for (int i = 0; i < 25; i++){
            if (i < 10){
                arr[i] = 2;
            }else if(i < 20){
                arr[i] = 4;
            }else {
                arr[i] = 8;
            }
        }
        return dfs(0, target, 3);
    }

    public static int dfs(int index,int left,int num){//num剩下可以错的个数，left当前路径与目标分数的差值
        if (left == 0){
            return 1;
        }
        if (num == 0){
            return 0;
        }
        if (index >= arr.length){
            return 0;
        }
        return dfs(index + 1,left - arr[index],num) + dfs(index + 1,left,num - 1);
    }
}
