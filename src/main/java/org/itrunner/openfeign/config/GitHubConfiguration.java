package org.itrunner.openfeign.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class GitHubConfiguration {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("sunjc", "a8e117f1dcc6076cb0441940af01875c2f6ca7b3");
    }
}