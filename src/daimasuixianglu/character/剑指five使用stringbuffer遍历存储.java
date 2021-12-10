package daimasuixianglu.character;

public class 剑指five使用stringbuffer遍历存储 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("     "));
    }
    //可以考虑先扩容，然后从后往前遍历的双指针法
    public static String replaceSpace(String s) {
        //我的解答，string to char[]，遍历同时加入到StringBuffer
        char[] arr = s.toCharArray();//可以不用这一行,直接s.charAt();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == ' '){
                str.append("%20");
            }else{
                str.append(arr[i]);
            }
        }
        return str.toString();
//官方解答使用了3倍长度的数组，但空间效率比stringbuffer高。replaceAll效率最低，且特别慢
        //官方解答，建立字符数组地长度为 s 的长度的 3 倍，使用字符数组，
//        int length = s.length();
//        char[] array = new char[length * 3];
//        int size = 0;
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                array[size++] = '%';
//                array[size++] = '2';
//                array[size++] = '0';
//            } else {
//                array[size++] = c;
//            }
//        }
//        String newStr = new String(array, 0, size);
//        return newStr;


//        String[] str = s.split(" ");
//        StringBuffer out = new StringBuffer();
//        for (int i = 0; i < str.length - 1; i++){
//            out.append(str[i] + "%20");
//        }
//        out.append(str[str.length - 1]);
//        return out.toString();
    }
}
