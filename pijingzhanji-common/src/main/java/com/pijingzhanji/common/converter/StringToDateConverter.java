package com.pijingzhanji.common.converter;

import com.pijingzhanji.common.util.DateFormatStyle;
import com.pijingzhanji.common.util.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @author : 披荆斩棘
 * @date : 17/7/17
 */
public class StringToDateConverter implements Converter< String, Date > {

    @Override
    public Date convert ( String source ) {
        for ( DateFormatStyle formatStyle : DateFormatStyle.values() ) {
            return DateUtils.formatStringByStyle( source.trim() , formatStyle.getDateStyle() );
        }
        return DateUtils.formatStringByStyle( source.trim() , DateFormatStyle.CN_DATE_BASIC_STYLE.getDateStyle() );
    }
}
