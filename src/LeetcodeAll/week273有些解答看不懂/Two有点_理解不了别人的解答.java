package LeetcodeAll.week273有些解答看不懂;

import java.util.Arrays;

public class Two有点_理解不了别人的解答 {
    public static void main(String[] args) {
        System.out.println(executeInstructions(3,new int[]{0,1},"RRDDLU"));
    }
    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int[] col = new int[2001];
        int[] row = new int[2001];
        int m = s.length();
        Arrays.fill(row,m);
        Arrays.fill(col,m);
        int x = 1000,y = 1000,l = startPos[1]+1,r = n-startPos[1],t = startPos[0]+1,b = n-startPos[0];
        int[] res = new int[s.length()];
        for(int i = m-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='L') col[y++] = i;
            if(c=='R') col[y--] = i;
            if(c=='U') row[x++] = i;
            if(c=='D') row[x--] = i;
            int min = m;
            min = Math.min(min,col[y-l]);
            min = Math.min(min,col[y+r]);
            min = Math.min(min,row[x-t]);
            min = Math.min(min,row[x+b]);
            res[i] = min-i;
        }
        return res;
    }
}
