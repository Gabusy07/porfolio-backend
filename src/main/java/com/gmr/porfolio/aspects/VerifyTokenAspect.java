package com.gmr.porfolio.aspects;

import com.gmr.porfolio.controllers.SkillController;
import com.gmr.porfolio.utils.JWTutil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class VerifyTokenAspect {


    //@Pointcut("execution(* com.gmr.porfolio.controller.unaclase.method1())")
    public void anyConversation() {}

    //@Before(value="anyConversation()")
    public void verifyToken(String token){
        //jwt.verifyToken(token);
        System.out.println("HELLO ASPECT");
    }
}
