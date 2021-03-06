package com.lin.jiang.app.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by JiangLin.<br>
 * Date: 2019/09/17 11:01<br>
 * Description: TimeTraceAspect 方法耗时计算注解切面类<br>
 * <a href="https://www.google.com">文档地址</a>
 * <p>
 * {@link TimeTrace}
 *
 * @author JiangLin
 */
@Aspect
public class TimeTraceAspect {

    @Pointcut("execution(@com.lin.jiang.app.aop.TimeTrace * *(..))")
    public void timeTraceBehavior() {
    }

    @Around("timeTraceBehavior()")
    public Object wavePointcutAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 类名
        String className = methodSignature.getDeclaringType().getSimpleName();
        // 方法名
        String methodName = methodSignature.getName();
        // 功能名
        TimeTrace behaviorTrace = methodSignature.getMethod().getAnnotation(TimeTrace.class);
        String value = behaviorTrace.value();
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        Log.e("[jianglin]", String.format("%s类中%s方法执行%s功能，耗时：%dms", className, methodName, value, duration));
        return result;
    }
}
