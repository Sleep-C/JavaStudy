package LeetcodeAll.doubelWeek65;

public class nine206为什么不对 {
    private int now_x;
    private int now_y;
    private int width;
    private int height;
    private String dir;
    public nine206为什么不对(int width, int height) {
        this.width = width;
        this.height = height;
        this.now_x = 0;
        this.now_x = 0;
        this.dir = "East";
    }

    public void step(int num) {
        num = num%(2*height + 2*width -4);
        for (int i = 0; i<num; i++){
            switch (dir){
                case "East":
                    if (now_x == width - 1){
                        dir = "North";
                        now_y++;
                    }else {
                        now_x++;
                    }
                    break;
                case "North":
                    if (now_y == height - 1){
                        dir = "West";
                        now_x--;
                    }else {
                        now_y++;
                    }
                    break;
                case "West":
                    if (now_x == 0){
                        dir = "South";
                        now_y--;
                    }else {
                        now_x--;
                    }
                    break;
                case "South":
                    if (now_y == 0){
                        dir = "East";
                        now_x++;
                    }else {
                        now_y--;
                    }
                    break;
            }
        }
    }

    public int[] getPos() {
        int[] pos = new int[]{now_x,now_y};
        return pos;
    }

    public String getDir() {
        return dir;
    }
}
