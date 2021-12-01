package LeetcodeAll.week268;

public class Nine207模拟过程 {
    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[]{1,1,1,4,2,3},4));
    }
    public static int wateringPlants(int[] plants, int capacity) {
        int out = 0;
        int label = capacity;
        for(int i = 0; i<plants.length; i++){
            if(label >= plants[i]){
                out++;
                label-=plants[i];
            }else{
                label = capacity - plants[i];
                out += (2*i + 1);
            }
        }
        return out;
    }
}
