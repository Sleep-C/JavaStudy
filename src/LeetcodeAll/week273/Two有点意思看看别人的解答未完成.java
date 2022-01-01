package LeetcodeAll.week273;

public class Two有点意思看看别人的解答未完成 {
    public static void main(String[] args) {
        System.out.println(executeInstructions(9,new int[]{4,5},"URDDDUUUUULLLLLDDD"));
    }
    //凸形结构暂时无法解决
    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];
        int x = startPos[1];
        int y = startPos[0];
        int j = 0;
        int i = 0;
        for (; i < s.length(); i++){
            int label = 0;
            while (label == 0 && j < s.length()){
                switch (s.charAt(j)){
                    case 'L':
                        if (x > 0){
                            x--;
                        }else{
                            label = 1;
                        }
                        break;
                    case 'R':
                        if (x < n - 1){
                            x++;
                        }else{
                            label = 1;
                        }
                        break;
                    case 'U':
                        if (y > 0){
                            y--;
                        }else{
                            label = 1;
                        }
                        break;
                    case 'D':
                        if (y < n - 1){
                            y++;
                        }else{
                            label = 1;
                        }
                        break;
                }
                if (label == 0){
                    j++;
                }
            }
            result[i] = j - i;
            switch (s.charAt(i)){
                case 'L':
                    if (x < n - 1){
                        x++;
                    }else{
                        j = i + 1;
                        x = startPos[1];
                        y = startPos[0];
                    }
                    break;
                case 'R':
                    if (x > 0){
                        x--;
                    }else{
                        j = i + 1;
                        x = startPos[1];
                        y = startPos[0];
                    }
                    break;
                case 'U':
                    if (y < n - 1){
                        y++;
                    }else{
                        j = i + 1;
                        x = startPos[1];
                        y = startPos[0];
                    }
                    break;
                case 'D':
                    if (y > 0){
                        y--;
                    }else{
                        j = i + 1;
                        x = startPos[1];
                        y = startPos[0];
                    }
                    break;
            }
        }
        return result;
    }
}
