package com.liuhao.cloud.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class HostAddrKeyResolver implements KeyResolver {


    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {

        String hostAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostName();
        System.err.println(hostAddress);
        return Mono.just(hostAddress);
    }

     /*//注入到spring容器
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver(){

        return new HostAddrKeyResolver();
    }*/
}
