package org.capljf.bigspring.controller.exception;

import org.capljf.bigspring.pojo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jifang.liu created on 2019/5/2 15:50
 */
@Controller
@RequestMapping(path = "/exception")
public class GlobalExceptionController {
    @RequestMapping(path = "/html", method = RequestMethod.GET)
    public Object error() throws Exception {
        throw new Exception("统一异常处理。");
    }

    @RequestMapping(path = "/json", method = RequestMethod.GET)
    public String json() throws MyException {
        throw new MyException("json异常");
    }
}
