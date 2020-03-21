package adaydoner.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Before("execution(public void addAccount())") //pointcut expression
	public void beforeAddAccountAdvice(){
		System.out.println("Executing " + getClass() + "@Before advice , beforeAddAccontAdvice() method...");
	}
}
