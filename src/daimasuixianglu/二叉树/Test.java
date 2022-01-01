package daimasuixianglu.二叉树;


import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            set.add(i);
            recall(out,set,n,k,1,i);
            set.remove(i);
        }
        return out;
    }
    public static void recall(List<List<Integer>> list,Set<Integer> set,int n,int k,int num,int last){
        if (k == num){
            List<Integer> new_list = new ArrayList<>(set);
            list.add(new_list);
        }else {
            for (int i = last + 1; i <= n; i++){
                set.add(i);
                recall(list,set,n,k,num + 1,i);
                set.remove(i);
            }
        }
    }
}
