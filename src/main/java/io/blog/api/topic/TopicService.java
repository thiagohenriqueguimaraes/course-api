package io.blog.api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    private List<Topic> topicsOld = Arrays.asList(
            new Topic("javascript", "Java Script", "Descrição Java Script"),
            new Topic("javascript2", "Java Script2", "Descrição Java Script"),
            new Topic("javascript3", "Java Script3", "Descrição Java Script")
            );

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    List<Topic> GetAll(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    Topic Get(String id) {
        return topicRepository
                .findById(id)
                .orElse(null);
    }

    public Topic GetOld(String id) {

        return topicsOld
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void add(Topic topic) {
        topicRepository.save(topic);

    }
    public void addOld(Topic topic) {
        topicsOld.add(topic);
    }

    public void Update(Topic topic)
    {
        topicRepository.save(topic);
    }
    public void UpdateOld(String id, Topic topic) {

        for (int i = 0; i < topicsOld.size(); i++) {
            Topic t = topicsOld.get(i);
            if (t.getId().equals(id)){
                topicsOld.set(i, topic);
                return;
            }
        }
    }

    void Delete(String id) {
        topicRepository.deleteById(id);
    }
    public void DeleteOld(String id) {
        topicsOld.removeIf(t -> t.getId().equals(id));
    }
}
