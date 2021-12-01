package tencent50;

public class FortyThree {
    public static void main(String[] args ){
        System.out.println(multiply("999","0"));
    }
    public static String multiply(String num1, String num2) {
        if (num1.charAt(0)=='0'){
            return "0";
        }
        if (num2.charAt(0)=='0'){
            return "0";
        }
        if (num1.length()<num2.length()){
            String mid = num1;
            num1=num2;
            num2=mid;
        }
        int m1=num1.length()-1;
        int m2=num2.length()-1;
        int carry=0;
        String out = "";
        for (int i=0;i<num1.length();i++){
            int carry1=0;
            int out1=0;
            for (int j=0;j<=i && j<num2.length();j++){
                int x=Character.getNumericValue(num1.charAt(m1-i+j));
                int y=Character.getNumericValue(num2.charAt(m2-j));
                int out3=x*y;
                out1=out1+out3%10;
                carry1=carry1+(out3/10);
                for (;out1>=10;){
                    out1=out1-10;
                    carry1++;
                }
            }
            out1=out1+carry;
            for (;out1>=10;){
                out1=out1-10;
                carry1++;
            }
            out = out1+out;
            carry=carry1;
        }
        for (int i=1;i<num2.length();i++)
        {
            int carry1=0;
            int out1=0;
            for (int j=i;j<num2.length();j++){
                int x=Character.getNumericValue(num1.charAt(j-i));
                int y=Character.getNumericValue(num2.charAt(m2-j));
                int out3=x*y;
                out1=out1+out3%10;
                carry1=carry1+(out3/10);
                for (;out1>=10;){
                    out1=out1-10;
                    carry1++;
                }
            }
            out1=out1+carry;
            for (;out1>=10;){
                out1=out1-10;
                carry1++;
            }
            out = out1+out;
            carry=carry1;
        }
        if (carry>0){
            out=carry+out;
        }
        return out;
    }
}
