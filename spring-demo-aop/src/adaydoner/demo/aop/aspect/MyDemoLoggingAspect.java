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
	// pointcut expression --> "execution(* add*(adaydoner.demo.aop.Account))" : any modifier, any return type, name start with add and with has Account parameter method
	// pointcut expression --> "execution(* packageName.*.*(..))" : any return type, in packageName package any class, any method, zero to any arguments with any type
	// pointcut expression --> "execution(* add*(adaydoner.demo.aop.Account))" : any return type, method start with add and need Account type parameter
	// pointcut expression --> "execution(* add*(adaydoner.demo.aop.Account, ..))" : any return type, method start with add method, need one Account type and followed by any type parameter
	// pointcut expression --> "execution(* add*(..))" : any return type, method start with add method and with any type parameter
	// pointcut expression --> "execution(* adaydoner.demo.aop.dao.*.*( ..))" : any return type, in adaydpner.demo.aop.dao package, any class any method any parameter
	@Before("execution(* adaydoner.demo.aop.dao.*.*( ..))") 
	public void beforeAddAccountAdvice(){
		System.out.println(getClass() + " : @Before advice method");
	}
}
