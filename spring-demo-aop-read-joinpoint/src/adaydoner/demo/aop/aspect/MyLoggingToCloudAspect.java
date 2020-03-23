package adaydoner.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingToCloudAspect {
	
	@Before("adaydoner.demo.aop.aspect.AopExpressions.anyClassAndMethodForDaoPackageExceptGettersAndSetters()")
	public void logToCloudAsync(){
		System.out.println("\n\n==AOP=ADVICE==>" + getClass() + " : logToCloudAsync() method");
	}
}
