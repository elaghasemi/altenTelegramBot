package learnswedish.service;

import learnswedish.domain.SwedishWord;
import learnswedish.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SwedishWordService {

    @Autowired
    private WordRepository wordRepository;

    public void saveWord(SwedishWord swedishWord) {
        wordRepository.save(swedishWord);
    }

    public SwedishWord findBySwedishWord(String swedishWord) {
        return wordRepository.findBySwedishWord(swedishWord);
    }

}
