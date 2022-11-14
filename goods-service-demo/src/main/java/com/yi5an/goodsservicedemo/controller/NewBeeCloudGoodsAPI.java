package com.yi5an.goodsservicedemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yi5an
 * @date 2022/11/14 22:40
 * @document
 */

@RestController
public class NewBeeCloudGoodsAPI {

    /**
     * 当前应用启动端口
     */
    @Value("$(server.port)")
    private String applicationServerPort;

    @GetMapping("/goods/{goodsId}")
    public String goodsDetail(@PathVariable("goodsId") int goodsId) {
        // 根据id查询商品并返回调用端
        if (goodsId < 1 || goodsId > 100000) {
            return "查询商品为空，当前服务端口为" + applicationServerPort;
        }
        String goodsName = "商品" + goodsId;
        // 返回信息给调用端
        return goodsName + "，当前服务的端口为" + applicationServerPort;
    }
}
