package com.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader","MyUrl")
                                .addRequestParameter("MyParam","MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)","/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    //bir istek geldiğinde eureka server ile konus ve load balance kullanarak currency-exchange application name'indekiler arasında
    //load balancer kullanmayı sağla.
    //filters kullanarak eklemek istediğimiz şeyleri ekleyebiliyoruz.
    //filter ile bir url'i baska bir isimle de çağarabiliyoruz. currency-conversion-feign'i currency-conversion-new ile çağırdık.
    }
}
