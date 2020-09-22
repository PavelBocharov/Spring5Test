//package com.mar.spring.five.test.service.cache;
//
//import org.ehcache.Cache;
//import org.ehcache.CacheManager;
//import org.ehcache.config.builders.CacheConfigurationBuilder;
//import org.ehcache.config.builders.CacheManagerBuilder;
//import org.ehcache.config.builders.ResourcePoolsBuilder;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//
//import static java.util.Objects.isNull;
//
//@Service(value = "ehCacheService")
//@Scope("singleton")
//public class EhCacheService implements CacheService {
//
//    private CacheManager cacheManager = null;
//    private Cache<String, String> cache = null;
//
//    @PostConstruct
//    private void initBean() {
//        if (isNull(cacheManager) || isNull(cache)) {
//            init();
//        }
//    }
//
//    @Override
//    public synchronized String get(String key) {
//        if (isNull(cacheManager) || isNull(cache)) {
//            init();
//        }
//        return cache.get(key);
//    }
//
//    @Override
//    public synchronized void add(String key, String value) {
//        if (isNull(cacheManager) || isNull(cache)) {
//            init();
//        }
//        cache.put(key, value);
//    }
//
//    private void init() {
//        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache(
//                "MarCacheAlias",
//                CacheConfigurationBuilder.newCacheConfigurationBuilder(
//                        String.class, String.class, ResourcePoolsBuilder.heap(10).build()
//                ).build()
//        ).build(true);
//
//        cache = cacheManager.getCache("MarCacheAlias", String.class, String.class);
//    }
//}
