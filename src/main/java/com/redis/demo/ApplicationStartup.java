package com.redis.demo;

import com.redis.demo.service.CoinsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private CoinsDataService coinsDataService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        coinsDataService.fetchCoins();
    }
}
