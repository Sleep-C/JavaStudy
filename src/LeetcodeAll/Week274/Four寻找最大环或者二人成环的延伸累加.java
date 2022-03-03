package LeetcodeAll.Week274;

import java.util.*;

public class Four寻找最大环或者二人成环的延伸累加 {
    public static void main(String[] args) {
        System.out.println(maximumInvitations(new int[]{1,0,3,2,5,6,7,4,9,8,11,10,11,12,10}));
        //结果为6
    }
    public static int maximumInvitations(int[] favorite) {
        int result = 0;
        int[] arr;
        Map<Integer, List<Integer>> map = new HashMap<>();//map用来存储对于i，有哪些人喜欢他。
        Set<Integer> set = new HashSet<>();

        arr = new int[favorite.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < favorite.length; i++){
            if (favorite[favorite[i]] == i){
                if (stack.contains(i))continue;
                arr[i] = 2;
                arr[favorite[i]] = 2;
                stack.push(i);
                stack.push(favorite[i]);
                continue;
            }
            if (map.containsKey(favorite[i])){
                List<Integer> list = map.get(favorite[i]);
                list.add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(favorite[i],list);
            }
        }
        //这里应该用二环两边分别做一次延申，最大值相加 ******
        int size1 = stack.size();
        result = size1;
        while (!stack.isEmpty()){
            int left = 2;
            int right = 2;
            while (stack.size() >= size1){
                int tmp = stack.pop();
                if (map.containsKey(tmp)){
                    List<Integer> list = map.get(tmp);
                    for (int i = 0; i < list.size(); i++){
                        arr[list.get(i)] = arr[tmp] + 1;
                        if (arr[list.get(i)] > left){
                            left = arr[list.get(i)];
                        }
                        stack.push(list.get(i));
                    }
                }
            }
            while (stack.size() >= size1 - 1){
                int tmp = stack.pop();
                if (map.containsKey(tmp)){
                    List<Integer> list = map.get(tmp);
                    for (int i = 0; i < list.size(); i++){
                        arr[list.get(i)] = arr[tmp] + 1;
                        if (arr[list.get(i)] > right){
                            right = arr[list.get(i)];
                        }
                        stack.push(list.get(i));
                    }
                }
            }
            result += left + right - 4;
            size1 -= 2;
        }
        //对于延申之外的，遍历，深度遍历，每次遍历后置1，并且只看下最大环，环之外的不能参加会议
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                set.clear();
                int label = i;
                int label2 = 0;
                while (!set.contains(label)){
                    if (arr[label] != 0){
                        label2 = 1;
                        break;
                    }
                    set.add(label);
                    arr[label] = 1;
                    label = favorite[label];
                }
                if (label2 == 1){
                    continue;
                }
                if (label == i){
                    if (set.size() > result){
                        result = set.size();
                    }
                }else {
                    int mid = label;
                    int size = 1;
                    while (favorite[mid] != label){
                        mid = favorite[mid];
                        size++;
                    }
                    if (size > result){
                        result = size;
                    }
                }
            }else if (arr[i] > 1){
                if (arr[i] > result){
                    result = arr[i];
                }
            }
        }
        return result;
    }
}
