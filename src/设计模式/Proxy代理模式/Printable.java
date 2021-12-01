package 设计模式.Proxy代理模式;

public interface Printable {
    void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}
