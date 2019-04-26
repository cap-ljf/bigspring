package org.capljf.bigspring.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jifang.liu created on 2019/4/26 10:06
 */
@RequestMapping("/web/thymeleaf")
@Controller
public class ThymeLeafController {

    @RequestMapping(path = "/index.htm", method = RequestMethod.GET)
    public String index(ModelMap map){
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}
