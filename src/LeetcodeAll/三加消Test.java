package LeetcodeAll;

public class 三加消Test {
    public static void main(String[] args) {
        test("aaabbbcccba");
    }

    /**
     * 三消问题“aaabbbcccba”->"aaabbbba"->"aaaa"->""，可能消不完，最长1000
     * 考虑为字符串建立两个等长的数组，每一列含义如下，如果前一个处于夹击中小于三的整数部分为n，则当前位整数部分为n+1
     * 还要考虑两个或三个小于三的组合为大于三的
     * 以及考虑前一个n，而当前位字符与前一个相同，此时该如何与前一位结合？
     * @param
     * @return
     */
    public static String test(String s){
        //0->三连，-1->无解，1-n->需要处理的迭代次数....带0.5的表示1连（权重低一些）
        int[] left=new int[s.length()];
        int[] right = new int[s.length()];
        int i,j,k;

        for (i=0;i<s.length();i=j){
            j=i+1;
            k=i;
            for (;j<s.length() && s.charAt(k)==s.charAt(j);j++){ }
            if (j-k<3){
                for (int m=k-1;k>=0 && s.charAt(m)!=s.charAt(j);m--){ }

            }

        }



        return s;
    }
}
