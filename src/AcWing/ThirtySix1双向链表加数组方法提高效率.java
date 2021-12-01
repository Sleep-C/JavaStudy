package AcWing;

import java.util.Arrays;
import java.util.Scanner;

public class ThirtySix1双向链表加数组方法提高效率 {
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
        DoubleNodeList[] new_label = new DoubleNodeList[n];
        DoubleNodeList head = new DoubleNodeList();
        DoubleNodeList tail = new DoubleNodeList();
        DoubleNodeList head1 = head;
        head.next = tail;
        tail.pre = head;
        //数据存入双向链表，及对输入顺序下的每一个数，存储其节点，便于快速访问
        for (int i = 0; i < n; i++){
            DoubleNodeList mid = new DoubleNodeList(list[i],label[i]+1);
            mid.next = head.next;
            mid.pre = head;
            mid.next.pre = mid;
            mid.pre.next = mid;
            new_label[label[i]] = mid;
            head = head.next;
        }

        int[] label1 = new int[n];//输出的第一列
        int[] label2 = new int[n];//输出的第二列
        for (int i = n - 1; i>0; i--){
            DoubleNodeList mid = new_label[i];
            if (mid.next == tail){
                label1[i] = mid.val - mid.pre.val;
                label2[i] = mid.pre.subscript;
            }else if (mid.pre != head1){
                int pre = mid.val - mid.pre.val;
                int next = mid.next.val - mid.val;
                if (pre > next){
                    label1[i] = next;
                    label2[i] = mid.next.subscript;
                }else {
                    label1[i] = pre;
                    label2[i] = mid.pre.subscript;
                }
            }else{
                label1[i] = mid.next.val - mid.val;
                label2[i] = mid.next.subscript;
            }
            mid.next.pre = mid.pre;
            mid.pre.next = mid.next;
        }
        for (int i = 1; i < n; i++){
            System.out.println(label1[i] + " " + label2[i]);
        }
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
