package com.stu.sign.utils;

/**
 * @author zhaoyan5 对象按值比较是否相等
 */
public class EqualUtils {

	// 比较某个对象按字符比较是否和多个对象中的某一个按字符比较相等,只要有一个相等就返回true.
	public static boolean equals(Object o, Object... args) {
		if (o == null && args == null) {// 如果a和b都为空
			return true;
		}
		if (o != null && args != null) {// 如果a和b都不为空
			for (Object arg : args) {// 如果a和任意一个相等都返回true
				if (o != null && arg != null && String.valueOf(o).equals(String.valueOf(arg))) {
					return true;
				}
			}
		}
		return false;
	}

	// 比较某个对象按字符比较是否和多个对象中的某一个按字符比较相等,只要有一个相等就返回false.
	public static boolean notEquals(Object o, Object... args) {
		if (o == null && args == null) {// 如果a和b都为空
			return false;
		}
		if (o != null && args != null) {// 如果a和b都不为空
			for (Object arg : args) {// 如果a和任意一个相等都返回true
				if (o != null && arg != null && String.valueOf(o).equals(String.valueOf(arg))) {
					return false;
				}
			}
		}
		return true;
	}
}