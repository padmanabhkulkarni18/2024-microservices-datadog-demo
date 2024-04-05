package com.padmanabh.microservices.datadog.demo.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/home")
public class DemoController {

    @Autowired
    private Tracer tracer;
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public String demo(){

        Span span = tracer.buildSpan("hello-endpoint").start();
        logger.error("Hello API call.. This is ERROR log outside span or tracer - error log");
        logger.warn("Hello API call...inside span and tracer started - warn log");
        logger.info("Hello API call...inside span and tracer started - info log");

        logger.info("calling another here");
        demoAnother();
        try {
            // Your business logic here
            return "Hello, tracing with Datadog and OpenTracing!" + Instant.now();
        } finally {
            span.finish();
        }

    }

    @GetMapping("/helloAnother")
    public String demoAnother(){

        Span span = tracer.buildSpan("hello-endpoint").start();
        logger.error("Hello Another API call.. error log");
        logger.warn("Hello Another API call... warn log");
        logger.info("Hello Another API call... info log");
        try {
            // Your business logic here
            return "Hello, Another with Datadog and OpenTracing!" + Instant.now();
        } finally {
            span.finish();
        }

    }
}
