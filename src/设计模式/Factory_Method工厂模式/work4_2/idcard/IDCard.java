package 设计模式.Factory_Method工厂模式.work4_2.idcard;

import 设计模式.Factory_Method工厂模式.work4_2.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int number;
    IDCard(String owner,int number){
        System.out.println("制作"+owner+"的ID卡");
        this.owner = owner;
        this.number = number;
    }
    @Override
    public void use() {
        System.out.println("使用"+owner+"的ID卡");
    }
    public String getOwner(){
        return owner;
    }
    public int getNumber(){return number;}
}
