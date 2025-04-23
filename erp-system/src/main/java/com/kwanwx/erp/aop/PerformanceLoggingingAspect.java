package com.kwanwx.erp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class PerformanceLoggingingAspect {

	// service 패키지 내부의 모든 public 메서드를 타겟
	@Around("execution(public * com.kwanwx.erp.service..*(..))")
	public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
		String signature = pjp.getSignature().toShortString();
		long start = System.currentTimeMillis();
		
		Object result = pjp.proceed();
		
		long elapsed = System.currentTimeMillis() - start;
		log.info("{} executed in {} ms", signature, elapsed);
		
		return result;
	}
}
