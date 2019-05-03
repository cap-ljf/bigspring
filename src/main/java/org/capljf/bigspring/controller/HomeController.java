package org.capljf.bigspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jifang.liu created on 2019/4/10 13:19
 */
@RequestMapping(path = "/")
@RestController
@Slf4j
public class HomeController {

    @RequestMapping(path = {"index"}, method = RequestMethod.GET)
    public Object index(HttpServletRequest request){
        log.info("request:{}", (Object[]) request.getCookies());
        log.warn("request:{}", (Object[]) request.getCookies());
        return "Hello bigspring!";
    }

}
