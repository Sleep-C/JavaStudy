package LeetcodeAll.week268;

public class Eight207枚举_暴力 {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1,8,3,8,3}));
    }
    public static int maxDistance(int[] colors) {
        int out = 0;
        for(int i = 0; i<colors.length; i++){
            if(i > 0 && colors[i] == colors[i - 1]){
                continue;
            }
            for(int j = colors.length - 1; j > i; j--){
                if(j < colors.length - 1 && colors[j] == colors[j + 1]){
                    continue;
                }
                if (colors[i] != colors[j] && out < j - i){
                    out = j - i;
                }
            }
        }
        return out;
    }
}
