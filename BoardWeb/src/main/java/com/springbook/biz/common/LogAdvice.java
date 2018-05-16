package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

 @Service
 @Aspect //Aspect = Pointcut + Advice 둘의 결합 설정 을 해줘야 하는데 @Aspect 로 포인트컷과 어드바이스를 결합해준다.
public class LogAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut(){}
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행전 동작");
	}
}
