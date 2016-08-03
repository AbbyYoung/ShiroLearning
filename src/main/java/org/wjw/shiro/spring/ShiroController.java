package org.wjw.shiro.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 嘉玮 on 2016-8-2.
 */
@Controller
@RequestMapping("/shiro-test")
public class ShiroController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }
}
