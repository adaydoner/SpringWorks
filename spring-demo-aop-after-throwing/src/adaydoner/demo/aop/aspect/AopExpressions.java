package adaydoner.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
	
	@Pointcut("execution(* adaydoner.demo.aop.dao.*.*(..))")
	public void anyClassAndMethodForDaoPackage() { }
	
	@Pointcut("execution(* adaydoner.demo.aop.dao.*.get*(..))")
	public void getter(){ }
	
	@Pointcut("execution(* adaydoner.demo.aop.dao.*.set*(..))")
	public void setter(){ }
	
	@Pointcut("anyClassAndMethodForDaoPackage() && !(getter() || setter())")
	public void anyClassAndMethodForDaoPackageExceptGettersAndSetters(){ }
	
}
