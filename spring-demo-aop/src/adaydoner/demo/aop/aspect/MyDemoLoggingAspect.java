package adaydoner.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	// pointcut expression --> "execution(public void addAccount())" :  match addAccount() method in any class
	// pointcut expression --> "execution(public void adaydoner.demo.aop.dao.AccountDAO.addAccount())" :  match only AccountDAO.addAccount() method
	// pointcut expression --> "execution(public void add*())" :  match any method that start with add in any class
	// pointcut expression --> "execution(* add*())" :  match -> any modifier , any return type , name start with add
	@Before("execution(* add*())") 
	public void beforeAddAccountAdvice(){
		System.out.println(getClass() + " : @Before advice method");
	}
}
