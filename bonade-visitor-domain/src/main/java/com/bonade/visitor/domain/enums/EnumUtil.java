package com.bonade.visitor.domain.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

import org.spin.common.db.entity.MyBatisEnum;
import org.spin.common.throwable.BizException;
import org.springframework.util.ObjectUtils;

import com.baomidou.mybatisplus.core.enums.IEnum;

public class EnumUtil {

	@SuppressWarnings("rawtypes")
	public static <T extends MyBatisEnum> String getByValue(Integer value, Class<T> enumClass,String strAtt) {
        for (T each: enumClass.getEnumConstants()) {
            if (value.equals(each.getValue())) {
                return each.getDescription();
            }
        }
        if(ObjectUtils.isEmpty(strAtt)) {
        	return null;
        }else {
        	throw new BizException(strAtt + "枚举值不存在!");
        }
    }
	
	@SuppressWarnings("rawtypes")
	private static Map<Class, Object> map = new ConcurrentHashMap<>();

	@SuppressWarnings("unchecked")
	public static <T> Optional<T> getEnumObject(Class<T> className, Predicate<T> predicate) {
        if (!className.isEnum()) {
            return null;
        }
        Object obj = map.get(className);
        T[] ts = null;
        if (obj == null) {
            ts = className.getEnumConstants();
            map.put(className, ts);
        } else {
            ts = (T[]) obj;
        }
        return Arrays.stream(ts).filter(predicate).findAny();
    }

	
	@SuppressWarnings("rawtypes")
	public static <T> Optional<T> getEnum(Integer value,Class<T> enumClass,String strAtt) {
	    Optional<T> m1 = (Optional<T>) EnumUtil.getEnumObject(enumClass, e -> ((IEnum) e).getValue().equals(value));
	    if(m1.isPresent()) {
	    	return m1;
	    }else {
	    	 if(ObjectUtils.isEmpty(strAtt)) {
	         	return null;
	         }else {
	         	throw new BizException(strAtt + "枚举值不存在!");
	         }
	    }
	}
}
