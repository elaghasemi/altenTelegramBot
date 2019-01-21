package learnswedish.repository;

import learnswedish.domain.SwedishWord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WordRepository extends MongoRepository<SwedishWord, String> {
    SwedishWord findBySwedishWord(String swedishWord);
}
