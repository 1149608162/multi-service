package com.yi5an.gateway.predicate;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author yi5an
 * @date 2022/11/18 11:25
 */
@Component
public class GoodsIdRoutePredicateFactory extends AbstractRoutePredicateFactory<GoodsIdRoutePredicateFactory.Config> {

    /**
     * 构造函数
     */
    public GoodsIdRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {

                // 获取goodsId的值
                String goodsId = exchange.getRequest().getQueryParams().getFirst("goodsId");
                if (null != goodsId) {
                    int numberId = Integer.parseInt(goodsId);
                    //判断goodsId是否在配置区间内
                    if (numberId > config.getMinValue() && numberId < config.getMaxValue()) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        /**
         * 定义配置文件中的参数项
         */
        return Arrays.asList("minValue", "maxValue");
    }

    @Validated
    @Data
    // 接收配置文件中定义的最大和最小值
    public static class Config {

        private int minValue;

        private int maxValue;

    }

}
