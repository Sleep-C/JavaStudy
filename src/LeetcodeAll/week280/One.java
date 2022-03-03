package LeetcodeAll.week280;

public class One {
    public static void main(String[] args) {

    }
    public int countOperations(int num1, int num2) {
        // if (num1 == 0 || num2 == 0){
        //     return 0;
        // }
        // if (num1 >= num2){
        //     return countOperations(num1 - num2,num2) + 1;
        // }else{
        //     return countOperations(num1,num2 - num1) + 1;
        // }
        int result = 0;
        while (num1 != 0 && num2 != 0){
            result++;
            if (num1 >= num2){
                num1 = num1 - num2;
            }else{
                num2 = num2 - num1;
            }
        }
        return result;
    }
}
