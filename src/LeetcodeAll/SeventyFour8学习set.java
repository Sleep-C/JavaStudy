package LeetcodeAll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeventyFour8学习set {
    public static void main(String[] args) {

    }
    //官方解答set用法学习
//    public int robotSim(int[] commands, int[][] obstacles) {
//        int[] dx = new int[]{0, 1, 0, -1};
//        int[] dy = new int[]{1, 0, -1, 0};
//        int x = 0, y = 0, di = 0;
//
//        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
//        Set<Long> obstacleSet = new HashSet();
//        for (int[] obstacle: obstacles) {
//            long ox = (long) obstacle[0] + 30000;
//            long oy = (long) obstacle[1] + 30000;
//            obstacleSet.add((ox << 16) + oy);
//        }
//
//        int ans = 0;
//        for (int cmd: commands) {
//            if (cmd == -2)  //left
//                di = (di + 3) % 4;
//            else if (cmd == -1)  //right
//                di = (di + 1) % 4;
//            else {
//                for (int k = 0; k < cmd; ++k) {
//                    int nx = x + dx[di];
//                    int ny = y + dy[di];
//                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
//                    if (!obstacleSet.contains(code)) {
//                        x = nx;
//                        y = ny;
//                        ans = Math.max(ans, x*x + y*y);
//                    }
//                }
//            }
//        }
//
//        return ans;
//    }
    public static int robotSim(int[] commands, int[][] obstacles) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++){
            map.put(obstacles[i][0] + "," + obstacles[i][1] ,1);
        }
        int direction = 0;//0-北，1东，2南，3西
        int out = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < commands.length; i++){
            if (commands[i] < 0){
                switch(commands[i]){
                    case -1:
                        direction++;
                        break;
                    case -2:
                        direction--;
                        break;
                }
                if (direction < 0){
                    direction = 3;
                }
                if (direction > 3){
                    direction = 0;
                }
            }else{
                switch(direction){
                    case 0:
                        for (int j = 0; j < commands[i]; j++){
                            if (map.containsKey(x + "," + (y + 1))){
                                break;
                            }
                            y++;
                        }
                        break;
                    case 1:
                        for (int j = 0; j < commands[i]; j++){
                            if (map.containsKey((x + 1) + "," + y)){
                                break;
                            }
                            x++;
                        }
                        break;
                    case 2:
                        for (int j = 0; j < commands[i]; j++){
                            if (map.containsKey(x + "," + (y - 1))){
                                break;
                            }
                            y--;
                        }
                        break;
                    case 3:
                        for (int j = 0; j < commands[i]; j++){
                            if (map.containsKey((x - 1) + "," + y)){
                                break;
                            }
                            x--;
                        }
                        break;
                }
                if (x*x + y*y > out){
                    out = x*x + y*y;
                }
            }
        }
        return out;
    }
}
