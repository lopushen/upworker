package com.lopushen.configuration;

import com.lopushen.route.RssRouteFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by i.lopushen on 03/08/2016.
 */
@Configuration
public class CamelConfiguration {

    @Autowired
    RssRouteFactory rssRouteFactory;

    @Bean
    public CamelContext camelContext() throws Exception {
        DefaultCamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(rssRouteFactory.createRssRouteBuilder("java", new Date()));
        camelContext.addRoutes(rssRouteFactory.createRssRouteBuilder("python", new Date()));
        camelContext.addRoutes(rssRouteFactory.createRssRouteBuilder("wordpress", new Date()));
        return camelContext;
    }
}
