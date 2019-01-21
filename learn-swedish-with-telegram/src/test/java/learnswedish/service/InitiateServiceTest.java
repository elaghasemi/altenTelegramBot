package learnswedish.service;

import learnswedish.config.MongoDBConfig;
import learnswedish.domain.Lesson;
import learnswedish.domain.SwedishWord;
import learnswedish.repository.LessonRepository;
import learnswedish.repository.WordRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoDBConfig.class})
@SpringBootTest(classes = InitiateService.class)
@DataMongoTest
public class InitiateServiceTest {

    @Autowired
    InitiateService initiateService;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    WordRepository wordRepository;

    @Test
    public void fillTheWordsTest() {
        initiateService.fillTheWords();
        SwedishWord swedishWord = wordRepository.findBySwedishWord("Hej");
        Assert.assertNotNull(swedishWord);
    }

    @Test
    public void fillTheLessonsTest() {
        initiateService.fillTheWords();
        List<Lesson> lessons = lessonRepository.findAll();
        Assert.assertNotNull(lessons);
    }

}
