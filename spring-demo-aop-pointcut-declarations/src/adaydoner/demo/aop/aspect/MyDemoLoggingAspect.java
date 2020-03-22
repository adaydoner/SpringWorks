package adaydoner.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	// pointcut expression --> "execution(public void addAccount())" :  match addAccount() method in any class
	// pointcut expression --> "execution(public void adaydoner.demo.aop.dao.AccountDAO.addAccount())" :  match only AccountDAO.addAccount() method
	// pointcut expression --> "execution(public void add*())" :  match any method that start with add in any class
	// pointcut expression --> "execution(* * add*())" :  match -> any modifier , any return type , name start with add
	// pointcut expression --> "execution(* add*(adaydoner.demo.aop.Account))" : any modifier, any return type, name start with add and with has Account parameter method
	// pointcut expression --> "execution(* packageName.*.*(..))" : any return type, in packageName package any class, any method, zero to any arguments with any type
	// pointcut expression --> "execution(* add*(adaydoner.demo.aop.Account))" : any return type, method start with add and need Account type parameter
	// pointcut expression --> "execution(* add*(adaydoner.demo.aop.Account, ..))" : any return type, method start with add method, need one Account type and followed by any type parameter
	// pointcut expression --> "execution(* add*(..))" : any return type, method start with add method and with any type parameter
	// pointcut expression --> "execution(* adaydoner.demo.aop.dao.*.*( ..))" : any return type, in adaydpner.demo.aop.dao package, any class any method any parameter
	
	@Pointcut("execution(* adaydoner.demo.aop.dao.*.*(..))")
	private void anyClassAndMethodForDaoPackage() { }
	
	@Pointcut("execution(* adaydoner.demo.aop.dao.*.get*(..))")
	private void getter(){ }
	
	@Pointcut("execution(* adaydoner.demo.aop.dao.*.set*(..))")
	private void setter(){ }
	
	@Pointcut("anyClassAndMethodForDaoPackage() && !(getter() || setter())")
	private void anyClassAndMethodForDaoPackageExceptGettersAndSetters(){ }
	
	@Before("anyClassAndMethodForDaoPackage()") 
	public void beforeAddAccountAdvice(){
		System.out.println(getClass() + " : @Before beforeAddAccountAdvice() method");
	}
	
	/*@Before("anyClassAndMethodForDaoPackage()")
	public void beforeTryReUsablePointcutExpression(){
		System.out.println(getClass() + " : @Before beforeTryReUsablePointcutExpression() method");
	}*/
	
	@Before("anyClassAndMethodForDaoPackageExceptGettersAndSetters()")
	public void combiningPointcutsExample(){
		System.out.println(getClass() + " : combiningPointcutsExample()");
	}
	
}
