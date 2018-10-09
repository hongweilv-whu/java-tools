package com.whu.sres.lhw.tools;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Desc: 对象处理工具类
 * Created by lvhongwei on 2018/4/14.
 */
public final class ObjectTools {

    private ObjectTools() {
    }

    /**
     * 对象间属性拷贝
     *
     * 使用场景：DAO与VO、DTO与VO等对象做映射时，用此方法
     * 拷贝原理：
     * 1、源和目的两个类的访问权限需要是public的
     * 2、属性名称相同的进行拷贝
     * 3、属性类型为基本类型时，目的对象的范围要比源更大，如long和int
     * 4、属性类型为引用类型时，源和目的需要一致，浅拷贝
     *
     * @param source 源对象
     * @param dest   目的对象
     */
    public static void copyAttribute(Object source, Object dest) {
        try {
            PropertyUtils.copyProperties(dest, source);
            //BeanUtils.copyProperties(dest, source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 深度拷贝对象
     *
     * 使用场景：一个项目中需要实现clone的类很多时，建议采用该工具方法，而不是覆写每个类的clone方法。
     * 注意事项：
     * 1、该方法要求待拷贝的类实现了Serializable接口
     * 2、待拷贝的类如果有transient变量，不会进行拷贝
     * 3、待拷贝的类的属性也要是可序列化的。
     */
    public static <T extends Serializable> T deepClone(T src) {
        return SerializationUtils.clone(src);
        /*try {
            // 将对象写到流里
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(src);
            oo.close();
            // 从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            @SuppressWarnings("unchecked")
            T dest = (T) oi.readObject();
            oi.close();
            return dest;
        } catch (NotSerializableException e1) {
            throw new RuntimeException("inner property not serializable.", e1);
        } catch (Exception e) {
            throw new RuntimeException("deep clone failed.", e);
        }*/
    }

    /**
     * 根据对象属性，生成其HashCode值
     *
     * @param args 对象属性列表
     * @return hashCode值
     */
    public static int generateHashCode(Object... args) {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        for (Object arg : args) {
            hashCodeBuilder.append(arg);
        }
        return hashCodeBuilder.toHashCode();
    }

    public static String generateToString(Object target, Object... props) {
        ToStringBuilder toStringBuilder = new ToStringBuilder(target);
        for (Object prop : props) {
            toStringBuilder.append(prop);
        }
        return toStringBuilder.toString();
    }
}
