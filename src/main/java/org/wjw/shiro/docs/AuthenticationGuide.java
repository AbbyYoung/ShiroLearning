package org.wjw.shiro.docs;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * Created by 嘉玮 on 2016-7-27.
 */
public class AuthenticationGuide {

    public void step1(){
        //Example using most common scenario:
        //String username and password.  Acquire in
        //system-specific manner (HTTP request, GUI, etc)

        UsernamePasswordToken token =
                new UsernamePasswordToken( "username", "password" );

        //”Remember Me” built-in, just do this:
        token.setRememberMe(true);
    }


    public void step2(UsernamePasswordToken token){
        //With most of Shiro, you'll always want to make sure you're working with the currently executing user, referred to as the subject
        Subject currentUser = SecurityUtils.getSubject();

        //Authenticate the subject by passing
        //the user name and password token
        //into the login method
        currentUser.login(token);
    }

    public void logout(Subject currentUser){

        currentUser.logout(); //removes all identifying information and invalidates their session too.
    }
}
