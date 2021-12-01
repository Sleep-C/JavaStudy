package 设计模式.Adapter适配器模式.习题2_2相对路径起点在项目的根目录;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("src\\设计模式\\Adapter适配器模式\\习题2_2报错\\file.txt");
            f.setValue("year","2004");
            f.setValue("month","4");
            f.setValue("day","21");
            f.writeToFile("src\\设计模式\\Adapter适配器模式\\习题2_2报错\\newfile.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
