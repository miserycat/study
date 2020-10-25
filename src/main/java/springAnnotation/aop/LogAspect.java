package springAnnotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by shengchao wu on 7/10/2018.
 *
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int springAnnotation.aop.MathCalculator.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logBefore() {
        System.out.println("log before...");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("log end...");
    }

    @AfterReturning
    public void logReturn(JoinPoint joinPoint) {
        System.out.println("log return value {}");
    }

    public void logException() {
        System.out.println("log div exception, result {}");
    }
}
