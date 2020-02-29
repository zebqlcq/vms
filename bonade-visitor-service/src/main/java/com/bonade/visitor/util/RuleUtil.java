package com.bonade.visitor.util;

import java.util.Random;

/**
 * 
 * @ClassName:  RuleUtil   
 * @Description:相关规则生成工具类 
 * @author: lcq 
 * @date:   2019年12月25日 下午3:51:36   
 * @version 1.0
 */
public class RuleUtil {
	
	/**
	 * 
	 * @Title: randomNum   
	 * @Description: 随机生成6位随机数
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 * @author: lcq
	 * @date:   2019年12月25日 下午3:51:31
	 * @version 1.0
	 */
	public static String randomNum() {
		Random random = new Random();
        int randomNum = random.nextInt(1000000);
        String randomCode = String.format("%06d", randomNum);
        System.out.println(randomCode);
		return randomCode;
	}
}
