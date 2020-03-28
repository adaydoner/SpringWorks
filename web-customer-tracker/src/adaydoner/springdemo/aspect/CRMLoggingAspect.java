package adaydoner.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut expressions, its in PointcutExpressions.java file

	// add @Before advice
	@Before("adaydoner.springdemo.aspect.PointcutExpressions.forAppFlow()")
	public void before(JoinPoint jp) {
		// Display the target object method that we'r calling
		String method = jp.getSignature().toShortString();
		myLogger.info("=====>> in @Before calling method  : " + method);

		// Display the arguments
		Object[] args = jp.getArgs();
		for (Object tempArgs : args) {
			myLogger.info("----->Target object's method argument : " + tempArgs);
		}
	}

	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "adaydoner.springdemo.aspect.PointcutExpressions.forAppFlow()", 
			returning = "result")
	public void after(JoinPoint jp, Object result) {
		// Display the target object method that we'r calling
		String method = jp.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning from method : " + method);
		
		
		// Display the data that return
		myLogger.info("=====>> result : " + result);
		
		
	}

}
