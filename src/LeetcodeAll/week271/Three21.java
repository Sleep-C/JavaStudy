package LeetcodeAll.week271;

import java.util.HashMap;
import java.util.Map;

public class Three21 {
    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }
    //将map换为int[]后速度有提升
    public static int countPoints(String rings) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = 1;
        }
        int out = 0;
        for (int i = 0; i < rings.length(); i += 2){
            int x = (int)rings.charAt(i + 1) - (int)('0');
            switch(rings.charAt(i)){
                case 'R':
                    if (arr[x] %2 != 0){
                        if (arr[x]%3 == 0 && arr[x]%5 == 0){
                            out++;
                        }
                        arr[x]*=2;
                    }
                    break;
                case 'G':
                    if (arr[x] %3 != 0){
                        if (arr[x]%2 == 0 && arr[x]%5 == 0){
                            out++;
                        }
                        arr[x]*=3;
                    }
                    break;

                case 'B':
                    if (arr[x] %5 != 0){
                        if (arr[x]%2 == 0 && arr[x]%3 == 0){
                            out++;
                        }
                        arr[x]*=5;
                    }
                    break;
            }
        }
        return out;
    }
//    public static int countPoints(String rings) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < 10; i++){
//            map.put(i,1);
//        }
//        int out = 0;
//        for (int i = 0; i < rings.length(); i = i + 2){
//            int x = (int)rings.charAt(i + 1) - (int)('0');
//            switch(rings.charAt(i)){
//                case 'R':
//                    if (map.get(x)%2 != 0){
//                        if (map.get(x)%3 == 0 && map.get(x)%5 == 0){
//                            out++;
//                        }
//                        map.put(x,map.get(x)*2);
//                    }
//                    break;
//                case 'G':
//                    if (map.get(x)%3 != 0){
//                        if (map.get(x)%2 == 0 && map.get(x)%5 == 0){
//                            out++;
//                        }
//                        map.put(x,map.get(x)*3);
//                    }
//                    break;
//                case 'B':
//                    if (map.get(x)%5 != 0){
//                        if (map.get(x)%3 == 0 && map.get(x)%2 == 0){
//                            out++;
//                        }
//                        map.put(x,map.get(x)*5);
//                    }
//                    break;
//            }
//        }
//        return out;
//    }
}
