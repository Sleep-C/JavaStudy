package LeetcodeAll.week266;

public class sixtyFour20不应该去看每个具体商品或店而是直接查找最小的n {
    public static void main(String[] args) {

    }
    //问题的答案一定在1到100005之间，然后假设为mid，判断需要的店的数量是否小于提供的店的数量
    public static int minimizedMaximum(int n, int[] q) {
        int l = 1 , r = 100005;
        while(l < r){
            int mid = (l+r)>>1;
            int count = 0;
            for(int x : q){
                count += (x-1)/mid+1;
            }
            if(count <= n){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
