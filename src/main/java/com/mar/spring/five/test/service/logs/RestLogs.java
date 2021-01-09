package com.mar.spring.five.test.service.logs;

import com.mar.spring.five.test.service.cache.SpringCacheService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Aspect
@Component
public class RestLogs {

    @Autowired
    SpringCacheService springCacheService;

    private Logger logger = Logger.getLogger(RestLogs.class.getCanonicalName());

    private enum StartEndMethod{
        START_METHOD("startMethod"),
        END_METHOD("endMethod");

        private String posMethod;

        StartEndMethod(String method) {
            this.posMethod = method;
        }

    }

    @Pointcut("@annotation(com.mar.spring.five.test.service.logs.LogMethod)")
    public void needLogMethod() {
    }

    @Before("needLogMethod()")
    public void startMethod(JoinPoint joinPoint) {
        logger.info(getMethodInfo(joinPoint, StartEndMethod.START_METHOD).toString());
    }

    @AfterReturning(pointcut = "needLogMethod()", returning = "response")
    public void endMethod(JoinPoint joinPoint, Object response) {
        StringBuilder stringBuilder = getMethodInfo(joinPoint, StartEndMethod.END_METHOD);
        stringBuilder.append(", response: ").append(response);

        logger.info(stringBuilder.toString());
    }

    private StringBuilder getMethodInfo(JoinPoint joinPoint, StartEndMethod startEndMethod) {
        logger.warning("Spring inject - " + springCacheService);
        logger.warning("Spring inject value - " + springCacheService.getValue("dqwdq"));

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        StringBuilder stringBuilder = new StringBuilder(startEndMethod.posMethod)
                .append(": ")
                .append(methodName)
                .append("()");

        if (Objects.nonNull(args) && args.length > 0) {
            stringBuilder
                    .append(", args: ")
                    .append(
                            Stream.of(args)
                                    .map(o -> String.valueOf(o))
                                    .collect(Collectors.joining(","))
                    );
        }
        return stringBuilder;
    }

}
