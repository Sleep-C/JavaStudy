package LeetcodeAll.week279;

import java.util.Arrays;

public class Three {
    public static void main(String[] args) {

    }
    private int[] label;
    private int[] label2;
    private int max;
    private int num;

    public Three(int size) {
        label = new int[size];
        label2 = new int[size];
        for (int i = 0; i < size; i++){
            label2[i] = 1;
        }
        num = 0;
        max = size;
    }

    public void fix(int idx) {
        if (label[idx] == 0){
            label[idx] = 1;
            label2[idx] = 0;
            num++;
        }
    }

    public void unfix(int idx) {
        if (label[idx] == 1){
            label[idx] = 0;
            label2[idx] = 1;
            num--;
        }
    }

    public void flip() {
        int[] mid = label;
        label = label2;
        label2 = mid;
        num = max - num;
    }

    public boolean all() {
        if (num == max){
            return true;
        }else {
            return false;
        }
    }

    public boolean one() {
        if (num == 0){
            return false;
        }else {
            return true;
        }
    }

    public int count() {
        return num;
    }

    public String toString() {
        return Arrays.toString(label).replace("[","").replace("]","").replace(", ","");
    }
}
