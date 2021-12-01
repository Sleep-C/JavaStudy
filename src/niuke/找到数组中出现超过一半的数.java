package niuke;

public class 找到数组中出现超过一半的数 {
    public static void main(String[] args) {
        System.out.println(getValue(new int[]{1,2,3,4,5,2,2,2,2,2,2},11));
    }

    /**
     * https://www.nowcoder.com/test/710813/summary
     * 2016年腾讯研发工程师
     * @param gifts
     * @param n
     * @return
     */
    public static int getValue(int[] gifts, int n) {
        // write code here
        int[] gift_copy=new int[n];
        for(int i=0;i<n;i++){
            gift_copy[i]=gifts[i];
        }
        int j=0;
        int num=0;
        for (int i=0;i<n;i++){
            if (gift_copy[i]==gift_copy[j]){
                continue;
            }else{
                gift_copy[i]=0;
                gift_copy[j]=0;
                for(int k=j+1;k<n;k++){
                    if (gift_copy[k]!=0){
                        j=k;
                        if (i<j){
                            i=j;
                        }
                        break;
                    }
                    if(k==n-1){
                        return 0;
                    }
                }
            }
        }
        for (int i=0;i<n;i++){
            if(gifts[i]==gifts[j]){
                num++;
            }
        }
        if (num>(n/2)){
            return gifts[j];
        }else{
            return 0;
        }
    }
}
