package learnswedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SwedishWord {
    @Id
    private String id;
    private String swedishWord;
    private String englishWord;

    public SwedishWord(String id, String swedishWord, String englishWord) {
        this.id = id;
        this.swedishWord = swedishWord;
        this.englishWord = englishWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSwedishWord() {
        return swedishWord;
    }

    public void setSwedishWord(String swedishWord) {
        this.swedishWord = swedishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }
}
