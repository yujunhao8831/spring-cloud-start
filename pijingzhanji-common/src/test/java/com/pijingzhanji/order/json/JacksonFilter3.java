package com.pijingzhanji.order.json;

import com.pijingzhanji.common.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author : 披荆斩棘
 * @date : 2017/6/22
 */
public class JacksonFilter3 {

    Map< String, Object > data;

    @Before
    public void setUp () throws Exception {
        String json = "{\"statusCode\":\"200\",\"statusMessage\":\"请求成功\",\"responseContent\":{\"pageNum\":1,\"pageSize\":10,\"size\":10,\"startRow\":1,\"endRow\":10,\"total\":4691,\"pages\":470,\"list\":[{\"orderNo\":\"pijingzhanji161125183452000432\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"tcj004\",\"nickName\":\"tcj004\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":10088,\"platformName\":\"海妖直播\",\"serverId\":10088,\"serverName\":\" \",\"amount\":1.0,\"receiptAmount\":1.0,\"fee\":0.0,\"createTime\":\"2016-11-25 18:34:52\",\"payTime\":\"2016-11-27 07:46:56\",\"paymentOrderNo\":\"pijingzhanji20161125183452819716\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161125184829170463\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"tcj004\",\"nickName\":\"tcj004\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":10088,\"platformName\":\"海妖直播\",\"serverId\":116,\"serverName\":\" 开心1区\",\"amount\":0.0,\"receiptAmount\":0.0,\"fee\":0.0,\"createTime\":\"2016-11-25 18:48:29\",\"payTime\":\"2016-11-25 18:49:41\",\"paymentOrderNo\":\"pijingzhanji20161125184829544896\",\"tradeNo\":\"pijingzhanji_reToplat161125184941831455\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129161148902225\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"lml\",\"nickName\":\"lml\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":20000,\"platformName\":\"神道1\",\"serverId\":1,\"serverName\":\" 仙侠道1服\",\"amount\":100.0,\"receiptAmount\":100.0,\"fee\":0.0,\"createTime\":\"2016-11-29 16:11:50\",\"payTime\":\"2016-12-01 11:47:03\",\"paymentOrderNo\":\"pijingzhanji20161129161145800432\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司11\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129161236043515\",\"payStatus\":2,\"payStatusName\":\"失败\",\"userId\":\"tcj011\",\"nickName\":\"tcj011\",\"rechargeWay\":4,\"rechargeWayName\":\"支付宝\",\"platformId\":10092,\"platformName\":\"乐盈电竞\",\"serverId\":0,\"serverName\":\" \",\"amount\":1.0,\"receiptAmount\":1.0,\"fee\":0.0,\"createTime\":\"2016-11-29 16:12:37\",\"payTime\":\"2016-11-29 16:13:20\",\"paymentOrderNo\":\"pijingzhanji20161129161236203574\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"返点\",\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129164226753579\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"lml\",\"nickName\":\"lml\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":10006,\"platformName\":\"视频互动\",\"serverId\":0,\"serverName\":\" \",\"amount\":100.0,\"receiptAmount\":100.0,\"fee\":0.0,\"createTime\":\"2016-11-29 16:42:26\",\"payTime\":\"2016-12-01 11:47:03\",\"paymentOrderNo\":\"pijingzhanji20161129164222482933\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129164250842470\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"lml\",\"nickName\":\"lml\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":10006,\"platformName\":\"视频互动\",\"serverId\":0,\"serverName\":\" \",\"amount\":100.0,\"receiptAmount\":100.0,\"fee\":0.0,\"createTime\":\"2016-11-29 16:42:50\",\"payTime\":\"2016-12-01 11:47:03\",\"paymentOrderNo\":\"pijingzhanji20161129164246290361\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129164307698738\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"lml\",\"nickName\":\"lml\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":20000,\"platformName\":\"神道1\",\"serverId\":1,\"serverName\":\" 仙侠道1服\",\"amount\":100.0,\"receiptAmount\":100.0,\"fee\":0.0,\"createTime\":\"2016-11-29 16:43:07\",\"payTime\":\"2016-12-01 11:47:03\",\"paymentOrderNo\":\"pijingzhanji20161129164304479401\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司11\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129172431889140\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"lml\",\"nickName\":\"lml\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":20000,\"platformName\":\"神道1\",\"serverId\":1,\"serverName\":\" 仙侠道1服\",\"amount\":100.0,\"receiptAmount\":100.0,\"fee\":0.0,\"createTime\":\"2016-11-29 17:24:32\",\"payTime\":\"2016-12-01 11:47:03\",\"paymentOrderNo\":\"pijingzhanji20161129172428563493\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司11\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129172457274287\",\"payStatus\":3,\"payStatusName\":\"已关闭\",\"userId\":\"lml\",\"nickName\":\"lml\",\"rechargeWay\":4,\"rechargeWayName\":\"乐盈币兑换.威富通\",\"platformId\":10088,\"platformName\":\"海妖直播\",\"serverId\":1,\"serverName\":\" 仙侠道1服\",\"amount\":100.0,\"receiptAmount\":100.0,\"fee\":0.0,\"createTime\":\"2016-11-29 17:24:58\",\"payTime\":\"2016-12-01 11:47:03\",\"paymentOrderNo\":\"pijingzhanji20161129172454489979\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"developers\":\"乐盈盈公司\",\"platformTerminalName\":\"PC\"},{\"orderNo\":\"pijingzhanji161129172334454138\",\"payStatus\":1,\"payStatusName\":\"成功\",\"userId\":\"tcj011\",\"nickName\":\"tcj011\",\"rechargeWay\":4,\"rechargeWayName\":\"微信支付\",\"platformId\":20000,\"platformName\":\"神道1\",\"serverId\":1,\"serverName\":\" 仙侠道1服\",\"amount\":1.0,\"receiptAmount\":1.0,\"fee\":0.0,\"createTime\":\"2016-11-29 17:23:34\",\"payTime\":\"2016-11-29 17:23:57\",\"paymentOrderNo\":\"pijingzhanji20161129172334178595\",\"tradeNo\":\"pijingzhanji_reToplat161129172357535566\",\"channelId\":\"vnp56ams\",\"countryName\":\"中国\",\"orderType\":1,\"orderTypeName\":\"充值\",\"developers\":\"乐盈盈公司11\",\"platformTerminalName\":\"PC\"}],\"prePage\":0,\"nextPage\":2,\"isFirstPage\":true,\"isLastPage\":false,\"hasPreviousPage\":false,\"hasNextPage\":true,\"navigatePages\":8,\"navigatepageNums\":[1,2,3,4,5,6,7,8],\"navigateFirstPage\":1,\"navigateLastPage\":8,\"firstPage\":1,\"lastPage\":8}}";
        data = JsonUtils.jsonToType( json , Map.class );
    }

    @Test
    public void name () throws Exception {
        System.err.println( "data = " + data );
        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
        String filter = "*,responseContent.list[orderNo,payStatus]";
        System.err.println( filter + ",data = " + JsonUtils.toFilterJson( data , filter ) );

    }


}











