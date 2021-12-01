package niuke;

public class n位格雷码 {
    public static void main(String[] args) {
        System.out.println(getGray(6));
    }

    /**
     * https://www.nowcoder.com/test/710813/summary
     * 2016腾讯研发工程师
     * 1位格雷码有两个码字
     * (n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
     * (n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1 [4]
     * n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
     * @param
     * @return
     */
    public static String[] getGray(int n) {
        // write code here
        if (n==1){
            return new String[]{"0","1"};
        }
        String[] gray1=getGray(n-1);
        String[] gray2=new String[gray1.length*2];
        for (int i=0;i<gray1.length;i++){
            gray2[2*gray1.length-i-1]="1"+gray1[i];
            gray2[i]="0"+gray1[i];
        }

        return gray2;
    }
}
