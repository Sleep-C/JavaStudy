package AcWing;

import java.util.Arrays;
import java.util.Scanner;

public class ThirtySix1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        String line2 = scan.nextLine();
        String[] string_list = line2.split(" ");
        //Lambda表达式方式
        int[] list = Arrays.stream(string_list).mapToInt(Integer::parseInt).toArray();
        //另一种方式
//        int[] list = Arrays.stream(string_list).mapToInt(Integer::parseInt).toArray();
        int[] label = new int[n];
        for (int i = 0; i<n; i++){
            label[i] = i;
        }
        quickSort(list, label,0,n-1);
        //用双向链表，存储初始输入顺序的每一个链表索引，然后以输入顺序从后往前遍历，每遍历一个就删除一个节点，就不用判断输入输出顺序。
        int[] label1 = new int[n];//输出的第一列
        int[] label2 = new int[n];//输出的第二列
        for (int i = 1;i<n;i++){
            if (label[0]>label[i]){
                label1[label[0]] = list[i] - list[0];
                label2[label[0]] = label[i] + 1;
                break;
            }
        }
        for (int i = 0; i<n; i++){
            if (label[n - 1]>label[n - 1 - i]){
                label1[label[n - 1]] = list[n - 1] - list[n - 1 - i];
                label2[label[n - 1]] = label[n - 1 - i] + 1;
                break;//两个break冲突了
            }
        }
        for (int i = 1; i<list.length-1; i++){
            for (int j = i - 1; j>=0; j--){
                if (label[i]>label[j]){
                    label1[label[i]] = list[i] - list[j];
                    label2[label[i]] = label[j] + 1;
                    break;
                }
            }
            for (int j = i + 1; j < n; j++){
                if (label[i]>label[j]){
                    if (label1[label[i]]==0 || label1[label[i]] > list[j] - list[i]){
                        label1[label[i]] = list[j] - list[i];
                        label2[label[i]] = label[j] + 1;
                    }
                    break;
                }
            }
        }
        for (int i = 1; i < n; i++){
            System.out.println(label1[i] + " " + label2[i]);
        }
        //暴力方法超时
//        for (int i = 1; i<n; i++){
//            int min = list[0];
//            int min_j = 0;
//            for (int j = 1; j < i; j++){
//                if (Math.abs(min - list[i]) >= Math.abs(list[j] - list[i])){
//                    if (Math.abs(min - list[i]) == Math.abs(list[j] - list[i])){
//                        if (min > list[j]){
//                            min_j = j;
//                            min = list[j];
//                        }
//                    }else {
//                        min_j = j;
//                        min = list[j];
//                    }
//                }
//            }
//            min_j++;
//            System.out.println(Math.abs(min - list[i]) + " " + min_j);
//        }
    }
    public static void quickSort(int[] arr, int[] label, int low, int high) {
        //如果指针在同一位置(只有一个数据时)，退出
        if (high - low < 1) {
            return;
        }
        //标记，从高指针开始，还是低指针（默认高指针）
        boolean flag = true;
        //记录指针的其实位置
        int start = low;
        int end = high;
        //默认中间值为低指针的第一个值
        int midValue = arr[low];
        int midLabel = label[low];
        while (true) {
            //高指针移动
            if (flag) {
                //如果列表右方的数据大于中间值，则向左移动
                if (arr[high] > midValue) {
                    high--;
                } else if (arr[high] < midValue) {
                    //如果小于，则覆盖最开始的低指针值，并且移动低指针，标志位改成从低指针开始移动
                    arr[low] = arr[high];
                    label[low] = label[high];
                    low++;
                    flag = false;
                }
            } else {
                //如果低指针数据小于中间值，则低指针向右移动
                if (arr[low] < midValue) {
                    low++;
                } else if (arr[low] > midValue) {
                    //如果低指针的值大于中间值，则覆盖高指针停留时的数据，并向左移动高指针。切换为高指针移动
                    arr[high] = arr[low];
                    label[high] = label[low];
                    high--;
                    flag = true;
                }
            }
            //当两个指针的位置相同时，则找到了中间值的位置，并退出循环
            if (low == high) {
                arr[low] = midValue;
                label[low] = midLabel;
                break;
            }
        }
        //然后出现有，中间值左边的小于中间值。右边的大于中间值。
        //然后在对左右两边的列表在进行快速排序
        quickSort(arr,label, start, low -1);
        quickSort(arr, label,low + 1, end);
    }

}
