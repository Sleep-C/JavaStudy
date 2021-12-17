package LeetcodeAll.week271;

public class Five21 {
    public static void main(String[] args) {

    }
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int out = 0;
        int waterA = capacityA;
        int waterB = capacityB;
        int mid = plants.length/2;
        for (int i = 0; i < mid; i++){
            if (waterA < plants[i]){
                waterA = capacityA;
                out++;
            }
            waterA = waterA - plants[i];
        }
        if (plants.length%2 == 1){
            for (int i = plants.length - 1; i > mid; i--){
                if (waterB < plants[i]){
                    waterB = capacityB;
                    out++;
                }
                waterB = waterB - plants[i];
            }
            if (waterB < plants[mid] && waterA < plants[mid]){
                out++;
            }
        }else {
            for (int i = plants.length - 1; i > mid - 1; i--){
                if (waterB < plants[i]){
                    waterB = capacityB;
                    out++;
                }
                waterB = waterB - plants[i];
            }
        }
        return out;
    }
}
