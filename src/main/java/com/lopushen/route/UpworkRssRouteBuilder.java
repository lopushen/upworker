package com.lopushen.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by i.lopushen on 03/08/2016.
 */
@Component
public class UpworkRssRouteBuilder extends RouteBuilder {

    @Value("${upworker.feed.prefix}")
    private String prefix;
    @Value("${upworker.feed.url}")
    private String url;

    @Override
    public void configure() throws Exception {
        from(prefix+url+"?q=java").marshal().rss().to("mock:result");
    }
}
