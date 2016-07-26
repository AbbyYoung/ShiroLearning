package org.wjw.stormpath.tutorial;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountList;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.authc.AuthenticationRequest;
import com.stormpath.sdk.authc.AuthenticationResult;
import com.stormpath.sdk.authc.UsernamePasswordRequest;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import com.stormpath.sdk.resource.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 嘉玮 on 2016-7-26.
 */
public class Getstarted {

    private static Logger log = LoggerFactory.getLogger(Getstarted.class);


    public static void main(String[] args){
//        System.setProperty("stormpath.apiKey.id","5CHEZMKHJE79C2Y1C6FHWJOZ4");
//        System.setProperty("stormpath.apiKey.secret","xYjZwfDYE7dwgANbIthcKDOP1qt4ksN2GEIQZR0JAVw");
        System.setProperty("STORMPATH_APPLICATION_HREF","https://api.stormpath.com/v1/applications/ouR8jjXd8RJ3y6AbLo79Y");

        //creating a Stormpath Client
        Client client = Clients.builder().build();

        //Retrieve your Application
        Application application = client.getResource(System.getProperty("STORMPATH_APPLICATION_HREF"),Application.class);

        createUserAccount(client,application);

//        retrieveAccount(application);
    }

    public static void createUserAccount(Client client,Application application){


        //Create a User Account
        Account account = client.instantiate(Account.class);

        account
                .setGivenName("Jean-Luc")
                .setSurname("Picard")
                .setUsername("jlpicard")
                .setEmail("capt@enterprise.com")
                .setPassword("Changeme1");

        account = application.createAccount(account);
    }

    public static void retrieveAccount(Application application){
        Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("username", "tk421");
        AccountList accounts = application.getAccounts(queryParams);

        for (Account acct : accounts) {
            log.info("Found Account: " + acct.getHref() + ", " + acct.getEmail());
        }
    }

    public static void authenticateAccount(Application application){
        AuthenticationRequest request = UsernamePasswordRequest.builder()
                .setUsernameOrEmail("tk421")
                .setPassword("Changeme1")
                .build();

        try {
            AuthenticationResult result = application.authenticateAccount(request);
            Account account = result.getAccount();
            log.info("Authenticated Account: " + account.getUsername() + ", Email: " + account.getEmail());
        } catch (ResourceException ex) {
            log.error(ex.getMessage());
        }
    }
}
