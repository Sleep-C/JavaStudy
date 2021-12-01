package tencent50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sixteen速度慢 {
    public static void main(String[] args ){
        int[] a={-1,2,1,-4};
        System.out.println(threeSumClosest(a,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        int m,m1;
        int i,j,k;
        for(i=0;i<n-1;i++){
            for(j=n-1;j>=i+1;j--){
                if(nums[j]<nums[j-1]){
                    m=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=m;
                }
            }
        }
        m=20000;
        for (i=0;i<n-1;i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(j=n-1;j>i;j--){
                if (j<n-1 && nums[j]==nums[j+1]){
                    continue;
                }
                for (k=i+1;k<j;k++){
                    if (k>i+1 && nums[k]==nums[k-1]){
                        continue;
                    }
                    m1=nums[i]+nums[j]+nums[k];
                    if(Math.abs(target-m1)<Math.abs(target-m)){
                        m=m1;
                    }
                }
            }
        }
        return m;

    }
}
