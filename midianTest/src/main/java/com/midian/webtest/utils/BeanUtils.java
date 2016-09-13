/**
 * Copyright @ 2016jkzl. All rights reserved
 */
package com.midian.webtest.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author peter.Chen
 * @version 1.0
 *          <p>
 *          operation
 *          date                        operator         content
 *          2016/9/8 14:31             peter.Chen       new
 * @Description:
 * @date 2016/9/8 14:31
 */
public class BeanUtils {
    /**
     * 二维数组转化为一维数组的遍历
     * @param array
     * @param toClass
     * @return
     */
    public static Iterator<Object[]> arrayToIterator(Object[][] array, Class toClass) {

        List<Object[]> objectArrayList = new ArrayList<Object[]>();
        try {
            Field[] fieldArray = toClass.getDeclaredFields();
            // 需要+判断参数个数是否相同
            for (int i = 0; i < array.length; i++) {
                Object[] innerArray = array[i];// 旧的一维数组如[1,2,3]
                Object instance = toClass.newInstance();
                Field field = null;
                for (int j = 0; j < innerArray.length; j++) {
                    field = fieldArray[j];
                    field.setAccessible(true);
                    field.set(instance, innerArray[j]);
                }
                Object[] newInnerArray = new Object[] { instance };// 新的[{<name,1>,<age,2>}]
                objectArrayList.add(newInnerArray);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return objectArrayList.iterator();
    }
}
