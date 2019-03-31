package io.blog.api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topics")
    public List<Topic> GetAll(){
        return topicService.GetAll();
    }

    @RequestMapping("/topics/{id}")
    public Topic Get(@PathVariable String id){
        return topicService.Get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void Add(@RequestBody Topic topic){
        topicService.add(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void Update(@RequestBody Topic topic, @PathVariable String id) {
        topicService.Update(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void Delete(@PathVariable String id){
        topicService.Delete(id);
    }
}
