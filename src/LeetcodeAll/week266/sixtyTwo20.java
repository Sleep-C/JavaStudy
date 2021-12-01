package LeetcodeAll.week266;

public class sixtyTwo20 {
    public static void main(String[] args) {
        String word="bbaeixoubb";
        System.out.println(countVowelSubstrings(word));
    }
    public static int countVowelSubstrings(String word) {
        int label=0;
        int out=0;
        for (int i=0;i<word.length();i++){
            if (label==0 && (word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u')){
                out = out + count1(word,i);
                label = 1;
            }
            if (label==1 && word.charAt(i)!='a' && word.charAt(i)!='e' && word.charAt(i)!='i' && word.charAt(i)!='o' && word.charAt(i)!='u'){
                label=0;
            }
        }
        return out;
    }
    public static int count1(String word,int k){
        int i = k;
        int out=0;
        for (;i<word.length();i++){
            if (word.charAt(i)!='a' && word.charAt(i)!='e' && word.charAt(i)!='i' && word.charAt(i)!='o' && word.charAt(i)!='u'){
                break;
            }
        }
        i--;
        if (i-k<4){
            return 0;
        }
        int labela;
        int labele;
        int labeli;
        int labelo;
        int labelu;
        for (int m=k;m<=i-4;m++){
            labela=0;
            labele=0;
            labeli=0;
            labelo=0;
            labelu=0;
            for (int n=m;n<=i;n++){
                if (word.charAt(n)=='a'){
                    labela=1;
                }
                if (word.charAt(n)=='e'){
                    labele=1;
                }
                if (word.charAt(n)=='i'){
                    labeli=1;
                }
                if (word.charAt(n)=='o'){
                    labelo=1;
                }
                if (word.charAt(n)=='u'){
                    labelu=1;
                }
                if (labela==1 && labele==1 && labeli==1 && labelo==1 && labelu==1){
                    out = out + (i-n+1);
                    break;
                }
            }
        }
        return out;
    }
}
