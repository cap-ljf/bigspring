package org.capljf.bigspring.controller.debug;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jifang.liu created on 2019/4/10 19:29
 */
@RequestMapping(path = "/debug/similarity")
@RestController
public class SimilarityDebugController {


    /*@RequestMapping(path = "phraseSimilarity", method = RequestMethod.GET)
    public Object phraseSimilarity(String phrase1, String phrase2){
        long start = System.currentTimeMillis();
        Map<String, Object> result = Maps.newHashMap();
        double score = Similarity.phraseSimilarity(phrase1, phrase2);
        result.put("score", score);
        result.put("time", (System.currentTimeMillis()-start) + "ms");
        result.put("phrase1", phrase1);
        result.put("phrase2", phrase2);
        return result;
    }*/

}
