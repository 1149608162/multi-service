package com.yi5an.orderservicedemo.controller;

import com.yi5an.orderservicedemo.openfeign.NewBeeGoodsService;
import com.yi5an.orderservicedemo.openfeign.NewBeeShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yi5an
 * @date 2022/11/15 10:37
 */
@RestController
public class NewBeeCloudOrderAPI {

    @Resource
    private NewBeeGoodsService newBeeGoodsService;

    @Resource
    private NewBeeShopCartService newBeeShopCartService;


    @GetMapping("/order/saveOrder")
    public String saveOrder(@RequestParam("cartId") int cartId, @RequestParam("goodsId") int goodsId) {

        String goodsResult = newBeeGoodsService.goodsDetail(goodsId);

        String cartResult = newBeeShopCartService.cartItemDetail(cartId);

        return "success! goodsResult={" + goodsResult + "},cartResult={" + cartResult + "}";
    }

}
