package com.example.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ControllerAspects {

		private Logger logger = LoggerFactory.getLogger(this.getClass());

		@AfterReturning(value = "execution(* com.example.demoApp.*.*(..))", returning = "result")
		public void afterReturning(JoinPoint joinPoint, Object result) {
			logger.info("{} returned with value {}", joinPoint, result);
		}
		
		@AfterThrowing(value = "execution(* com.example.demoApp.*.*(..))", throwing = "exeption")
		public void afterTrowing(JoinPoint joinPoint, Throwable exeption){
			logger.error("{} throwing exeption ", joinPoint);
		}
}
