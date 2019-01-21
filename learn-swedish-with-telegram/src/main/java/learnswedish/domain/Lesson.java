package learnswedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Lesson {

    List<SwedishWord> words;
    @Id
    private String id;
    private String name;


    public Lesson(String id, String name, List<SwedishWord> words) {
        this.id = id;
        this.name = name;
        this.words = words;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SwedishWord> getWords() {
        return words;
    }

    public void setWords(List<SwedishWord> words) {
        this.words = words;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




