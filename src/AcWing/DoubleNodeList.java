package AcWing;

public class DoubleNodeList {
    int val;
    int subscript;
    DoubleNodeList next;
    DoubleNodeList pre;
    DoubleNodeList(int val){
        this.val = val;
    }
    DoubleNodeList(int val,int subscript){
        this.val = val;
        this.subscript = subscript;
    }
    DoubleNodeList(){}
    DoubleNodeList(int val,int subscript,DoubleNodeList next,DoubleNodeList pre){
        this.val = val;
        this.subscript = subscript;
        this.next = next;
        this.pre = pre;
    }
}
