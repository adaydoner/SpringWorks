package adaydoner.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	
	@Before("adaydoner.demo.aop.aspect.AopExpressions.anyClassAndMethodForDaoPackageExceptGettersAndSetters()") 
	public void beforeAddAccountAdvice(){
		System.out.println("==AOP=ADVICE==>" + getClass() + " : @Before beforeAddAccountAdvice() method");
	}
	
}
