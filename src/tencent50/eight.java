package tencent50;

public class eight {
    public static void main(String[] args ){
        System.out.println(Math.pow(2,31));
        System.out.println(myAtoi("2147483646"));
    }
    //注重细节，逻辑严密，必须能想清楚每一点
    public static int myAtoi(String s) {
        int i=0;
        int num=s.length();
        int label=1;
        int n=0;
        int label2=0;
        if(num==0){
            return 0;
        }
        for (;s.charAt(i)==' ' && num-1>i;i++){
        }
        if(s.charAt(i)=='-'){
            label=-1;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }
        for(;label2==0 && i<num;i++){
            switch (s.charAt(i)){
                case '0':
                    if(n>214748364.7){
                        label2=2;
                    }
                    n=n*10+0;
                    break;
                case '1':
                    if(n>(214748364.6)){
                        label2=2;
                    }
                    n=n*10+1;
                    break;
                case '2':
                    if(n>(214748364.5)){
                        label2=2;
                    }
                    n=n*10+2;
                    break;
                case '3':
                    if(n>(214748364.4)){
                        label2=2;
                    }
                    n=n*10+3;
                    break;
                case '4':
                    if(n>(214748364.3)){
                        label2=2;
                    }
                    n=n*10+4;
                    break;
                case '5':
                    if(n>(214748364.2)){
                        label2=2;
                    }
                    n=n*10+5;
                    break;
                case '6':
                    if(n>(214748364.1)){
                        label2=2;
                    }
                    n=n*10+6;
                    break;
                case '7':
                    if(n>(214748364.0)){
                        label2=2;
                    }
                    n=n*10+7;
                    break;
                case '8':
                    if(n>(214748363.9)){
                        label2=2;
                    }
                    n=n*10+8;
                    break;
                case '9':
                    if(n>(214748363.8)){
                        label2=2;
                    }
                    n=n*10+9;
                    break;
                default:
                    label2=1;
            }
        }
        if (label2==2){
            if(label==1){
                n=(int)2147483648.0;
            }else {
                n=-(int)2147483648.0;
                n--;
            }
        }else {
            n=n*label;
        }

        return n;
    }
}
