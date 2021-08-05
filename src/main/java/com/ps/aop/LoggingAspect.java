package com.ps.aop;

import com.ps.utility.Constants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
Aspect for logging execution of service , repo and controller
 **/
@Aspect
@Component
public class LoggingAspect {
    //Get the active profile
    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());


    /**
     * Pointcut that matches all spring bean in application's packages
     */
    @Pointcut("within(com.ps.services..*)" +
    "|| within(com.ps.repository..*)"+
    "||within(com.ps.controller..*)"
    )
    public void applicationPackagePointcut(){
        //the method is empty as it only point cut the implementation will be in the advise

    }

    /**
     * Advice that logs methods throwing exception
     * @param joinPoint join point for the advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e){
        if(Constants.SERVICE_PROFILE_DEV.toUpperCase().equals(activeProfiles.toUpperCase())){
            logger.error("Exception in {}.{}() with cause \'{}\' and exception=\'{}\'",
                    joinPoint.getSignature().getDeclaringType(),joinPoint.getSignature().getName(),
                    e.getCause()!=null?e.getCause():e.getMessage(),e.getMessage(),e);
        }
        else{
            logger.error("Exception in {}.{}() with cause {}",
                    joinPoint.getSignature().getDeclaringType(),joinPoint.getSignature().getName(),
                    e.getCause()!=null?e.getCause():e.getMessage());

        }
    }

    /**
     * Advice that logs when a method is entered and exited
     * @param jointPoint join point for advice
     * @throws Throwable throws the IllegalArumenetException.
     *
     */

    @Around("applicationPackagePointcut()")
    public Object logAround(ProceedingJoinPoint jointPoint) throws Throwable{
       if(logger.isDebugEnabled()){
            logger.debug("Enter : {}.{} with argument[s]={}",jointPoint.getSignature().getDeclaringTypeName(),
            jointPoint.getSignature().getDeclaringType(), Arrays.toString(jointPoint.getArgs()));
        }
        try{
            Object result=jointPoint.proceed();
            if(logger.isDebugEnabled()){
                logger.debug("Exit: {}.{} with result = {}",jointPoint.getSignature().getDeclaringTypeName(),
                        jointPoint.getSignature().getName(),result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal arguments:{} in {}.{}()",Arrays.toString(jointPoint.getArgs()),
                    jointPoint.getSignature().getDeclaringType(),jointPoint.getSignature().getName());
        throw e;
        }

    }
}
