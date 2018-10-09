package com.whu.sres.lhw.tools.design.factory;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumMap;

/**
 * Description: 枚举缓存Car工厂方法实现类
 * Created by lvhw on 2018/10/5 18:26.
 */
public enum CachedCarFactory {
    FordCar {
        @Override
        Car createSelf() {
            return new FordCar();
        }
    },
    BuickCar {
        @Override
        Car createSelf() {
            return new BuickCar();
        }
    };

    /**
     * 枚举缓存，保存实例化的car对象
     */
    private static EnumMap<CachedCarFactory, Car> cache = Maps.newEnumMap(CachedCarFactory.class);

    public Car create() {
        Car car = cache.get(this);
        if (null == car) {
            car = createSelf();
            cache.put(this, car);
        }
        return car;
    }

    abstract Car createSelf();

    public static CachedCarFactory getByName(String carName) {
        for (CachedCarFactory cachedCarFactory : CachedCarFactory.values()) {
            if (StringUtils.equalsIgnoreCase(cachedCarFactory.toString(), carName)) {
                return cachedCarFactory;
            }
        }
        throw new AssertionError("unsupported car type : " + carName);
    }
}
