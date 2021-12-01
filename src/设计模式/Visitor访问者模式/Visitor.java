package 设计模式.Visitor访问者模式;




public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
