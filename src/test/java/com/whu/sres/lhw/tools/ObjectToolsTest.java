package com.whu.sres.lhw.tools;

import com.whu.sres.lhw.tools.bean.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 * Created by lvhw on 2018/10/2 21:03.
 */
public class ObjectToolsTest extends BaseTest{

    @Test
    public void generateToString() {
        BaseArg arg = new BaseArg();
        arg.setId(100);
        arg.setName("testName");

        String str = ObjectTools.generateToString(arg, arg.getId(), arg.getName());
        log.info(str);
    }

    @Test
    public void deepCloneNormal() {
        ResultBean<String> r1 = new ResultBean<>();
        r1.setCode(1000);
        r1.setResult("result bean 1.");

        ResultBean<String> r2 = ObjectTools.deepClone(r1);
        r2.setResult("result bean 2.");
        println(r1);
        println(r2);
    }

    @Test
    public void deepCloneTransient() {
        Person o1 = new Person();
        o1.setId(1);
        o1.setName("user1");
        o1.setPassWord("abc");

        Person o2 = ObjectTools.deepClone(o1);
        println(o1);
        println(o2);
    }

    @Test
    public void deepCloneInnerNoneSerializable() {
        Person o1 = new Person();
        o1.setId(1);
        o1.setName("user1");
        o1.setPassWord("abc");
        Career career1 = new Career();
        career1.setTitle("programmer");
        career1.setPhones(Arrays.asList("1978234", "110000"));
        o1.setCareer(career1);

        Person o2 = ObjectTools.deepClone(o1);
        println(o1);
        println(o2);
    }

    @Test
    public void copyAttribute() {
        Person p1 = new Person();
        p1.setId(101);
        p1.setName("p1");
        p1.setPassWord("111");

        PersonAlias p2 = new PersonAlias();
        p2.setId("102");
        p2.setName("p2");
        p2.setNameAlias("p2alias");

        ObjectTools.copyAttribute(p1, p2);
        println(p1);
        println(p2);
    }
}