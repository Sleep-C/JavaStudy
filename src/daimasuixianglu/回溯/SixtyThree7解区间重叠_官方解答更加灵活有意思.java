package daimasuixianglu.回溯;

import java.util.*;

public class SixtyThree7解区间重叠_官方解答更加灵活有意思 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("eaaaabaaec"));
    }
    //别人的解答很有意思，思路更加清晰，简洁
    public static List<Integer> partitionLabels(String s) {
        char[]str=s.toCharArray();
        int N=str.length;
        int[]far=new int[26];
        for(int i=0;i<N;i++){
            far[str[i]-'a']=i;
        }
        int left=0;
        int right=far[str[0]-'a'];
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<N;i++){
            if( far[str[i]-'a']>right){
                right=far[str[i]-'a'];
            }
            if(i==right){
                ans.add(i-left+1);
                left=i+1;
            }
        }
        return ans;
    }
//    public static List<Integer> partitionLabels(String s) {
//        List<Integer> list = new ArrayList<>();
//        if (s.length() == 1){
//            list.add(1);
//            return list;
//        }
//        int[][] arr = new int[24][2];
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++){
//            int m = s.charAt(i) - 'a';
//            if (set.contains(m)){
//                arr[m][1] = i;
//            }else {
//                set.add(m);
//                arr[m][0] = i;
//                arr[m][1] = i;
//            }
//        }
//        class MyCmopare implements Comparator<int[]> {
//            @Override
//            public int compare(int[] x,int[] y){
//                if (x[0] > y[0]){
//                    return 1;
//                }else if (x[0] < y[0]){
//                    return -1;
//                }else{
//                    if (x[1] > y[1]){
//                        return 1;
//                    }else if(x[1] < y[1]){
//                        return -1;
//                    }
//                    return 0;
//                }
//            }
//        }
//        if (set.size() == 1){
//            list.add(s.length());
//            return list;
//        }
//        Arrays.sort(arr, new MyCmopare());
//
//        int i = 0;
//        for ( ; i < arr.length; i++){
//            if (arr[i][0] > 0){
//                i--;
//                break;
//            }
//        }
//        int right = arr[i][1];
//        int left = arr[i][0];
//        for ( ; i < arr.length; i++){
//            if (right < arr[i][0]){
//                list.add(right - left + 1);
//                right = arr[i][1];
//                left = arr[i][0];
//
//            }else{
//                if (right < arr[i][1]){
//                    right = arr[i][1];
//
//                }
//            }
//            if (i == arr.length - 1){
//                list.add(right - left + 1);
//            }
//        }
//        return list;
//    }
}
