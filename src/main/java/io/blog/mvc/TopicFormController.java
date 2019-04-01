package io.blog.mvc;

import io.blog.api.topic.Topic;
import io.blog.api.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class TopicFormController implements WebMvcConfigurer {

    @Autowired
    private TopicService topicService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/results").setViewName("results");
    }
    @GetMapping("/form-topic")
    public String ShowForm(Topic topic)
    {
        return "formTopic";
    }
    @PostMapping("/form-topic")
    public String checkTopicInfo(@Valid Topic topic, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "formTopic";
        }
        topicService.add(topic);

        return "redirect:/results";
    }
}
