package com.mar.spring.five.test.service.cache;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SpringCacheService
        implements CacheManagerCustomizer<EhCacheCacheManager>
{

    private Logger log = Logger.getLogger(SpringCacheService.class.getSimpleName());

    @Cacheable(value = {"MarStringCache"}, sync = true)
    public String getValue(String key) {
        log.info("Get new value. Key: " + key);
        return key.toUpperCase();
    }

    @Override
    public void customize(EhCacheCacheManager cacheManager) {


//        cacheManager.setCacheNames(asList("MarStringCache"));
//
//        cacheManager.setCacheManager(CacheManagerBuilder.newCacheManagerBuilder().withCache(
//                "MarCacheAlias",
//                CacheConfigurationBuilder.newCacheConfigurationBuilder(
//                        String.class, String.class, ResourcePoolsBuilder.heap(10).build()
//                ).build()
//        ).build(true));
//
//
//
//        EhCacheManagerFactoryBean managerFactoryBean = new EhCacheManagerFactoryBean();
//        managerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        managerFactoryBean.setShared(true);
//
//        cacheManager.setCacheManager();
    }
}
