package LeetcodeAll.doubleWeek66;

public class Six208排除特殊情况再数学分析 {
    public static void main(String[] args) {

    }
    //官方解答，从左到右遍历房屋，如果房屋左右都没有桶，就选择在右边放，右边放不了放左边，左边也放不了就无解。（因为从左往右遍历，所以桶优先放右边，左边的房屋都已经有了，右边也许能用上）
    //我的解答，先遍历一次排除无解情况，再遍历一次处理H.H的情况，最后统计H个数与前一步相加得到最终的结果。
    public static int minimumBuckets(String street) {
        if (street.length() == 1){
            if (street.charAt(0) == 'H'){
                return -1;
            }else{
                return 0;
            }
        }
        if ((street.charAt(0) == 'H' && street.charAt(1) == 'H') || (street.charAt(street.length() - 1) == 'H' && street.charAt(street.length() - 2) == 'H')){
            return -1;
        }
        for (int i = 1; i < street.length() - 2; i++){
            if (street.charAt(i) == 'H' && street.charAt(i + 1) == 'H' && street.charAt(i + 2) == 'H'){
                return -1;
            }
        }
        int out = 0;
        for (int i = 1; i < street.length() - 1; i++){
            if (street.charAt(i) == '.' && street.charAt(i - 1) == 'H' && street.charAt(i + 1) == 'H'){
                out++;
                String str1 = street.substring(0,i - 1);
                String str2 = street.substring(i + 2,street.length());
                street = str1 + "..." + str2;
            }
        }
        for (int i = 0; i < street.length(); i++){
            if (street.charAt(i) == 'H'){
                out++;
            }
        }
        return out;
    }
}
