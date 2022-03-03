package LeetcodeAll.doubleWeek68;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Two最佳方案使用拓扑排序 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("yeast");
        list.add("flour");
        List<List<String>> list1 = new LinkedList<>();
        list1.add(list);
        System.out.println(findAllRecipes(new String[]{"bread"},list1,new String[]{"yeast","flour","corn"}));
    }
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < supplies.length; i++){
            set.add(supplies[i]);
        }
        Set<String> set2 = new HashSet<>();
        List<String> list = new LinkedList<>();
        int label = 0;
        while (label == 0){
            label = 1;
            for (int i = 0; i < recipes.length; i++){
                int label2 = 0;
                if (!set2.contains(recipes[i])){
                    label2 = 1;
                    for (int j = 0; j < ingredients.get(i).size(); j++){
                        if (!set.contains(ingredients.get(i).get(j))){
                            label2 = 0;
                            break;
                        }
                    }
                }
                if (label2 == 1){
                    label = 0;
                    set.add(recipes[i]);
                    list.add(recipes[i]);
                    set2.add(recipes[i]);
                }
            }
        }
        return list;
    }
}
