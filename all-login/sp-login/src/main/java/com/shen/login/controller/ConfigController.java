package com.shen.login.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    final Log log = LogFactory.getLog(Log.class);

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${name:123}")
    private String name ;

    @RequestMapping("/get")
    public boolean get() {
        log.info(useLocalCache);
        log.info(name);
        return useLocalCache;

    }
}