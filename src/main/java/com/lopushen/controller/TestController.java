package com.lopushen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i.lopushen on 03/08/2016.
 */
@RestController
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String getRss(@RequestParam String q) {
        return "";
    }
}
