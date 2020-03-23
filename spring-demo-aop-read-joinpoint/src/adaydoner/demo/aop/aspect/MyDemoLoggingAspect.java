package adaydoner.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import adaydoner.demo.aop.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	
	@Before("adaydoner.demo.aop.aspect.AopExpressions.anyClassAndMethodForDaoPackageExceptGettersAndSetters()") 
	public void beforeAddAccountAdvice(JoinPoint theJp){
		System.out.println("\n\n==AOP=ADVICE==>" + getClass() + " : @Before beforeAddAccountAdvice() method");
		
		//display the method signature
		MethodSignature ms = (MethodSignature) theJp.getSignature();
		System.out.println("-->Target object's method signature : " + ms);
		
		//display method arguments
		Object args[] = theJp.getArgs();
		for (Object object : args) {
			System.out.println("\n-->Target object's argument : : " + object);
			if(object instanceof Account){
				Account theAcc = (Account) object;
				System.out.println("-->Account's name : " + theAcc.getName());
				System.out.println("-->Account's mail : " + theAcc.geteMail());
			}
		}
	}
	
}
