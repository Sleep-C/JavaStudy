package LeetcodeAll;

public class ThirtySix {
    public static void main(String[] args ){
        char[][] board=new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        int[] arr;
        for (int i=0;i<9;i++){
            arr=new int[]{0,0,0,0,0,0,0,0,0};
            for (int j=0;j<9;j++){
                if (board[i][j]=='.'){
                    continue;
                }
                int x=Integer.parseInt(String.valueOf(board[i][j]))-1;
                arr[x]++;
                if (arr[x]>1){
                    return false;
                }
            }
            arr=new int[]{0,0,0,0,0,0,0,0,0};
            for (int j=0;j<9;j++){
                if (board[j][i]=='.'){
                    continue;
                }
                int x=Integer.parseInt(String.valueOf(board[j][i]))-1;
                arr[x]++;
                if (arr[x]>1){
                    return false;
                }
            }
        }
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                arr=new int[]{0,0,0,0,0,0,0,0,0};
                for (int m=0;m<3;m++){
                    for (int n=0;n<3;n++){
                        if (board[3*i+m][3*j+n]=='.'){
                            continue;
                        }
                        int x=Integer.parseInt(String.valueOf(board[3*i+m][3*j+n]))-1;
                        arr[x]++;
                        if (arr[x]>1){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
