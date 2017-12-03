package com.pijingzhanji.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author : 披荆斩棘
 * @date : 2017/7/28
 */
public class UploadUtils {

    /**
     * 构建路径
     * <pre>
     * UploadUtils.buildPath("user/local","info","root")                = /user/local/info/root/
     * UploadUtils.buildPath("user//local","info/","/root")             = /user/local/info/root/
     * UploadUtils.buildPath("//user//local//","info/","/root")         = /user/local/info/root/
     * UploadUtils.buildPath("//user//local//","//info/","/root")       = /user/local/info/root/
     * UploadUtils.buildPath("//user//local//","//info///","//root")    = /user/local/info/root/
     * UploadUtils.buildPath("//user//local//","//info///","//root///") = /user/local/info/root/
     * </pre>
     *
     * @param paths
     * @return
     */
    public static String buildPath ( String... paths ) {
        StringBuilder builder = new StringBuilder();
        for ( String path : paths ) {
            final String[] pathArrays = StringUtils.split( path , StringPrivateUtils.SPRIT );
            builder.append( addSpritPrefix( StringUtils.join( pathArrays , StringPrivateUtils.SPRIT ) ) );
        }
        return addSpritSuffix( builder.toString() , true );
    }

    /**
     * 构建存储文件夹,如果没有这个文件夹目录,则创建
     *
     * @param storeFolderPath : 文件夹目录路径
     * @return
     */
    public static boolean buildStoreFolder ( String storeFolderPath ) {
        Path path = Paths.get( storeFolderPath );
        File file = path.toFile();
        return file.exists() || file.mkdirs();
    }

    /**
     * 构建文件名称
     *
     * @param fileName : 默认文件名
     * @return {@link UUID#randomUUID()} + #fileName
     */
    public static String buildFileName ( String fileName ) {
        return UUID.randomUUID().toString() + fileName;
    }


    /**
     * 添加 '/' 前缀
     * <pre>
     * UploadUtils.addSpritPrefix("user/local")  =  /user/local
     * </pre>
     *
     * @param rawPath : 路径
     * @return
     */
    public static String addSpritPrefix ( String rawPath ) {
        return addSpritPrefixRepeat( rawPath , false );
    }

    /**
     * 添加 '/' 前缀,可去除重复 '/',只保留一个 '/'
     * <pre>
     * UploadUtils.addSpritPrefix("//user/local",true)     =  /user/local
     * UploadUtils.addSpritPrefix("//user/local/",true)    =  /user/local/
     * UploadUtils.addSpritPrefix("//user/local//",true)   =  /user/local/
     * UploadUtils.addSpritPrefix("///user/local",true)    =  /user/local
     * UploadUtils.addSpritPrefix("///user/local/",true)   =  /user/local/
     * UploadUtils.addSpritPrefix("///user/local//",true)  =  /user/local/
     * </pre>
     *
     * @param rawPath    : 路径
     * @param repetition : 是否去除重复
     * @return
     */
    public static String addSpritPrefix ( String rawPath , boolean repetition ) {
        return addSpritPrefixRepeat( rawPath , repetition );
    }


    private static String addSpritPrefixRepeat ( String rawPath , boolean repetition ) {
        if ( ! repetition ) {
            return StringPrivateUtils.SPRIT + rawPath;
        }
        String[] paths = StringUtils.split( rawPath , StringPrivateUtils.SPRIT );
        if ( StringUtils.lastIndexOf( rawPath , StringPrivateUtils.SPRIT ) == rawPath.length() - 1 ) {
            // 最后一个字符是 "/"
            return StringPrivateUtils.SPRIT + StringUtils.join( paths ,
                                                                StringPrivateUtils.SPRIT ) + StringPrivateUtils.SPRIT;
        }
        return StringPrivateUtils.SPRIT + StringUtils.join( paths , StringPrivateUtils.SPRIT );
    }

    /**
     * 添加 '/' 后缀
     * <pre>
     * UploadUtils.addSpritSuffix("//user/local")     =  /user/local/
     * </pre>
     *
     * @param rawPath : 路径
     * @return
     */
    public static String addSpritSuffix ( String rawPath ) {
        return addSpritSuffixRepeat( rawPath , false );
    }

    /**
     * 添加 '/' 后缀
     * <pre>
     * UploadUtils.addSpritSuffix("user/local",true)          =    user/local/
     * UploadUtils.addSpritSuffix("///user/local",true)       =    /user/local/
     * UploadUtils.addSpritSuffix("user/local///",true)       =    user/local/
     * UploadUtils.addSpritSuffix("///user/local///",true)    =    /user/local/
     * </pre>
     *
     * @param rawPath    : 路径
     * @param repetition : 是否去重复
     * @return
     */
    public static String addSpritSuffix ( String rawPath , boolean repetition ) {
        return addSpritSuffixRepeat( rawPath , repetition );
    }

    private static String addSpritSuffixRepeat ( String rawPath , boolean repetition ) {
        if ( ! repetition ) {
            return rawPath + StringPrivateUtils.SPRIT;
        }

        String[] paths = StringUtils.split( rawPath , StringPrivateUtils.SPRIT );
        if ( StringUtils.indexOf( rawPath , StringPrivateUtils.SPRIT ) == 0 ) {
            // 第一个字符是 "/"
            return StringPrivateUtils.SPRIT + StringUtils.join( paths ,
                                                                StringPrivateUtils.SPRIT ) + StringPrivateUtils.SPRIT;
        }
        return StringUtils.join( paths , StringPrivateUtils.SPRIT ) + StringPrivateUtils.SPRIT;
    }


}
