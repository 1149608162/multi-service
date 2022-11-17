package com.yi5an.orderservicedemo.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yi5an
 * @date 2022/11/17 17:12
 */
@FeignClient(value = "shopcart-service", path = "/shop-cart")
public interface NewBeeShopCartService {

    @GetMapping("/{cartId}")
    String cartItemDetail(@PathVariable(value = "cartId") int cartId);

}
