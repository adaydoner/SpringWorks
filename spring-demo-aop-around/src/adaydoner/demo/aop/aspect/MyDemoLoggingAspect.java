package adaydoner.demo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	
	@Around("execution(* adaydoner.demo.aop.service.*.getFortune(..))")
	public Object aroundGetFortune (ProceedingJoinPoint pjp) throws Throwable{
		
		
		//print out the method we'r advising on
		String method = pjp.getSignature().toShortString();
		System.out.println("\n===>> Executing @Around on method : " + method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute the target method
		Object result;
		
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			//log the exception
			System.out.println(e.getMessage());
			
			//give user a custom message
			result = ("Exception handled at " + method);
			
			//or we can re-throw exception to MainApp
			//throw e;
		}
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display
		long duration = end - begin;
		System.out.println("\n\n====>> Duration : " + duration/1000.0 + " seconds");
		
		
		//return result
		return result;
		
	}
	
	
	
	
	
	
	
	
}
