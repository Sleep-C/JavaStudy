package tencent50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FortySix深拷贝 {
//    static List<List<Integer>> out=new ArrayList<>();
    public static void main(String[] args ){
        int[] nnnn={0,1};
        System.out.println(permute(nnnn));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        out.add(list);
        for (int i=1;i<nums.length;i++){
            out=changeOut(nums[i],out);
        }
        return out;

    }
    public static List<List<Integer>> changeOut(int x,List<List<Integer>> out){
        int m = out.get(0).size();
        int n = out.size();
        for (int i=0;i<out.size() && out.get(i).size()==m;i++){
            for (int j=0;j<m+1;j++){
                List<Integer> oldList=out.get(i).stream().collect(Collectors.toCollection(ArrayList::new));

//                Collections.copy(oldList,out.get(i));
                oldList.add(j,x);
                out.add(oldList);
            }
        }
        int nn=out.size();
        for (int i=n-1;i>=0;i--){
            out.remove(i);
        }
        return out;
    }
}
