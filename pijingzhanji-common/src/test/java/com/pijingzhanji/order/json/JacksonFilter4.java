package com.pijingzhanji.order.json;

import com.pijingzhanji.common.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author : 披荆斩棘
 * @date : 2017/6/22
 */
public class JacksonFilter4 {

    Map< String, Object > data;

    @Before
    public void setUp () throws Exception {
        String json = "{\"statusCode\":\"200\",\"statusMessage\":\"请求成功\",\"responseContent\":{\"pageNum\":1,\"pageSize\":10,\"size\":10,\"startRow\":1,\"endRow\":10,\"total\":4691,\"pages\":470,\"list\":[{\"orderNo\":\"pijingzhanji161124154114718384\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"tcj004\",\"nickName\":\"tcj004\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":20000,\"platformName\":\"神道1\",\"serverId\":105,\"serverName\":\" 神道2区\",\"amount\":1.0,\"receiptAmount\":1.0,\"fee\":0.0,\"createTime\":\"2016-11-24 15:41:14\",\"payTime\":\"2016-11-24 15:42:00\",\"paymentOrderNo\":\"pijingzhanji20161124154114699326\",\"tradeNo\":\"pijingzhanji_reToplat161124154200865608\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司11\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161124154409602012\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"tcj004\",\"nickName\":\"tcj004\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":20000,\"platformName\":\"神道1\",\"serverId\":110,\"serverName\":\" 新浪1服\",\"amount\":1.0,\"receiptAmount\":1.0,\"fee\":0.0,\"createTime\":\"2016-11-24 15:44:09\",\"payTime\":\"2016-11-24 15:44:33\",\"paymentOrderNo\":\"pijingzhanji20161124154409478232\",\"tradeNo\":\"pijingzhanji_reToplat161124154433154600\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司11\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161124154458248829\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"tcj004\",\"nickName\":\"tcj004\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":1,\"platformName\":\"玩一下\",\"serverId\":0,\"serverName\":\" \",\"amount\":10.0,\"receiptAmount\":10.0,\"fee\":0.0,\"createTime\":\"2016-11-24 15:44:58\",\"payTime\":\"2016-11-24 15:45:36\",\"paymentOrderNo\":\"pijingzhanji20161124154458765068\",\"tradeNo\":\"pijingzhanji_re161124154536978148\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161124164044273545\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"15810461570\",\"nickName\":\"15810461570\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":1,\"platformName\":\"玩一下\",\"serverId\":0,\"serverName\":\" \",\"amount\":4999.0,\"receiptAmount\":4999.0,\"fee\":0.0,\"createTime\":\"2016-11-24 16:40:44\",\"payTime\":\"2016-11-24 16:41:36\",\"paymentOrderNo\":\"pijingzhanji20161124164044672101\",\"tradeNo\":\"pijingzhanji_re161124164136282060\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161125112608247257\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"15810461570\",\"nickName\":\"15810461570\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":1,\"platformName\":\"玩一下\",\"serverId\":0,\"serverName\":\" \",\"amount\":1.0,\"receiptAmount\":1.0,\"fee\":0.0,\"createTime\":\"2016-11-25 11:26:08\",\"payTime\":\"2016-11-25 11:26:42\",\"paymentOrderNo\":\"pijingzhanji20161125112608130025\",\"tradeNo\":\"pijingzhanji_re161125112642209553\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161125114228133052\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"15810461570\",\"nickName\":\"15810461570\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":1,\"platformName\":\"玩一下\",\"serverId\":0,\"serverName\":\" \",\"amount\":2.0,\"receiptAmount\":2.0,\"fee\":0.0,\"createTime\":\"2016-11-25 11:42:28\",\"payTime\":\"2016-11-25 11:43:12\",\"paymentOrderNo\":\"pijingzhanji20161125114228191862\",\"tradeNo\":\"pijingzhanji_re161125114312533857\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161125162709967226\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"tcj004\",\"nickName\":\"tcj004\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":10092,\"platformName\":\"乐盈电竞\",\"serverId\":114,\"serverName\":\" 人人1区\",\"amount\":1.0,\"receiptAmount\":1.0,\"fee\":0.0,\"createTime\":\"2016-11-25 16:27:09\",\"payTime\":\"2016-11-25 16:27:43\",\"paymentOrderNo\":\"pijingzhanji20161125162709926913\",\"tradeNo\":\"pijingzhanji_reToplat161125162743072010\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161125184829170463\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"tcj004\",\"nickName\":\"tcj004\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":10088,\"platformName\":\"海妖直播\",\"serverId\":116,\"serverName\":\" 开心1区\",\"amount\":0.0,\"receiptAmount\":0.0,\"fee\":0.0,\"createTime\":\"2016-11-25 18:48:29\",\"payTime\":\"2016-11-25 18:49:41\",\"paymentOrderNo\":\"pijingzhanji20161125184829544896\",\"tradeNo\":\"pijingzhanji_reToplat161125184941831455\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161124163846395460\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"15810461570\",\"nickName\":\"15810461570\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":1,\"platformName\":\"玩一下\",\"serverId\":0,\"serverName\":\" \",\"amount\":4999.0,\"receiptAmount\":4999.0,\"fee\":0.0,\"createTime\":\"2016-11-24 16:38:46\",\"payTime\":\"2016-11-26 06:46:54\",\"paymentOrderNo\":\"pijingzhanji20161124163846219549\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161124163814279933\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"15810461570\",\"nickName\":\"15810461570\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":1,\"platformName\":\"玩一下\",\"serverId\":0,\"serverName\":\" \",\"amount\":9990.0,\"receiptAmount\":9990.0,\"fee\":0.0,\"createTime\":\"2016-11-24 16:38:14\",\"payTime\":\"2016-11-26 06:46:54\",\"paymentOrderNo\":\"pijingzhanji20161124163814175829\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"}],\"prePage\":0,\"nextPage\":2,\"isFirstPage\":true,\"isLastPage\":false,\"hasPreviousPage\":false,\"hasNextPage\":true,\"navigatePages\":8,\"navigatepageNums\":[1,2,3,4,5,6,7,8],\"navigateFirstPage\":1,\"navigateLastPage\":8,\"firstPage\":1,\"lastPage\":8}}";
        data = JsonUtils.jsonToType( json , Map.class );
    }

    @Test
    public void name () throws Exception {
        System.err.println( "data = " + data );

        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
        String filter = "*,responseContent[*,list[payStatusName,userId]]";
        System.err.println( filter + ",data = " + JsonUtils.toFilterJson( data , filter ) );

    }


}











