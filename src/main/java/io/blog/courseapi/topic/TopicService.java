package io.blog.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    private List<Topic> topicsOld = Arrays.asList(
            new Topic("javascript", "Java Script", "Descrição Java Script"),
            new Topic("javascript2", "Java Script2", "Descrição Java Script"),
            new Topic("javascript3", "Java Script3", "Descrição Java Script")
            );
    public List<Topic> GetAll(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic Get(String id) {
        return topicRepository.findById(id).get();
        /*Topic topic = topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .get();
        return topic;
        */
    }

    public Topic GetOld(String id) {

        Topic topic = topicsOld.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .get();
        return topic;

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
    public void UpdateOld(int id, Topic topic) {

        for (int i = 0; i < topicsOld.size(); i++) {
            Topic t = topicsOld.get(i);
            if (t.getId().equals(id)){
                topicsOld.set(i, topic);
                return;
            }
        }
    }

    public void Delete(String id) {
        topicRepository.deleteById(id);
    }
    public void DeleteOld(String id) {
        topicsOld.removeIf(t -> t.getId().equals(id));
    }
}
