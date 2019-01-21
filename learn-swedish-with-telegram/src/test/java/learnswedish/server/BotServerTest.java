package learnswedish.server;


import learnswedish.config.MongoDBConfig;
import learnswedish.repository.LessonRepository;
import learnswedish.service.InitiateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoDBConfig.class})
@SpringBootTest(classes = InitiateService.class)
@DataMongoTest
public class BotServerTest {


    @Autowired
    LessonRepository lessonRepository;


    @Test
    public void TelegramBotServerIsRunning() throws TelegramApiRequestException {
        ApiContextInitializer.init();
        BotServer bot = mock(BotServer.class);
        TelegramBotsApi telegramBotsApi = mock(TelegramBotsApi.class);
        Assert.assertNull(telegramBotsApi.registerBot(new BotServer(lessonRepository.findAll())));
    }

    @Test
    public void canSayHelloWorld() throws TelegramApiRequestException {
        ApiContextInitializer.init();
        BotServer bot = mock(BotServer.class);
        TelegramBotsApi telegramBotsApi = mock(TelegramBotsApi.class);
        telegramBotsApi.registerBot(new BotServer(lessonRepository.findAll()));
        Update mock = mock(Update.class);
        when(mock.getUpdateId()).thenReturn(null);
    }

}
