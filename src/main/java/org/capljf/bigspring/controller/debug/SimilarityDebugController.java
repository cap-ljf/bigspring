package org.capljf.bigspring.controller.debug;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jifang.liu created on 2019/4/10 19:29
 */
@RequestMapping(path = "/debug/similarity")
@RestController
public class SimilarityDebugController {


    @RequestMapping(path = "phraseSimilarity", method = RequestMethod.GET)
    public Object phraseSimilarity(String name) {
        return "Hello " + name;
    }

}
