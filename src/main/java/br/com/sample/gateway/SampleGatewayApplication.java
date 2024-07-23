package br.com.sample.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ms1", r -> r.path("/ms1/**")
                        .uri("lb://MS1-SERVICES"))
                .route("ms2", r -> r.path("/ms2/**")
                        .uri("lb://MS1-SERVICES"))
                .build();
    }

}
