package com.kwanwx.erp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
public class PerformanceLoggingingAspect {
	private static final Logger log = LoggerFactory.getLogger(PerformanceLoggingingAspect.class);
	
	// application.properties에서 threshold 불러오기
	@Value("${performance.logging.warn-threshold-ms}")
	private long warnThreshold;
	
	// @Service가 붙은 모든 클래스의 public 메서드
	@Pointcut("within(@org.springframework.streotype.Service *)")
	public void serviceMethod() {}

	@Around("serviceMethod()")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long elapsed = System.currentTimeMillis() - start;
		
		String method = joinPoint.getSignature().toShortString();
		if (elapsed >= warnThreshold) {
			log.warn("{} executed in {} ms (>= {} ms)", method, elapsed, warnThreshold);
		} else {
			log.info("{} executed in {} ms", method, elapsed);
		}
		
		return result;
	}
}
