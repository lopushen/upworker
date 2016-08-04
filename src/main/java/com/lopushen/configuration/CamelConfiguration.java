package com.lopushen.configuration;

import com.lopushen.route.UpworkRssRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by i.lopushen on 03/08/2016.
 */
@Configuration
public class CamelConfiguration {

    @Autowired
    private UpworkRssRouteBuilder upworkRssRouteBuilder;

    @Bean
    public CamelContext camelContext() throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(upworkRssRouteBuilder);
        return camelContext;
    }
}
