package tencent50;

public class eleven {
    public static void main(String[] args ){
        int a[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
    public static int maxArea(int[] height) {//应该用双指针法，两个在两边的指针，每次向内移动较小的一个,移动到第一个大于小指针处
        int n=height.length;
        int max=0;
        int m;
        for(int i=0;i<n;i++){
            m=0;
            for (int j=0;j<i;j++){
                if(height[i]<=height[j]){
                    m=i-j;
                    break;
                }
            }
            for(int j=n-1;j>=i;j--){
                if(height[i]<=height[j]){
                    if(m<j-i){
                        m=j-i;
                    }
                    break;
                }
            }
            if(max<height[i]*m){
                max=height[i]*m;
            }
        }
        return max;
    }
}
