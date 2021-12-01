package LeetcodeAll;

public class ThirtyNine6Hard未完成 {
    public static void main(String[] args){

    }
    public static int numDecodings(String s) {
        int n=0;
        String[] s1=s.split("0");
        for (int i=0;i<s1.length-2;i++){
            s1[i]=s1[i].substring(0,s1[i].length()-1);
        }
        for (int i=0;i<s1.length;i++){
            String[] s2 = s1[i].split("(?<=3|4|5|6|7|8|9)");
            for (int j=0;j<s2.length;j++){
                if (s2[j].charAt(s2[j].length()-1)+""=="7" || s2[j].charAt(s2[j].length()-1)+""=="8" || s2[j].charAt(s2[j].length()-1)+""=="9"){
                    n=n+solvingStar3(s2[j]);
                }else{
                    n=n+solvingStar(s2[j],0);
                }
            }
        }
        n=n%1000000007;
        return n;
    }
    public static int solvingStar3(String s){
        int n2=0;
        if (s.charAt(s.length()-2)+""=="2"){
            s=s.substring(0,s.length()-1);
            n2=n2+solvingStar(s,0);
        }else if(s.charAt(s.length()-2)+""=="*"){//*后连*如何处理
            n2=n2+solvingStar2(s);
        }else{
            n2=n2+solvingStar(s,0);
        }
        return n2;
    }
    public static int solvingStar(String s,int n_before){
        int n3=0;
        String[] s3=s.split("(?<=\\*)");
        if ((s3.length==2 && s3[1].length()>0)||s3.length>2){
            n3=n3+solvingStar(s3[0].substring(0,s3[0].length()-2),n_before);//0
            n3=n3+2*solvingStar(s.substring(s3[0].length(),s.length()),n_before+s3[0].length());//1,2
            //3-9
            int n5 = n_before+s3[0].length();
            if (s3[0].charAt(s3.length-2)+""=="2"){
                for (int i=0;i<n5/2;i++){
                    n3=n3+4*factorial(n5-i,i);
                }
                n5=n5-1;
                for (int i=0;i<n5/2;i++){
                    n3=n3+3*factorial(n5-i,i);
                }
            }else{
                for (int i=0;i<n5/2;i++){
                    n3=n3+7*factorial(n5-i,i);
                }
            }
        }else{
            int n = n_before+s3[0].length();
            if (n==1){
                if(s3[0].charAt(0)+""=="*"){
                    n3 = n3 + 9;
                }
            }
            if (s3[0].charAt(s3[0].length()-1)+""=="*"){
                if (s3[0].charAt(s3[0].length()-2)+""=="1"){
                    for (int i=0;i<n/2;i++){
                        n3=n3+9*factorial(n-i,i);
                    }
                    n=n-2;
                    for (int i=0;i<n/2;i++){
                        n3=n3+factorial(n-i,i);
                    }
                }else{
                    for (int i=0;i<n/2;i++){
                        n3=n3+6*factorial(n-i,i);
                    }
                    n=n-1;
                    for (int i=0;i<n/2;i++){
                        n3=n3+3*factorial(n-i,i);
                    }
                    n=n-1;
                    for (int i=0;i<n/2;i++){
                        n3=n3+factorial(n-i,i);
                    }
                }
            }else{
                for (int i=0;i<n/2;i++){
                    n3=n3+factorial(n-i,i);
                }
            }
        }
        return n3;
    }
    public static int factorial(int n,int m){
        int n4=1;
        for ( int i=0;i<m;i++){
            n4=n4*(n-i);
        }
        for (int i=0;i<m;i++){
            n4=n4/(i+1);
        }
        return n4;
    }
    public static int solvingStar2(String s){
        int n1=0;
        if (s.length()>2){
            // s[s.length()-2]==0
            if (s.charAt(s.length()-3)+""=="*"){
                n1=n1+2*solvingStar(s.substring(0,s.length()-3),0);
            }else{
                n1=n1+solvingStar(s.substring(0,s.length()-3),0);
            }
            // s[s.length()-2]==1
            n1=n1+solvingStar(s,0);
            // s[s.length()-2]==2-6
            n1=n1+5*solvingStar(s.substring(0,s.length()-1),0);
            // s[s.length()-2]==7-9
            n1=n1+3*solvingStar3(s.substring(0,s.length()-1));
        }else{
            n1=n1+10;
        }
        return n1;
    }

}
