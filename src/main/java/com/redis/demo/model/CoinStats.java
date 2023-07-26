package com.redis.demo.model;

import lombok.Data;

@Data
public class CoinStats {
    private float total;
    private float totalCoins;
    private float totalMarkets;
    private float totalExchanges;
    private String totalMarketCap;
    private String total24hVolume;
}
