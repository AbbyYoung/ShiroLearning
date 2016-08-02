package org.wjw.shiro.docs;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.permission.DomainPermission;
import org.apache.shiro.subject.Subject;

/**
 * Created by 嘉玮 on 2016-7-27.
 */
public class AuthorizationGuide {


    public void step1(){
        //get the current Subject
        Subject currentUser =
                SecurityUtils.getSubject();

        if (currentUser.hasRole("administrator")) {
            //show a special button‏
        } else {
            //don’t show the button?)‏
        }
    }

    public void step2(){
        Subject currentUser =
                SecurityUtils.getSubject();

        Permission printPermission =
                new DomainPermission("laserjet3000n","print");

        if (currentUser.isPermitted(printPermission)) {
            //do one thing (show the print button?)‏
        } else {
            //don’t show the button?
        }

        String perm = "printer:print:laserjet4400n";

        if(currentUser.isPermitted(perm)){
            //show the print button?
        } else {
            //don’t show the button?
        }
    }

    @RequiresPermissions("Account:create")
    public void openAccount(Account acct){

    }

    @RequiresRoles("teller")
    public void descAccount(Account acct){

    }
}
