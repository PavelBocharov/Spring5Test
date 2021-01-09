package com.mar.spring.five.test.api;

import com.mar.spring.five.test.data.dto.HelloDto;
import com.mar.spring.five.test.data.entity.Hello;
import com.mar.spring.five.test.service.HelloService;
import com.mar.spring.five.test.service.cache.CacheService;
import com.mar.spring.five.test.service.cache.SpringCacheService;
import com.mar.spring.five.test.service.logs.LogMethod;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(
        value = "/"
)
public class Controller {

    private Logger log = Logger.getLogger(Controller.class.getSimpleName());

    @Autowired
    private HelloService helloService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    @Qualifier("ehCacheService")
    private CacheService cacheService;

    @Autowired
    SpringCacheService springCacheService;

    @GetMapping("spring")
    @LogMethod
    @Operation(
            summary = "Получи Hello в ответ",
            description = "Отправляешь логин, и поулчаешь его капсом, время и 'HELLO'."
    )
    public HelloDto springGet(@RequestParam(value = "login", required = false, defaultValue = "def") String login) {

        String name = springCacheService.getValue(login);

        if (StringUtils.isEmpty(name)) {
            throw new NullPointerException();
        }

        Hello hello = helloService.hello(name);
        return conversionService.convert(hello, HelloDto.class);
    }

    @GetMapping("eh")
    @LogMethod
    @Operation(
            summary = "Тест EhCache",
            description = "Кэширование логинов, которые были отправлены на обработку"
    )
    public HelloDto ehCacheGet(@RequestParam(value = "login", required = false, defaultValue = "def") String login) {

        String name = cacheService.get(login);
        if (isNull(name)) {
            log.info("Init cache. Login: " + login);
            name = login.toUpperCase();
            cacheService.add(login, name);
        }

        if (StringUtils.isEmpty(name)) {
            throw new NullPointerException();
        }

        Hello hello = helloService.hello(name);
        return conversionService.convert(hello, HelloDto.class);
    }

    @PostMapping(
            value = "info",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @LogMethod
    @Operation(
            summary = "Отправь POST получи HELLO.",
            description = "Отправь POST получи HELLO. Все то же, что и у GET И много-много текста"
    )
    public @ResponseBody HelloDto infoPost(@RequestBody HelloDto helloDto) {
        log.info("infoPost -> " + helloDto.toString());
        Hello hello = helloService.hello(helloDto.getUserName());
        return conversionService.convert(hello, HelloDto.class);
    }
}
