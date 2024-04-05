package com.padmanabh.microservices.datadog.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.opentracing.Tracer;
import io.opentracing.contrib.tracerresolver.TracerResolver;
import io.opentracing.noop.NoopTracerFactory;

@Configuration
public class TracingConfig {

    @Bean
    public Tracer tracer() {
        return TracerResolver.resolveTracer();
    }
}
