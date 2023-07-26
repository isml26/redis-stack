package com.redis.demo.service;

import com.google.gson.Gson;
import com.redis.demo.model.Coins;
import com.redis.demo.utils.HttpUtils;
import io.github.dengliming.redismodule.redisjson.RedisJSON;
import io.github.dengliming.redismodule.redisjson.args.SetArgs;
import io.github.dengliming.redismodule.redisjson.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CoinsDataService {
    public static final String GET_COINS_API = "https://coinranking1.p.rapidapi.com/coins?referenceCurrencyUuid=yhjMzLPhuIDl&timePeriod=24h&tiers%5B0%5D=1&orderBy=marketCap&orderDirection=desc&limit=50&offset=0";
    public static final String REDIS_KEY_COINS = "coins";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisJSON redisJSON;
    public void fetchCoins(){
        log.info("inside fetchCoins");
        ResponseEntity<Coins> coinsResponseEntity = restTemplate.exchange(
                GET_COINS_API,
                HttpMethod.GET,
                HttpUtils.getHttpEntity(),
                Coins.class);
        storeCoinsToRedisJSON(coinsResponseEntity.getBody());
    }

    private void storeCoinsToRedisJSON(Coins coins) {
        redisJSON.set(REDIS_KEY_COINS, SetArgs.Builder.create(".", GsonUtils.toJson(coins)));
    }

}
