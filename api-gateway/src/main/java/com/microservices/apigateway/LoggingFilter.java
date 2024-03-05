package com.microservices.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

    //Log ekleme satırı.
    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    //herhangi bir request geldiğinde bu request için log'a path'ini yazdırıcak.
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of the requesst received -> {} ",exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
