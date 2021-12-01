package LeetcodeAll.week267;

public class Three207思路奇特考虑第k人买完票的一瞬间其他人买到票的数量 {
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{5},0));
    }
    //我的方法模拟
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int out = 0;
        int label = tickets.length;
        int label_k = k;
        for (int i = 0;;i++){
            tickets[i]--;
            if (tickets[i]==0){
                if (i<label_k){
                    label_k--;
                }else if(i==label_k){
                    out++;
                    break;
                }
                for (int j = i;j<label-1;j++){
                    tickets[j] = tickets[j+1];
                }
                label--;
                i--;
            }
            if (i == label - 1){
                i = -1;
            }
            out++;
        }
        return out;
    }
}
