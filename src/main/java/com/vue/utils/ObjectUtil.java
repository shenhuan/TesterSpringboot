package com.vue.utils;

/**
 * @author juan
 * @ClassName ObjectUtil
 * @Description 对象工具类
 * @Date 2020/1/1
 * @Verison 1.0
 */

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;


import java.util.Map;

public class ObjectUtil {
    public static <T> T mapToObject(Map map, Class<T> beanClass) throws Exception {
        if (map == null)
            return null;

        T obj = beanClass.newInstance();

        BeanUtils.populate(obj, map);

        return obj;
    }

    public static Map objectToMap(Object obj) {
        if (obj == null)
            return null;

        return new BeanMap(obj);
    }

}

