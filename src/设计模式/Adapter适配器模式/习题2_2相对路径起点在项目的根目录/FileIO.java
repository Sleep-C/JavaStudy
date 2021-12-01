package 设计模式.Adapter适配器模式.习题2_2相对路径起点在项目的根目录;

import java.io.IOException;

public interface FileIO {
    void readFromFile(String filename) throws IOException;
    void writeToFile(String filename) throws IOException;
    void setValue(String key,String value);
    String getValue(String key);
}
