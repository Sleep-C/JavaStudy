package tencent50;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class seventyEight {
    public static void main(String[] args ){
        System.out.println(subsets(new int[]{0}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        out.add(list);
        int min=0;
        int max=0;
        for (int i=0;i<nums.length;i++){
            for (int j=min;j<=max;j++){
                for (int k=0;k<nums.length;k++){
                    list = out.get(j).stream().collect(Collectors.toCollection(ArrayList::new));
                    if (!list.contains(nums[k]) && (list.size()==0 || nums[k]>list.get(list.size()-1))){
                        list.add(nums[k]);
                        out.add(list);
                    }
                }
                min=max+1;
                max=out.size()-1;
            }
        }
        return out;
    }

}
