package tencent50;

public class four {
    public static void main(String[] args ){
        int a[]={1,3};
        int b[]={2,4};
        double x = findMedianSortedArrays(a,b);
        System.out.println(x);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double k = 0.0;
        if(nums1.length==0){
            int m=nums2.length;
            if(m%2==0){
                k=(nums2[m/2-1]+nums2[m/2])/2;
            }else {
                k=nums2[(m-1)/2];
            }
        }
        if(nums2.length==0){
            int m=nums1.length;
            if(m%2==0){
                k=(nums1[m/2-1]+nums1[m/2])/2;
            }else {
                k=nums1[(m-1)/2];
            }
        }
        int n = nums1.length + nums2.length;
        if(n%2==0){
            k=0.0;
            int i=0;
            int j=0;
            for(int m=0;m<n/2+1;m++){
                if(i>=nums1.length){
                    if(m==n/2 || m==n/2-1){
                        k=k+nums2[j];
                    }
                    j++;
                    continue;
                }
                if(j>=nums2.length){
                    if(m==n/2 || m==n/2-1){
                        k=k+nums1[i];
                    }
                    i++;
                    continue;
                }
                if(nums1[i]<nums2[j]){
                    if(m==n/2 || m==n/2-1){
                        k=k+nums1[i];
                    }
                    i++;
                }else{
                    if(m==n/2 || m==n/2-1){
                        k=k+nums2[j];
                    }
                    j++;
                }
            }
            k=k/2.0;
        }else{
            int i=0;
            int j=0;
            for(int m=0;m<(n+1)/2;m++){
                if(i>=nums1.length){
                    k=nums2[j];
                    j++;
                    continue;
                }
                if(j>=nums2.length){
                    k=nums1[i];
                    i++;
                    continue;
                }
                if(nums1[i]<nums2[j]){
                    k=nums1[i];
                    i++;
                }else{
                    k=nums2[j];
                    j++;
                }
            }
        }
        return k;
    }
}
