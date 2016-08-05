package com.lopushen.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Created by i.lopushen on 05/08/2016.
 */
@Component
public class RssRouteFactory {

    Logger logger = LoggerFactory.getLogger(RssRouteFactory.class);

    public static final String RSS_DATE_PATTERN = "yyyy-MM-dd'T'HH:MM:ss";
    @Value("${upworker.feed.prefix}")
    private String prefix;
    @Value("${upworker.feed.url}")
    private String initialUrl;
    @Value("${upworker.feed.consumer.delay}")
    private String consumerDelay;
    @Value("${upworker.feed.split.entries}")
    private boolean splitEntries;

    private String buildUrl(String queue, Date from) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().host(initialUrl)
                .queryParam("consumer.delay", consumerDelay)
                .queryParam("splitEntries", splitEntries).queryParam("q", queue)
//                .queryParam("lastUpdate", formatDate())
                .build();
        return uriComponents.toString();
    }

    public RouteBuilder createRssRouteBuilder(String queue, Date from) {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(prefix+buildUrl(queue, from)).marshal().rss().log("Consumed message from " +queue).to("log:demo");
            }
        };
    }

    private String formatDate() {

        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.minus(2, ChronoUnit.HOURS);

        return localDateTime.format(DateTimeFormatter.ofPattern(RSS_DATE_PATTERN));
    }
}
