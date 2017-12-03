package com.pijingzhanji.order.bean.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-08-21
 */
@Data
@EqualsAndHashCode( callSuper = true )
@Accessors( chain = true )
@TableName( "pijingzhanji_order" )
public class Order extends Model< Order > {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @TableId( value = "id", type = IdType.AUTO )
    private Integer id;
    /**
     * 订单号
     */
    @TableField( "order_id" )
    private String  orderId;


    @Override
    protected Serializable pkVal () {
        return this.id;
    }

}
