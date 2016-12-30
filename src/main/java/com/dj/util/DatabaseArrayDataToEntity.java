package com.dj.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DatabaseArrayDataToEntity {
	
	 /**
     * 相同属性值拷贝，不相同的属性保留原值
     * @author: bingye
     * @createTime: 2014-11-8 上午10:33:59
     * @param <S>
     * @param <D>
     * @param s 源对象
     * @param d 目标对象
     * @return D 目标对象
     */
   /* @SuppressWarnings({ "unchecked", "rawtypes"})
    public static <S, D> List<S> copyPropertys(S s, List<D> ds) {
       
    	List<S> dfields = new ArrayList<S>();
        Field[] sfields = s.getClass().getDeclaredFields();
        Class scls = s.getClass();
        
        	try {
            for (Field sfield : sfields) {
            	
            	
            	
                String sName = sfield.getName();
                Class sType = sfield.getType();
                String sfieldName = sName.substring(0, 1).toUpperCase()
                        + sName.substring(1);
                Method sGetMethod = scls.getMethod("get" + sfieldName);
                Object value = sGetMethod.invoke(s);
                for (Field dfield : dfields) {
                    String dName = dfield.getName();
                    Class dType = dfield.getType();
                    if (dName.equals(sName)
                            && sType.toString().equals(dType.toString())) {
                        Method dSetMethod = dcls.getMethod("set" + sfieldName,
                                sType);
                        dSetMethod.invoke(d, value);
                        break;
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e1) {
            e1.printStackTrace();
        }
        return d;
    }
*/
}
