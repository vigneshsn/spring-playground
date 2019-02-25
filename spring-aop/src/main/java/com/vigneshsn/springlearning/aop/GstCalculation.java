package com.vigneshsn.springlearning.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class GstCalculation {

    Logger log = LoggerFactory.getLogger(GstCalculation.class);

    //@Around("@annotation(Gst)") //annotation does not work with interface
    //this works with interface
    @Around("execution(* com.vigneshsn.springlearning.service.CustomerService.calculatePrice(..))")
    public Object applyGst(ProceedingJoinPoint joinPoint) throws Throwable {
        Object val = joinPoint.proceed();
        BigDecimal price = (BigDecimal) val;
        BigDecimal finalPrice = price.subtract(BigDecimal.valueOf(1));
        log.debug("applying gst " + finalPrice);
        return finalPrice;
    }

}
