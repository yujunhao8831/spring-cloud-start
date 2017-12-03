package com.pijingzhanji.common.util;


import com.pijingzhanji.common.regex.RegexType;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 披荆斩棘
 * @date : 2016/10/15
 */
public final class NumberPlusUtils extends NumberUtils {

    private static final Pattern NUMBER_PATTERN                = Pattern.compile( RegexType.NUMBER );
    private static final Pattern SQUARE_ROOT_IN_NUMBER_PATTERN = Pattern.compile( RegexType.SQUARE_ROOT_IN_NUMBER );

    /**
     * 判断一个数字是否是正整数
     * <p>正整数为大于0的整数。自然数中，除了0，其余的就是正整数。
     * 正整数又可分为质数，1和合数。正整数可带正号（+），也可以不带。
     * 如：+1、+6、3、5，这些都是正整数。
     * </p>
     *
     * @param digital
     * @return
     */
    public static boolean isPositiveInteger ( int digital ) {
        return digital > 0 && digital % 1 == 0;
    }

    public static boolean isNotPositiveInteger ( int digital ) {
        return ! isPositiveInteger( digital );
    }

    /**
     * 判断一个字符串是否是正数
     * <p>
     * 比0大的数叫正数[positive number],0本身不算正数。正数前面常有一个符号“+”，通常可以省略不写。
     * </p>
     *
     * @param character
     * @return
     */
    public static boolean isPositiveNumber ( String character ) {
        return ! isNotSquareRootInNumber( character ) && Float.parseFloat( character ) > 0;
    }

    public static boolean isNotPositiveNumber ( String character ) {
        return ! isPositiveNumber( character );
    }

    /**
     * is 根号里的数
     * <p>根号里面不能为负数(大于等于0的数)</p>
     */
    public static boolean isSquareRootInNumber ( String character ) {
        if ( null == character ) {
            return false;
        }
        Matcher matcher = SQUARE_ROOT_IN_NUMBER_PATTERN.matcher( character );
        return matcher.matches();
    }

    public static boolean isNotSquareRootInNumber ( String character ) {
        return ! isSquareRootInNumber( character );
    }

    /**
     * is 数字
     *
     * @param character
     * @return
     */
    public static boolean isNumberPlus ( String character ) {
        if ( null == character ) {
            return false;
        }
        Matcher matcher = NUMBER_PATTERN.matcher( character );
        return matcher.matches();
    }

    public static boolean isNotNumberPlus ( String character ) {
        return ! isNumberPlus( character );
    }


}














