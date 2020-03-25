package adaydoner.demo.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import adaydoner.demo.aop.Account;

@Aspect
@Component
@Order(1)
public class MyLoggingToCloudAspect {
	
	@AfterReturning(
			pointcut="execution(* adaydoner.demo.aop.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJp, List<Account> result){
		String method = theJp.getSignature().toShortString();
		System.out.println("\n===>> @AfterReturning method afterReturningFindAccountsAdvice : " + method);
		
		System.out.println(">> Result is :" + result);
		System.out.println(">> Modfying result...");
		if(!result.isEmpty()){
			Account temp = result.get(0);
			temp.setName("Name changed in MyLoggingToCloudAspect/afterReturningFindAccountsAdvice()");
		}
		System.out.println(">> Result is :" + result);
	}
	
	@Before("adaydoner.demo.aop.aspect.AopExpressions.anyClassAndMethodForDaoPackageExceptGettersAndSetters()")
	public void logToCloudAsync(){
		System.out.println("\n\n==AOP=ADVICE==>" + getClass() + " : logToCloudAsync() method");
	}
}
