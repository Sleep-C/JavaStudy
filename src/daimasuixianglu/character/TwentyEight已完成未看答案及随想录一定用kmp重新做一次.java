package daimasuixianglu.character;

public class TwentyEight已完成未看答案及随想录一定用kmp重新做一次 {
    public static void main(String[] args) {

    }
    //考虑字符串分割，然后排除所有的不适用情况。第一个处理很巧妙
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        haystack += ",";//去掉neddle在结尾处造成分割出来str的长度为1的情况
        String[] str = haystack.split(needle);
        if (str.length == 1){//这是没有解的情况
            return -1;
        }
        if (str.length == 0){//这是haystack刚好等于needle的情况
            return 0;
        }
        return str[0].length();
    }
}
