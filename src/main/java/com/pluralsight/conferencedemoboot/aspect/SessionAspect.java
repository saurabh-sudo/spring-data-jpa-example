package com.pluralsight.conferencedemoboot.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SessionAspect {

    @Before(value = "execution(* com.pluralsight.conferencedemoboot.controllers.SessionsController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());

    }

    @After(value = "execution(*  com.pluralsight.conferencedemoboot.controllers.SessionsController.*(..)) and args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }

    @After(value = "execution(*  com.pluralsight.conferencedemoboot.controllers.SessionsController.ListBySessionName(..)) and args(name)")
    public void afterAdviceList(JoinPoint joinPoint, String name) {
        System.out.println("After method: afterAdviceList " + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name - " + name + " ") ;
    }
}