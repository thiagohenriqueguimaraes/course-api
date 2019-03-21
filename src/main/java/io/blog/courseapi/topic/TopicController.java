package io.blog.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> GetAll(){
        return topicService.GetAll();
    }

    /*@RequestMapping(value = "topicq/{id}", method=GET)
    public Topic Get(@RequestParam(value="id") string id){

    }
    */
}
