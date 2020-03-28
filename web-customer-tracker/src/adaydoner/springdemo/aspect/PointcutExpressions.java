package adaydoner.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointcutExpressions {

	@Pointcut("execution(* adaydoner.springdemo.controller.*.*(..))")
	protected void forControllerPackage(){
		
	}

	@Pointcut("execution(* adaydoner.springdemo.service.*.*(..))")
	protected void forServicePackage(){
		
	}
	
	@Pointcut("execution(* adaydoner.springdemo.dao.*.*(..))")
	protected void forDaoPackage(){
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	protected void forAppFlow(){
		
	}
}
