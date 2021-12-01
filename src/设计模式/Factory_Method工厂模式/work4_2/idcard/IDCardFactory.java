package 设计模式.Factory_Method工厂模式.work4_2.idcard;

import 设计模式.Factory_Method工厂模式.work4_2.framework.Factory;
import 设计模式.Factory_Method工厂模式.work4_2.framework.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IDCardFactory extends Factory {
    private HashMap database = new HashMap();
    private int serial = 100;
    private List owners = new ArrayList();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner,serial++);
    }


    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List getOwners(){
        return owners;
    }
}
