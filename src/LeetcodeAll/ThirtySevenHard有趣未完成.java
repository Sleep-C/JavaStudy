package LeetcodeAll;

public class ThirtySevenHard有趣未完成 {
    public static void main(String[] args ){
        char[][] board=new char[][]{{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        solveSudoku(board);
        //[['.','.','9','7','4','8','.','.','.'],['7','.','.','.','.','.','.','.','.'],['.','2','.','1','.','9','.','.','.'],['.','.','7','.','.','.','2','4','.'],['.','6','4','.','1','.','5','9','.'],['.','9','8','.','.','.','3','.','.'],['.','.','.','8','.','3','.','2','.'],['.','.','.','.','.','.','.','.','6'],['.','.','.','2','7','5','9','.','.']]
    }
    public static void solveSudoku(char[][] board) {
//        考虑维护一个备选值列表,先遍历一次数组，填充备选值列表，然后只在列表上做操作..判断第二个为0
        int[][][] alter=new int[9][9][9];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]=='.'){
                    fillAlter(i,j,board,alter);
                }
            }
        }
        int x;
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (alter[i][j][0]!=0 && alter[i][j][1]==0){
                    x=alter[i][j][0];
                    changeAlter(i,j,x,alter,board);
                }
            }
        }
        System.out.println('1');
    }
    public static int changeAlter3(int label,int i,int[][][] alter,int[] x){
        if (label==1){
            for (int m=0;m<x.length;m++){
                for (int j=0;j<9;j++){
                    int n=0;
                    for (;alter[i][j][n]!=0 && alter[i][j][n]<x[m];n++){
                    }
                    if (alter[i][j][n]==x[m]){
                        for (int k=n;k<8;k++){
                            alter[i][j][k]=alter[i][j][k+1];
                        }
                        alter[i][j][8]=0;
                    }
                }
            }
            for (int j=0;j<9;j++){
                if (alter[i][j][0]!=0 && alter[i][j][1]==0){
                    return 1;
                }
            }
        }
        if (label==2){
            for (int m=0;m<x.length;m++){
                for (int j=0;j<9;j++){
                    int n=0;
                    for (;alter[j][i][n]!=0 && alter[j][i][n]<x[m];n++){
                    }
                    if (alter[j][i][n]==x[m]){
                        for (int k=n;k<8;k++){
                            alter[j][i][k]=alter[j][i][k+1];
                        }
                        alter[j][i][8]=0;
                    }
                }
            }
            for (int j=0;j<9;j++){
                if (alter[j][i][0]!=0 && alter[j][i][1]==0){
                    return 1;
                }
            }
        }


        return 0;
    }
    public static void changeAlter2(int[][][] alter){
        //考虑找到任何一个直接return？
        int[] arr;
        for (int m=0;m<9;m++){
            arr=new int[]{0,0,0,0,0,0,0,0,0};
            int i=m/3;
            int j=m%3;
            for (int n=0;n<9;n++){
                int i1=n/3;
                int j1=n%3;

            }
        }
        for (int i=0;i<9;i++){
            arr=new int[]{0,0,0,0,0,0,0,0,0};
            for (int j=0;j<9;j++){
                if (alter[i][j][1]!=0 && alter[i][j][2]==0){
                    for (int m=j+1;m<9;m++){
                        if (alter[i][m][1]==alter[i][j][1] && alter[i][m][0]==alter[i][j][0] && alter[i][m][2]==0){
                            //其他全减去这两个数，判断如果存在length==1，调用changeAlter???return
                            int[] x=new int[]{alter[i][m][0],alter[i][m][1]};
                            int xx = changeAlter3(1,i,alter,x);
                            if (xx==1){
                                //return
                            }
                        }
                    }
                }
                if (alter[i][j][2]!=0 && alter[i][j][3]==0){
                    for (int m1=j+1;m1<8;m1++){
                        if (alter[i][m1][1]==alter[i][j][1] && alter[i][m1][2]==alter[i][j][2] && alter[i][m1][0]==alter[i][j][0] && alter[i][m1][3]==0){
                            for (int m2=m1+1;m2<9;m2++){
                                if (alter[i][m2][1]==alter[i][j][1] && alter[i][m2][2]==alter[i][j][2] && alter[i][m2][0]==alter[i][j][0] && alter[i][m2][3]==0){
                                    int[] x=new int[]{alter[i][m2][0],alter[i][m2][1],alter[i][m2][2]};
                                    int xx = changeAlter3(1,i,alter,x);
                                    if (xx==1){
                                        //return
                                    }
                                }
                            }
                        }
                    }
                }
                for (int m=0;alter[i][j][m]!=0;m++){
                    arr[alter[i][j][m]-1]++;
                }
            }//横向
            for (int m=0;m<9;m++){
                if (arr[m]==1){
                    //找到直接调用changeAlter
                    for (int j=0;j<9;j++){
                        for (int m1=0;alter[i][j][m1]!=0;m1++){
                            if (alter[i][j][m1]==m+1){
                                alter[i][j][0]=m+1;
                                for (m=1;m<9;m++){
                                    alter[i][j][m]=0;
                                }
                                //return
                            }
                        }
                    }
                }
            }
        }
        for (int j=0;j<9;j++){
            arr=new int[]{0,0,0,0,0,0,0,0,0};
            for (int i=0;i<9;i++){
                if (alter[i][j][1]!=0 && alter[i][j][2]==0){
                    for (int m=i+1;m<9;m++){
                        if (alter[m][j][1]==alter[i][j][1] && alter[m][j][0]==alter[i][j][0] && alter[m][j][2]==0){
                            //其他全减去这两个数，判断如果存在length==1，调用changeAlter???return
                            int[] x=new int[]{alter[m][j][0],alter[m][j][1]};
                            int xx = changeAlter3(2,j,alter,x);
                            if (xx==1){
                                //return
                            }
                        }
                    }
                }
                if (alter[i][j][2]!=0 && alter[i][j][3]==0){
                    for (int m1=i+1;m1<8;m1++){
                        if (alter[m1][j][1]==alter[i][j][1] && alter[m1][j][2]==alter[i][j][2] && alter[m1][j][0]==alter[i][j][0] && alter[m1][j][3]==0){
                            for (int m2=m1+1;m2<9;m2++){
                                if (alter[m2][j][1]==alter[i][j][1] && alter[m2][j][2]==alter[i][j][2] && alter[m2][j][0]==alter[i][j][0] && alter[m2][j][3]==0){
                                    int[] x=new int[]{alter[m2][j][0],alter[m2][j][1],alter[m2][j][2]};
                                    int xx = changeAlter3(2,j,alter,x);
                                    if (xx==1){
                                        //return
                                    }
                                }
                            }
                        }
                    }
                }
                for (int m=0;alter[i][j][m]!=0;m++){
                    arr[alter[i][j][m]-1]++;
                }
            }//纵向
            for (int m=0;m<9;m++){
                if (arr[m]==1){
                    //找到直接调用changeAlter
                    for (int i=0;i<9;i++){
                        for (int m1=0;alter[i][j][m1]!=0;m1++){
                            if (alter[i][j][m1]==m+1){
                                alter[i][j][0]=m+1;
                                for (m=1;m<9;m++){
                                    alter[i][j][m]=0;
                                }
                                //return
                            }
                        }
                    }
                }
            }
        }
    }

    public static void fillAlter(int i,int j,char[][] board,int[][][] alter){
        int[] arr=new int[]{0,0,0,0,0,0,0,0,0};
        int x;
        int n=i/3;
        int m=j/3;
        for (int k=0;k<9;k++){
            if (board[i][k]!='.'){
                x=Integer.parseInt(String.valueOf(board[i][k]))-1;
                arr[x]++;
            }
            if (board[k][j]!='.'){
                x=Integer.parseInt(String.valueOf(board[k][j]))-1;
                arr[x]++;
            }
        }
        for (int k1=0;k1<3;k1++){
            for (int k2=0;k2<3;k2++){
                if (board[n*3+k1][m*3+k2]!='.'){
                    x=Integer.parseInt(String.valueOf(board[n*3+k1][m*3+k2]))-1;
                    arr[x]++;
                }
            }
        }
        int label=0;
        for (int k=0;k<9;k++){
            if (arr[k]==0){
                alter[i][j][label]=k+1;
                label++;
            }
        }
    }
    public static void changeAlter(int i,int j,int x,int[][][] alter,char[][] board){//有问题!!!!
        board[i][j]=String.valueOf(alter[i][j][0]).toCharArray()[0];
        alter[i][j][0]=0;
        for (int k=0;k<9;k++){
            //考虑依次减去x，而后如果出现只有一种可能的，递归调用此函数
            for (int m=0;m<x;m++){
                if (alter[i][k][m]==x){
                    for (int m1=m;m1<8;m1++){
                        alter[i][k][m1]=alter[i][k][m1+1];
                    }
                    alter[i][k][8]=0;
                    break;
                }
            }
            if (alter[i][k][0]!=0 && alter[i][k][1]==0){
                changeAlter(i,k,alter[i][k][0],alter,board);
            }
            for (int m=0;m<x;m++){
                if (alter[k][j][m]==x){
                    for (int m1=m;m1<8;m1++){
                        alter[k][j][m1]=alter[k][j][m1+1];
                    }
                    alter[k][j][8]=0;
                    break;
                }
            }
            if (alter[k][j][0]!=0 && alter[k][j][1]==0){
                changeAlter(k,j,alter[k][j][0],alter,board);
            }
        }
        int n=i/3;
        int m=j/3;
        for (int k1=0;k1<3;k1++){
            for (int k2=0;k2<3;k2++){
                for (int m1=0;m1<x;m1++){
                    if (alter[n*3+k1][m*3+k2][m1]==x){
                        for (int m2=m1;m2<8;m2++){
                            alter[n*3+k1][m*3+k2][m2]=alter[n*3+k1][m*3+k2][m2+1];
                        }
                        alter[n*3+k1][m*3+k2][8]=0;
                        break;
                    }
                }
                if (alter[n*3+k1][m*3+k2][0]!=0 && alter[n*3+k1][m*3+k2][1]==0){
                    changeAlter(n*3+k1,m*3+k2,alter[n*3+k1][m*3+k2][0],alter,board);
                }
            }
        }
    }
}
