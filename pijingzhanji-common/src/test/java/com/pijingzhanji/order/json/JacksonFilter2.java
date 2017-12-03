package com.pijingzhanji.order.json;

import com.pijingzhanji.common.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author : 披荆斩棘
 * @date : 2017/6/22
 */
public class JacksonFilter2 {

    Map< String, Object > data;

    @Before
    public void setUp () throws Exception {
        String json = "{\n" +
                "    \"user\": {\n" +
                "        \"id\": 1,\n" +
                "        \"username\": \"admin\",\n" +
                "        \"nickName\": \"披荆斩棘\",\n" +
                "        \"roles\": [\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                \"groupId\": 1,\n" +
                "                \"roleName\": \"超级管理员\",\n" +
                "                \"roleNameCode\": \"admin\",\n" +
                "                \"roleType\": \"USER\",\n" +
                "                \"enabled\": true,\n" +
                "                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                \"updateTime\": \"2017-07-07 22:24:29\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"permissionResource\": [\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                \"parentId\": 0,\n" +
                "                \"permissionSort\": 1,\n" +
                "                \"permissionName\": \"角色管理\",\n" +
                "                \"resourceType\": \"MENU\",\n" +
                "                \"resourceApiUriMethods\": \"GET\",\n" +
                "                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                \"categoryCode\": \"C\",\n" +
                "                \"methods\": [\n" +
                "                    \"GET\"\n" +
                "                ],\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"id\": 2,\n" +
                "                        \"parentId\": 1,\n" +
                "                        \"permissionSort\": 1,\n" +
                "                        \"permissionName\": \"角色列表\",\n" +
                "                        \"resourceType\": \"MENU\",\n" +
                "                        \"resourceApiUriMethods\": \"GET\",\n" +
                "                        \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                        \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                        \"categoryCode\": \"C\",\n" +
                "                        \"methods\": [\n" +
                "                            \"GET\"\n" +
                "                        ],\n" +
                "                        \"children\": [\n" +
                "                            {\n" +
                "                                \"id\": 3,\n" +
                "                                \"parentId\": 2,\n" +
                "                                \"permissionSort\": 1,\n" +
                "                                \"permissionName\": \"修改角色\",\n" +
                "                                \"resourceType\": \"API\",\n" +
                "                                \"resourceApiUri\": \"/roles\",\n" +
                "                                \"resourceApiUriMethods\": \"PUT\",\n" +
                "                                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"categoryCode\": \"C\",\n" +
                "                                \"methods\": [\n" +
                "                                    \"PUT\"\n" +
                "                                ],\n" +
                "                                \"children\": []\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": 4,\n" +
                "                                \"parentId\": 2,\n" +
                "                                \"permissionSort\": 2,\n" +
                "                                \"permissionName\": \"查看分页角色\",\n" +
                "                                \"resourceType\": \"API\",\n" +
                "                                \"resourceApiUri\": \"/roles\",\n" +
                "                                \"resourceApiUriMethods\": \"GET\",\n" +
                "                                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"categoryCode\": \"C\",\n" +
                "                                \"methods\": [\n" +
                "                                    \"GET\"\n" +
                "                                ],\n" +
                "                                \"children\": []\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": 5,\n" +
                "                                \"parentId\": 2,\n" +
                "                                \"permissionSort\": 3,\n" +
                "                                \"permissionName\": \"查看角色\",\n" +
                "                                \"resourceType\": \"API\",\n" +
                "                                \"resourceApiUri\": \"/roles/{id}\",\n" +
                "                                \"resourceApiUriMethods\": \"GET\",\n" +
                "                                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"categoryCode\": \"C\",\n" +
                "                                \"methods\": [\n" +
                "                                    \"GET\"\n" +
                "                                ],\n" +
                "                                \"children\": []\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": 6,\n" +
                "                                \"parentId\": 2,\n" +
                "                                \"permissionSort\": 5,\n" +
                "                                \"permissionName\": \"删除角色\",\n" +
                "                                \"resourceType\": \"API\",\n" +
                "                                \"resourceApiUri\": \"/roles/{id}\",\n" +
                "                                \"resourceApiUriMethods\": \"DELETE\",\n" +
                "                                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"categoryCode\": \"C\",\n" +
                "                                \"methods\": [\n" +
                "                                    \"DELETE\"\n" +
                "                                ],\n" +
                "                                \"children\": []\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": 7,\n" +
                "                                \"parentId\": 2,\n" +
                "                                \"permissionSort\": 6,\n" +
                "                                \"permissionName\": \"新增角色\",\n" +
                "                                \"resourceType\": \"API\",\n" +
                "                                \"resourceApiUri\": \"/roles\",\n" +
                "                                \"resourceApiUriMethods\": \"POST\",\n" +
                "                                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"categoryCode\": \"C\",\n" +
                "                                \"methods\": [\n" +
                "                                    \"POST\"\n" +
                "                                ],\n" +
                "                                \"children\": []\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": 8,\n" +
                "                                \"parentId\": 2,\n" +
                "                                \"permissionSort\": 7,\n" +
                "                                \"permissionName\": \"得到当前用户可见角色\",\n" +
                "                                \"resourceType\": \"API\",\n" +
                "                                \"resourceApiUri\": \"/roles/allow-see-roles/{userId}\",\n" +
                "                                \"resourceApiUriMethods\": \"GET\",\n" +
                "                                \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "                                \"categoryCode\": \"C\",\n" +
                "                                \"methods\": [\n" +
                "                                    \"GET\"\n" +
                "                                ],\n" +
                "                                \"children\": []\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ],\n" +
                "        \"rolePermissionResources\": [\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 1,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 2,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 2,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 3,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 3,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 4,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 4,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 5,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 5,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 6,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 6,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 7,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 7,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 8,\n" +
                "                \"roleId\": 1,\n" +
                "                \"permissionResourceId\": 8,\n" +
                "                \"resourceApiUriShowFields\": \"*\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"treeGroups\": [],\n" +
                "        \"currentGroupRelatedGroups\": [],\n" +
                "        \"currentGroup\": {\n" +
                "            \"id\": 1,\n" +
                "            \"groupName\": \"系统管理\",\n" +
                "            \"groupCode\": \"SYSTEM\",\n" +
                "            \"createManagerAdminUserId\": 1,\n" +
                "            \"createTime\": \"2017-07-07 22:24:29\",\n" +
                "            \"updateTime\": \"2017-07-07 22:24:29\",\n" +
                "            \"enabled\": true,\n" +
                "            \"children\": []\n" +
                "        }\n" +
                "    },\n" +
                "    \"token\": \"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5OTQ3MDk2NDcxMSwiZXhwIjoxNDk5NDc0NTY0fQ.ZAfIE_A0RIXR8h10nKK_J3cyEbsfWdvrbXSERKob5I0A-mKXeO7Xm0DVc6cfEj5LUnTUbT3akrMwExdyp4Z73g\"\n" +
                "}";
        data = JsonUtils.jsonToType( json , Map.class );
    }

    @Test
    public void name () throws Exception {
        System.err.println( "data = " + data );

        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
        String filter = "user.username,user.roles.groupId,user.permissionResource.permissionName,user.permissionResource.children";
        System.err.println( filter + ",data = " + JsonUtils.toFilterJson( data , filter ) );

    }


}











