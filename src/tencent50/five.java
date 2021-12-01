package tencent50;

public class five {
    public static void main(String[] args){
        System.out.println(longestPalindrome("sbasb"));
    }


    public static String longestPalindrome(String s) {
        int i;
        int j;
        int myLength=0;
        int result_1=-1;
        int result_2=-1;
        for(i=0;i<s.length()-1;i++){
            for(j=s.length()-1;j>i;j--){
                if(s.charAt(i)==s.charAt(j)){
                    if(check(s,i+1,j-1)){
                        if(myLength<j-i+1){
                            myLength=j-i+1;
                            result_1=i;
                            result_2=j;
                        }
                        j=i;
                    }
                }
            }
        }
        if(myLength==0){
            return s.substring(0,1);
        }else{
            return s.substring(result_1,result_2+1);
        }
    }
    public static boolean check(String s, int first, int last){
        if (first>=last){
            return true;
        }else{
            if (s.charAt(first)!=s.charAt(last)){
                return false;
            }else{
                return check(s,first+1,last-1);
            }
        }
    }

}
