package com.pijingzhanji.common.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : 披荆斩棘
 * @date : 2017/10/30
 */
public final class SortUtils {

    /**
     * 字符串 ascii 升序.
     * 首先字符串切割成一个个字符,然后汇总字符串的ascii,然后进行升序
     * <p>
     * <pre>
     *     final List< String > primaryIds = new ArrayList<>( Arrays.asList( "95", "69", "78", "1207", "1216", "1225","224","77","as","gd","a" ) );
     *     primaryIds.sort( SortUtils.naturalOrderAscii() );
     *     System.err.println( "primaryIds = " + primaryIds );
     *     打印 : primaryIds = [a, 95, 77, 69, 78, 224, 1207, 1216, 1225, gd, as]
     * </pre>
     *
     * @return {@link Comparator}
     */
    public static Comparator< String > naturalOrderAscii () {
        return Comparator.comparing( SortUtils::sumStringAsciiValue );
    }


    /**
     * 字符串 数值(如果这个字符串是数值类型)或者ascii值(如果不是数值类型那么转换为ascii值) 升序.
     * 首先字符串切割成一个个字符,然后汇总字符串的数值或者ascii,然后进行升序
     * <p>
     * <pre>
     *     final List< String > primaryIds = new ArrayList<>( Arrays.asList( "3","1","9","22","5","8","224","77","as","gd","a" ) );
     *     primaryIds.sort( SortUtils.naturalOrderAscii() );
     *     System.err.println( "primaryIds = " + primaryIds );
     *     打印 : primaryIds = [1, 3, 5, 8, 9, a, 22, 77, 224, gd, as]
     * </pre>
     *
     * @return {@link Comparator}
     */
    public static Comparator< String > naturalOrderByNumberOrAscii () {
        return Comparator.comparing( SortUtils::sumStringNumberOrAsciiValue );
    }

    /**
     * 字符串 ascii 倒序.
     *
     * @return {@link Comparator}
     */
    public static Comparator< String > reverseOrderAscii () {
        return ( before , after ) -> sumStringAsciiValue( after ).compareTo( sumStringAsciiValue( before ) );
    }

    /**
     * 汇总字符串中每个字符 ascii 的值
     *
     * @param string
     * @return
     */
    public static Long sumStringAsciiValue ( String string ) {
        return Stream.of( string.toCharArray() )
                     .mapToLong( chars -> {
                         List< Byte > bytes = new ArrayList<>( chars.length );
                         for ( char c : chars ) {
                             bytes.add( ( byte ) c );
                         }
                         return bytes.parallelStream().mapToLong( Byte::longValue ).sum();
                     } ).sum();
    }

    /**
     * 汇总字符串中每个字符 数值或者ascii值
     *
     * @param string
     * @return
     */
    public static Long sumStringNumberOrAsciiValue ( String string ) {
        if ( NumberPlusUtils.isNumberPlus( string ) ) {
            return Long.valueOf( string );
        }
        return sumStringAsciiValue( string );
    }
}
