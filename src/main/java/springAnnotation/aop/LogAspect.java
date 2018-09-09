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
 * 前置通知(@Before)：logBefore
 * 后置通知(@After)：logEnd
 * 返回通知(@AfterReturning)：logReturn
 * 异常通知(@AfterThrowing)：logException
 * 环绕通知(@Around)：手动调用joinPoint.proceed();
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
