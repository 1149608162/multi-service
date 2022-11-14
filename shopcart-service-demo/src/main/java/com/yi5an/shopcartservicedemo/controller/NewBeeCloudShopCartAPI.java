package com.yi5an.shopcartservicedemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yi5an
 * @date 2022/11/14 22:46
 * @document
 */
@RestController
public class NewBeeCloudShopCartAPI {

    @Value("${server.port}")
    private String applicationServerPort;

    @GetMapping("/shop-cart/{cartId}")
    public String cartItemDetail(@PathVariable("cartId") int cartId) {

        // 根据id查询商品并返回给调用端
        if (cartId < 0 || cartId > 100000) {
            return "查询购物车项为空，当前服务的端口为" + applicationServerPort;
        }

        String cartItem = "购物项" + cartId;

        return cartItem + "，当前服务的端口号为" + applicationServerPort;

    }

}
