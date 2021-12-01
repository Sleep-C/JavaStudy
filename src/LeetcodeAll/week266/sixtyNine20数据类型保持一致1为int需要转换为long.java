package LeetcodeAll.week266;

public class sixtyNine20数据类型保持一致1为int需要转换为long {
    public static void main(String[] args) {
        System.out.println(countVowels("noosabasboosa"));
    }
    public static long countVowels(String word) {
        long out=0;
        for (int i=0;i<word.length();i++){
            if (word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u'){
                out = out + (word.length()-i)*(i+(long)1);//这里1不是long结果会有问题
            }
        }
        return out;
    }
}
