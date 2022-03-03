package daimasuixianglu.回溯;

import java.util.*;

public class ThirtyTwo3Hard重要PriorityQueue {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("EZE","TIA"));
        list.add(Arrays.asList("EZE","HBA"));
        list.add(Arrays.asList("AXA","TIA"));
        list.add(Arrays.asList("JFK","AXA"));
        list.add(Arrays.asList("ANU","JFK"));
        list.add(Arrays.asList("ADL","ANU"));

        list.add(Arrays.asList("TIA","AUA"));
        list.add(Arrays.asList("ANU","AUA"));
        list.add(Arrays.asList("ADL","EZE"));
        list.add(Arrays.asList("ADL","EZE"));
        list.add(Arrays.asList("EZE","ADL"));
        list.add(Arrays.asList("AXA","EZE"));

        list.add(Arrays.asList("AUA","AXA"));
        list.add(Arrays.asList("JFK","AXA"));
        list.add(Arrays.asList("AXA","AUA"));
        list.add(Arrays.asList("AUA","ADL"));
        list.add(Arrays.asList("ANU","EZE"));
        list.add(Arrays.asList("TIA","ADL"));

        list.add(Arrays.asList("EZE","ANU"));
        list.add(Arrays.asList("AUA","ANU"));
        System.out.println(findItinerary(list));
    }
    static Map<String,PriorityQueue<String>> map = new HashMap<>();
    static List<String> result = new LinkedList<>();
    public static List<String> findItinerary(List<List<String>> tickets){
        for (int i = 0; i < tickets.size(); i++){
            if (map.containsKey(tickets.get(i).get(0))){
                PriorityQueue<String> priorityQueue = map.get(tickets.get(i).get(0));
                priorityQueue.add(tickets.get(i).get(1));
            }else {
                PriorityQueue<String> priorityQueue = new PriorityQueue<>();
                priorityQueue.add(tickets.get(i).get(1));
                map.put(tickets.get(i).get(0),priorityQueue);
            }
        }
        recur("JFK");
        Collections.reverse(result);
        return result;
    }
    public static void recur(String n){
        while (map.containsKey(n) && map.get(n).size() > 0){
            recur(map.get(n).poll());
        }
        result.add(n);
    }
    //看完下面两个参考资料，并重写215
    //https://baijiahao.baidu.com/s?id=1665383380422326763&wfr=spider&for=pc
    //https://blog.csdn.net/u010623927/article/details/87179364
    //PriorityQueue
//    public static List<String> findItinerary(List<List<String>> tickets) {
//        Map<String,List<String>> map = new HashMap<>();
//        Map<String,Integer> label = new HashMap<>();
//        List<String> result = new LinkedList<>();
//        for (int i = 0; i < tickets.size(); i++){
//            if (map.containsKey(tickets.get(i).get(0))){
//                List<String> list = map.get(tickets.get(i).get(0));
//                list.add(tickets.get(i).get(1));
//                label.put(tickets.get(i).get(0), label.get(tickets.get(i).get(0)) + 1);
//            }else {
//                List<String> list = new ArrayList<>();
//                list.add(tickets.get(i).get(1));
//                map.put(tickets.get(i).get(0),list);
//                label.put(tickets.get(i).get(0), 1);
//            }
//        }
//        result.add("JFK");
//        String last = "JFK";
//        while (last != null){
//            List<String> list = map.get(last);
//            label.put(last,label.get(last) - 1);
//            if (list == null || list.size() == 0){
//                break;
//            }
//            int i = 0;
//            int mylabel = -1;
//            String mid = null;
//            for (; i < list.size(); i++){
//                if (label.containsKey(list.get(i)) && label.get(list.get(i)) > 0){
//                    mid = list.get(i);
//                    mylabel = i;
//                    i++;
//                    break;
//                }
//            }
//            for (; i < list.size(); i++){
//                if (list.get(i).compareTo(mid) < 0 && label.containsKey(list.get(i)) && label.get(list.get(i)) > 0){
//                    mid = list.get(i);
//                    mylabel = i;
//                }
//            }
//            if (mid == null){
//                result.add(list.get(0));
//                break;
//            }
//            result.add(mid);
//            list.remove(mylabel);
//            last = mid;
//        }
//        return result;
//    }
}
