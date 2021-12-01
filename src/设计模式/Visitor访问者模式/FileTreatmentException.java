package 设计模式.Visitor访问者模式;

public class FileTreatmentException extends RuntimeException{
    public FileTreatmentException(){

    }
    public FileTreatmentException(String msg){
        super(msg);
    }
}
