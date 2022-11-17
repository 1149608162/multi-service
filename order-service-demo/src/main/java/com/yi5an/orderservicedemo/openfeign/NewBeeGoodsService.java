package com.yi5an.orderservicedemo.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yi5an
 * @date 2022/11/17 17:08
 */

@FeignClient(value = "goods-service", path = "/goods")
public interface NewBeeGoodsService {

    @GetMapping(value = "/{goodsId}")
    String goodsDetail(@PathVariable(value = "goodsId") int goodsId);

    @PostMapping("/page/{pageNum}")
    String goodsList(@PathVariable(value = "pageNum") int pageNum);

}
