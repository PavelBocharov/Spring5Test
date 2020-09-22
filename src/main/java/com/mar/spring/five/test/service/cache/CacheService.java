package com.mar.spring.five.test.service.cache;

public interface CacheService {

    String get(String key);

    void add(String key, String value);

}
