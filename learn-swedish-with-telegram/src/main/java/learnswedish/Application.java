package learnswedish;

import learnswedish.server.BotServer;
import learnswedish.service.InitiateService;
import learnswedish.service.LessonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class Application {


    static LessonService lessonService = null;

    public static void main(String[] args) {
        initiateMonogoData(SpringApplication.run(Application.class, args));
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BotServer(lessonService.findAll()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static void initiateMonogoData(ConfigurableApplicationContext context) {
        InitiateService initiateService = context.getBean("initiateService", InitiateService.class);
        lessonService = context.getBean("lessonService", LessonService.class);
        initiateService.fillTheWords();
    }
}
