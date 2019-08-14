package wen.tian.it;

import org.junit.Test;

/**
 * @author tianwenwen
 * @date 2019/8/12 9:55
 **/
public class MyTest {
    @Test
    public void test1(){
        Key1 key1 = new Key1(1,"san");
        Key1 key11 = new Key1(1,"san");
        System.out.println(key1.hashCode());
        System.out.println(key11.hashCode());
        System.out.println(key1.equals(key11));
    }
}
