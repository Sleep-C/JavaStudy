package LeetcodeAll.week268;

public class Zero208用map存储每一个值的所有存在区间 {
    public static void main(String[] args) {

        RangeFreqQuery r = new RangeFreqQuery(new int[]{2,2,1,2,2});
        System.out.println(r.query(1,3,1));
    }
}
