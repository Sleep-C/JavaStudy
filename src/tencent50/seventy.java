package tencent50;

public class seventy {
    public static void main(String[] args ){
        System.out.println(climbStairs(45));
    }
    public static int climbStairs(int n) {
        int j=2;
        int k=1;
        int m=0;
        for (int i=3;i<=n;i++){
            m=j+k;
            k=j;
            j=m;
        }
        return m;
    }
//    public static int climbStairs(int n) {//递归超时
//        if (n>2){
//            return climbStairs(n-1)+climbStairs(n-2);
//        }else if (n==2){
//            return 2;
//        }else {
//            return 1;
//        }
//    }
}
